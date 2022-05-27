package com.udacity.shoestore.screens.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.ShoeViewModel
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding


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
        binding.shoeViewModel = viewModel

        viewModel.eventAddShoe.observe(viewLifecycleOwner, Observer { isAdded ->
            if (isAdded) {
                findNavController().navigate(R.id.action_shoeDetailFragment_to_inventoryFragment)
                viewModel.onAddShoeComplete()
            }
        })

        viewModel.eventCancel.observe(viewLifecycleOwner, Observer { isCanceled ->
            if (isCanceled) {
                findNavController().navigate(R.id.action_shoeDetailFragment_to_inventoryFragment)
                viewModel.onCancelComplete()
            }
        })
        return binding.root
    }
}