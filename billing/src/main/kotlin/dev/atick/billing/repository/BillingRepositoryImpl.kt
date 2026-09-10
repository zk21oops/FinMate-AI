package dev.atick.billing.repository

import android.app.Activity
import dev.atick.billing.data.BillingDataSource
import dev.atick.billing.models.Product
import dev.atick.core.utils.suspendRunCatching
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

/**
 * Implementation of the [BillingRepository] interface.
 *
 * @param billingDataSource The data source for billing.
 * @see BillingRepository
 */
class BillingRepositoryImpl @Inject constructor(
    private val billingDataSource: BillingDataSource,
) : BillingRepository {
    /**
     * Flow of available products.
     *
     * @return The flow of available [Product]s.
     */
    override val products: StateFlow<List<Product>>
        get() = billingDataSource.products

    /**
     * Updates the products and purchases.
     *
     * @return A [Result] of [Unit].
     */
    override suspend fun updateProductsAndPurchases(): Result<Unit> {
        return suspendRunCatching {
            billingDataSource.updateProductsAndPurchases()
        }
    }

    /**
     * Purchase a product.
     *
     * @param activity The activity instance.
     * @param product The product to purchase.
     * @return A [Result] of [Unit].
     */
    override suspend fun purchaseProduct(activity: Activity, product: Product): Result<Unit> {
        return suspendRunCatching {
            billingDataSource.purchaseProduct(activity, product)
        }
    }
}
