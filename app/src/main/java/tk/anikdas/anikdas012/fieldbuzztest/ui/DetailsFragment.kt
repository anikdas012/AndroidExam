package tk.anikdas.anikdas012.fieldbuzztest.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import tk.anikdas.anikdas012.fieldbuzztest.databinding.FragmentDetailsBinding
import tk.anikdas.anikdas012.fieldbuzztest.viewmodel.DetailsViewModel

/**
 * Created by "Anik Das" on 20-Dec-2020
 * Developer email: "anikdas012@gmail.com"
 */

class DetailsFragment: Fragment() {

    lateinit var binding: FragmentDetailsBinding
    lateinit var viewModel: DetailsViewModel
    lateinit var token: String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentDetailsBinding.inflate(inflater)
        token = arguments!!.getString("token").toString()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(this)[DetailsViewModel::class.java]
        viewModel.setToken(token)

        binding.upload.setOnClickListener {
            validateInputs()
        }
    }
}