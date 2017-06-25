package de.nebensinn.fonefwd

import android.content.Context
import android.content.Intent

class AndroidActivityChanger : ActivityChanger {
    lateinit private var context: Context

    override fun setContext(context: Context) {
        this.context = context
    }

    override fun <T : Class<*>> changeActivityTo(newActivity: T) {
        val intent = Intent(context, newActivity)
        context.startActivity(intent)
    }
}