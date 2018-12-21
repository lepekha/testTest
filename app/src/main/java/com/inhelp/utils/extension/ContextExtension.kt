package com.inhelp.utils.extension

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.ClipboardManager
import android.content.Context
import android.content.Context.NOTIFICATION_SERVICE
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.provider.MediaStore
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat.startActivity
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

fun Context.saveBitmap(bitmap: Bitmap): String {
    val millis = System.currentTimeMillis()
    val seconds = millis / 1000
    return MediaStore.Images.Media.insertImage(this.contentResolver, bitmap, "photo_$seconds.jpg", "drawing")
}

fun Context.createInstagramIntent(bitmap: Bitmap){
    val share = Intent(Intent.ACTION_SEND)
    share.type = "image/*"
    val uri = Uri.parse(this.saveBitmap(bitmap))
    share.putExtra(Intent.EXTRA_STREAM, uri)
    share.setPackage("com.instagram.android")
    startActivity(Intent.createChooser(share, "Share to"))
}