package de.nebensinn.fonefwd

import org.junit.Test

import org.junit.Assert.*

class RuleModelUnitTest {
    val ruleModel = RuleModel()

    @Test
    fun addRule_shouldAddNewRule() {
        assertEquals(emptyList<Rule>(), ruleModel.rules)
        val newRule = Rule("MyWifi", "12345")
        ruleModel.addRule(newRule)
        assertTrue(ruleModel.rules.contains(newRule))
        assertEquals(1, ruleModel.rules.count())
    }

    @Test
    fun addRule_shouldNotAddDuplicateRule() {
        val newRule = Rule("MyWifi", "12345")
        ruleModel.addRule(newRule)
        ruleModel.addRule(newRule)
        assertEquals(1, ruleModel.rules.count())
    }

    @Test
    fun addRule_shouldIgnoreNullRule() {
        assertEquals(emptyList<Rule>(), ruleModel.rules)
        ruleModel.addRule(null)
        assertEquals(emptyList<Rule>(), ruleModel.rules)
    }
}
