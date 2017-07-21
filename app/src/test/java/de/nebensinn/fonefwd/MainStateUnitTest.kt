package de.nebensinn.fonefwd

import org.junit.Assert.assertEquals
import org.junit.Test

class MainStateUnitTest {
    @Test
    fun addRule_shouldChangeStateToAdding() {
        val mainState = MainState(MainStates.START)
        mainState.startAddingRules()
        assertEquals(MainStates.ADDING, mainState.state)
    }
}