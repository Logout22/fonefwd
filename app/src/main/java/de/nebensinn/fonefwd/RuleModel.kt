package de.nebensinn.fonefwd

data class Rule(val wifiSSID: String, val targetPhoneNumber: String)

interface IRuleModel {
    fun addRule(rule: Rule): Boolean
}

class RuleModel() : IRuleModel {
    private val ruleList = mutableSetOf<Rule>()
    val rules: Set<Rule> get() = ruleList

    override fun addRule(rule: Rule): Boolean  = ruleList.add(rule)
}