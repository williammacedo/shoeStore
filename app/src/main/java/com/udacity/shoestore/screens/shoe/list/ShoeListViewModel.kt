package com.udacity.shoestore.screens.shoe.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.screens.shoe.repository.ShoeRepository

class ShoeListViewModel : ViewModel() {

    private val shoeRepository = ShoeRepository()

    private val _shoes = MutableLiveData<List<Shoe>>()
    val shoes: LiveData<List<Shoe>>
        get() = _shoes

    init {
        _shoes.value = shoeRepository.getAll()
    }

    fun update() {
        _shoes.value =  shoeRepository.getAll()
    }

    fun save(shoe: Shoe) {
        shoeRepository.save(shoe)
        update()
    }
}