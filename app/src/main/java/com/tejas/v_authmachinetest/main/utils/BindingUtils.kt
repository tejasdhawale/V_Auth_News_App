package com.tejas.v_authmachinetest.main.utils

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso
import com.tejas.v_authmachinetest.R

class BindingUtils {
    companion object {

        private const val IMAGE_URL = "imageUrl"
        private const val VISIBILITY = "android:visibility"

        @BindingAdapter(IMAGE_URL)
        @JvmStatic
        fun loadImage(view: AppCompatImageView, url: String?) {
            if (url != null)
                Picasso.with(view.context)
                    .load(url)
                    .error(R.drawable.ic_launcher_background)
                    .placeholder(R.drawable.loading_animation)
                    .into(view)
            else {
                Picasso.with(view.context)
                    .load(R.drawable.ic_failed)
                    .placeholder(R.drawable.ic_failed)
                    .into(view)

            }

        }

        @BindingAdapter(VISIBILITY)
        @JvmStatic
        fun setVisibility(view: View, isVisible: Boolean) {
            view.visibility = if (isVisible) View.VISIBLE else View.GONE
        }


    }

}