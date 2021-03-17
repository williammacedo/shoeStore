package com.udacity.shoestore.screens.shoe.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.NavHostFragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.screens.shoe.viewModel.ShoeViewModel


class ShoeDetailFragment : Fragment() {

    private lateinit var binding: FragmentShoeDetailBinding
    private val viewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoe_detail,
            container,
            false
        )

        binding.cancelButton.setOnClickListener {
            navigateToList()
        }

        binding.saveButton.setOnClickListener {
            save()
            navigateToList()
        }

        return binding.root
    }

    private fun save() {
        val size = if (binding.sizeEdit.text.isNotBlank()) binding.sizeEdit.text.toString().toDouble() else 0.0
        viewModel.save(
            Shoe(
                binding.nameEdit.text.toString(),
                size,
                binding.companyEdit.text.toString(),
                binding.descriptionText.text.toString()
            )
        )
    }

    private fun navigateToList() {
        val action = ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment()
        findNavController(this).navigate(action)
    }

}