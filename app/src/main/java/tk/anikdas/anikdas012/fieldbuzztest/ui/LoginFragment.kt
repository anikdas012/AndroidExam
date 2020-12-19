package tk.anikdas.anikdas012.fieldbuzztest.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import tk.anikdas.anikdas012.fieldbuzztest.R
import tk.anikdas.anikdas012.fieldbuzztest.databinding.FragmentLoginBinding

/**
 * Created by "Anik Das" on 19-Dec-2020
 * Developer email: "anikdas012@gmail.com"
 */

class LoginFragment: Fragment() {

    lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentLoginBinding.inflate(inflater)
        return binding.root
    }
}