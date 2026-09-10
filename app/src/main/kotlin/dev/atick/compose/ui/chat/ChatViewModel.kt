package dev.atick.compose.ui.chat

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.atick.compose.data.chat.ChatScreenData
import dev.atick.compose.repository.chat.ChatRepository
import dev.atick.core.ui.utils.OneTimeEvent
import dev.atick.core.ui.utils.TextFieldData
import dev.atick.core.ui.utils.UiState
import dev.atick.core.ui.utils.updateState
import dev.atick.core.ui.utils.updateWith
import dev.atick.core.utils.MonthInfo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(
    private val chatRepository: ChatRepository,
) : ViewModel() {
    private val _chatUiState = MutableStateFlow(UiState(ChatScreenData()))
    val chatUiState = _chatUiState.asStateFlow()

    init {
        chatRepository.getAllMessages()
            .onEach { messages ->
                _chatUiState.updateState {
                    copy(messages = messages)
                }
            }
            .catch { e -> _chatUiState.update { it.copy(error = OneTimeEvent(e)) } }
            .launchIn(viewModelScope)
    }

    fun initializeChat(monthInfo: MonthInfo, historyDepth: Int) {
        _chatUiState.updateWith(viewModelScope) {
            chatRepository.initializeChat(
                monthInfo,
                historyDepth,
            )
        }
    }

    fun onNewMessageUpdate(newMessage: String) {
        _chatUiState.updateState {
            copy(newMessage = TextFieldData(newMessage))
        }
    }

    fun onSendMessage() {
        val newMessage = chatUiState.value.data.newMessage.value
        _chatUiState.updateState { copy(newMessage = TextFieldData("")) }
        _chatUiState.updateWith(viewModelScope) { chatRepository.sendMessage(newMessage) }
    }
}
