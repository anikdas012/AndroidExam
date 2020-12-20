package tk.anikdas.anikdas012.fieldbuzztest.models

/**
 * Created by "Anik Das" on 20-Dec-2020
 * Developer email: "anikdas012@gmail.com"
 */

data class UserDetails(
    val tsync_id: String,
    val name: String,
    val email: String,
    val phone: String,
    val full_address: String?,
    val name_of_university: String,
    val graduation_year: Int,
    val cgpa: Double?,
    val experience_in_months: Int?,
    val current_work_place_name: String?,
    val applying_in: String,
    val expected_salary: Int,
    val field_buzz_reference: String?,
    val github_project_url: String,
    val cv_file: CV,
    val on_spot_update_time: Long,
    val on_spot_creation_time: Long
)
