package hackathon.client;


import hackathon.client.request.AboutMeTagsDTO;

import java.util.List;

public interface MWLClient {

    List<AboutMeTagsDTO> getAllEmployeeAboutMeTagsDTO();

}
