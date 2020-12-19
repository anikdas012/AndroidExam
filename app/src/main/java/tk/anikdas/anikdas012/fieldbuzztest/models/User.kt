package tk.anikdas.anikdas012.fieldbuzztest.models

import com.google.gson.annotations.SerializedName

/**
 * Created by "Anik Das" on 20-Dec-2020
 * Developer email: "anikdas012@gmail.com"
 */

data class User(
    @SerializedName("name") val name: String,
    @SerializedName("token") val token: String
)
