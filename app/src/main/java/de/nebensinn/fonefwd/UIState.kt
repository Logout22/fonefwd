package de.nebensinn.fonefwd

enum class UIStates {
    MAIN, RULES
}

class UIState(val activity: ActivityChanger, private var _state: UIStates) {
    private val originalState = _state
    val state: UIStates get() = _state

    fun viewRules() {
        if (_state != UIStates.RULES) {
            _state = UIStates.RULES
            activity.changeActivityTo(ViewRules::class.java)
        }
    }

    fun reset() {
        _state = originalState
    }
}