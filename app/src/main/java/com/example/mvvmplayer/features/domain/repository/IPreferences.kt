package com.example.mvvmplayer.features.domain.repository

import android.content.Context
import androidx.core.content.edit
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

private const val PREFS = "prefs"
private const val SESSION = "session"

class PreferencesImpl(context: Context) : IPreferences {

    private val prefs = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE)

    override suspend fun getSession(): Boolean {
        return withContext(Dispatchers.IO) {
            prefs.getBoolean(SESSION, false)
        }
    }

    override suspend fun setSession() {
        withContext(Dispatchers.IO) {
            prefs.edit { putBoolean(PREFS, true) }
        }
    }

    override suspend fun clear() {
        withContext(Dispatchers.IO) {
            prefs.edit {
                remove(SESSION)
            }
        }
    }
}


interface IPreferences {
    suspend fun getSession() : Boolean
    suspend fun setSession()
    suspend fun clear()
}