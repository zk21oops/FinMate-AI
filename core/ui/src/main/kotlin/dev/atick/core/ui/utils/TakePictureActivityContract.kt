package dev.atick.core.ui.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.MediaStore
import androidx.activity.result.contract.ActivityResultContract
import androidx.annotation.CallSuper

/**
 * Contract for taking picture.
 */
class TakePictureActivityContract : ActivityResultContract<Uri, Pair<Boolean, Uri>>() {

    private lateinit var imageUri: Uri

    /**
     * Create an intent for taking picture.
     *
     * @param context The context.
     * @param input The input.
     * @return The intent.
     */
    @CallSuper
    override fun createIntent(context: Context, input: Uri): Intent {
        imageUri = input
        return Intent(MediaStore.ACTION_IMAGE_CAPTURE).putExtra(MediaStore.EXTRA_OUTPUT, input)
    }

    /**
     * Get the synchronous result.
     *
     * @param context The context.
     * @param input The input.
     * @return The synchronous result.
     */
    override fun getSynchronousResult(
        context: Context,
        input: Uri,
    ): SynchronousResult<Pair<Boolean, Uri>>? = null

    /**
     * Parse the result.
     *
     * @param resultCode The result code.
     * @param intent The intent.
     * @return The result.
     */
    @Suppress("AutoBoxing")
    override fun parseResult(resultCode: Int, intent: Intent?): Pair<Boolean, Uri> {
        return (resultCode == Activity.RESULT_OK) to imageUri
    }
}
