package de.nebensinn.fonefwd

import org.junit.Assert.assertEquals
import org.junit.Test

class UIStateUnitTest {
    @Test
    fun viewRules_shouldChangeStateToRules() {
        val uiState = UIState(UIStates.MAIN)
        uiState.viewRules()
        assertEquals(UIStates.RULES, uiState.state)
    }
}