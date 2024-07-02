
package com.example.comftyaccess

import HotelViewModel
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.comftyaccess.databinding.FragmentAllReviewsBinding
import com.example.comftyaccess.databinding.FragmentEditReviewBinding
import com.example.comftyaccess.model.Model
import com.example.comftyaccess.model.Review
import com.squareup.picasso.Picasso


class EditReviewFragment : Fragment() {
    private lateinit var binding: FragmentEditReviewBinding
    private lateinit var viewModel: EditReviewViewModel
    private lateinit var cameraLauncher: ActivityResultLauncher<Void?>
    private lateinit var galleryLauncher: ActivityResultLauncher<String>
    private var selectedReview: Review? = null
    private var isAvatarSelected: Boolean = false
    private lateinit var hotelViewModel: HotelViewModel

    override fun onStart() {
        (activity as AppCompatActivity?)!!.supportActionBar!!.title = "Edit review"
        super.onStart()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEditReviewBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(EditReviewViewModel::class.java)
        hotelViewModel = ViewModelProvider(this).get(HotelViewModel::class.java)
        binding.progressBarER.visibility = View.GONE

        setupActivityResultLaunchers()
        setupStarRating()

        binding.btCancelEditreview.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.btAddEditreview.setOnClickListener {
            editReview()
        }
        hotelViewModel.loadHotels { hotels ->
            Log.d("EditReviewFragment", "Hotels loaded: ${hotels.size}")
            if (hotels.isNotEmpty()) {
                activity?.runOnUiThread {
                    val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, hotels.map { it.name })
                    binding.hotelNameSpinnerEditReview.adapter = adapter
                    adapter.notifyDataSetChanged()
                }
            }
            loadReviewData()
        }


        return binding.root
    }

    private fun loadReviewData() {
        val position: Int = arguments?.getInt("pos") ?: return
        selectedReview = viewModel.data.value?.get(position)
        binding.progressBarER.visibility = View.VISIBLE
        selectedReview?.let { review ->
            binding.emailTvEditReview.text = review.email
            binding.descriptionEditTextEditReview.setText(review.description)
            val hotelNameIndex= (binding.hotelNameSpinnerEditReview.adapter as ArrayAdapter<String>).getPosition(review.hotelName)
            binding.hotelNameSpinnerEditReview.setSelection(hotelNameIndex)

            if (review.img.isNotBlank()) {
                Picasso.get().load(review.img)
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .error(R.drawable.ic_launcher_foreground)
                    .into(binding.ivEditReview)
            }
            updateStarRating(review.rate)
            binding.progressBarER.visibility = View.GONE
        }
    }

    private fun setupStarRating() {
        val starViews = listOf(
            binding.rowStar1EditReview,
            binding.rowStar2EditReview,
            binding.rowStar3EditReview,
            binding.rowStar4EditReview,
            binding.rowStar5EditReview
        )

        starViews.forEachIndexed { index, imageView ->
            imageView.setOnClickListener {
                updateStarRating(index + 1) // Update the visual rating when a star is clicked
            }
        }
    }

    private fun updateStarRating(rate: Int) {
        val starViews = listOf(
            binding.rowStar1EditReview,
            binding.rowStar2EditReview,
            binding.rowStar3EditReview,
            binding.rowStar4EditReview,
            binding.rowStar5EditReview
        )
        starViews.forEachIndexed { index, imageView ->
            if (index < rate) {
                imageView.setImageResource(R.drawable.baseline_star_rate_24)
            } else {
                imageView.setImageResource(R.drawable.baseline_star_outline_24)
            }
        }
        makeStarsClickable(starViews)
    }

    private fun makeStarsClickable(starViews: List<ImageView>) {
        starViews.forEachIndexed { index, imageView ->
            imageView.setOnClickListener {
                updateStarRating(index + 1)
            }
        }
    }

    private fun setupActivityResultLaunchers() {
        cameraLauncher = registerForActivityResult(ActivityResultContracts.TakePicturePreview()) { bitmap ->
            bitmap?.let {
                binding.ivEditReview.setImageBitmap(it)
                isAvatarSelected = true
            }
        }

        galleryLauncher = registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
            uri?.let {
                binding.ivEditReview.setImageURI(it)
                isAvatarSelected = true
            }
        }

        binding.btnCameraEditReview.setOnClickListener {
            cameraLauncher.launch(null)
        }

        binding.btnGalleryEditReview.setOnClickListener {
            galleryLauncher.launch("image/*")
        }
    }

    private fun calculateRating(): Int {
        val starViews = listOf(
            binding.rowStar1EditReview,
            binding.rowStar2EditReview,
            binding.rowStar3EditReview,
            binding.rowStar4EditReview,
            binding.rowStar5EditReview
        )
        return starViews.count { imageView ->
            imageView.drawable.constantState == resources.getDrawable(R.drawable.baseline_star_rate_24, null).constantState
        }
    }

    private fun editReview() {

        selectedReview!!.hotelName = binding.hotelNameSpinnerEditReview.selectedItem.toString()
        selectedReview!!.description = binding.descriptionEditTextEditReview.text.toString()
        selectedReview!!.email = binding.emailTvEditReview.text.toString()
        selectedReview!!.rate = calculateRating()
        binding.progressBarER.visibility = View.VISIBLE
        if (isAvatarSelected) {
            (binding.ivEditReview.drawable as? BitmapDrawable)?.let { drawable ->
                val bitmap = drawable.bitmap
                Model.instance.uploadImage(selectedReview!!.reviewId.toString(), bitmap) { url ->
                    selectedReview!!.img=url!!
                    Log.d("EditReviewFragment", "Review img url ${selectedReview!!.img.toString()}")

                    Model.instance.addReview(selectedReview!!) {
                        Toast.makeText(requireContext(), "Review replaced!", Toast.LENGTH_LONG).show()
                        Log.d("EditReviewFragment", "Review replaced with img")
                        findNavController().navigateUp()  // Navigate up in the navigation stack
                    }
                    binding.progressBarER.visibility = View.GONE
                }
            } ?: Log.e("EditReviewFragment", "Failed to cast drawable to BitmapDrawable")
        } else{
            selectedReview?.let {
                Model.instance.addReview(it) {
                    Toast.makeText(requireContext(), "Review replaced!", Toast.LENGTH_LONG).show()
                    Log.d("EditReviewFragment", "Review replaced without img")
                    findNavController().navigateUp()  // Navigate up in the navigation stack
                    binding.progressBarER.visibility = View.GONE
                }
            }
        }

    }

}
