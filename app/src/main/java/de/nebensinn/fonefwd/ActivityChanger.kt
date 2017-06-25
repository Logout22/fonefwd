package de.nebensinn.fonefwd

import android.content.Context

interface ActivityChanger {
    fun setContext(context: Context)
    fun <T : Class<*>> changeActivityTo(newActivity: T)
}