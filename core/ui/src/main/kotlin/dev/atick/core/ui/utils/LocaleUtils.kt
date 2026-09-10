package dev.atick.core.ui.utils

import androidx.appcompat.app.AppCompatDelegate
import androidx.core.os.LocaleListCompat

/**
 * Sets the locale for the application based on the user's preferred language.
 *
 * @param languageCode The language code to set the application locale to.
 */
fun setLanguagePreference(languageCode: String) {
    val appLocale = LocaleListCompat.forLanguageTags(languageCode)
    AppCompatDelegate.setApplicationLocales(appLocale)
}
