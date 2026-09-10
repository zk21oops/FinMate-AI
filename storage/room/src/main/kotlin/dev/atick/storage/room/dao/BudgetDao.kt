package dev.atick.storage.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import dev.atick.storage.room.models.BudgetEntity
import kotlinx.coroutines.flow.Flow

/**
 * Data Access Object (DAO) for the budgets table.
 */
@Dao
interface BudgetDao {
    /**
     * Returns a [Flow] of [BudgetEntity] representing the budget for the given month.
     *
     * @param month The month for which the budget is to be retrieved.
     * @return A [Flow] of [BudgetEntity] representing the budget for the given month.
     */
    @Query("SELECT * FROM budgets WHERE month = :month")
    fun getBudgetForMonth(month: Long): Flow<BudgetEntity?>

    /**
     * Inserts or updates the given [BudgetEntity] in the budgets table.
     *
     * @param budget The [BudgetEntity] to be inserted or updated.
     */
    @Upsert
    suspend fun insertOrUpdateBudget(budget: BudgetEntity)

    /**
     * Deletes the given [BudgetEntity] from the budgets table.
     *
     * @param budget The [BudgetEntity] to be deleted.
     */
    @Delete
    suspend fun deleteBudget(budget: BudgetEntity)
}
