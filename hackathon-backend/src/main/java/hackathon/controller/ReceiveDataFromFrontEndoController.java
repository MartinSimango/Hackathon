package hackathon.controller;


import hackathon.Repository.ProjectAllocationRepository;
import hackathon.client.MWLClient;
import hackathon.client.request.ReceiveDataFromFrontEndDTO;
import hackathon.entity.ProjectAllocation;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;

import javax.inject.Inject;
import java.util.List;

@Controller("/TestCheck")
public class ReceiveDataFromFrontEndoController {

    @Inject
    ProjectAllocationRepository projectAllocationRepository;

    @Post("/post")
    public String SaveDataFromFrontEnd(long number, String description,String projectCode) {

        ReceiveDataFromFrontEndDTO instance = new ReceiveDataFromFrontEndDTO(number,description,projectCode);
        projectAllocationRepository.save(number,description,projectCode);

        System.out.println("Saved");

        return instance.toString();
    }


}