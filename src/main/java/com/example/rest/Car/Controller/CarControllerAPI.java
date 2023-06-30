package com.example.rest.Car.Controller;

import com.example.rest.Car.DTO.CarDTO;
import com.example.rest.Car.Entity.Car;
import com.example.rest.CarRestTemplate;
import com.example.rest.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CarControllerAPI {
    CarRestTemplate crt = new CarRestTemplate();
    @GetMapping("/all")
    public ResponseEntity<Response> getallcars(){
        List<Car> car = crt.getallCarsAPI();
        Response response = Response.builder().status(true).message(car.toString()).data("Here you can find a list of the available cars").build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Response> getfindcarbyid(@PathVariable Long id){

       return crt.getCarbyAPI(id);
    }

    @PostMapping("/savecar")
    public ResponseEntity<Response> postaddcar(@RequestBody Car car){
       Car c = crt.saveCarAPI(car);
        Response response = Response.builder().status(true).message(c.toString()).data("The car has been added successfully").build();
        return new ResponseEntity<>(response, HttpStatus.OK);

    }



    @DeleteMapping("/deletecar/{id}")
    public ResponseEntity<Response> deletecar(@PathVariable Long id){
       crt.deleteCarAPi(id);
        Response response =Response.builder().status(true).message("").data("The selected car has been deleted").build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
