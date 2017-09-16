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

    @Test
    fun updateRule_shouldIgnoreUpdatesToNonExistingRules() {
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
    fun loadRules_shouldLoadRulesFromMap() {
        val validMap = mapOf(
                Pair("0_ssid", "ssid1"),
                Pair("0_phone","1234"),
                Pair("1_ssid", "ssid2"),
                Pair("1_phone","5678")
        )
        ruleModel.loadRules(validMap)
        assertEquals(2, ruleModel.rules.size)
    }

    @Test
    fun loadRules_shouldNotLoadRulesFromMapIfKeyNotIndex() {
        val invalidMap = mapOf(Pair("key", setOf("")))
        ruleModel.loadRules(invalidMap)
        assertEquals(0, ruleModel.rules.size)
    }

    @Test
    fun loadRules_shouldNotLoadRulesFromMapIfTypeMismatches() {
        val invalidMap = mapOf(Pair("0_ssid", 8.7), Pair("0_phone", 12))
        ruleModel.loadRules(invalidMap)
        assertEquals(0, ruleModel.rules.size)
    }

    @Test
    fun removeRule_shouldRemoveExistingRule() {

    }

    @Test
    fun removeRule_shouldFailIfRuleDoesNotExist() {

    }
}
