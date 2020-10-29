package hackathon.backend.kotlin.service

import io.micronaut.core.annotation.Introspected


@Introspected
data class EmployeeMatch (
        val employee_name: String,
        val employee_skills_percentage: Double
)