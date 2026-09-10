package dev.atick.storage.room.models

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Entity representing a budget in the database.
 *
 * @property month The timestamp of the start of the month, used as the primary key.
 * @property amount The amount allocated for the budget.
 * @property description An optional description of the budget.
 */
@Entity(tableName = "budgets")
data class BudgetEntity(
    @PrimaryKey
    val month: Long, // Timestamp of the start of the month
    val amount: Double,
    val description: String? = null,
)
