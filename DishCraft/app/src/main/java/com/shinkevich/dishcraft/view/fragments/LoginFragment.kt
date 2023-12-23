package com.shinkevich.dishcraft.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.shinkevich.dishcraft.R
import com.shinkevich.dishcraft.databinding.FragmentLoginBinding
import com.shinkevich.dishcraft.viewmodel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment(){
    private lateinit var binding: FragmentLoginBinding
    private val viewModel by viewModels<LoginViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.isAuthenticated.observe(this){ isAuthenticated ->
            if(isAuthenticated){
                requireActivity().findNavController(R.id.mainNavHost).navigate(R.id.action_authFragment_to_sideMenuFragment)
            }
            else{
                binding.authErrorTV.visibility = View.VISIBLE
            }
        }


        binding.apply {
            loginRegistrationBtn.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_loginFragment_to_registrationFragment))
            /*loginRegistrationBtn.setOnClickListener {
                findNavController().navigate(R.id.action_loginFragment_to_registrationFragment)
            }*/
            loginLoginBtn.setOnClickListener {
                val email = userNameEditText.text.toString()
                val password = passwordEditText.text.toString()
                viewModel.signin(email, password)
            }
        }
    }
}