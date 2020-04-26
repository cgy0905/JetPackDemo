package com.example.jetpackdemo.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.jetpackdemo.R
import com.example.jetpackdemo.viewmodel.CustomViewModelProvider
import com.example.jetpackdemo.viewmodel.RegisterModel

/**
 * @author: cgy
 * @date: 2020/4/26 18:09
 * @description: 注册的Fragment
 */
class RegisterFragment : Fragment(){

    private val registerModel : RegisterModel by viewModels {
        CustomViewModelProvider.providerRegisterModel(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //return super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.register_fragment, container, false)
    }
}