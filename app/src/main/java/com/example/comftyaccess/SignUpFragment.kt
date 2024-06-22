package com.example.comftyaccess

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.example.comftyaccess.databinding.FragmentSignUpBinding
import com.example.comftyaccess.model.Model

class SignUpFragment : Fragment() {

    private lateinit var binding: FragmentSignUpBinding
    private var action: NavDirections? = null
    private val accessNeedsOptions =  Model.accessNeedsOptions

    private var accessNeedType: String?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentSignUpBinding.inflate(layoutInflater)

        binding.signInHereIBtn.setOnClickListener { view ->
            val action = SignUpFragmentDirections.actionSignUpFragmentToSignInFragment()
            findNavController().navigate(action)
        }

        binding.helpImgBtn.setOnClickListener { view1 ->
            //dialog_accessibility_needs -  the xml res/layout/dialog_accessibility_needs.xml of the dialog page
            val dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_accessibility_needs, null)
            val dialog = Dialog(requireContext())
            // Apply the dialog window features such as background, animation, etc.
            dialog.window?.apply {
                setBackgroundDrawableResource(android.R.color.transparent)
            }
            dialog.setContentView(dialogView)
            // To close the dialog when tapping outside of it
            dialog.setCanceledOnTouchOutside(true)
            dialog.show()
        }

        createAccessNeedSpinner()
        return binding.root
    }

    private fun createAccessNeedSpinner() {
        val adapter = ArrayAdapter(
            requireContext(), // Use requireContext() within Fragments
            R.layout.spinner_item, // Your custom item layout
            accessNeedsOptions // The list of options
        )
        binding.accessNeedSpinner.adapter = adapter

        binding.accessNeedSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
               accessNeedType = parent.getItemAtPosition(position).toString()
            }
            override fun onNothingSelected(parent: AdapterView<*>) {}
        }
    }


}