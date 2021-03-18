package com.udacity.shoestore.screens.shoe.viewModel

import androidx.databinding.ObservableParcelable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class ShoeViewModel : ViewModel() {

    val observableShoe = ObservableParcelable<Shoe>()

    private val _shoes = MutableLiveData<MutableList<Shoe>>()
    val shoes: LiveData<MutableList<Shoe>>
        get() = _shoes

    init {
        _shoes.value = arrayListOf(
            com.udacity.shoestore.models.Shoe("Nike Air", 38.0, "Nike", "Great tennis"),
            Shoe("Adidas Superstar", 40.0, "Adidas", "Unbelievable Adidas"),
            Shoe("Puma Viz Runner", 39.0, "Adidas", "Unbelievable Puma tennis")
        )
        observableShoe.set(Shoe("", 0.0, "", ""))
    }

    fun save() {
        _shoes.value?.add(observableShoe.get()!!)
        observableShoe.set(Shoe("", 0.0, "", ""))
    }
}