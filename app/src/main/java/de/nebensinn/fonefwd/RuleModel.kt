package de.nebensinn.fonefwd

import android.renderscript.RSInvalidStateException
import java.io.Serializable

data class Rule(val wifiSSID: String, val targetPhoneNumber: String) : Serializable {
    override fun toString(): String = "When on $wifiSSID, forward to $targetPhoneNumber"
    fun toStringSet(): MutableSet<String> = mutableSetOf(wifiSSID, targetPhoneNumber)
}

interface IRuleModel {
    fun addRule(rule: Rule?): Int?
    fun updateRule(indexString: String, changedRule: Rule)
}

class RuleModel() : IRuleModel {
    private val ruleList = mutableListOf<Rule>()
    val rules: List<Rule> get() = ruleList.toList()

    override fun addRule(rule: Rule?): Int? {
        if (rule == null || ruleList.contains(rule)) {
            return null
        }

        ruleList.add(rule)
        return ruleList.count() - 1
    }

    override fun updateRule(indexString: String, changedRule: Rule) {
        val index = indexString.toInt()
        if (index < 0 || index >= ruleList.count()) {
            throw IllegalStateException()
        }
        ruleList[index] = changedRule
    }
}