package com.shinkevich.dishcraft.data.mapper

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import com.shinkevich.dishcraft.data.networkstorage.entity.Image

class ImageMapper {
    companion object{
        fun imageToBitmap(image: Image):Bitmap?{
            if(image.data == null || image.data.isEmpty()){
                return null
            }
            val decodedString: ByteArray = Base64.decode(image.data, Base64.DEFAULT)
            return BitmapFactory.decodeByteArray(decodedString, 0, decodedString.size)
        }
    }
}