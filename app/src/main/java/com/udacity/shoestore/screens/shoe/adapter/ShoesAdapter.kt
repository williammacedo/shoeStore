package com.udacity.shoestore.screens.shoe.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.databinding.DataBindingUtil
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ItemShoeBinding
import com.udacity.shoestore.models.Shoe

class ShoesAdapter(private val context: Context) : BaseAdapter() {

    private val dataset = ArrayList<Shoe>()

    override fun getCount(): Int {
        return dataset.size
    }

    override fun getItem(position: Int): Shoe {
        return dataset[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val item = getItem(position)

        val view: View =
            convertView ?: LayoutInflater.from(context).inflate(R.layout.item_shoe, parent, false)

        val binding = DataBindingUtil.bind<ItemShoeBinding>(view)
        view.tag = binding
        binding?.item = item
        return view
    }

    fun update(trips: List<Shoe>) {
        dataset.clear()
        dataset.addAll(trips)
        notifyDataSetChanged()
    }
}