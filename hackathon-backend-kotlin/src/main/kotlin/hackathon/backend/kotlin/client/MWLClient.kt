package hackathon.backend.kotlin.client

import hackathon.backend.kotlin.client.request.AboutMeTagsDTO
import io.micronaut.core.type.Argument
import io.micronaut.http.HttpHeaders
import io.micronaut.http.HttpRequest
import io.micronaut.http.MediaType
import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.client.annotation.Client
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MWLClient @Inject constructor(@Client private val mwlHttpClient: RxHttpClient)  {

    fun getAllEmployeeAboutMeTagsDTO(): List<AboutMeTagsDTO>? {
        return mwlHttpClient.exchange(HttpRequest.GET<Any>("https://bsg-staging.myworklife.com/app/rest/api/employee/tagsaboutme")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
                .header(HttpHeaders.AUTHORIZATION, "Basic YnNnOnRlc3Q=")
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON), Argument.listOf(AboutMeTagsDTO::class.java)).blockingSingle().body()
    }
}
