package com.shinkevich.dishcraft.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.shinkevich.dishcraft.R

class DrawerArrayAdapter(context: Context, resource: Int, objects: Array<String>) : ArrayAdapter<String>(context, resource, objects) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = if (position == 0) {
            LayoutInflater.from(context).inflate(R.layout.drawer_create_btn, parent, false)
        } else {
            super.getView(position, convertView, parent)
        }
        return view
    }
}