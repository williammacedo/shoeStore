package com.udacity.shoestore.screens.shoe.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe


class ShoeDetailFragment : Fragment() {

    private lateinit var binding: FragmentShoeDetailBinding

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
            navigateToList(null)
        }

        binding.saveButton.setOnClickListener {
            navigateToList(getShoe())
        }

        return binding.root
    }

    private fun getShoe(): Shoe {
        val size = if (binding.sizeEdit.text.isNotBlank()) binding.sizeEdit.text.toString().toDouble() else 0.0
        return Shoe(
            binding.nameEdit.text.toString(),
            size,
            binding.companyEdit.text.toString(),
            binding.descriptionText.text.toString()
        )
    }

    private fun navigateToList(shoe: Shoe?) {
        val action = ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment(shoe)
        findNavController(this).navigate(action)
    }

}