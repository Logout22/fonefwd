package de.nebensinn.fonefwd

import org.junit.Test

import org.junit.Assert.*
import org.mockito.Mockito.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class RuleModelUnitTest {
    val ruleModel = RuleModel()

    @Test
    fun addRule_shouldAddNewRule() {
        assertEquals(emptySet<Rule>(), ruleModel.rules)
        val newRule = Rule("MyWifi", "12345")
        ruleModel.addRule(newRule)
        assertTrue(ruleModel.rules.contains(newRule))
    }

    @Test
    fun addRule_shouldNotAddDuplicateRule() {
        val newRule = Rule("MyWifi", "12345")
        assertTrue(ruleModel.addRule(newRule))
        assertFalse(ruleModel.addRule(newRule))
    }
}
