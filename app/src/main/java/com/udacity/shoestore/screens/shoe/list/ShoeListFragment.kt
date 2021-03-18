package com.udacity.shoestore.screens.shoe.list

import android.graphics.Color
import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.screens.shoe.adapter.ShoesAdapter
import com.udacity.shoestore.screens.shoe.viewModel.ShoeViewModel


class ShoeListFragment : Fragment() {

    private lateinit var adapter: ShoesAdapter

    private lateinit var binding: FragmentShoeListBinding
    private val viewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoe_list,
            container,
            false
        )
//        configListView()

        binding.addFab.setOnClickListener {
            val action = ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment()
            findNavController(this).navigate(action)
        }

        viewModel.shoes.observe(viewLifecycleOwner, Observer {
            for (shoe in it) {
                addTextView("Name: ${shoe.name}")
                addTextView("Company: ${shoe.company}")
                addTextView("Size: ${shoe.size}")
                val linha = View(context)
                val layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    3
                )
                layoutParams.topMargin = 16
                linha.layoutParams = layoutParams
                linha.setBackgroundColor(R.color.black)
                binding.linearLayout.addView(linha)
            }
//            adapter.update(it)
        })

        setHasOptionsMenu(true)

        return binding.root
    }

    private fun addTextView(text: String) {
        var layoutParameters = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        layoutParameters.marginStart = 32
        layoutParameters.topMargin = 16
        var view = TextView(context)
        view.layoutParams = layoutParameters
        view.text = text
        binding.linearLayout.addView(view)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.logout_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, findNavController(this))
                || super.onOptionsItemSelected(item)
    }

    /*private fun configListView() {
        adapter = ShoesAdapter(context!!.applicationContext)
        binding.shoesListview.adapter = adapter
    }*/

}