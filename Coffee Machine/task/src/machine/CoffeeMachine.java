package machine;

import java.util.Scanner;

enum CoffeeMachineEnum {
    ACTION,
    CHOOSING_COFFEE
}
public class CoffeeMachine {
    int water;
    int milk;
    int coffee;
    int money;
    int cups;
    State status;
    Scanner scanner = new Scanner(System.in);

    enum CoffeeType {
        ESPRESSO("1", 250, 0, 16, 4),
        LATTE("2", 350, 75, 20, 7),
        CAPPUCCINO("3", 200, 100, 12, 6);

        int water, milk, coffee, money;
        String type;
        CoffeeType(String type, int water, int milk, int coffee, int money) {
            this.type = type;
            this.water = water;
            this.milk = milk;
            this.coffee = coffee;
            this.money = money;
        }
        public static CoffeeType findCoffeeByType (String type) {
            for (CoffeeType value : values()) {
                if(type.equals(value.type)) {
                    return value;
                }
            }
            return null;
        }
    }
    enum State {
        STANDBY("standby"),
        BUY("buy"),
        FILL("fill"),
        TAKE("take"),
        REMAINING("remaining"),
        EXIT("exit");

        String name;
        State(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
    void initializeIngredients(int water, int milk, int coffee, int money, int cups) {
        this.water += water;
        this.milk += milk;
        this.coffee += coffee;
        this.money += money;
        this.cups += cups;
        this.status = State.STANDBY;
    }

    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        coffeeMachine.initializeIngredients(400, 540, 120, 550, 9);
        State currentStatus = coffeeMachine.status;

        while (!currentStatus.getName().equals("exit")) {
            coffeeMachine.menu();
            currentStatus = coffeeMachine.status;
        }
    }

     void menu() {
        System.out.println("Write action (buy, fill, take, remaining, exit): ");
        Scanner scanner = new Scanner(System.in);
        String operation = scanner.next();
        System.out.println();

        switch (operation) {
            case "buy":
                buy();
                status = State.BUY;
                break;
            case "fill":
                fill();
                status = State.FILL;
                break;
            case "take":
                take();
                status = State.TAKE;
                break;
            case "remaining":
                machineState();
                status = State.REMAINING;
                break;
            default:
                status = State.EXIT;
                break;
        }
    }

     void take() {
        System.out.println("I gave you $" + money);
        money = 0;

    }
     void fill() {
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
        menu();

    }
     void buy() {
         System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
         String choice = scanner.next();
         if (choice.equals("1") || choice.equals("2") || choice.equals("3")) {
             makeCoffee(choice);
         } else {
             status = State.STANDBY;
             menu();
         }
     }
     void makeCoffee(String choice) {
         CoffeeType coffeeType = CoffeeType.findCoffeeByType(choice);
         if(coffeeType != null) {
             if (water >= coffeeType.water && milk >= coffeeType.milk && coffee >= coffeeType.coffee && cups >= 1) {
                water -= coffeeType.water;
                milk -= coffeeType.milk;
                coffee -= coffeeType.coffee;
                cups -= 1;
                money += coffeeType.money;
                 System.out.println("I have enough resources, making you a coffee!");
             } else {
                 boolean hasWater, hasMilk, hasCoffee, hasCups;
                 hasWater = water >= coffeeType.water;
                 hasMilk = milk >= coffeeType.milk;
                 hasCoffee = coffee >= coffeeType.coffee;
                 hasCups = cups >= 1;
                 notEnoughResources(hasWater, hasMilk, hasCoffee, hasCups);
             }

         }

    }
    private static void notEnoughResources(boolean hasWater, boolean hasMilk, boolean hasCoffee, boolean hasCups) {
        if (!hasWater && hasMilk && hasCoffee && hasCups) {
            System.out.println("Sorry, not enough water!");
        } else if(hasWater && !hasMilk && hasCoffee && hasCups) {
            System.out.println("Sorry, not enough milk!");
        } else if(hasWater && hasMilk && !hasCoffee && hasCups) {
            System.out.println("Sorry, not enough coffee!");
        } else if (hasWater && hasMilk && hasCoffee && !hasCups) {
            System.out.println("Sorry, not enough cups!");
        } else {
            //do nothing

        }
    }


     void machineState() {
        System.out.println("The coffee machine has:\n" +
                water + " of water\n" +
                milk + " of milk\n" +
                coffee + " of coffee beans\n" +
                cups + " of disposable cups\n" +
                money + " of money");
        System.out.println();
        menu();
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
