package com.shinkevich.dishcraft.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.shinkevich.dishcraft.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //findViewById<FrameLayout>(R.id.mainFrameLayout).setPadding(5,10+getStatusBarHeight(),5,10)
        /*findViewById<FrameLayout>(R.id.mainFrameLayout).setPadding(0,getStatusBarHeight(),0,0)

        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )*/
    }

    fun getStatusBarHeight(): Int {
        var result = 0
        val resourceId = resources.getIdentifier("status_bar_height", "dimen", "android")
        if (resourceId > 0) {
            result = resources.getDimensionPixelSize(resourceId)
        }
        return result
    }
}