package com.example.android3homework1.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.android3homework1.databinding.FragmentEditBinding
import com.example.android3homework1.ui.model.UserModel
import com.example.android3homework1.ui.model.UserViewModel


class EditFragment : Fragment() {

    private var _binding: FragmentEditBinding? = null
    private val binding get() = _binding!!
    private val editViewModel: UserViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEditBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListener()

    }

    private fun setupListener() = with(binding) {
        btnContinue.setOnClickListener {
            val userName = etNameUser.text.toString().trim()
            val age = etAge.text.toString().trim()
            val email = etMail.text.toString().trim()
            val password = etPassword.text.toString().trim()

            val user = UserModel(
                userName = userName,
                age = age,
                email = email,
                password = password
            )
            editViewModel.saveUser(user)
            findNavController().navigateUp()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
