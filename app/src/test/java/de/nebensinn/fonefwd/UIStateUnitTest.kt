package de.nebensinn.fonefwd

import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito.*

class UIStateUnitTest {
    val mainActivityMock = mock(IActivityChanger::class.java)!!

    @Test
    fun viewRules_shouldChangeStateToRules() {
        val uiState = UIState(mainActivityMock, UIStates.MAIN)
        uiState.viewRules()
        assertEquals(UIStates.RULES, uiState.state)
    }

    @Test
    fun viewRules_shouldTransitionToRulesInMainState() {
        val uiState = UIState(mainActivityMock, UIStates.MAIN)
        uiState.viewRules()
        verify(mainActivityMock).changeActivityTo(ViewRules::class.java)
    }

    @Test
    fun viewRules_shouldNotTransitionToRulesInRulesState() {
        val uiState = UIState(mainActivityMock, UIStates.RULES)
        uiState.viewRules()
        verify(mainActivityMock, never()).changeActivityTo(ViewRules::class.java)
    }
}