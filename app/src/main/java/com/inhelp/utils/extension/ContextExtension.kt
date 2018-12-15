package com.inhelp.utils.extension

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.ClipboardManager
import android.content.Context
import android.content.Context.NOTIFICATION_SERVICE
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.widget.Toast
import androidx.core.app.NotificationCompat
import com.inhelp.R
import java.util.concurrent.atomic.AtomicInteger


fun Context.getClipboard(): String {
    val clipboard = this.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    return clipboard.primaryClip?.getItemAt(0)?.text.toString()
}

fun Context?.toast(text: CharSequence, duration: Int = Toast.LENGTH_LONG) = this?.let {
    Toast.makeText(it, text, duration).show()
}

inline val Context.notificationManager: NotificationManager?
    get() = getSystemService(NOTIFICATION_SERVICE) as? NotificationManager

fun Context.notification(title: String, content: String, contentIntent: PendingIntent? = null, bitmap: Bitmap, chanelID: String) {
    val notification = NotificationCompat.Builder(this, chanelID)
            .setContentTitle(title)
            .setContentText(content)
            .setContentIntent(contentIntent)
            .setSmallIcon(R.drawable.ic_round_save_24px)
            .setLargeIcon(BitmapFactory.decodeResource(this.resources, R.drawable.ic_round_save_24px))
            .setWhen(System.currentTimeMillis())
            .setAutoCancel(true)


//    val url_value = URL(content)
//    val mIcon = BitmapFactory.decodeStream(url_value.openConnection().getInputStream())
    notification.setLargeIcon(bitmap)
    this.notificationManager?.notify(AtomicInteger().get(), notification.build())
}