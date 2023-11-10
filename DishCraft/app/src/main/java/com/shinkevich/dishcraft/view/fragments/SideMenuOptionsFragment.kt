package com.shinkevich.dishcraft.view.fragments

import android.os.Bundle
import android.text.Layout
import android.text.SpannableString
import android.text.style.AlignmentSpan
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.shinkevich.dishcraft.R
import com.shinkevich.dishcraft.databinding.DrawerHeaderBinding
import com.shinkevich.dishcraft.databinding.FragmentSideMenuOptionsBinding

class SideMenuOptionsFragment : Fragment() {
    private lateinit var binding: FragmentSideMenuOptionsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSideMenuOptionsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController =
            (childFragmentManager.findFragmentById(R.id.sideMenuNavHost) as NavHostFragment).navController
        NavigationUI.setupWithNavController(binding.navView, navController)

        binding.apply {
            navView.menu.centerTitles()
            val headerBinding = DrawerHeaderBinding.bind(navView.getHeaderView(0))
            headerBinding.createRecipeBtn.setOnClickListener {
                navController.navigate(R.id.createRecipeFragment)
                drawerLayout.closeDrawer(GravityCompat.START)
            }
        }

        binding.filterImgBtn.setOnClickListener {
            val action = SideMenuOptionsFragmentDirections.actionSideMenuFragmentToFiltersFragment()
            findNavController().navigate(action)
        }
    }

    /*val navItemSelectedListener = NavigationView.OnNavigationItemSelectedListener { menuItem->
        val navController = (childFragmentManager.findFragmentById(R.id.sideMenuNavHost) as NavHostFragment).navController
        when(menuItem.itemId){
            //R.id.recipeListMenuItem -> navController.navigate(R.id.recipeListFragment)
        }
        true
    }*/

    private fun Menu.centerTitles() {
        for (i in 0 until size()) {
            val item = getItem(i)
            SpannableString(item.title).also {
                it.setSpan(AlignmentSpan.Standard(Layout.Alignment.ALIGN_CENTER), 0, it.length, 0)
                item.title = it
            }
        }
    }


}