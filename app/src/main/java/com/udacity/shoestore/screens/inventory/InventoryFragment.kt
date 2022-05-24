package com.udacity.shoestore.screens.inventory

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.udacity.shoestore.R
import com.udacity.shoestore.ShoeViewModel
import com.udacity.shoestore.databinding.FragmentInventoryBinding
import com.udacity.shoestore.databinding.ShoeItemBinding
import com.udacity.shoestore.models.Shoe
import kotlinx.android.synthetic.main.fragment_welcome.*

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
        viewModel.shoeList.observe(viewLifecycleOwner){
            for(shoe in it){
                addViewItem(shoe)
            }
        }

        binding.floatingActionButton.setOnClickListener {
//            findNavController().navigate()
        }
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
}