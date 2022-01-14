package se.lexicon;

import se.lexicon.model.*;

import java.util.Arrays;
import java.util.Scanner;

public class App {
    VendingMachineImplementation vendingMachine;
    Kaffe kaffe;
    Ramlösa ramlösa;
    Snickers snickers;
    Scanner user;

    public void initialize() {
        kaffe = new Kaffe(1, 10, "Kaffe", true);
        ramlösa = new Ramlösa(2, 15, "Ramlösa Citron", false);
        snickers = new Snickers(3, 16, "Snickers", 488);
        Product[] productList = {kaffe, ramlösa, snickers};

        vendingMachine = new VendingMachineImplementation(productList);
    }

    public static void main(String[] args) {
        App app = new App();
        app.initialize();

        Scanner user = new Scanner(System.in);

        boolean endSession = false;
        int choice = 0;

        do {
            app.printMenu();
            choice = user.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("How much would you like to add?");
                    int amount = user.nextInt();
                    app.vendingMachine.addCurrency(amount);
                    break;
                case 2:
                    System.out.println(Arrays.toString(app.vendingMachine.getProducts()));
                    break;
                case 3:
                    System.out.println("Which product would you like information about?");
                    int id = user.nextInt();
                    System.out.println(app.vendingMachine.getDescription(id));
                    break;
                case 4:
                    System.out.println("Which produce would you like to purchase?");
                    int value = user.nextInt();
                    Product product = app.vendingMachine.request(value);
                    System.out.println("You receive " + product.getProductName());
                    break;
                case 5:
                    System.out.println("Your balance is " + app.vendingMachine.getBalance());
                    break;
                case 6:
                    System.out.println("Thank you, come again. \n" +
                            "Your change is " + app.vendingMachine.endSession());
                    endSession = true;
                    break;
            }
        } while (!endSession);
    }


    private void printMenu() {
        System.out.println("Welcome to the internet, what would you prefer? \n" +
                "1:Add currency \n" +
                "2:View product list \n" +
                "3:View individual product \n" +
                "4:Purchase product \n" +
                "5:View balance \n" +
                "6:End session and receive change");
    }
}
