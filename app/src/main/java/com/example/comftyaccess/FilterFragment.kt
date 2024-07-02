package com.example.comftyaccess

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.comftyaccess.databinding.FragmentFilterBinding
import com.example.comftyaccess.model.Model

class FilterFragment : Fragment() {
    private lateinit var binding: FragmentFilterBinding

    private var accessNeedType: String? = null
    private var ageRangeType: String? = null
    private var email: String? = null
    private var rating: String? = null
    private val accessNeedsOptions = listOf("Rather not to mention") + Model.accessNeedsOptions.filterNot {
        it == "Other" || it == "Do not want to share"
    }
    private val ageRangeOptions = listOf("Rather not to mention") + Model.ageRangeOptions

    // Set the action bar title when the fragment starts
    override fun onStart() {
        (activity as AppCompatActivity?)!!.supportActionBar!!.title = "Filter"
        super.onStart()
    }

    // Inflate the fragment's layout and initialize necessary components
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFilterBinding.inflate(inflater, container, false)

        setupSpinners()
        setupStarRating()
        setupButton()

        return binding.root
    }

    // Setup the spinners for selecting access needs and age range
    private fun setupSpinners() {
        createAccessNeedSpinner()
        createAgeRangeSpinner()
    }

    // Setup the star rating click listeners
    private fun setupStarRating() {
        val stars = arrayOf(
            binding.filterStar1,
            binding.filterStar2,
            binding.filterStar3,
            binding.filterStar4,
            binding.filterStar5
        )

        // Add click listeners to each star to update the rating
        stars.forEachIndexed { index, imageView ->
            imageView.setOnClickListener {
                rating = (index + 1).toString()  // Update the rating based on which star was clicked
                stars.forEachIndexed { starIndex, starImageView ->
                    starImageView.setImageResource(
                        if (starIndex <= index) R.drawable.baseline_star_rate_24
                        else R.drawable.baseline_star_outline_24
                    )
                }
            }
        }
    }

    // Setup the filter button click listener
    private fun setupButton() {
        binding.filterBt.setOnClickListener {
            // Collect email from the input field
            email = binding.emailEditText.text.toString()
            if (binding.cbStarsFilter.isChecked) {
                // If checked, use the rating if available; otherwise, use "Rather not to mention"
                rating = rating ?: "Rather not to mention"
            } else {
                // If not checked, always use "Rather not to mention"
                rating = "Rather not to mention"
            }
            // Prepare to send the data to another fragment or activity
            val action = FilterFragmentDirections.actionFilterFragmentToFilteredReviewsFragment(
                email ?: "Rather not to mention",
                accessNeedType ?: "Rather not to mention",
                rating ?: "Rather not to mention",
                ageRangeType ?: "Rather not to mention",
                "Rather not to mention"
            )
            Log.d("FilterFragment", "Access Need Type: $accessNeedType")
            Log.d("FilterFragment", "Age Range Type: $ageRangeType")
            Log.d("FilterFragment", "Email: $email")
            Log.d("FilterFragment", "Rating: $rating")
            findNavController().navigate(action)
            rating = "Rather not to mention" // for the back button
        }
    }

    // Create the Access Need spinner and set its options
    private fun createAccessNeedSpinner() {
        val adapter = ArrayAdapter(
            requireContext(), // Use requireContext() within Fragments
            R.layout.spinner_item, // Your custom item layout
            accessNeedsOptions // The list of options
        )
        binding.accessNeedSpinnerSpinnerFilter.adapter = adapter

        binding.accessNeedSpinnerSpinnerFilter.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                accessNeedType = parent.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }
    }

    // Create the Age Range spinner and set its options
    private fun createAgeRangeSpinner() {
        val adapter = ArrayAdapter(
            requireContext(), // Use requireContext() within Fragments
            R.layout.spinner_item, // Your custom item layout
            ageRangeOptions // The list of options
        )
        binding.ageRangeSpinnerFilter.adapter = adapter

        binding.ageRangeSpinnerFilter.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                ageRangeType = parent.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }
    }
}