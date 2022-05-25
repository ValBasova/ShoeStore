package com.udacity.shoestore.screens.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.ShoeViewModel
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe


class ShoeDetailFragment : Fragment() {
    private lateinit var binding: FragmentShoeDetailBinding
    private val viewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoe_detail,
            container,
            false
        )
        binding.saveButton.setOnClickListener {
            val newShoe = Shoe(
                binding.shoeNameText.text.toString(),
                binding.shoeSizeText.text.toString().toDouble(),
                binding.shoeCompanyText.text.toString(),
                binding.shoeDescriptionText.text.toString()
            )
            viewModel.addNewShoe(newShoe)
            findNavController().navigate(R.id.action_shoeDetailFragment_to_inventoryFragment)

        }
        binding.cancelButton.setOnClickListener {
            findNavController().navigate(R.id.action_shoeDetailFragment_to_inventoryFragment)
        }
        return binding.root
    }
}