package dev.atick.storage.room.data

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.atick.storage.room.dao.BudgetDao
import dev.atick.storage.room.dao.ChatDao
import dev.atick.storage.room.dao.ExpenseDao
import dev.atick.storage.room.models.BudgetEntity
import dev.atick.storage.room.models.ChatEntity
import dev.atick.storage.room.models.ExpenseEntity

/**
 * Room database for Expense.
 */
@Database(
    version = 1,
    exportSchema = false,
    entities = [
        ExpenseEntity::class,
    ],
)
abstract class ExpenseDatabase : RoomDatabase() {
    /**
     * Get the data access object for [ExpenseEntity] entity.
     *
     * @return The data access object for [ExpenseEntity] entity.
     */
    abstract fun getExpenseDao(): ExpenseDao
}

/**
 * Room database for Budget.
 */
@Database(
    version = 1,
    exportSchema = false,
    entities = [
        BudgetEntity::class,
    ],
)
abstract class BudgetDatabase : RoomDatabase() {
    /**
     * Get the data access object for [BudgetEntity] entity.
     *
     * @return The data access object for [BudgetEntity] entity.
     */
    abstract fun getBudgetDao(): BudgetDao
}

/**
 * Room database for Chat.
 */
@Database(
    version = 1,
    exportSchema = false,
    entities = [
        ChatEntity::class,
    ],
)
abstract class ChatDatabase : RoomDatabase() {
    /**
     * Get the data access object for [ChatEntity] entity.
     *
     * @return The data access object for [ChatEntity] entity.
     */
    abstract fun getChatDao(): ChatDao
}
