package de.nebensinn.fonefwd

enum class UIStates {
    MAIN, RULES
}

class UIState(initialState: UIStates) : State<UIStates>(initialState) {
    fun viewRules() {
        if (_state != UIStates.RULES) {
            _state = UIStates.RULES
        }
    }
}