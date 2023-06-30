package com.example.rest.Car.Controller;

import com.example.rest.Car.DTO.CarDTO;
import com.example.rest.Car.Entity.Car;
import com.example.rest.Car.Service.CarService;
import com.example.rest.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {
    @Autowired
    private CarService carService;


    @GetMapping("/all")
    public ResponseEntity<Response> getallcars(){
        List<CarDTO> cardto = carService.allCars();
        Response response = Response.builder().status(true).message(cardto.toString()).data("Here you can find a list of the available cars").build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Response> getfindcarbyid(@PathVariable Long id){
        CarDTO carDTO = carService.carById(id);
        Response response = Response.builder().status(true).message(carDTO.toString()).data("Here you can find the requested car").build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/savecar")
    public ResponseEntity<Response> postaddcar(@RequestBody Car car){
        CarDTO carDTO = carService.addcar(car);
        Response response = Response.builder().status(true).message(carDTO.toString()).data("The car has been added successfully").build();
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @PutMapping("/updatecar/{id}")
    public ResponseEntity<Response> putupdatecar(@PathVariable Long id, @RequestBody Car car){
        CarDTO carDTO = carService.updateCar(id,car);
       Response response = Response.builder().status(true).message(carDTO.toString()).data("The selected car has been updated").build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/deletecar/{id}")
    public ResponseEntity<Response> deletecar(@PathVariable Long id){
        carService.deletecar(id);
        Response response =Response.builder().status(true).message("").data("The selected car has been deleted").build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
