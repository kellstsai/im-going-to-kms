//DeliveryMediator.java
package com.example;

import java.time.LocalTime;
import java.util.List;

class DeliveryMediator {
    public void orderFood(Customer customer, Restaurant restaurant, List<Food> foodItems) {
        LocalTime currentTime = LocalTime.now();
        if (!restaurant.isOperatingHours(currentTime)) {
            System.out.println("Sorry, " + restaurant.getName() + " is closed at the moment.");
            return;
        }
        System.out.println(customer + " placed an order at " + restaurant);
        System.out.println("Dietary Restrictions: " + customer.getDietaryRestrictions());
        System.out.println("Food Items:");
        for (Food food : foodItems) {
            System.out.println("- " + food.getDescription());
        }
    }

    public void assignDriver(Customer customer, List<Driver> drivers) {
        LocalTime currentTime = LocalTime.now();
        boolean driverFound = false;
        
        for (Driver driver : drivers) {
            if (driver.isAvailable(currentTime) && driver.canDeliverToCounty(customer.getCounty())) {
                System.out.println(customer + "'s order assigned to " + driver);
                driverFound = true;
                break;
            }
        }

        if (!driverFound) {
            System.out.println("No available drivers at the moment.");
        }
    }

    // Method to deliver food by the driver to the customer
    public void deliverFood(Driver driver, Customer customer) {
        System.out.println(driver + " delivered food to " + customer);
    }
}


    

