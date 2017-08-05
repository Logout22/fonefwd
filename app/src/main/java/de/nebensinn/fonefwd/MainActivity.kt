package de.nebensinn.fonefwd

import android.app.Activity
import android.content.Intent
import android.os.Bundle

class MainActivity() : Activity() {
    val ruleModel = RuleModel()

    fun switchToViewRulesActivity() {
        val intent = Intent(this, ViewRulesActivity::class.java)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun viewRulesButtonClicked() {
        switchToViewRulesActivity()
    }

    fun activateWiFi(ssid: String) {

    }
}
