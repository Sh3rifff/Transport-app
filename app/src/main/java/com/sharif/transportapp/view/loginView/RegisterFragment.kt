package com.sharif.transportapp.view.loginView

import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.sharif.transportapp.viewModel.LoginViewModel
import com.sharif.transportapp.R
import com.sharif.transportapp.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment(R.layout.fragment_register) {

    private lateinit var binding: FragmentRegisterBinding
    private val viewModel by viewModels<LoginViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRegisterBinding.bind(view)

        setupObserver()

        setListeners()

        nameFocusListener()
        emailFocusListener()
        passwordFocusListener()
        confirmPasswordFocusListener()
    }

    private fun setListeners() {
        binding.buttonSignIn.setOnClickListener {
            viewModel.register(
                binding.inputName.toString(),
                binding.inputEmail.toString(),
                binding.inputPassword.toString(),
                binding.inputConfirmPassword.toString()
            )
        }

        binding.alreadyAccount.setOnClickListener {
            findNavController().navigate(R.id.register_to_login)
        }
    }

    private fun setupObserver() {
        viewModel.isRegister.observe(viewLifecycleOwner) {
            if (it) {
                Toast.makeText(requireContext(), "Gel", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), "Problem var", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun nameFocusListener() {
        binding.inputName.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.nameContainer.helperText = validEmail()
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
        binding.inputConfirmPassword.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.confirmPasswordContainer.helperText = validPassword()
            }
        }
    }

    private fun confirmPasswordFocusListener() {
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

    private fun validName(): String? {
        val nameText = binding.inputName.text.toString()
        if (nameText.isEmpty()) {
            return "Invalid Name"
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

    private fun validConfirmPassword(): String? {
        val cpasswordText = binding.inputConfirmPassword.text.toString()
        if (cpasswordText.isEmpty()) {
            return "Invalid Password"
        }
        return null
    }

}