package com.tejas.v_authmachinetest.main.dashboard

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tejas.v_authmachinetest.main.model.Article
import com.tejas.v_authmachinetest.main.utils.DateTimeUtils

class RowArticleViewModel(articleData: Article) : ViewModel() {

    var articleLiveData = MutableLiveData<Article>()
    var title = MutableLiveData<String>()
    var date = MutableLiveData<String>()
    var imageUrl = MutableLiveData<String>()


    init {
        articleLiveData.value = articleData
        title.value = articleData.title
        imageUrl.value = articleData.urlToImage
        date.value = DateTimeUtils.formatStringDate(
            articleData.publishedAt)

    }

}