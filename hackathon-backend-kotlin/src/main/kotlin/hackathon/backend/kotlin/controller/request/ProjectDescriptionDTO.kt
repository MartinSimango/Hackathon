package hackathon.backend.kotlin.controller.request

import io.micronaut.core.annotation.Introspected

@Introspected
data class ProjectDescriptionDTO(
        var description: String,
        var projectCode: String,
        var teamSize: Long)

   

