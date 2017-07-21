package de.nebensinn.fonefwd

enum class MainStates {
    START, ADDING
}

class MainState(initialState: MainStates) : State<MainStates>(initialState) {
    fun startAddingRules() {
        if (_state != MainStates.ADDING) {
            _state = MainStates.ADDING
        }
    }
}