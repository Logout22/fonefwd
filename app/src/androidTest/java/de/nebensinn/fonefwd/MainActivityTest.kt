package de.nebensinn.fonefwd

import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.intent.Intents
import android.support.test.espresso.intent.Intents.intended
import android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4

import org.junit.Rule;
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
}
