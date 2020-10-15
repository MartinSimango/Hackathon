package hackathon.client.request;

import io.micronaut.core.annotation.Introspected;

import java.io.Serializable;
import java.util.List;

@Introspected
public class ReceiveDataFromFrontEndDTO  {

    private int number ;
    private String description;
    private String projectCode;

    public ReceiveDataFromFrontEndDTO(){}
    public ReceiveDataFromFrontEndDTO (int number, String description,String projectCode){
        this.number = number;this.description=description;this.projectCode=projectCode;}

    public String getprojectCode() {
        return projectCode;
    }

    public void setprojectCode(String projectCode) {
        this.projectCode = projectCode;
    }


    public String getdescription() {
        return description;
    }

    public void setdescription(String description) {
        this.description = description;
    }

    public int getnumber() {
        return number;
    }

    public void setnumber(int number) {
        this.number = number;
    }
    public String toString(){
        return "Number" + "=" + " "+number + " " +"Descrption"+ "="+ " "+ description + " " +"ProjectCode"+ "="+ " "+ projectCode;
    }
}