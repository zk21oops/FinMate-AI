package dev.atick.storage.room.data

import dev.atick.storage.room.models.ExpenseAnalysis
import kotlinx.coroutines.flow.Flow

/**
 * Interface for accessing and analyzing expense data.
 */
interface AnalysisDataSource {
    /**
     * Retrieves category analyses for expenses within a specified date range.
     *
     * @param startDate The start date of the range (inclusive) in milliseconds since epoch.
     * @param endDate The end date of the range (inclusive) in milliseconds since epoch.
     * @param topN The number of top categories to retrieve.
     * @return A Flow emitting a list of ExpenseAnalysis objects for the top categories.
     */
    fun getCategoryAnalyses(startDate: Long, endDate: Long, topN: Int): Flow<List<ExpenseAnalysis>>

    /**
     * Retrieves merchant analyses for expenses within a specified date range.
     *
     * @param startDate The start date of the range (inclusive) in milliseconds since epoch.
     * @param endDate The end date of the range (inclusive) in milliseconds since epoch.
     * @param topN The number of top merchants to retrieve.
     * @return A Flow emitting a list of ExpenseAnalysis objects for the top merchants.
     */
    fun getMerchantAnalyses(startDate: Long, endDate: Long, topN: Int): Flow<List<ExpenseAnalysis>>

    /**
     * Retrieves the total spending within a specified date range.
     *
     * @param startDate The start date of the range (inclusive) in milliseconds since epoch.
     * @param endDate The end date of the range (inclusive) in milliseconds since epoch.
     * @return A Flow emitting the total spending as a Double.
     */
    fun getTotalSpending(startDate: Long, endDate: Long): Flow<Double>
}
