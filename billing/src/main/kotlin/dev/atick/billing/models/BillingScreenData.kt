package dev.atick.billing.models

/**
 * Data class for the billing screen.
 *
 * @param products The list of products.
 */
data class BillingScreenData(
    val products: List<Product> = listOf(),
)
