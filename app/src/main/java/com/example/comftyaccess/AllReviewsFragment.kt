package com.example.comftyaccess

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.comftyaccess.databinding.FragmentAllReviewsBinding
import com.example.comftyaccess.model.Review

class AllReviewsFragment : Fragment() {
    private lateinit var binding: FragmentAllReviewsBinding
    private lateinit var reviewRecyclerAdapter: ReviewRecyclerAdapter
    private lateinit var viewModel: AllReviewsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAllReviewsBinding.inflate(inflater, container, false)
        setupRecyclerView()
        setupViewModel()
        return binding.root
    }
    private fun setupRecyclerView() {
    binding.allReviewsRv.layoutManager = LinearLayoutManager(context)
    reviewRecyclerAdapter = ReviewRecyclerAdapter(LayoutInflater.from(context), emptyList())
    binding.allReviewsRv.adapter = reviewRecyclerAdapter
    }
    private fun setupViewModel() {
    viewModel = ViewModelProvider(this)[AllReviewsViewModel::class.java]
    viewModel.data.observe(viewLifecycleOwner) { reviews ->
        if (reviews.isNullOrEmpty()) {
            Log.d("AllReviewsFragment", "No reviews available")
        } else {
                reviewRecyclerAdapter.data = reviews
                Log.d("AllReviewsFragment", "Received ${reviews.size} reviews")

            }
        }
    }

    internal class AllReviewsViewHolder(itemView: View, listener: OnItemClickListener?) :
        RecyclerView.ViewHolder(itemView) {
        var hotelnameTV: TextView
        var ageTV: TextView
        var disTV: TextView
        var avatarImg: ImageView
        var star1: ImageView
        var star2: ImageView
        var star3: ImageView
        var star4: ImageView
        var star5: ImageView

        init {
            hotelnameTV = itemView.findViewById(R.id.row_hotel_name)
            ageTV= itemView.findViewById(R.id.raw_age_TextView)
            disTV= itemView.findViewById(R.id.row_disabillity_textView)
            star1 = itemView.findViewById(R.id.row_star1)
            star2 = itemView.findViewById(R.id.row_star2)
            star3 = itemView.findViewById(R.id.row_star3)
            star4 = itemView.findViewById(R.id.row_star4)
            star5 = itemView.findViewById(R.id.row_star5)
            avatarImg = itemView.findViewById(R.id.row_iv)
            itemView.setOnClickListener {
                val pos = getAdapterPosition()
                listener!!.onItemClick(pos)
            }
        }

        fun bind(re: Review) {
            hotelnameTV.setText(re.hotelName)
            ageTV.setText(re.age.toString())
            disTV.setText(re.accessNeed)
            val stars = listOf(star1, star2, star3, star4, star5)
            stars.forEach { it.setImageResource(R.drawable.baseline_star_outline_24) }
            for (i in 0 until re.rate) {
                stars[i].setImageResource(R.drawable.baseline_star_rate_24)
            }
           //add image binding
        }
    }


    //---------------------OnItemClickListener ---------------------------
    interface OnItemClickListener {
        fun onItemClick(pos: Int)
    }


    //---------------------Recycler adapter ---------------------------
    internal class ReviewRecyclerAdapter(private var inflater: LayoutInflater, private var _data: List<Review>?) : RecyclerView.Adapter<AllReviewsViewHolder>() {var listener: OnItemClickListener? = null

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