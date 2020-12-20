package tk.anikdas.anikdas012.fieldbuzztest.viewmodel

import android.net.Uri
import androidx.lifecycle.ViewModel

/**
 * Created by "Anik Das" on 20-Dec-2020
 * Developer email: "anikdas012@gmail.com"
 */

class DetailsViewModel: ViewModel() {

    private lateinit var token: String
    private lateinit var cvUri: Uri

    fun setToken(token: String) {
        this.token = token
    }

    fun setCvUri(cvUri: Uri) {
        this.cvUri = cvUri
    }
}