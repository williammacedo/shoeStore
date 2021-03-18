package com.udacity.shoestore.util

import android.widget.EditText
import androidx.databinding.InverseMethod

object Converter {
    @InverseMethod("stringToDouble")
    @JvmStatic fun doubleToString(value: Double): String {
        return value.toString()
    }

    @JvmStatic fun stringToDouble(value: String): Double {
        return if (value.isNotBlank()) {
            value.toDouble()
        } else {
            0.0
        }
    }
}