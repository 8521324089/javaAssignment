package com.sunbase_data.javaassignment.Service;
import java.util.List;

import com.sunbase_data.javaassignment.Model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Service
public class CreateCustomer implements PostService {

    String createUrl="https://qa2.sunbasedata.com/sunbase/portal/api/assignment.jsp";

    @Autowired
    private RestTemplate restTemplate;




    public String createCus(String token, Customer customer) {
        HttpHeaders headers=new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(token);

        restTemplate=new RestTemplate();
        String cmd="create";

        createUrl=createUrl+"?cmd="+cmd;


        HttpEntity<Customer> entity = new HttpEntity<>(customer, headers);

        ResponseEntity<String> response = restTemplate.exchange(createUrl, HttpMethod.POST,   entity,String.class);


        return response.toString();



    }





    @Override
    public String getToken(String login, String password) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Object> getCustomer(String token) {
        // TODO Auto-generated method stub
        return null;
    }






}