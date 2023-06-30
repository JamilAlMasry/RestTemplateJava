package com.example.rest.Car.Service;

import com.example.rest.Car.DTO.CarDTO;
import com.example.rest.Car.Entity.Car;
import com.example.rest.Car.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    public List<CarDTO> allCars(){
        List<Car> list = carRepository.findAll();
        List<CarDTO> carlist = new ArrayList<>();
        for(int i=0;i<list.size();i++){
            carlist.add(new CarDTO(list.get(i).getId(),list.get(i).getBrand()));
        }
        return carlist;
    }

    public CarDTO carById(Long id){
        Car c;
        try {
            c = carRepository.findById(id).orElseThrow(()-> new ChangeSetPersister.NotFoundException());
        } catch (ChangeSetPersister.NotFoundException e) {
            throw new RuntimeException(e);
        }
        CarDTO car = new CarDTO(c.getId(),c.getBrand());
        return car;
    }

    public CarDTO addcar(Car c){
        carRepository.save(c);
        return new CarDTO(c.getId(),c.getBrand());
    }

    public CarDTO updateCar(Long id, Car car){
        Car c = null;
        try {
            c = carRepository.findById(id).orElseThrow(()-> new ChangeSetPersister.NotFoundException());
        }  catch (ChangeSetPersister.NotFoundException e) {
            throw new RuntimeException(e);
        }
        c.setBrand(car.getBrand());

        carRepository.save(c);
        return new CarDTO(c.getId(),c.getBrand());
    }

    public void deletecar(Long id){
        carRepository.deleteById(id);
    }

}
