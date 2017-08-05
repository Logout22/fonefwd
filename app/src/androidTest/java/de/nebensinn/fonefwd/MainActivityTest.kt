package de.nebensinn.fonefwd

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.intent.Intents
import android.support.test.espresso.intent.Intents.intended
import android.support.test.espresso.intent.matcher.IntentMatchers.*
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.hamcrest.core.AllOf.allOf
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @get:Rule
    val testRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Test
    fun switchToRulesView() {
        Intents.init()
        onView(withId(R.id.viewActiveRulesButton)).perform(click())
        intended(hasComponent(ViewRulesActivity::class.java.name))
    }

    @Test
    fun shouldCallNumberWhenRuleIsActivated() {
        val rule = Rule("ssid", "123456789")
        val mainActivity = testRule.activity as MainActivity
        val prefsEditor = mainActivity.getPreferences(Context.MODE_PRIVATE).edit()
        prefsEditor.putStringSet("1", rule.toStringSet())
        assertTrue(prefsEditor.commit())
        mainActivity.activateWiFi(rule.wifiSSID)
        intended(allOf(
                hasAction(Intent.ACTION_CALL),
                hasData(Uri.parse("tel:" + rule.targetPhoneNumber))
        ))
    }
}
