package de.nebensinn.fonefwd

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
        val activity = testRule.activity
        val viewButton = activity.findViewById(R.id.viewActiveRulesButton)
        // TODO wrong thread: viewButton.performClick()

        // TODO Test with Espresso
        /*Intents.init()
        intending(anyOf(hasComponent(MainActivity::class.java.name), hasComponent(OnboardingActivity::class.java!!.getName())))
                .respondWith(Instrumentation.ActivityResult(Activity.RESULT_CANCELED, null))
        // inject User instance here
        mActivityRule.launchActivity(null)
        intended(hasComponent(MainActivity::class.java.name), times(1))
        Intents.release()*/
    }
}
