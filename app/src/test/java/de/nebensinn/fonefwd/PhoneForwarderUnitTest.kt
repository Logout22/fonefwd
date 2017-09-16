package de.nebensinn.fonefwd

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class PhoneForwarderUnitTest {
    val ruleModel = RuleModel()
    val phoneForwarder = PhoneForwarder()

    init {
        ruleModel.addRule(Rule("ssid", "number"))
        ruleModel.addRule(Rule("rightssid", "othernumber"))
    }

    @Test
    fun wifiEnabled_shouldReturnPhoneNumberOnMatchingRule() {
        val result = phoneForwarder.wifiEnabled("rightssid", ruleModel)
        assertEquals("othernumber", result)
    }

    @Test
    fun wifiEnabled_shouldReturnNullOnNonMatchingRule() {
        val invalidResult = phoneForwarder.wifiEnabled("wrongssid", ruleModel)
        assertEquals(null, invalidResult)
    }
}