package dev.atick.billing.data

import android.app.Activity
import dev.atick.billing.models.Product
import kotlinx.coroutines.flow.StateFlow

/**
 * Interface for data sources that provide products and purchases.
 */
interface BillingDataSource {
    /**
     * Flow of available products.
     *
     * @return The flow of available [Product]s.
     */
    val products: StateFlow<List<Product>>

    /**
     * Updates the products and purchases.
     */
    suspend fun updateProductsAndPurchases()

    /**
     * Purchase a product.
     *
     * @param activity The activity instance.
     * @param product The product to purchase.
     */
    suspend fun purchaseProduct(activity: Activity, product: Product)
}
