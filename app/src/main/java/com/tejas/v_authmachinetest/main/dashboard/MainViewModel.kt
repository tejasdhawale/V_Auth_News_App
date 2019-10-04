package com.tejas.v_authmachinetest.main.dashboard

import android.app.Application
import android.view.MotionEvent
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.tejas.v_authmachinetest.main.BaseApplicationContextViewModel
import com.tejas.v_authmachinetest.main.CommonEvents
import com.tejas.v_authmachinetest.main.adapter.RecyclerItemClickListener
import com.tejas.v_authmachinetest.main.dashboard.MainActivity.Companion.SHOW_DETAIL_SCREEN
import com.tejas.v_authmachinetest.main.model.Article
import com.tejas.v_authmachinetest.main.roomDb.AppDatabase


class MainViewModel(application: Application) : BaseApplicationContextViewModel(application) {

    private var mMainRepo: MainRepo? = null

    var dataModelList: MutableList<ViewModel> = mutableListOf()
    var myRecyclerViewAdapter: ArticleListAdapter
    var recyclerItemClickListener: RecyclerItemClickListener? = null
    var meetingData = MutableLiveData<Article>()
    var showProgress = MutableLiveData<Boolean>(false)
    val applicatipnContext = application
    lateinit var myAppDatabase: AppDatabase

    init {
        mMainRepo = MainRepo()
        setObserver(application)
        myRecyclerViewAdapter = ArticleListAdapter(dataModelList)
    }

    //initial route
    fun setData(appDatabase: AppDatabase) {
        myAppDatabase = appDatabase
        checkDbForArticles()
    }

    private fun checkDbForArticles() {
        //CHECK FOR COUNT
        if (myAppDatabase.articleDAO.articles.isEmpty()) {
            //there are no articles in DB fetch from API
            mMainRepo?.getDataList()
        } else {
            dataModelList.clear()
            dataModelList.addAll(getVmList(myAppDatabase.articleDAO.articles))
            myRecyclerViewAdapter.notifyDataSetChanged()
        }
    }

    private fun setObserver(application: Application) {

        recyclerItemClickListener = RecyclerItemClickListener(application,
            object : RecyclerItemClickListener.OnItemClickListener {
                override fun onItemClick(view: View, position: Int) {
                    val model = dataModelList[position] as RowArticleViewModel
                    meetingData.value = model.articleLiveData.value
                    currentState.value = CommonEvents.NavToNext(SHOW_DETAIL_SCREEN)
                }

                override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
                    return false
                }

                override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {

                }

                override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {

                }
            })

        mMainRepo?.getResponseData()?.observeForever { o ->
            if (o != null) {
                dataModelList.clear()
                dataModelList.addAll(getVmList(o.articles))
                myRecyclerViewAdapter.notifyDataSetChanged()

                //saving all data to local DB
                addAllInRoomDB(o.articles)
            }
        }

        mMainRepo?.getmodelEvents()?.observeForever { it ->
            when (it) {
                is CommonEvents.ShowToast -> {
                    currentState.value = CommonEvents.ShowToast(text = it.text)
                }
                is CommonEvents.ShowProgress -> {
                    showProgress.value = it.show
                }
            }
        }
    }

    private fun addAllInRoomDB(articles: MutableList<Article>) {


        val articleDAO = myAppDatabase.articleDAO
        //clearing previous news
        articleDAO.clearTable()

        //clearing new news into DB
        for (article in articles)
            articleDAO.insert(article)
    }

    fun fetchData(view: View) {
        //New data need by user fetch from API
        mMainRepo?.getDataList()
    }

    private fun getVmList(list: List<Article>): MutableList<ViewModel> {
        val vmList: MutableList<ViewModel> = mutableListOf()
        if (list.isNotEmpty()) {
            for (article: Article in list) {
                vmList.add(RowArticleViewModel(article))
            }
        }
        return vmList
    }


}