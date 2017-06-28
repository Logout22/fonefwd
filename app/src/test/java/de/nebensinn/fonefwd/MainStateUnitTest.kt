package de.nebensinn.fonefwd

import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito.*

class MainStateUnitTest {
    val rule = Rule("param1", "param2")
    val ruleModelMock = mock(IRuleModel::class.java)!!

    @Test
    fun addRule_shouldChangeStateToAdding() {
        val mainState = MainState(ruleModelMock, MainStates.START)
        mainState.addRule(rule)
        assertEquals(MainStates.ADDING, mainState.state)
    }

    @Test
    fun viewRules_shouldAddRuleInStartState() {
        val mainState = MainState(ruleModelMock, MainStates.START)
        mainState.addRule(rule)
        verify(ruleModelMock).addRule(rule)
    }

    @Test
    fun viewRules_shouldNotAddRuleInAddingState() {
        val mainState = MainState(ruleModelMock, MainStates.ADDING)
        mainState.addRule(rule)
        verify(ruleModelMock, never()).addRule(rule)
    }
}