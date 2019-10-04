package com.tejas.v_authmachinetest.main.articleInfo

import android.app.Application
import android.view.View
import androidx.lifecycle.MutableLiveData
import com.tejas.v_authmachinetest.main.BaseApplicationContextViewModel
import com.tejas.v_authmachinetest.main.CommonEvents
import com.tejas.v_authmachinetest.main.model.Article
import com.tejas.v_authmachinetest.main.utils.DateTimeUtils


class ArticleInfoViewModel(application: Application) :
    BaseApplicationContextViewModel(application) {
    var articleData = MutableLiveData<Article>()
    var date = MutableLiveData<String>("")
    var author = MutableLiveData<String>("")


    fun setData(article: Article?) {
        articleData.value = article
        author.value = if (article?.author.isNullOrBlank()) "No Mentioned" else article?.author
        date.value = DateTimeUtils.formatStringDate(
            articleData.value?.publishedAt
        )
    }

    fun onLinkClicked(view: View) {

        currentState.value = CommonEvents.NavToNext(ArticleInfoActivity.SHOW_NEWS_IN_BROWSER)

    }


}