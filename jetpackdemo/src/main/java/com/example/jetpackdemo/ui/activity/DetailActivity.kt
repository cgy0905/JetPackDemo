package com.example.jetpackdemo.ui.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.jetpackdemo.R
import com.example.jetpackdemo.common.BaseConstant
import com.example.jetpackdemo.utils.AppPrefsUtils
import com.example.jetpackdemo.viewmodel.CustomViewModelProvider
import com.example.jetpackdemo.viewmodel.DetailModel

/**
 * @author: cgy
 * @date: 2020/5/11 11:27
 * @description: 鞋子详情界面
 */
class DetailActivity : AppCompatActivity(){

    private val detailModel : DetailModel by viewModels {
        CustomViewModelProvider.providerDetailModel(
            this,
            intent.getLongExtra(BaseConstant.DETAIL_SHOE_ID, 1L),
            AppPrefsUtils.getLong(BaseConstant.SP_USER_ID)
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_detail)

        //val binding = DataBindingUtil.setContentView<DetailActivityBinding>(this, R.layout.activity_detail)

    }
}