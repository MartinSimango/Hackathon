package hackathon.backend.kotlin.service

import io.micronaut.core.annotation.Introspected
import java.util.*


@Introspected
data class SkillOutput (
        val skill_description: String,
        val employee_skill_arr: ArrayList<EmployeeMatch>
)
