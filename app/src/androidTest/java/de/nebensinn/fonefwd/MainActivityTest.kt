package de.nebensinn.fonefwd

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.intent.Intents
import android.support.test.espresso.intent.Intents.intended
import android.support.test.espresso.intent.matcher.IntentMatchers.*
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.hamcrest.core.AllOf.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

val rule = Rule("ssid", "123456789")

class ActivityTestRuleWithPreferences : ActivityTestRule<MainActivity>(MainActivity::class.java) {
    override fun beforeActivityLaunched() {
        val context = InstrumentationRegistry.getTargetContext()
        val prefsEditor = context.getSharedPreferences("MainActivity", Context.MODE_PRIVATE).edit()
        prefsEditor.clear()
        prefsEditor.putString("0_ssid", rule.wifiSSID)
        prefsEditor.putString("0_phone", rule.targetPhoneNumber)
        prefsEditor.commit()
        super.beforeActivityLaunched()
    }

}

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @get:Rule private val testRule = ActivityTestRuleWithPreferences()

    @Test
    fun switchToRulesView() {
        testRule.launchActivity(Intent())
        Intents.init()
        onView(withId(R.id.viewActiveRulesButton)).perform(click())
        intended(hasComponent(ViewRulesActivity::class.java.name))
    }

    @Test
    fun shouldCallNumberWhenRuleIsActivated() {
        val mainActivity = testRule.launchActivity(Intent())
        mainActivity.activateWiFi(rule.wifiSSID)
        intended(allOf(
                hasAction(Intent.ACTION_CALL),
                hasData(Uri.parse("tel:**21*${rule.targetPhoneNumber}#"))
        ))
    }

    @Test
    fun shouldCallNumberForNewRuleWhenWifiIsAlreadyActive() {
    }
}
