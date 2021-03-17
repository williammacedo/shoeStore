package com.udacity.shoestore.screens.shoe.repository

import com.udacity.shoestore.models.Shoe

val dataset = arrayListOf(
    com.udacity.shoestore.models.Shoe("Nike Air", 38.0, "Nike", "Great tennis"),
    Shoe("Adidas Superstar", 40.0, "Adidas", "Unbelievable Adidas"),
    Shoe("Puma Viz Runner", 39.0, "Adidas", "Unbelievable Adidas")
)

class ShoeRepository {

    fun getAll(): List<Shoe> {
        return dataset
    }

    fun get(position: Int): Shoe {
        return dataset[position]
    }

    fun save(shoe: Shoe) {
        dataset.add(shoe)
    }

    fun saveAll(shoes: List<Shoe>) {
        dataset.addAll(shoes)
    }

    fun clear() {
        dataset.clear()
    }
}