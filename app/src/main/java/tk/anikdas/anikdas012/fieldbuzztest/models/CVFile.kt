package tk.anikdas.anikdas012.fieldbuzztest.models

import com.google.gson.annotations.SerializedName

/**
 * Created by "Anik Das" on 20-Dec-2020
 * Developer email: "anikdas012@gmail.com"
 */

data class CVFile(
    @SerializedName("id") val id: Int,
    @SerializedName("tsync_id") val tsync_id: String
)
