package de.nebensinn.fonefwd

enum class MainStates {
    START, ADDING
}

class MainState(private val ruleModel: IRuleModel = RuleModel(), initialState: MainStates) : State<MainStates>(initialState) {
    fun addRule(rule: Rule) {
        if (_state != MainStates.ADDING) {
            _state = MainStates.ADDING
            ruleModel.addRule(rule)
        }
    }
}