package com.apolis.courotineuiupdateexample

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import java.text.SimpleDateFormat

class CommonBinding {

    companion object {

        @JvmStatic
        @BindingAdapter("remote_image")
        fun remoteImage(iv: ImageView, url: String) {

        }

        @JvmStatic
        @BindingAdapter("showAsTime")
        public fun showAsTime(textView: TextView, ts: Long) {
            if(ts == 0L) {
                textView.text = "00:00"
                return
            }
            textView.text = SimpleDateFormat("mm:ss").format(ts)
        }
    }
}