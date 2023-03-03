import java.util.Scanner;

public class CandyStore {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // create Scanner object to read input
        double totalCost = 0.0; // initialize total cost to 0
        String candyChoice = candyChoices(); // call candyChoices() method to prompt user for candy choice

        while (!candyChoice.equalsIgnoreCase("quit")) { // continue asking for candy choice until user enters "quit"
            System.out.print("Enter the quantity you would like to purchase: ");
            int candyQty = input.nextInt(); // read user input for quantity
            double candyCost = calculateCost(candyChoice, candyQty); // calculate the cost of candy choice and quantity
            totalCost += candyCost; // add the cost to the total cost
            System.out.println("Added " + candyQty + " " + candyChoice + " to your cart for a total cost of $" + candyCost);
            candyChoice = candyChoices(); // prompt user for candy choice again
        }

        double tax = totalCost * 0.13; // calculate tax
        double totalCostWithTax = totalCost + tax; // calculate total cost with tax
        System.out.println("Subtotal: $" + totalCost);
        System.out.println("Tax (13%): $" + tax);
        System.out.println("Total: $" + totalCostWithTax);

    } //end main

    public static String candyChoices() {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the Candy Store! Here are your choices:");
        System.out.println("a) Reese's Pieces: $2.50/0.5 kg");
        System.out.println("b) Skittles: $1.75/1 kg");
        System.out.println("c) Jubjubes: $0.50/1 kg");
        System.out.println("d) Lollipops: 1 for $0.50 or 5 for $2.00");
        System.out.println("e) Smarties: $1.50/1 kg");
        System.out.print("Enter the letter corresponding to your candy choice (or quit to exit): ");
        return input.nextLine(); // return user's candy choice
    }

    public static double calculateCost(String choice, int qty) {
        double cost = 0.0; // initialize cost to 0
        switch (choice.toLowerCase()) {
            case "a":
                cost = qty * 2.5; // cost of Reese's Pieces is $2.50/0.5 kg
                break;
            case "b":
                cost = qty * 1.75; // cost of Skittles is $1.75/1 kg
                break;
            case "c":
                cost = qty * 0.5; // cost of Jubjubes is $0.50/1 kg
                break;
            case "d":
                int lollipopBundles = qty / 5; // calculate number of 5-pack bundles
                int lollipopSingles = qty % 5; // calculate number of individual lollipops
                cost = lollipopBundles * 2.0 + lollipopSingles * 0.5; // cost of lollipops is 1 for $0.50 or 5 for $2.00
                break;
            case "e":
                cost = qty * 1.5; // cost of Smarties is $1.50/1 kg
                break;
        }
        return cost;
    }
}

