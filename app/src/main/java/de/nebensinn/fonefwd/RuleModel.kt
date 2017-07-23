package de.nebensinn.fonefwd

import java.io.Serializable

data class Rule(val wifiSSID: String, val targetPhoneNumber: String) : Serializable {
    override fun toString(): String = "When on $wifiSSID, forward to $targetPhoneNumber"
}

interface IRuleModel {
    fun addRule(rule: Rule?)
}

class RuleModel() : IRuleModel {
    private val ruleList = mutableSetOf<Rule>()
    val rules: List<Rule> get() = ruleList.toList()

    override fun addRule(rule: Rule?) {
        if (rule != null) {
            ruleList.add(rule)
        }
    }
}