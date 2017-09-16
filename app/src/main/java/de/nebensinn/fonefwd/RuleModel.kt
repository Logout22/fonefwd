package de.nebensinn.fonefwd

import android.renderscript.RSInvalidStateException
import java.io.Serializable

data class Rule(val wifiSSID: String, val targetPhoneNumber: String) : Serializable {
    override fun toString(): String = "When on $wifiSSID, forward to $targetPhoneNumber"
}

interface IRuleModel {
    fun addRule(rule: Rule?): Int?
    fun updateRule(indexString: String, changedRule: Rule)
    fun loadRules(ruleMap: Map<String, *>)
}

class RuleModel : IRuleModel {
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
        // TODO provide log for the status label
        if (index >= 0 && index < ruleList.count()) {
            ruleList[index] = changedRule
        }
    }

    override fun loadRules(ruleMap: Map<String, *>) {
        for (index in 0 until ruleMap.keys.size) {
            val ssidKey = "${index}_ssid"
            val phoneKey = "${index}_phone"
            if (!(ruleMap.containsKey(ssidKey) && ruleMap.containsKey(phoneKey))) {
                break
            }
            try {
                val currentSSID = ruleMap[ssidKey] as String
                val currentPhone = ruleMap[phoneKey] as String
                addRule(Rule(currentSSID, currentPhone))
            } catch (_: ClassCastException) {
                // TODO provide log for the status label
                break
            }
        }
    }
}