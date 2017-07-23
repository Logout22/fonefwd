package de.nebensinn.fonefwd

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View

class MainActivity() : Activity() {

    val uiState: UIState = UIState(UIStates.MAIN)

    fun switchToViewRulesActivity() {
        val intent = Intent(this, ViewRulesActivity::class.java)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun viewRulesButtonClicked(view: View) {
        uiState.viewRules()
        switchToViewRulesActivity()
    }

    override fun onResume() {
        super.onResume()
        uiState.reset()
    }
}
