package hackathon.client;


import hackathon.client.request.AboutMeTagsDTO;
import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import io.reactivex.Flowable;
import io.reactivex.Maybe;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

import static io.micronaut.http.HttpHeaders.*;

@Singleton
public class MWLClientSupport implements MWLClient {
    @Inject
    @Client
    RxHttpClient mwlHttpClient;

    public List<AboutMeTagsDTO> getAllEmployeeAboutMeTagsDTO(){

        return mwlHttpClient.exchange(HttpRequest.GET("https://bsg-staging.myworklife.com/app/rest/api/employee/tagsaboutme")
                .header(CONTENT_TYPE, MediaType.APPLICATION_JSON)
                .header(AUTHORIZATION, "Basic YnNnOnRlc3Q=")
                .header(ACCEPT, MediaType.APPLICATION_JSON), Argument.listOf(AboutMeTagsDTO.class)).blockingSingle().body();
    }

}
