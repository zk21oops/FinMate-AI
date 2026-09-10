package dev.atick.billing.models

import com.android.billingclient.api.Purchase
import com.android.billingclient.api.Purchase.PurchaseState

/**
 * Data class for a one-time purchase.
 *
 * @param productIds The list of product IDs.
 * @param purchaseTime The time of purchase.
 * @param purchaseToken The purchase token.
 * @param isAcknowledged Whether the purchase is acknowledged.
 * @param oneTimePurchaseState The state of the one-time purchase.
 */
data class OneTimePurchase(
    val productIds: List<String>,
    val purchaseTime: Long,
    val purchaseToken: String,
    val isAcknowledged: Boolean = false,
    val oneTimePurchaseState: OneTimePurchaseState,
)

/**
 * Sealed interface representing the state of a one-time purchase.
 */
sealed interface OneTimePurchaseState {
    data object Purchased : OneTimePurchaseState
    data object Pending : OneTimePurchaseState
    data object Verifying : OneTimePurchaseState
    data object Available : OneTimePurchaseState
    data object Unavailable : OneTimePurchaseState
}

/**
 * Converts a [Purchase] to a [OneTimePurchase].
 *
 * @return The [OneTimePurchase] object.
 */
fun Purchase.asOneTimePurchase(): OneTimePurchase {
    return OneTimePurchase(
        productIds = products,
        purchaseTime = purchaseTime,
        purchaseToken = purchaseToken,
        isAcknowledged = isAcknowledged,
        oneTimePurchaseState = when (purchaseState) {
            PurchaseState.PURCHASED -> {
                if (isAcknowledged) {
                    OneTimePurchaseState.Purchased
                } else {
                    OneTimePurchaseState.Verifying
                }
            }
            PurchaseState.UNSPECIFIED_STATE -> OneTimePurchaseState.Unavailable
            PurchaseState.PENDING -> OneTimePurchaseState.Pending
            else -> OneTimePurchaseState.Available
        },
    )
}
