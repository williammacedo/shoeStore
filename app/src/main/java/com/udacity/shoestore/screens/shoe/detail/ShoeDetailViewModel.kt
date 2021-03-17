package com.udacity.shoestore.screens.shoe.detail

import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.screens.shoe.repository.ShoeRepository

class ShoeDetailViewModel() : ViewModel() {

    private val shoeRepository = ShoeRepository()

    fun save(shoe: Shoe) {
        shoeRepository.save(shoe)
    }
}