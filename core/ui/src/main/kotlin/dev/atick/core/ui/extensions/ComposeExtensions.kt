package dev.atick.core.ui.extensions

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext

@Composable
fun rememberToastState() = LocalContext.current.let { context ->
    remember(context) {
        { message: String ->
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }
    }
}
