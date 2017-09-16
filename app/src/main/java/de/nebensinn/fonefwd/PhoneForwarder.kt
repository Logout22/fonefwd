package de.nebensinn.fonefwd

class PhoneForwarder {
    fun wifiEnabled(
            ssid: String,
            model: RuleModel
    ): String? {
        for ((wifiSSID, targetPhoneNumber) in model.rules) {
            if (wifiSSID == ssid) {
                return targetPhoneNumber
            }
        }
        return null
    }
}