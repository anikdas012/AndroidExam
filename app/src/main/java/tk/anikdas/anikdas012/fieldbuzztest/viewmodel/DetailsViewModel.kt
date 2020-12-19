package tk.anikdas.anikdas012.fieldbuzztest.viewmodel

import androidx.lifecycle.ViewModel

/**
 * Created by "Anik Das" on 20-Dec-2020
 * Developer email: "anikdas012@gmail.com"
 */

class DetailsViewModel: ViewModel() {

    private lateinit var token: String

    fun setToken(token: String) {
        this.token = token
    }
}