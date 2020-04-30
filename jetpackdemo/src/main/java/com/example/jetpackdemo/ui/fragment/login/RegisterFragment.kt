package com.example.jetpackdemo.ui.fragment.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.jetpackdemo.R
import com.example.jetpackdemo.common.BaseConstant
import com.example.jetpackdemo.databinding.RegisterFragmentBinding
import com.example.jetpackdemo.ui.RegisterFragmentArgs
import com.example.jetpackdemo.viewmodel.CustomViewModelProvider
import com.example.jetpackdemo.viewmodel.RegisterModel

/**
 * @author: cgy
 * @date: 2020/4/26 18:09
 * @description: 注册的Fragment
 */
class RegisterFragment : Fragment() {

    private val registerModel: RegisterModel by viewModels {
        CustomViewModelProvider.providerRegisterModel(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //return super.onCreateView(inflater, container, savedInstanceState)
        val binding: RegisterFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.register_fragment, container, false
        )
        initData(binding)
        onSubscribeUi(binding)
        return binding.root
    }



    private fun initData(binding: RegisterFragmentBinding) {
        //SageArgs的使用
        val safeArgs : RegisterFragmentArgs by navArgs()
        val email = safeArgs.email
        binding.model?.mail?.value = email

        binding.lifecycleOwner = this
        binding.model = registerModel
        binding.activity = activity

    }

    private fun onSubscribeUi(binding: RegisterFragmentBinding) {
        binding.btnRegister.setOnClickListener {
            registerModel.register()
            val bundle = Bundle()
            bundle.putString(BaseConstant.ARGS_NAME, registerModel.n.value)
            findNavController().navigate(R.id.login, bundle, null)
        }
    }
}