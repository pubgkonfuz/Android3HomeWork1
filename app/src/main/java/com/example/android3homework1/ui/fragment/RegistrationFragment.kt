package com.example.android3homework1.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.android3homework1.R
import com.example.android3homework1.data.preferences.SharedPreference
import com.example.android3homework1.databinding.FragmentRegistrationBinding
import com.example.android3homework1.ui.model.UserModel
import com.example.android3homework1.ui.model.UserViewModel

class RegistrationFragment : Fragment() {

    private var _binding: FragmentRegistrationBinding? = null
    private val binding get() = _binding!!
    private val userViewModel: UserViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegistrationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListener()
    }

    private fun setupListener() = with(binding) {
        btnTwo.setOnClickListener {
            val userName = user.text.toString().trim()
            val age = aje.text.toString().trim()
            val email = imail.text.toString().trim()
            val password = cod.text.toString().trim()

            val user = UserModel(
                userName = userName,
                age = age,
                email = email,
                password = password,
            )

            userViewModel.saveUser(user)
            findNavController().navigate(R.id.action_registrationFragment_to_userFragment2)
            SharedPreference.isShownOnBoard = true
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}