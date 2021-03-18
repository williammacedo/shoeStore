package com.udacity.shoestore.screens.shoe.list

import android.os.Bundle
import android.view.*
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
        configListView()

        binding.addFab.setOnClickListener {
            val action = ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment()
            findNavController(this).navigate(action)
        }

        viewModel.shoes.observe(viewLifecycleOwner, Observer {
            adapter.update(it)
        })

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.logout_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, findNavController(this))
                || super.onOptionsItemSelected(item)
    }

    private fun configListView() {
        adapter = ShoesAdapter(context!!.applicationContext)
        binding.shoesListview.adapter = adapter
    }

}