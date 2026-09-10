package dev.atick.compose.repository.analysis

import dev.atick.compose.data.analysis.UiAnalysis
import dev.atick.compose.data.analysis.toUiAnalyses
import dev.atick.storage.room.data.AnalysisDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * Implementation of [AnalysisRepository] that fetches data from the [AnalysisDataSource].
 *
 * @param analysisDataSource The data source for analysis data.
 */
class AnalysisRepositoryImpl @Inject constructor(
    private val analysisDataSource: AnalysisDataSource,
) : AnalysisRepository {

    /**
     * Gets the category analyses.
     *
     * @param startDate The start date of the analysis.
     * @param endDate The end date of the analysis.
     * @param topN The number of top categories to fetch.
     * @return A [Flow] of [List] of [UiAnalysis] representing the category analyses.
     */
    override fun getCategoryAnalyses(
        startDate: Long,
        endDate: Long,
        topN: Int,
    ): Flow<List<UiAnalysis>> {
        return analysisDataSource.getCategoryAnalyses(startDate, endDate, topN)
            .map { analyses -> analyses.toUiAnalyses() }
    }

    /**
     * Gets the merchant analyses.
     *
     * @param startDate The start date of the analysis.
     * @param endDate The end date of the analysis.
     * @param topN The number of top merchants to fetch.
     * @return A [Flow] of [List] of [UiAnalysis] representing the merchant analyses.
     */
    override fun getMerchantAnalyses(
        startDate: Long,
        endDate: Long,
        topN: Int,
    ): Flow<List<UiAnalysis>> {
        return analysisDataSource.getMerchantAnalyses(startDate, endDate, topN)
            .map { analyses -> analyses.toUiAnalyses() }
    }

    /**
     * Gets the total spending.
     *
     * @param startDate The start date of the analysis.
     * @param endDate The end date of the analysis.
     * @return A [Flow] of [Double] representing the total spending.
     */
    override fun getTotalSpending(
        startDate: Long,
        endDate: Long,
    ): Flow<Double> {
        return analysisDataSource.getTotalSpending(startDate, endDate)
    }
}
