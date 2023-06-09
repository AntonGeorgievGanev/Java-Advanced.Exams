package Exams.E26June2021.groomingSalon;

import groomingSalon.GroomingSalon;
import groomingSalon.Pet;

public class Main {

    public static void main(String[] args) {
	// write your code here
        // Initialize the repository
        GroomingSalon salon = new GroomingSalon(20);

// Initialize entity
        groomingSalon.Pet dog = new groomingSalon.Pet("Ellias", 5, "Tim");

// Print Pet
        System.out.println(dog); // Ellias 5 - (Tim)

// Add Pet
        salon.add(dog);

// Remove Pet
        System.out.println(salon.remove("Ellias")); // true
        System.out.println(salon.remove("Pufa")); // false

        groomingSalon.Pet cat = new groomingSalon.Pet("Bella", 2, "Mia");
        groomingSalon.Pet bunny = new groomingSalon.Pet("Zak", 4, "Jon");

        salon.add(cat);
        salon.add(bunny);

// Get Pet
        Pet pet = salon.getPet("Bella", "Mia");
        System.out.println(pet); // Bella 2 - (Mia)

// Count
        System.out.println(salon.getCount()); // 2

// Get Statistics
        System.out.println(salon.getStatistics());
// The grooming salon has the following clients:
//Bella Mia
//Zak Jon

    }
}
