package com.inhelp.utils.extension

import android.graphics.Bitmap
import android.os.Environment
import java.io.FileOutputStream
import android.os.Environment.getExternalStorageDirectory
import java.io.File


fun Bitmap.saveToSD() {
    val millis = System.currentTimeMillis()
    val path = Environment.getExternalStorageDirectory().toString()
    FileOutputStream(File(path, "InHelp_$millis.jpg")).use { out ->
        this.compress(Bitmap.CompressFormat.JPEG, 100, out)
    }
}

