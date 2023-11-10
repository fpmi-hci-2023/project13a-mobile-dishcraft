package com.shinkevich.dishcraft.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.shinkevich.dishcraft.databinding.FragmentCreateRecipeBinding
import com.shinkevich.dishcraft.view.adapters.IngredientsAddAdapter
import com.shinkevich.dishcraft.view.adapters.StepsAddAdapter

class CreateRecipeFragment : Fragment() {
    private lateinit var binding: FragmentCreateRecipeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCreateRecipeBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            ingredientsRecyclerView.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            ingredientsRecyclerView.adapter = IngredientsAddAdapter(listOf("", ""))

            stepsRecyclerView.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            stepsRecyclerView.adapter = StepsAddAdapter(listOf(""))
        }
    }
}