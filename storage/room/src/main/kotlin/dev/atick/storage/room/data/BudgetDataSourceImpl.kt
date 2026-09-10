package dev.atick.storage.room.data

import dev.atick.core.di.IoDispatcher
import dev.atick.storage.room.dao.BudgetDao
import dev.atick.storage.room.models.BudgetEntity
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Implementation of the BudgetDataSource interface for accessing and managing budget data.
 *
 * @property budgetDao The DAO for accessing budget data.
 * @property ioDispatcher The CoroutineDispatcher for IO operations.
 */
class BudgetDataSourceImpl @Inject constructor(
    private val budgetDao: BudgetDao,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
) : BudgetDataSource {

    /**
     * Retrieves the budget for a specific month.
     *
     * @param month The month for which the budget is to be retrieved, represented as milliseconds since epoch.
     * @return A Flow emitting the BudgetEntity for the specified month, or null if no budget is found.
     */
    override fun getBudgetForMonth(month: Long): Flow<BudgetEntity?> {
        return budgetDao.getBudgetForMonth(month).flowOn(ioDispatcher)
    }

    /**
     * Inserts or updates a budget in the data source.
     *
     * @param budget The BudgetEntity to be inserted or updated.
     */
    override suspend fun insertOrUpdateBudget(budget: BudgetEntity) {
        withContext(ioDispatcher) {
            budgetDao.insertOrUpdateBudget(budget)
        }
    }

    /**
     * Deletes a budget from the data source.
     *
     * @param budget The BudgetEntity to be deleted.
     */
    override suspend fun deleteBudget(budget: BudgetEntity) {
        withContext(ioDispatcher) {
            budgetDao.deleteBudget(budget)
        }
    }
}
