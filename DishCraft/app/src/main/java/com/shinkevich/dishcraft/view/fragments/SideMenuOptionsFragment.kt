package com.shinkevich.dishcraft.view.fragments

import android.os.Bundle
import android.text.Layout
import android.text.SpannableString
import android.text.style.AlignmentSpan
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView.OnQueryTextListener
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.navigation.NavigationView
import com.shinkevich.dishcraft.R
import com.shinkevich.dishcraft.databinding.DrawerHeaderBinding
import com.shinkevich.dishcraft.databinding.FragmentSideMenuOptionsBinding
import com.shinkevich.dishcraft.viewmodel.RecipeListViewModel

class SideMenuOptionsFragment : Fragment() {
    private lateinit var binding: FragmentSideMenuOptionsBinding
    private lateinit var navController: NavController

    private val viewModel by viewModels<RecipeListViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSideMenuOptionsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = (childFragmentManager.findFragmentById(R.id.sideMenuNavHost) as NavHostFragment).navController
        //NavigationUI.setupWithNavController(binding.navView, navController)

        binding.apply {
            navView.menu.centerTitles()
            val headerBinding = DrawerHeaderBinding.bind(navView.getHeaderView(0))
            headerBinding.createRecipeBtn.setOnClickListener {
                navController.navigate(R.id.action_global_createRecipeFragment)
                drawerLayout.closeDrawer(GravityCompat.START)
            }

            navView.setNavigationItemSelectedListener(navItemSelectedListener)

            filterImgBtn.setOnClickListener {
                val action = SideMenuOptionsFragmentDirections.actionSideMenuFragmentToFiltersFragment()
                findNavController().navigate(action)
            }

            searchView.setOnQueryTextListener(object : OnQueryTextListener{
                override fun onQueryTextSubmit(searchQuery: String?): Boolean {
                    return false
                }

                override fun onQueryTextChange(p0: String?): Boolean {
                    return false
                }
            })
        }
    }

    private val navItemSelectedListener = NavigationView.OnNavigationItemSelectedListener { menuItem->
        val navController = (childFragmentManager.findFragmentById(R.id.sideMenuNavHost) as NavHostFragment).navController
        when(menuItem.itemId){
            R.id.recipeListFragment -> navController.navigateUp()
            R.id.myRecipesFragment -> navController.navigate(R.id.action_global_myRecipesFragment)
            R.id.favouriteRecipesFragment -> navController.navigate(R.id.action_global_favouriteRecipesFragment)
        }
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        true
    }

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