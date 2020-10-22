package hackathon.backend.kotlin.client.request

import io.micronaut.core.annotation.Introspected

@Introspected
data class AboutMeTagsDTO (
        val name: String?,
        val aboutMe: String?,
        val tags: List<String>?
)
