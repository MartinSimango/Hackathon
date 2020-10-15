package hackathon.controller;


import hackathon.client.MWLClient;
import hackathon.client.request.AboutMeTagsDTO;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import javax.inject.Inject;
import java.util.List;


@Controller("/hello")
public class AboutMeTagDTOController {
    @Inject
    private MWLClient mwlClient;
    @Get(produces = MediaType.APPLICATION_JSON)
    public List<AboutMeTagsDTO> getAllEmployeeAboutMeTagsDTO() {
        return mwlClient.getAllEmployeeAboutMeTagsDTO();
    }

    @Get("/world")
    public String test() {
        return "Hello World!";
    }
}
