package dev.atick.storage.room.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.atick.storage.room.data.AnalysisDataSource
import dev.atick.storage.room.data.AnalysisDataSourceImpl
import dev.atick.storage.room.data.BudgetDataSource
import dev.atick.storage.room.data.BudgetDataSourceImpl
import dev.atick.storage.room.data.ChatDataSource
import dev.atick.storage.room.data.ChatDataSourceImpl
import dev.atick.storage.room.data.ExpenseDataSource
import dev.atick.storage.room.data.ExpenseDataSourceImpl
import javax.inject.Singleton

/**
 * Dagger Hilt module responsible for providing implementations of data source interfaces.
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    /**
     * Binds the [ChatDataSourceImpl] implementation to the [ChatDataSource] interface.
     *
     * @param chatDataSourceImpl The concrete implementation of [ChatDataSourceImpl].
     * @return An instance of [ChatDataSource] representing the chat local data source.
     */
    @Binds
    @Singleton
    abstract fun bindChatDataSource(
        chatDataSourceImpl: ChatDataSourceImpl,
    ): ChatDataSource

    /**
     * Binds the [ExpenseDataSourceImpl] implementation to the [ExpenseDataSource] interface.
     *
     * @param expenseDataSourceImpl The concrete implementation of [ExpenseDataSourceImpl].
     * @return An instance of [ExpenseDataSource] representing the expense data source.
     */
    @Binds
    @Singleton
    abstract fun bindExpenseDataSource(
        expenseDataSourceImpl: ExpenseDataSourceImpl,
    ): ExpenseDataSource

    /**
     * Binds the [AnalysisDataSourceImpl] implementation to the [AnalysisDataSource] interface.
     *
     * @param analysisDataSourceImpl The concrete implementation of [AnalysisDataSourceImpl].
     * @return An instance of [AnalysisDataSource] representing the analysis data source.
     */
    @Binds
    @Singleton
    abstract fun bindAnalysesDataSource(
        analysisDataSourceImpl: AnalysisDataSourceImpl,
    ): AnalysisDataSource

    /**
     * Binds the [BudgetDataSourceImpl] implementation to the [BudgetDataSource] interface.
     *
     * @param budgetDataSourceImpl The concrete implementation of [BudgetDataSourceImpl].
     * @return An instance of [BudgetDataSource] representing the budget data source.
     */
    @Binds
    @Singleton
    abstract fun bindBudgetDataSource(
        budgetDataSourceImpl: BudgetDataSourceImpl,
    ): BudgetDataSource
}
