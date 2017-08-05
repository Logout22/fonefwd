package de.nebensinn.fonefwd

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class RuleModelUnitTest {
    val ruleModel = RuleModel()

    @Test
    fun addRule_shouldAddNewRule() {
        assertEquals(emptyList<Rule>(), ruleModel.rules)
        val newRule = Rule("MyWifi", "12345")
        val index = ruleModel.addRule(newRule)
        assertTrue(ruleModel.rules.contains(newRule))
        assertEquals(0, index)
        assertEquals(1, ruleModel.rules.count())
    }

    @Test
    fun addRule_shouldNotAddDuplicateRule() {
        val newRule = Rule("MyWifi", "12345")
        assertEquals(0, ruleModel.addRule(newRule))
        assertEquals(null, ruleModel.addRule(newRule))
        assertEquals(1, ruleModel.rules.count())
    }

    @Test
    fun addRule_shouldIgnoreNullRule() {
        assertEquals(emptyList<Rule>(), ruleModel.rules)
        assertEquals(null, ruleModel.addRule(null))
        assertEquals(emptyList<Rule>(), ruleModel.rules)
    }

    @Test(expected = NumberFormatException::class)
    fun updateRule_shouldFailOnNonIntIndex() {
        ruleModel.updateRule("twelve", Rule("", ""))
    }

    @Test(expected = IllegalStateException::class)
    fun updateRule_shouldFailIfRuleDoesNotExist() {
        ruleModel.addRule(Rule("MyWifi", "12345"))
        ruleModel.updateRule("1", Rule("", ""))
        ruleModel.updateRule("-22", Rule("", ""))
        ruleModel.updateRule("22", Rule("", ""))
    }

    @Test
    fun updateRule_shouldChangeExistingRule() {
        val oldRule = Rule("MyWifi", "12345")
        val ruleIndex = ruleModel.addRule(oldRule)
        assertEquals(oldRule, ruleModel.rules[ruleIndex!!])

        val newRule = Rule("MyNewWifi", "15764")
        ruleModel.updateRule(ruleIndex.toString(), newRule)
        assertEquals(newRule, ruleModel.rules[ruleIndex])
    }

    @Test
    fun removeRule_shouldRemoveExistingRule() {

    }

    @Test
    fun removeRule_shouldFailIfRuleDoesNotExist() {

    }
}
