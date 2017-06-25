package de.nebensinn.fonefwd

import android.app.Activity
import android.os.Bundle
import android.view.View

class MainActivity(val activityChanger: ActivityChanger = AndroidActivityChanger())
    : Activity(), ActivityChanger by activityChanger {

    val uiState: UIState = UIState(this, UIStates.MAIN)

    init {
        activityChanger.setContext(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun viewRulesButtonClicked(view: View) {
        uiState.viewRules()
    }

    override fun onResume() {
        super.onResume()
        uiState.reset()
    }
}
