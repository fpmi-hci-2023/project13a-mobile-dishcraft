package com.shinkevich.dishcraft.view

import android.content.Context
import com.shinkevich.dishcraft.R
import java.text.DecimalFormat
import java.text.SimpleDateFormat

class Utils {
    companion object {
        private const val MINUTES_IN_HOUR = 60
        private const val INPUT_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss"
        private const val INPUT_DATE_LENGTH = 19
        private const val OUTPUT_DATE_FORMAT = "dd-MM-yyyy HH:mm"


        private fun getMinutesString(minutes: Int, context : Context): String {
            return minutes.toString() + " " + context.getString(R.string.min)
        }

        fun showTime(timeInMinutes: Int, context : Context): String {
            if (timeInMinutes < MINUTES_IN_HOUR) {
                return getMinutesString(timeInMinutes,context)
            } else {
                val hours = timeInMinutes / MINUTES_IN_HOUR
                val minutes = timeInMinutes % MINUTES_IN_HOUR
                return hours.toString() + " " + context.getString(R.string.h) +
                        (if (minutes != 0) getMinutesString(minutes,context) else "")
            }
        }

        fun showDouble(value : Double) : String {
            val decimalFormat = DecimalFormat("#.#")
            decimalFormat.isDecimalSeparatorAlwaysShown = false
            return decimalFormat.format(value)
        }

        fun showDoubleWithSeparator(value : Double) : String {
            return String.format("%.1f", value)
        }

        fun formatDate(dateString: String):String{
            val inputDateFormatter = SimpleDateFormat(INPUT_DATE_FORMAT)
            val outputDateFormatter = SimpleDateFormat(OUTPUT_DATE_FORMAT)
            val date = inputDateFormatter.parse(dateString.subSequence(0, INPUT_DATE_LENGTH).toString())
            return outputDateFormatter.format(date)
        }

    }


}