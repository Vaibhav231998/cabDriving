package com.example.demo.Controllers;

import com.example.demo.Dtos.RequestDto.Driver;
import com.example.demo.Dtos.RequestDto.User;
import com.example.demo.Util;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
class CabBookingController {

    private List<User> users = new ArrayList<>();
    private List<Driver> drivers = new ArrayList<>();

    @PostMapping("/users")
    public ResponseEntity<String> addUser(@RequestBody User user) {
        users.add(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("User added successfully");
    }

    @PostMapping("/drivers")
    public ResponseEntity<String> addDriver(@RequestBody Driver driver) {
        drivers.add(driver);
        return ResponseEntity.status(HttpStatus.CREATED).body("Driver added successfully");
    }

    @GetMapping("/find-ride")
    public ResponseEntity<String> findRide(@RequestParam String username,
                                           @RequestParam int[] source,
                                           @RequestParam int[] destination) {
        List<Driver> availableDrivers = new ArrayList<>();
        for (Driver driver : drivers) {
            if (driver.isAvailable() && Util.isWithinRange(driver.getCurrentLocation(), source, 5)) {
                availableDrivers.add(driver);
            }
        }
        if (availableDrivers.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No ride found");
        } else {
            // Choose the nearest driver for simplicity
            Driver chosenDriver = availableDrivers.get(0);
            return ResponseEntity.ok(chosenDriver.getName() + " is available");
        }
    }
}
