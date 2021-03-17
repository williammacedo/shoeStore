package com.udacity.shoestore.screens.shoe.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel : ViewModel() {

    private val _shoes = MutableLiveData<MutableList<Shoe>>()
    val shoes: LiveData<MutableList<Shoe>>
        get() = _shoes

    init {
        _shoes.value = arrayListOf(
            com.udacity.shoestore.models.Shoe("Nike Air", 38.0, "Nike", "Great tennis"),
            Shoe("Adidas Superstar", 40.0, "Adidas", "Unbelievable Adidas"),
            Shoe("Puma Viz Runner", 39.0, "Adidas", "Unbelievable Adidas")
        )
    }

    fun save(shoe: Shoe) {
        _shoes.value?.add(shoe)
    }
}