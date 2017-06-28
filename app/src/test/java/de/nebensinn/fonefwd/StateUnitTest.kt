package de.nebensinn.fonefwd

import org.junit.Assert.assertEquals
import org.junit.Test

class StateUnitTest {

    enum class TestStates {INITIAL_STATE, DIFFERENT_STATE }

    class TestState(state: TestStates) : State<TestStates>(state) {
        fun changeState(to: TestStates) {
            _state = to
        }
    }

    @Test
    fun reset_shouldChangeStateToMain() {
        val testState = TestState(TestStates.INITIAL_STATE)
        testState.changeState(TestStates.DIFFERENT_STATE)
        assertEquals(TestStates.DIFFERENT_STATE, testState.state)
        testState.reset()
        assertEquals(TestStates.INITIAL_STATE, testState.state)
    }
}