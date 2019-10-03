package com.tejas.v_authmachinetest.main.articleInfo

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.tejas.v_authmachinetest.R
import com.tejas.v_authmachinetest.databinding.ActivityArticleInfoBinding
import com.tejas.v_authmachinetest.main.BaseActivity
import com.tejas.v_authmachinetest.main.CommonEvents
import com.tejas.v_authmachinetest.main.model.Article
import org.greenrobot.eventbus.EventBus


class ArticleInfoActivity : BaseActivity() {

    private var mBinding: ActivityArticleInfoBinding? = null
    var mViewModel: ArticleInfoViewModel? = null

    companion object {
        val SHOW_NEWS_IN_BROWSER = 12
    }

    override fun getCurrentFragment(): Fragment? {
        return null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val dataModel = EventBus.getDefault().removeStickyEvent(Article::class.java)

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_article_info)
        mViewModel = ViewModelProviders.of(this).get(ArticleInfoViewModel::class.java)

        mBinding?.vm = mViewModel
        mBinding?.lifecycleOwner = this

        setToolBar()

        mViewModel?.setData(dataModel)

        mViewModel?.currentState?.observe(this, Observer {
            when (it) {
                is CommonEvents.NavToNext -> {
                    if (it.flag == SHOW_NEWS_IN_BROWSER) {
                        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(dataModel.url)))
                    }
                } }
        }
        )

    }

    private fun setToolBar() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = "News Details"
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // handle arrow click here
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        finish()
    }

}
