package com.inhelp.utils

import android.content.Context
import android.graphics.Bitmap
import android.provider.MediaStore

object PhotoUtils {

    /**Метод для сохранения загруженной фотографии на устройство */
    fun saveCurrentPhoto(context: Context, bmp: Bitmap, photoId: String): String {
        return MediaStore.Images.Media.insertImage(context.contentResolver, bmp, "$photoId.jpg", "drawing")
    }
}