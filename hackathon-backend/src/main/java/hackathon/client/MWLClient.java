package hackathon.client;


import hackathon.client.request.AboutMeTagsDTO;
import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

import static io.micronaut.http.HttpHeaders.*;

@Singleton
public class MWLClient {
    @Inject
    @Client("http://localhost:8080/app/rest/api/")
    RxHttpClient mwlHttpClient;
    public List<AboutMeTagsDTO> getAllEmployeeAboutMeTagsDTO(){

        HttpResponse<List<AboutMeTagsDTO>> response = mwlHttpClient.exchange(HttpRequest.GET("/employee/tagsaboutme")
                .header(CONTENT_TYPE, MediaType.APPLICATION_JSON)
                .header(AUTHORIZATION, "Basic c29tZXVzZXJuYW1lOnNvbWVwYXNzd29yZA==" )
                .header(ACCEPT, "application/vnd.myworklife-v1+json"), Argument.listOf(AboutMeTagsDTO.class)).blockingFirst();

        List<AboutMeTagsDTO> dtos = response.body();

        return dtos;
    }

}
