package com.sunbase_data.javaassignment.Controller;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;




import java.util.List;

import com.sunbase_data.javaassignment.Model.Customer;
import com.sunbase_data.javaassignment.Service.CreateCustomer;
import com.sunbase_data.javaassignment.Service.FetchingCustomer;
import com.sunbase_data.javaassignment.Service.TokenService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/api/v1", method = RequestMethod.GET)
public class Controller {
    String generatedToken="";
    private TokenService tokenService=new TokenService();
    private FetchingCustomer fetchCustomer=new FetchingCustomer();
    private CreateCustomer createCustomer=new CreateCustomer();



    //for getting the authentication token using RestTemplate
    @PostMapping(value="/auth")
    public String getToken(){
        String response= tokenService.getToken("test@sunbasedata.com","Test@123");
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode tree = mapper.readTree(response);
            JsonNode node = tree.get("access_token");
            generatedToken = node.textValue().toString();
        }
        catch (Exception e){
            generatedToken=null;
        }



        return generatedToken;
    }

    @PostMapping(value="/create")
    public String NewCustomer( Customer customer) {
        String response=createCustomer.createCus(generatedToken,new Customer("piyush","Dasila","Vaibhav Khand","630 Siena Tower mahagun Mansion","Ghaziabad","UttarPradesh","piyush.dasilawork@gmail.com","9711126274"));

        return response;
    }




    public void updateCustomer(){

    }
    //for getting all the customers
    @GetMapping(value="/customers")
    public List<Object> getCustomers(){
        List<Object> response=fetchCustomer.getCustomer(generatedToken);
        return response;

    }
    public void deleteCustomer(){

    }
}