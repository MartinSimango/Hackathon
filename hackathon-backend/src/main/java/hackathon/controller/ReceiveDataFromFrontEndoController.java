package hackathon.controller;


import hackathon.client.MWLClient;
import hackathon.client.request.ReceiveDataFromFrontEndDTO;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;

import javax.inject.Inject;

@Controller("/TestCheck")
public class ReceiveDataFromFrontEndoController {
    ReceiveDataFromFrontEndDTO instance1 =  new ReceiveDataFromFrontEndDTO(4,"Hi there","MWL");

    @Get("/data")
    public ReceiveDataFromFrontEndDTO Test(){
        return instance1;
    }

    @Post("/post")
    public String Save(int number, String description,String projectCode) {
        ReceiveDataFromFrontEndDTO instance =  new ReceiveDataFromFrontEndDTO();
        instance.setnumber(number);
        instance.setprojectCode(projectCode);
        instance.setdescription(description);

        // save to database or something
        System.out.println("Saved");

        return instance.toString();
    }
}