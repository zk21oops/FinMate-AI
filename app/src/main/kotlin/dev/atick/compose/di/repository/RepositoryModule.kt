package dev.atick.compose.di.repository

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.atick.compose.repository.analysis.AnalysisRepository
import dev.atick.compose.repository.analysis.AnalysisRepositoryImpl
import dev.atick.compose.repository.budgets.BudgetsRepository
import dev.atick.compose.repository.budgets.BudgetsRepositoryImpl
import dev.atick.compose.repository.chat.ChatRepository
import dev.atick.compose.repository.chat.ChatRepositoryImpl
import dev.atick.compose.repository.expenses.ExpensesRepository
import dev.atick.compose.repository.expenses.ExpensesRepositoryImpl
import dev.atick.compose.repository.subscriptions.SubscriptionsRepository
import dev.atick.compose.repository.subscriptions.SubscriptionsRepositoryImpl
import dev.atick.compose.repository.user.UserDataRepository
import dev.atick.compose.repository.user.UserDataRepositoryImpl
import javax.inject.Singleton

/**
 * Dagger module that provides the binding for repository interfaces.
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    /**
     * Binds the [UserDataRepositoryImpl] implementation to the [UserDataRepository] interface.
     *
     * @param userDataRepositoryImpl The implementation of [UserDataRepository] to be bound.
     * @return The [UserDataRepository] interface.
     */
    @Binds
    @Singleton
    abstract fun bindUserDataRepository(
        userDataRepositoryImpl: UserDataRepositoryImpl,
    ): UserDataRepository

    /**
     * Binds the [AnalysisRepositoryImpl] implementation to the [AnalysisRepository] interface.
     *
     * @param analysisRepositoryImpl The implementation of [AnalysisRepository] to be bound.
     * @return The [AnalysisRepository] interface.
     */
    @Binds
    @Singleton
    abstract fun bindAnalysisRepository(
        analysisRepositoryImpl: AnalysisRepositoryImpl,
    ): AnalysisRepository

    /**
     * Binds the [BudgetsRepositoryImpl] implementation to the [BudgetsRepository] interface.
     *
     * @param budgetsRepositoryImpl The implementation of [BudgetsRepository] to be bound.
     * @return The [BudgetsRepository] interface.
     */
    @Binds
    @Singleton
    abstract fun bindBudgetsRepository(
        budgetsRepositoryImpl: BudgetsRepositoryImpl,
    ): BudgetsRepository

    /**
     * Binds the [SubscriptionsRepositoryImpl] implementation to the [SubscriptionsRepository] interface.
     *
     * @param subscriptionRepositoryImpl The implementation of [SubscriptionsRepository] to be bound.
     * @return The [SubscriptionsRepository] interface.
     */
    @Binds
    @Singleton
    abstract fun bindCategoriesRepository(
        subscriptionRepositoryImpl: SubscriptionsRepositoryImpl,
    ): SubscriptionsRepository

    /**
     * Binds the [ChatRepositoryImpl] implementation to the [ChatRepository] interface.
     *
     * @param chatRepositoryImpl The implementation of [ChatRepository] to be bound.
     * @return The [ChatRepository] interface.
     */
    @Binds
    @Singleton
    abstract fun bindChatRepository(
        chatRepositoryImpl: ChatRepositoryImpl,
    ): ChatRepository

    /**
     * Binds the [ExpensesRepositoryImpl] implementation to the [ExpensesRepository] interface.
     *
     * @param expensesRepositoryImpl The implementation of [ExpensesRepository] to be bound.
     * @return The [ExpensesRepository] interface.
     */
    @Binds
    @Singleton
    abstract fun bindExpensesRepository(
        expensesRepositoryImpl: ExpensesRepositoryImpl,
    ): ExpensesRepository
}
