package com.udacity.shoestore.screens.inventory

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.ShoeViewModel
import com.udacity.shoestore.databinding.FragmentInventoryBinding
import com.udacity.shoestore.databinding.ShoeItemBinding
import com.udacity.shoestore.models.Shoe

class InventoryFragment : Fragment() {

    private lateinit var binding: FragmentInventoryBinding
    private val viewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_inventory,
            container,
            false
        )
        viewModel.shoeList.observe(viewLifecycleOwner) {
            for (shoe in it) {
                addViewItem(shoe)
            }
        }

        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_inventoryFragment_to_shoeDetailFragment)
        }

        setHasOptionsMenu(true)

        return binding.root
    }

    private fun addViewItem(shoe: Shoe) {
        val viewItem = ShoeItemBinding.inflate(LayoutInflater.from(context))
        viewItem.apply {
            itemNameText.text = shoe.name
            itemSizeText.text = shoe.size.toString()
            itemCompanyText.text = shoe.company
            itemDescriptionText.text = shoe.description
        }
        binding.shoeItemScroll.addView(viewItem.root)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }
}