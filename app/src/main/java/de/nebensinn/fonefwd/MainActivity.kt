package de.nebensinn.fonefwd

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View

class MainActivity() : Activity() {

    val uiState: UIState = UIState(UIStates.MAIN)

    fun <T : Class<*>> changeActivityTo(newActivity: T) {
        val intent = Intent(this, newActivity)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun viewRulesButtonClicked(view: View) {
        uiState.viewRules()
        changeActivityTo(ViewRulesActivity::class.java)
    }

    override fun onResume() {
        super.onResume()
        uiState.reset()
    }
}
