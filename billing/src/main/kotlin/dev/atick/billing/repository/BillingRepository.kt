package dev.atick.billing.repository

import android.app.Activity
import dev.atick.billing.models.Product
import kotlinx.coroutines.flow.StateFlow

/**
 * Interface defining repository operations for billing.
 */
interface BillingRepository {
    /**
     * Flow of available products.
     *
     * @return The flow of available [Product]s.
     */
    val products: StateFlow<List<Product>>

    /**
     * Updates the products and purchases.
     *
     * @return A [Result] of [Unit].
     */
    suspend fun updateProductsAndPurchases(): Result<Unit>

    /**
     * Purchase a product.
     *
     * @param activity The activity instance.
     * @param product The product to purchase.
     * @return A [Result] of [Unit].
     */
    suspend fun purchaseProduct(activity: Activity, product: Product): Result<Unit>
}
