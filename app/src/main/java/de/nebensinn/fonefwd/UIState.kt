package de.nebensinn.fonefwd

enum class UIStates {
    MAIN, RULES
}

class UIState(private val activity: IActivityChanger, initialState: UIStates) : State<UIStates>(initialState) {
    fun viewRules() {
        if (_state != UIStates.RULES) {
            _state = UIStates.RULES
            activity.changeActivityTo(ViewRules::class.java)
        }
    }
}