package machine;

import java.util.Scanner;

public class CoffeeMachine {
    static int water = 400, milk = 540, coffee = 120, money = 550, cups = 9;
    Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        machineState();
        menu();
    }

    private static void menu() {
        System.out.println("Write action (buy, fill, take): ");
        Scanner scanner = new Scanner(System.in);
        String operation = scanner.next();

        switch (operation) {
            case "buy":
                buy();
                break;
            case "fill":
                fill();
                break;
            case "take":
                take();
                break;
        }
    }

    private static void take() {
        System.out.println("I gave you $" + money);
        money = 0;
        System.out.println();
        machineState();
    }
    private static void fill() {
        System.out.println("Write how many ml of water do you want to add:");
        Scanner scanner = new Scanner(System.in);
        water = water + scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add: ");
        milk = milk + scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add: ");
        coffee = coffee + scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        cups = cups + scanner.nextInt();
        System.out.println();
        machineState();

    }
    private static void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        System.out.println();
        switch (choice) {
            case 1:
                water = water - 250;
                coffee = coffee - 16;
                cups = cups - 1;
                money = money + 4;
                machineState();
                break;
            case 2:
                water = water - 350;
                milk = milk - 75;
                coffee = coffee - 20;
                cups = cups - 1;
                money = money + 7;
                machineState();
                break;
            case 3:
                water = water - 200;
                milk = milk - 100;
                coffee = coffee - 12;
                cups = cups - 1;
                money = money + 6;
                machineState();
                break;
            default:
                System.out.println("Error!");
                //do nothing
        }
    }

    private static void machineState() {
        System.out.println("The coffee machine has:\n" +
                water + " of water\n" +
                milk + " of milk\n" +
                coffee + " of coffee beans\n" +
                cups + " of disposable cups\n" +
                money + " of money");
        System.out.println();
    }

    private static void coffeeRequires() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water the coffee machine has:");
        double water = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        double milk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has: ");
        double coffee = scanner.nextInt();
        System.out.println("Write how many cups of coffee you will need:");
        double cups = scanner.nextInt();
        int count;


        if(cups * 200 < water && cups * 50 < milk && cups * 15 < coffee) {
            water = (water - cups * 200) / 200;
            milk = (milk - cups * 50) / 50;
            coffee = (coffee - cups * 15) / 15;
            count = min(water, milk, coffee);
            if (count >= 0) {
                System.out.println("Yes, I can make that amount of coffee (and even " + (int) count +" more than that)");
            } else {
                System.out.println("Yes, I can make that amount of coffee");
            }
        }
        else {
            water = water / 200;
            milk = milk / 50;
            coffee = coffee / 15;
            count = min(water, milk, coffee);
            System.out.println("No, I can make only " + (int) count +" cup(s) of coffee");
        }

    }

    private static int min(double water, double milk, double coffee) {
        return (int) Math.min(Math.min(water, milk), coffee);
    }

    private static void greet() {
        System.out.println("Starting to make a coffee\n" +
                "Grinding coffee beans\n" +
                "Boiling water\n" +
                "Mixing boiled water with crushed coffee beans\n" +
                "Pouring coffee into the cup\n" +
                "Pouring some milk into the cup\n" +
                "Coffee is ready!");
    }

}
