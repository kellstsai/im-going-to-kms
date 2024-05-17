package com.example;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        // Singleton usage
        CPPFoodDeliverySystem system = CPPFoodDeliverySystem.getInstance();

        // Factory usage
        List<Participant> participants = new ArrayList<>();

        // Create 4 restaurants
        participants.add(new Restaurant("Taco Bell", "123 Main St", "LA County", "08:00", "22:00", "Mexican", new ArrayList<>()));
        participants.add(new Restaurant("Pizza Hut", "456 Elm St", "Orange County", "09:00", "23:00", "Italian", new ArrayList<>()));
        participants.add(new Restaurant("Thai Palace", "789 Oak St", "Orange County", "10:00", "21:00", "Thai", new ArrayList<>()));
        participants.add(new Restaurant("Burger King", "321 Pine St", "LA County", "07:00", "20:00", "American", new ArrayList<>()));

        // Create 8 drivers
        participants.add(new Driver("John", "1st shift", "LA County"));
        participants.add(new Driver("Alice", "1st shift", "Orange County"));
        participants.add(new Driver("Bob", "2nd shift", "Orange County"));
        participants.add(new Driver("Emily", "2nd shift", "LA County"));
        participants.add(new Driver("Mike", "3rd shift", "San Bernardino County"));
        participants.add(new Driver("Sara", "3rd shift", "LA County"));
        participants.add(new Driver("David", "1st shift", "San Bernardino County"));
        participants.add(new Driver("Jessica", "2nd shift", "San Bernardino County"));

        // Create 10 customers
        participants.add(new Customer("Alex", "No allergies", "LA County"));
        participants.add(new Customer("Emma", "Gluten-free", "Orange County"));
        participants.add(new Customer("Oliver", "Vegan", "San Bernardino County"));
        participants.add(new Customer("Sophia", "No allergies", "Orange County"));
        participants.add(new Customer("William", "Halal", "LA County"));
        participants.add(new Customer("Ava", "No allergies", "Orange County"));
        participants.add(new Customer("James", "Vegetarian", "LA County"));
        participants.add(new Customer("Charlotte", "Gluten-free", "San Bernardino County"));
        participants.add(new Customer("Logan", "No allergies", "Orange County"));
        participants.add(new Customer("Isabella", "Keto", "LA County"));

        // Register all participants
        for (Participant participant : participants) {
            participant.register();
        }

        // Mediator usage
        DeliveryMediator mediator = new DeliveryMediator();

        // Example interaction: Customer 1 orders from Restaurant A
        Customer customer1 = (Customer) participants.get(16); // Retrieve the correct customer index

        // Get a list of available drivers
List<Driver> availableDrivers = getAvailableDrivers(participants);

if (availableDrivers.isEmpty()) {
    System.out.println("No available drivers at the moment.");
} else {
    // Example interaction: Assigning a driver to Customer 1's order
    mediator.assignDriver(customer1, availableDrivers);

    // Example interaction: Driver delivers food to Customer 1
    // Assuming the first available driver is assigned
    Driver assignedDriver = availableDrivers.get(0);
    mediator.deliverFood(assignedDriver, customer1);
}

    }

    // Method to get a list of available drivers
    private static List<Driver> getAvailableDrivers(List<Participant> participants) {
        List<Driver> availableDrivers = new ArrayList<>();
        for (Participant participant : participants) {
            if (participant instanceof Driver) {
                Driver driver = (Driver) participant;
                if (driver.isAvailable(LocalTime.now())) {
                    availableDrivers.add(driver);
                }
            }
        }
        return availableDrivers;
    }
}


