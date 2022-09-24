package banking;

import java.util.Objects;
import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;



public class Main {
    static String[] cardData = new String[2];
    static boolean exit = false;
    static boolean logIn = false;
    
    public static void main(String[] args) {
        BankAccount.menu();

    }


    }
    // BankAccount class
    public static class BankAccount {
        private static String card = "";
        private static String pin = "";
        Random random = new Random();

        public static void BankAccount() {
            
            String Pin = "";
            String BIN = "400000";
            
            

        }
        
        public static void menu() {
            Scanner scanner = new Scanner(System.in);
            
            startMenu();
            
            while (!exit) {
                int decision = scanner.nextInt();

                switch (decision) {

                    case 1:
                        createCard();
                        break;
                    case 2:
                        login(cardData);
                        break;
                    case 0:
                        exit = true;
                        break;
                    default:
                    startMenu();    
                }
            }
        }
        public static void startMenu() {
            System.out.println("Create an account");
            System.out.println("Log into account");
            System.out.println("Exit");
        }
        public static void createCard() {
            String Pin = "";
            String BIN = "400000";
            Random random = new Random();
            String AccIdentifier = "";
            String randNum2 = "";
            
            for (int i = 0; i < 10; i++) {
                AccIdentifier += String.valueOf(random.nextInt(10));
            }
            for (int i = 0; i < 4; i++) {
                randNum2 += String.valueOf(random.nextInt(10));
            }
            card = BIN + AccIdentifier;
            Pin = randNum2;
            cardData[0] = card;
            cardData[1] = Pin;
            luhnCheck();
            System.out.println("Your card has been created");
            System.out.println("Your card number:");
            System.out.println(cardData[0]);
            System.out.println("Your card PIN:");
            System.out.println(Pin);
            subMenu();
            startMenu();
        }
        public static void luhnCheck() {
            
            int[] cardInt = new int[cardData[0].length()];
            for (int i = 0; i < cardData[0].length(); i++) {
                cardInt[i] = Integer.parseInt(cardData[0].substring(i, i+1));
            }
            for (int i = cardInt.length - 2; i >= 0; i = i - 2) {
                int tempValue = cardInt[i];
                tempValue = tempValue * 2;
                if (tempValue > 9) {
                    tempValue = tempValue % 10 + 1;
                }
                cardInt[i] = tempValue; 
            }
            
            int total = 0;
            int checkSum = 0;
            for (int i = 0; i < cardInt.length - 1 ; i++) {
                total += cardInt[i];
            }
            checkSum = (10 - total % 10) % 10;
            String checkNum = String.valueOf(checkSum);
            removeLastNum();
            cardData[0] = cardData[0] + checkNum;

        }
        public static void removeLastNum() {
            cardData[0] = card.substring(0, card.length() - 1);
            
        }
        
        public static void subMenu() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("1. Balance");
            System.out.println("2. log out");
            System.out.println("0. Exit\n");
            while (logIn && !exit) {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Balance: 0");
                        subMenu();
                        break;
                    case 2:
                        System.out.println("You have successfully logged out!");
                        logIn = false;
                        startMenu();
                        break;
                    case 0:
                        System.out.println("Bye!");
                        exit = true;
                    default:
                        startMenu();     
                }
            }
        }
        
        public static void login(String[] cardData) {
            
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter your card number:");
            String logCard = scanner.nextLine();
            System.out.println("Enter your PIN");
            String logPin = scanner.nextLine();

            if (logCard.equals(cardData[0]) && logPin.equals(cardData[1])) {
                logIn = true;
                System.out.println("You have successfully logged in!");
                subMenu();
            } else {
                System.out.println("Wrong card number or PIN!");
                startMenu();
            }
            



        }


    }

             
}