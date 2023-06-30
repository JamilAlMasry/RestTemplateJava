package com.example.rest.Car.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
@Data
@Builder
@AllArgsConstructor
public class CarDTO implements Serializable {
private long id;
private String brand;
}
