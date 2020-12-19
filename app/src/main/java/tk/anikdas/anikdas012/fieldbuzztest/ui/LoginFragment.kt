package tk.anikdas.anikdas012.fieldbuzztest.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import tk.anikdas.anikdas012.fieldbuzztest.R
import tk.anikdas.anikdas012.fieldbuzztest.databinding.FragmentLoginBinding
import tk.anikdas.anikdas012.fieldbuzztest.viewmodel.LoginViewModel

/**
 * Created by "Anik Das" on 19-Dec-2020
 * Developer email: "anikdas012@gmail.com"
 */

class LoginFragment: Fragment() {

    lateinit var binding: FragmentLoginBinding
    lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentLoginBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]
        binding.login.setOnClickListener {
            attemptLogin()
        }
    }

    private fun attemptLogin() {
        viewModel.attemptLogin(binding.username.editText!!.text.toString(), binding.password.editText!!.text.toString())
            .removeObservers(viewLifecycleOwner)
        viewModel.attemptLogin(binding.username.editText!!.text.toString(), binding.password.editText!!.text.toString())
            .observe(viewLifecycleOwner) { token ->
                if (token != "Error") {
                    val argument = Bundle()
                    argument.putString("token", token)

                    val detailsFragment = DetailsFragment()
                    detailsFragment.arguments = arguments

                    
                } else {
                    Toast.makeText(this.context, "Login error", Toast.LENGTH_LONG).show()
                }
            }
    }
}