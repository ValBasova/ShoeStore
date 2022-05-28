package com.udacity.shoestore.screens.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    val viewModel by viewModels<LoginViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_login,
            container,
            false
        )
        binding.loginViewModel = viewModel
        binding.lifecycleOwner = this

        with(binding){
            loginViewModel = viewModel
            lifecycleOwner = this@LoginFragment
        }
        viewModel.eventUserLogin.observe(viewLifecycleOwner, Observer { login ->
            if (login) {
                findNavController().navigate(R.id.action_loginFragment_to_welcomeFragment)
                viewModel.onLoginComplete()
            }
//            else {
//                Toast.makeText(context, "Fields are empty", Toast.LENGTH_SHORT).show()
//            }
        })

        return binding.root
    }

}