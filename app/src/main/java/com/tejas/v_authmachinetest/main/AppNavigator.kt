package com.tejas.v_authmachinetest.main

import android.app.Activity
import android.content.Intent
import com.tejas.v_authmachinetest.main.articleInfo.ArticleInfoActivity
import com.tejas.v_authmachinetest.main.model.Article
import org.greenrobot.eventbus.EventBus

class AppNavigator {

    companion object {

        @JvmStatic
        fun navigateToDetailActivity(
            activity: Activity,
            it: Article
        ) {
            EventBus.getDefault().postSticky(it)
            val intent = Intent(activity, ArticleInfoActivity::class.java)
            activity.startActivity(intent)
        }
    }
}
