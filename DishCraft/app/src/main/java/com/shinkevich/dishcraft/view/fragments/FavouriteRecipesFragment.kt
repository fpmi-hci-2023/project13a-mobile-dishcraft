package com.shinkevich.dishcraft.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.shinkevich.dishcraft.databinding.FragmentFavouriteRecipesBinding


class FavouriteRecipesFragment : Fragment() {
    private lateinit var binding: FragmentFavouriteRecipesBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavouriteRecipesBinding.inflate(inflater, container, false)
        return binding.root
    }

}