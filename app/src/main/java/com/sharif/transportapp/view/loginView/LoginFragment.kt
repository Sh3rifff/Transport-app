package com.sharif.transportapp.view.loginView

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.sharif.transportapp.viewModel.LoginViewModel
import com.sharif.transportapp.view.mainView.MainActivity
import com.sharif.transportapp.R
import com.sharif.transportapp.databinding.FragmentLoginBinding

class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var binding: FragmentLoginBinding
    private val viewModel by viewModels<LoginViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLoginBinding.bind(view)

//        setupObserver()
        setListeners()
        emailFocusListener()
        passwordFocusListener()
    }

    private fun setListeners() {
        binding.buttonSignIn.setOnClickListener {
            viewModel.login(
                binding.inputEmail.toString(),
                binding.inputPassword.toString()
            )

            val intent = Intent(requireActivity(), MainActivity::class.java)
            startActivity(intent)
        }

        binding.createAccount.setOnClickListener {
            findNavController().navigate(R.id.login_to_register)
        }


    }

    private fun setupObserver() {
        viewModel.isLoggedIn.observe(viewLifecycleOwner) {
            if (it) {
                Toast.makeText(requireContext(), "Gel", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), "Problem var", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun emailFocusListener() {
        binding.inputEmail.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.emailContainer.helperText = validEmail()
            }
        }
    }

    private fun passwordFocusListener() {
        binding.inputPassword.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.passwordContainer.helperText = validPassword()
            }
        }
    }

    private fun validEmail(): String? {
        val emailText = binding.inputEmail.text.toString()
        if (!Patterns.EMAIL_ADDRESS.matcher(emailText).matches()) {
            return "Invalid Email Address"
        }
        return null
    }

    private fun validPassword(): String? {
        val passwordText = binding.inputPassword.text.toString()
        if (passwordText.isEmpty()) {
            return "Invalid Password"
        }
        return null
    }

}