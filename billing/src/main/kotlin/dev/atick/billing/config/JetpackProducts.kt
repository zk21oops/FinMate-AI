package dev.atick.billing.config

import dev.atick.billing.models.ProductType

/**
 * Map of Jetpack products and their types.
 *
 * The key is the product ID and the value is the product type.
 */
val JetpackProducts = mapOf(
    "dev.atick.jetpack.premium" to ProductType.ONE_TIME,
)
