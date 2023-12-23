package com.shinkevich.dishcraft.data.repository

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class TokenRepository @Inject constructor(@ApplicationContext private val context: Context) {
    private val USER_PREFERENCES = "user_preferences"
    private val TOKEN = "token"

    fun saveToken(token: String) {
        val prefs = context.getSharedPreferences(USER_PREFERENCES, Context.MODE_PRIVATE)
        val prefEditor = prefs.edit()
        prefEditor.putString(TOKEN, token)
        prefEditor.commit()
    }

    fun getToken() : String? {
        val prefs = context.getSharedPreferences(USER_PREFERENCES, Context.MODE_PRIVATE)
        return prefs.getString(TOKEN, null)
    }
}