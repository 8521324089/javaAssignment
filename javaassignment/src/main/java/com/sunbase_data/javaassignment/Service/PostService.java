package com.sunbase_data.javaassignment.Service;

import com.sunbase_data.javaassignment.Model.Customer;

import java.util.List;

public interface PostService {

    List<Object> getCustomer(String token);

    String getToken(String login, String password);

    String createCus(String token, Customer customer);
}
