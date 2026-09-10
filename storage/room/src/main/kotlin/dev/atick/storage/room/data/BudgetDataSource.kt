package dev.atick.storage.room.data

import dev.atick.storage.room.models.BudgetEntity
import kotlinx.coroutines.flow.Flow

/**
 * Interface for accessing and managing budget data.
 */
interface BudgetDataSource {
    /**
     * Retrieves the budget for a specific month.
     *
     * @param month The month for which the budget is to be retrieved, represented as milliseconds since epoch.
     * @return A Flow emitting the BudgetEntity for the specified month, or null if no budget is found.
     */
    fun getBudgetForMonth(month: Long): Flow<BudgetEntity?>

    /**
     * Inserts or updates a budget in the data source.
     *
     * @param budget The BudgetEntity to be inserted or updated.
     */
    suspend fun insertOrUpdateBudget(budget: BudgetEntity)

    /**
     * Deletes a budget from the data source.
     *
     * @param budget The BudgetEntity to be deleted.
     */
    suspend fun deleteBudget(budget: BudgetEntity)
}
