package hackathon.Services;


import hackathon.client.MWLClient;
import hackathon.client.request.AboutMeTagsDTO;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Get;

import javax.inject.Singleton;
import javax.inject.Inject;
import java.util.List;


@Singleton
public class AboutMeTagDTOService
{
    @Inject
    private MWLClient mwlClient;

    public List<AboutMeTagsDTO> getAllEmployeeAboutMeTagsDTO()
    {
        return mwlClient.getAllEmployeeAboutMeTagsDTO();
    }

    //Save,Update,

}
