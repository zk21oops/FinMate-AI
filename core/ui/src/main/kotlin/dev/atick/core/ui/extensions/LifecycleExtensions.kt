package dev.atick.core.ui.extensions

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import dev.atick.core.utils.SingleLiveEvent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

/**
 * Observe a [LiveData] and execute an action when the value is changed.
 *
 * @param action The action to be executed when the value is changed.
 */
inline fun <T> LifecycleOwner.observe(
    liveData: LiveData<T>,
    crossinline action: (T) -> Unit,
) {
    liveData.observe(this) { value ->
        value?.let { action(value) }
    }
}

/**
 * Observe a [LiveData] and execute an action when the value is changed.
 *
 * @param action The action to be executed when the value is changed.
 */
inline fun <T> LifecycleOwner.observeEvent(
    liveData: LiveData<SingleLiveEvent<T>>,
    crossinline action: (T) -> Unit,
) {
    liveData.observe(this) {
        it?.getContentIfNotHandled()?.let(action)
    }
}

/**
 * Observe a [LiveData] and execute an action when the value is changed.
 *
 * @param action The action to be executed when the value is changed.
 */
inline fun <T> LifecycleOwner.observeEvent(
    liveData: MutableLiveData<SingleLiveEvent<T>>,
    crossinline action: (T) -> Unit,
) {
    liveData.observe(this) {
        it?.getContentIfNotHandled()?.let(action)
    }
}

/**
 * Observe a [Flow] and execute an action when the value is changed.
 *
 * @param action The action to be executed when the value is changed.
 */
inline fun <T> LifecycleOwner.collectWithLifecycle(
    flow: Flow<T>,
    crossinline action: (T) -> Unit,
) {
    lifecycleScope.launch {
        repeatOnLifecycle(Lifecycle.State.STARTED) {
            flow.collect {
                it?.let { action(it) }
            }
        }
    }
}
