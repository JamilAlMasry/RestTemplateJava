package com.example.rest;

import com.example.rest.Car.Entity.Car;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class CarRestTemplate {
private RestTemplate rest = new RestTemplate();
    String mainurl = "http://localhost:8080/cars";

    public List<Car> getallCarsAPI(){
        String url = mainurl + "/all";
        Car[] car = rest.getForObject(url, Car[].class);
        return Arrays.asList(car);
    }
    public ResponseEntity<Response> getCarbyAPI(Long id){
        String url = mainurl +"/" + id;
        Response response =  rest.getForObject(url, Response.class);
        return new ResponseEntity<Response>(response, HttpStatus.OK);

    }
    public Car saveCarAPI(Car car){
        String url = mainurl + "/savecar";
        return rest.postForObject(url, car, Car.class);
    }

    public void deleteCarAPi(Long id){
        String url = mainurl + "/deletecar/" + id;
        rest.delete(url);
    }
}
