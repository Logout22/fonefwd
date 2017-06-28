package de.nebensinn.fonefwd

import android.content.Context
import android.content.Intent

interface IActivityChanger {
    fun setContext(context: Context)
    fun <T : Class<*>> changeActivityTo(newActivity: T)
}

class ActivityChanger : IActivityChanger {
    lateinit private var context: Context

    override fun setContext(context: Context) {
        this.context = context
    }

    override fun <T : Class<*>> changeActivityTo(newActivity: T) {
        val intent = Intent(context, newActivity)
        context.startActivity(intent)
    }
}