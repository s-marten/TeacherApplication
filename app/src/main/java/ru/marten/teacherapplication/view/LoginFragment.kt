package ru.marten.teacherapplication.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.marten.teacherapplication.model.LoginRepository
import ru.marten.teacherapplication.viewmodel.LoginViewModel
import ru.marten.teacherapplication.databinding.LoginFragmentBinding
import ru.marten.teacherapplication.util.createWithFactory


class LoginFragment : Fragment() {

    private var _binding: LoginFragmentBinding? = null

    private val binding get() = _binding!!

    private val loginViewModel by lazy {
        ViewModelProvider(
            this,
            createWithFactory {
                LoginViewModel(
                    LoginRepository()
                )
            }
        ).get(LoginViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = LoginFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLogin.setOnClickListener {
            loginViewModel.login(
                login = binding.etLogin.text.toString(),
                password = binding.etPassword.text.toString()
            )
        }

        loginViewModel.loginResult.observe(this.requireActivity()) {
            Toast.makeText(requireActivity(), it, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}