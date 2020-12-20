package tk.anikdas.anikdas012.fieldbuzztest.viewmodel

import android.content.Context
import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.schedulers.Schedulers
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import tk.anikdas.anikdas012.fieldbuzztest.models.CVFile
import tk.anikdas.anikdas012.fieldbuzztest.models.CVResponse
import tk.anikdas.anikdas012.fieldbuzztest.models.UserDetails
import tk.anikdas.anikdas012.fieldbuzztest.models.UserDetailsResponse
import tk.anikdas.anikdas012.fieldbuzztest.network.RetrofitService
import java.io.File

/**
 * Created by "Anik Das" on 20-Dec-2020
 * Developer email: "anikdas012@gmail.com"
 */

class DetailsViewModel: ViewModel() {

    private lateinit var token: String
    private lateinit var cvUri: Uri
    private lateinit var applicationContext: Context

    fun setToken(token: String) {
        this.token = token
    }

    fun setCvUri(cvUri: Uri) {
        this.cvUri = cvUri
    }

    fun setApplicationContext(context: Context) {
        applicationContext = context
    }

    fun uploadDetails(userDetails: UserDetails): LiveData<String> {
        var status: MediatorLiveData<String> = MediatorLiveData()
        RetrofitService.getDetailsApi().uploadDetails("Token $token", userDetails)
            .onErrorReturn {
                status.value = "Upload Error"
                return@onErrorReturn UserDetailsResponse(CVFile(0, "Error"))
            }
            .map { it ->
                val cvFile = it.cv_file
                status.value = uploadCV(cvFile)
            }
            .subscribeOn(Schedulers.io())
        return status
    }

    private fun uploadCV(cvFile: CVFile): String {
        val originalFile = File(cvUri.path)
        val filePart: RequestBody = RequestBody.create(MediaType.parse(applicationContext.contentResolver.getType(cvUri)!!), originalFile)
        val file: MultipartBody.Part = MultipartBody.Part.createFormData("cv", originalFile.name, filePart)
        val response = RetrofitService.getCVApi().uploadCV("Token $token",cvFile.id, file)
            .onErrorReturn {
                return@onErrorReturn CVResponse(0, false, "Error upload")
            }
            .subscribeOn(Schedulers.io())
            .blockingFirst()

        return response.message
    }
}