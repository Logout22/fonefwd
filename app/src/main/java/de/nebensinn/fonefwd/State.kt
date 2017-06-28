package de.nebensinn.fonefwd

open class State<T>(protected var _state: T) {
    private val originalState = _state
    val state: T get() = _state

    fun reset() {
        _state = originalState
    }
}