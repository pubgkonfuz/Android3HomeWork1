package com.example.android3homework1.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.android3homework1.R
import com.example.android3homework1.databinding.FragmentUserBinding
import com.example.android3homework1.ui.model.UserViewModel


class UserFragment : Fragment() {

    private var _binding: FragmentUserBinding? = null
    private val binding get() = _binding!!
    private val viewModel: UserViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListener()
        subscribeToUserInfo()
    }

    private fun setupListener() = with(binding) {
        btnToBeContinue.setOnClickListener {
            findNavController().navigate(R.id.action_userFragment_to_editFragment2)
        }
    }

    private fun subscribeToUserInfo() = with(binding) {
        viewModel.getUser()
        viewModel.userData.observe(viewLifecycleOwner) {uiState ->
            uiState?.let {
                it.success?.let {userModel ->
                    etUserName.text = userModel.userName
                    etAge.text = userModel.age.toString()
                    etEmail.text = userModel.email
                    etPassword.text = userModel.password
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}