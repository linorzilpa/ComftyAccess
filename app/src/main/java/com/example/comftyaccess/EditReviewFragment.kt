package com.example.comftyaccess

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.comftyaccess.databinding.FragmentAllReviewsBinding
import com.example.comftyaccess.databinding.FragmentEditReviewBinding


class EditReviewFragment : Fragment() {
    private lateinit var binding: FragmentEditReviewBinding
    private lateinit var viewModel: EditReviewViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEditReviewBinding.inflate(inflater, container, false)


        return binding.root
    }

}