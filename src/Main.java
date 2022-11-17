import model.client.Client;
import model.market.Cosmetics;
import model.market.EssentialOil;
import model.market.Products;
import model.market.Tea;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cosmetics cosmetics1 = new Cosmetics("Cacao Oil", 60, 72, "Cacao");
        Cosmetics cosmetics2 = new Cosmetics("Cream with Vitamin C", 45, 50, "Nuts");
        Cosmetics cosmetics3 = new Cosmetics("Bath Salt", 42, 50, "Orange");
        Tea tea1 = new Tea("Tea For Cholesterol", 32, 50, "Equisetum arvense, Taraxacum officinale, Urtica dioica");
        Tea tea2 = new Tea("Detox", 57, 100, "Zingiber officinale");
        Tea tea3 = new Tea("Cherry Tea", 37, 50, "Cerasorum stipites");
        EssentialOil essentialOil1 = new EssentialOil("Aroma Difusor", 53, 100, "Lavanda");
        EssentialOil essentialOil2 = new EssentialOil("Aloe Vera", 71, 20, "Aloe Vera");
        EssentialOil essentialOil3 = new EssentialOil("Lemon Oil", 64, 10, "Lemon");
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int totalSum = 0;
        int monthSum = 0;
        int daySum = 0, clientSum = 0;
        int nrOfClients = 0;
        int nrOfProducts = 0, end = 3, happy = 0, sad = 0;
        String stop;
        List<Products> products = new ArrayList<>(List.of(cosmetics1, cosmetics2, cosmetics3, tea1, tea2, tea3, essentialOil1, essentialOil3, essentialOil2));
        boolean b = true;
        for (int i = 1; b; i++) {
            daySum = 0;
            System.out.println("Day " + i);
            nrOfClients = random.nextInt(4, 8);
            for (int j = 1; j <= nrOfClients; j++) {
                Client client = new Client(random.nextInt(100, 200), false);
                System.out.println(j + " Client with " + client.getMoney() + " money");
                nrOfProducts = random.nextInt(1, end);
                clientSum = 0;
                System.out.println("   Require: ");
                int a = 0;
                for (int k = 1; k <= nrOfProducts; k++) {
                    Products product = products.get(random.nextInt(products.size()));
                    if (client.getMoney() >= product.getPrice()) {
                        System.out.println("    " + product.getName() + " with price " + product.getPrice());
                        clientSum += product.getPrice();
                        client.setMoney(client.getMoney() - product.getPrice());
                        client.setHappy(true);
                        a += 1;
                    }
                }
                if (a == nrOfProducts) {
                    System.out.println("Client is happy");
                    happy += 1;
                } else {
                    System.out.println("Client is sad");
                    sad += 1;
                }
                daySum += clientSum;
                System.out.println();
            }
            monthSum += daySum;
            System.out.println("+++++++++++++++");
            if (i % 30 == 0) {
                System.out.println("******************************");
                System.out.println(i / 30 + ". Month");
                System.out.println("The month income: " + monthSum);
                System.out.println("The month medium income: " + monthSum / 30);
                System.out.println("Total number of Clients: " + happy + sad);
                System.out.println("Happy: " + happy);
                System.out.println("Sad: " + sad);
                if (happy > sad) {
                    end += 1;
                } else {
                    end -= 1;
                }
                totalSum += monthSum;
                monthSum = 0;
                happy = 0;
                sad = 0;
                System.out.println("******************************");

                //Stop & Final Function
                System.out.print("Tap \"0\" to finish: ");
                stop = scanner.next();
                if (stop.equals("0")) {
                    System.out.println("####################################################################");

                    System.out.println("The total income: " + totalSum);
                    System.out.println("The medium income: " + totalSum / (i / 30));
                    System.out.println("####################################################################");
                    b = false;
                }
            }
        }
    }
}