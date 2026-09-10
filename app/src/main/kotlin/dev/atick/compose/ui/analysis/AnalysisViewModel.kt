package dev.atick.compose.ui.analysis

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.atick.compose.data.analysis.AnalysisScreenData
import dev.atick.compose.repository.analysis.AnalysisRepository
import dev.atick.core.ui.utils.OneTimeEvent
import dev.atick.core.ui.utils.UiState
import dev.atick.core.ui.utils.updateState
import dev.atick.core.utils.MonthInfo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class AnalysisViewModel @Inject constructor(
    private val analysisRepository: AnalysisRepository,
) : ViewModel() {
    private val _analysisUiState = MutableStateFlow(UiState(AnalysisScreenData()))
    val analysisUiState = _analysisUiState.asStateFlow()

    fun refreshAnalysis(monthInfo: MonthInfo) {
        // Fetch the category and merchant analyses for the given month.
        analysisRepository.getCategoryAnalyses(
            startDate = monthInfo.startDate,
            endDate = monthInfo.endDate,
            topN = 10,
        )
            .catch { e -> _analysisUiState.update { it.copy(error = OneTimeEvent(e)) } }
            .combine(
                analysisRepository.getMerchantAnalyses(
                    startDate = monthInfo.startDate,
                    endDate = monthInfo.endDate,
                    topN = 10,
                ),
            ) { categoryAnalysis, merchantAnalysis ->
                _analysisUiState.updateState {
                    copy(
                        categoryAnalyses = categoryAnalysis,
                        merchantAnalyses = merchantAnalysis,
                    )
                }
            }
            .launchIn(viewModelScope)
    }
}
