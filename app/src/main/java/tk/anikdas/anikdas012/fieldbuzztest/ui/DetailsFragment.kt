package tk.anikdas.anikdas012.fieldbuzztest.ui

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import tk.anikdas.anikdas012.fieldbuzztest.databinding.FragmentDetailsBinding
import tk.anikdas.anikdas012.fieldbuzztest.viewmodel.DetailsViewModel
import java.io.File

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

        binding.cvSelect.setOnClickListener {
            val fileIntent = Intent(Intent.ACTION_GET_CONTENT)
            fileIntent.type = "application/pdf"
            fileIntent.addCategory(Intent.CATEGORY_OPENABLE)
            startActivityForResult(fileIntent, 101)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 101 && resultCode == RESULT_OK) {
            if (context!!.contentResolver.getType(data!!.data!!) != "application/pdf") {
                Toast.makeText(this.context, "Select .pdf file", Toast.LENGTH_LONG).show()
                return
            }
            viewModel.setCvUri(data.data!!)
        }
    }

    private fun validateInputs() {
        if (binding.name.editText!!.text.isNullOrEmpty()) {
            Toast.makeText(this.context, "Name is required", Toast.LENGTH_LONG).show()
            return
        }

        if (binding.email.editText!!.text.isNullOrEmpty()
                && Patterns.EMAIL_ADDRESS.matcher(binding.email.editText!!.text).matches()) {
            Toast.makeText(this.context, "Proper email is required", Toast.LENGTH_LONG).show()
            return
        }

        if (binding.phone.editText!!.text.isNullOrEmpty()) {
            Toast.makeText(this.context, "Phone number is required", Toast.LENGTH_LONG).show()
            return
        }

        if (binding.varsity.editText!!.text.isNullOrEmpty()) {
            Toast.makeText(this.context, "University is required", Toast.LENGTH_LONG).show()
            return
        }

        if (binding.year.editText!!.text.isNullOrEmpty()
            && binding.year.editText!!.text.toString().toInt() !in 2015..2020
        ) {
            Toast.makeText(this.context, "Graduation year should be between 2015 and 2020", Toast.LENGTH_LONG).show()
            return
        }

        if (binding.cgpa.editText!!.text.toString().toDouble() !in 2.0..4.0) {
            Toast.makeText(this.context, "CGPA should be between 2.0 and 4.0", Toast.LENGTH_LONG).show()
            return
        }

        if (binding.experience.editText!!.text.toString().toInt() !in 0..100) {
            Toast.makeText(this.context, "Experience should be between 0 and 100 months", Toast.LENGTH_LONG).show()
            return
        }

        if (binding.radioGroup.checkedRadioButtonId == -1) {
            Toast.makeText(this.context, "Position is required", Toast.LENGTH_LONG).show()
            return
        }

        if (binding.salary.editText!!.text.isNullOrEmpty()
            && (binding.salary.editText!!.text.toString().toInt() !in 15000..60000)) {
            Toast.makeText(this.context, "Salary should be between 150000 and 60000", Toast.LENGTH_LONG).show()
            return
        }

        if (binding.url.editText!!.text.isNullOrEmpty()) {
            Toast.makeText(this.context, "Github URL is required", Toast.LENGTH_LONG).show()
            return
        }
    }
}