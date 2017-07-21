package de.nebensinn.fonefwd

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View

class MainActivity() : Activity() {

    val uiState: UIState = UIState(UIStates.MAIN)

    lateinit private var context: Context

    fun <T : Class<*>> changeActivityTo(newActivity: T) {
        val intent = Intent(context, newActivity)
        context.startActivity(intent)
    }

    init {
        this.context = context
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun viewRulesButtonClicked(view: View) {
        uiState.viewRules()
        changeActivityTo(ViewRules::class.java)
    }

    override fun onResume() {
        super.onResume()
        uiState.reset()
    }
}
