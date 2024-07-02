package com.example.comftyaccess

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.comftyaccess.databinding.FragmentAllReviewsBinding
import com.example.comftyaccess.model.Model
import com.example.comftyaccess.model.Review
import com.google.firebase.auth.FirebaseAuth
import com.squareup.picasso.Picasso
import kotlin.coroutines.coroutineContext


class AllReviewsFragment : Fragment() {
    private lateinit var binding: FragmentAllReviewsBinding
    private lateinit var reviewRecyclerAdapter: ReviewRecyclerAdapter
    private lateinit var viewModel: AllReviewsViewModel
    private val firebaseAuth: FirebaseAuth by lazy { FirebaseAuth.getInstance() }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAllReviewsBinding.inflate(inflater, container, false)
        reloadData()
        setupRecyclerView()
        setupViewModel()
        Model.instance.reviewsListLoadingState.observe(getViewLifecycleOwner()) { status ->
            binding.swipeRefresh.isRefreshing = status === Model.LoadingState.LOADING
        }
        binding.swipeRefresh.setOnRefreshListener { reloadData() }

        return binding.root
    }

    private fun setupRecyclerView() {
        binding.allReviewsRv.layoutManager = LinearLayoutManager(context)
        reviewRecyclerAdapter = ReviewRecyclerAdapter(LayoutInflater.from(context), emptyList())
        binding.allReviewsRv.adapter = reviewRecyclerAdapter
        reviewRecyclerAdapter.setOnItemClickListener(object : OnItemClickListener {
            override fun onItemClick(pos: Int) {
                val selectedReview = viewModel.data.value?.get(pos)
                if (selectedReview != null) {
                    showDialogWithReviewDetails(selectedReview, pos)
                } else {
                    // Handle the case where selectedReview is null
                    context?.let { ctx ->
                        Toast.makeText(ctx, "Error: Review not found!", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(this)[AllReviewsViewModel::class.java]
        //Every time that the view model list changes , also the RV changes
        viewModel.data.observe(viewLifecycleOwner) { reviews ->
            reviewRecyclerAdapter.data = reviews
            if (reviews.isNullOrEmpty()) {
                Log.d("AllReviewsFragment", "No reviews available")
            } else {
                Log.d("AllReviewsFragment", "Received ${reviews.size} reviews")
            }
        }
    }

    override fun onStart() {
        super.onStart()
        (activity as AppCompatActivity?)!!.supportActionBar!!.title = "All Reviews"
        if (viewModel.data.value.isNullOrEmpty()) {
            Model.instance.refreshAllReviews()
        }
    }

    fun reloadData() {
        Model.instance.refreshAllReviews()
    }

    fun showDialogWithReviewDetails(review: Review, pos: Int) {
        val dialogView = layoutInflater.inflate(R.layout.dialog_review_details, null)
        dialogView.findViewById<ProgressBar>(R.id.progressBarRD).visibility = View.VISIBLE

        // Binding TextViews with review details
        dialogView.findViewById<TextView>(R.id.tv_edit_hotelname_review_details).text = review.hotelName
        dialogView.findViewById<TextView>(R.id.tv_edit_accessNeed_review_details).text = review.accessNeed
        dialogView.findViewById<TextView>(R.id.tv_edit_desc_review_details).text = review.description ?: "No additional comments"
        dialogView.findViewById<TextView>(R.id.tv_edit_email_review_details).text = review.email
        dialogView.findViewById<TextView>(R.id.tv_edit_age_review_details).text = review.age.toString()

        // Handling the rating stars
        val starViews = listOf(
            dialogView.findViewById<ImageView>(R.id.row_star1_review_details),
            dialogView.findViewById<ImageView>(R.id.row_star2_review_details),
            dialogView.findViewById<ImageView>(R.id.row_star3_review_details),
            dialogView.findViewById<ImageView>(R.id.row_star4_review_details),
            dialogView.findViewById<ImageView>(R.id.row_star5_review_details)
        )

        starViews.forEachIndexed { index, imageView ->
            if (index < review.rate) {
                imageView.setImageResource(R.drawable.baseline_star_rate_24)
            } else {
                imageView.setImageResource(R.drawable.baseline_star_outline_24)
            }
        }

        val alertDialog = AlertDialog.Builder(requireContext())
            .setView(dialogView)
            .create()

        dialogView.findViewById<Button>(R.id.bt_back_review_details).setOnClickListener {
            alertDialog.dismiss() // Dismiss the dialog when the back button is pressed
        }

        val editImageView = dialogView.findViewById<ImageView>(R.id.iv_editreview_review_details) // Replace with the correct ID
        if (firebaseAuth.currentUser!=null)
        {
            if (!review.email.equals(firebaseAuth.currentUser!!.email))
                editImageView.visibility = View.GONE
        }
        editImageView.setOnClickListener {
            alertDialog.dismiss() // Dismiss the dialog first
            val action = AllReviewsFragmentDirections.actionAllReviewsFragmentToEditReviewFragment(pos)
            findNavController().navigate(action)

        }

        val avatarImg = dialogView.findViewById<ImageView>(R.id.iv_review_details) // Replace 'R.id.avatarImg' with the actual ID

        review.img?.let { imageUrl ->
            if (imageUrl.isNotBlank()) {
                Picasso.get().load(imageUrl)
                    .placeholder(R.drawable.ic_launcher_foreground)  // Placeholder image
                    .error(R.drawable.ic_launcher_foreground)         // Error image
                    .into(avatarImg)
            } else {
                avatarImg.setImageResource(R.drawable.ic_launcher_foreground)
            }
            dialogView.findViewById<ProgressBar>(R.id.progressBarRD).visibility = View.GONE
        } ?: avatarImg.setImageResource(R.drawable.ic_launcher_foreground)


        // Create and show the AlertDialog
        alertDialog.show()
    }


    internal class AllReviewsViewHolder(itemView: View, listener: OnItemClickListener?) :
        RecyclerView.ViewHolder(itemView) {
        var hotelnameTV: TextView
        var ageTV: TextView // Error need to fix linor
        var disTV: TextView
        var avatarImg: ImageView
        var star1: ImageView
        var star2: ImageView
        var star3: ImageView
        var star4: ImageView
        var star5: ImageView

        init {
            hotelnameTV = itemView.findViewById(R.id.row_hotel_name)
            ageTV= itemView.findViewById(R.id.row_age_TextView) // Error need to fix linor
            disTV= itemView.findViewById(R.id.row_disabillity_textView)
            star1 = itemView.findViewById(R.id.row_star1)
            star2 = itemView.findViewById(R.id.row_star2)
            star3 = itemView.findViewById(R.id.row_star3)
            star4 = itemView.findViewById(R.id.row_star4)
            star5 = itemView.findViewById(R.id.row_star5)
            avatarImg = itemView.findViewById(R.id.row_iv)
            itemView.setOnClickListener {
                val pos:Int = getAdapterPosition()
                listener!!.onItemClick(pos)
            }
        }

        fun bind(re: Review) {
            Log.d("ReviewBinding", "Binding review: $re")

            // Binding hotel name
            hotelnameTV.setText(re.hotelName)
            Log.d("ReviewBinding", "Hotel name bound: ${re.hotelName}")

            // Binding age
            ageTV.setText(re.age.toString()) // error nned to fix linor
            Log.d("ReviewBinding", "Age bound: ${re.age}")

            // Binding accessibility need
            disTV.setText(re.accessNeed)
            Log.d("ReviewBinding", "Access need bound: ${re.accessNeed}")

            // Binding star rating
            val stars = listOf(star1, star2, star3, star4, star5)
            stars.forEach { it.setImageResource(R.drawable.baseline_star_outline_24) }
            for (i in 0 until re.rate) {
                stars[i].setImageResource(R.drawable.baseline_star_rate_24)
            }
            Log.d("ReviewBinding", "Star rating bound: ${re.rate}")

            // Binding image
            re.img?.let { imageUrl ->
                if (imageUrl.isNotBlank()) {
                    val picasso = Picasso.Builder(MyApplication.getMyContext())
                        .listener { _, uri, exception ->
                            Log.e("ReviewBinding", "Error loading image from $uri", exception)
                        }
                        .build()
                    picasso.load(imageUrl)
                        .placeholder(R.drawable.ic_launcher_foreground)
                        .error(R.drawable.ic_launcher_foreground)  // Setting error placeholder
                        .into(avatarImg, object : com.squareup.picasso.Callback {
                            override fun onSuccess() {
                                Log.d("ReviewBinding", "Image loaded successfully: $imageUrl")
                            }

                            override fun onError(e: Exception?) {
                                Log.e("ReviewBinding", "Picasso load error: ", e)
                            }
                        })
                } else {
                    avatarImg.setImageResource(R.drawable.ic_launcher_foreground)
                    Log.d("ReviewBinding", "No image provided, setting default image")
                }
            } ?: run {
                avatarImg.setImageResource(R.drawable.ic_launcher_foreground)
                Log.d("ReviewBinding", "Image URL is null, setting default image")
            }

            Log.d("ReviewBinding", "Review binding completed")
        }
    }


    //---------------------OnItemClickListener ---------------------------
    interface OnItemClickListener {
        fun onItemClick(pos: Int)
    }


    //---------------------Recycler adapter ---------------------------
    internal class ReviewRecyclerAdapter(private var inflater: LayoutInflater, private var _data: List<Review>?) : RecyclerView.Adapter<AllReviewsViewHolder>() {
        var listener: OnItemClickListener? = null

        var data: List<Review>?
            get() = _data
            set(value) {
                _data = value
                notifyDataSetChanged()
                Log.d("AllReviewsFragment", "num of reviews: {${_data?.size}} ")

            }

        // Set the OnItemClickListener
        fun setOnItemClickListener(listener: OnItemClickListener?) {
            this.listener = listener
        }

        // Create a view holder
        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): AllReviewsViewHolder {
            // Inflate the row layout using parent context
            val view = inflater.inflate(R.layout.review_row, parent, false)
            // Create and return a new AllReviewsViewHolder
            return AllReviewsViewHolder(view, listener)
        }

        // Bind the data to the view holder
        override fun onBindViewHolder(holder: AllReviewsViewHolder, position: Int) {
            data?.let {
                val re: Review = it[position]
                holder.bind(re)
            }
        }


        // Return the number of items in the data
        override fun getItemCount(): Int = data?.size ?: 0
    }


}