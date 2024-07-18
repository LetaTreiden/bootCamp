import java.util.Scanner;

class Pet {
    private String name;
    private int hunger;     // 0 = not hungry, 10 = very hungry
    private int happiness;  // 0 = very sad, 10 = very happy

    public Pet(String name) {
        this.name = name;
        this.hunger = 5;     // Initial hunger level
        this.happiness = 5;  // Initial happiness level
    }

    public void feed() {
        if (hunger > 0) {
            hunger = hunger - 2;
            System.out.println(name + " is eating. Hunger level: " + hunger);
        } else {
            System.out.println(name + " is not hungry.");
        }
    }

    public void play() {
        if (happiness < 10) {
            happiness = happiness + 2;
            System.out.println(name + " is playing. Happiness level: " + happiness);
        } else {
            System.out.println(name + " is already very happy.");
        }
    }

    public void passTime() {
        if (hunger < 10) {
            hunger++;
        }
        if (happiness > 0) {
            happiness--;
        }
    }

    public void showStatus() {
        System.out.println(name + "'s status:");
        System.out.println("Hunger level: " + hunger);
        System.out.println("Happiness level: " + happiness);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of your pet: ");
        String petName = scanner.nextLine();
        
        Pet pet = new Pet(petName);
        
        while (true) {
            System.out.println("\nWhat would you like to do?");
            System.out.println("1. Feed " + petName);
            System.out.println("2. Play with " + petName);
            System.out.println("3. Show " + petName + "'s status");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    pet.feed();
                    break;
                case 2:
                    pet.play();
                    break;
                case 3:
                    pet.showStatus();
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            
            // Pass time after each action
            pet.passTime();
        }
    }
}
