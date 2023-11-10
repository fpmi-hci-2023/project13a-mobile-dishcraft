package com.shinkevich.dishcraft.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.shinkevich.dishcraft.R
import com.shinkevich.dishcraft.databinding.FragmentLoginBinding

class LoginFragment : Fragment(){
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            loginRegistrationBtn.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_loginFragment_to_registrationFragment))
            /*loginRegistrationBtn.setOnClickListener {
                findNavController().navigate(R.id.action_loginFragment_to_registrationFragment)
            }*/
            loginLoginBtn.setOnClickListener {
                requireActivity().findNavController(R.id.mainNavHost).navigate(R.id.action_authFragment_to_sideMenuFragment)
            }
        }
    }
}