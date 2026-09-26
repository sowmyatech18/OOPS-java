package cse25549;

import java.util.Scanner;


class product {

    private String name;
    private double price;
    private int id;

    public product() {
        name = "";
        price = 0.0;
        id = 0;
    }

    public product(String pro, double price, int proid) {
        this.name = pro;
        this.price = price;
        this.id = proid;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}



class shoppingCart {

    private product[] cart = new product[10];
    private int[] qty = new int[10];
    private int count = 0;

    public void add(product p, int q) {
        cart[count] = p;
        qty[count] = q;
        count++;
    }

    public void view() {
        double total = 0;

        if (count == 0) {
            System.out.println("Cart empty");
            return;
        }

        for (int i = 0; i < count; i++) {
            double cost = cart[i].getPrice() * qty[i];
            System.out.println(cart[i].getName() + " x " + qty[i] + " = $" + cost);
            total += cost;
        }

        System.out.println("Subtotal = $" + total);
    }

    public void remove(int id) {
        for (int i = 0; i < count; i++) {
            if (cart[i].getId() == id) {

                for (int j = i; j < count - 1; j++) {
                    cart[j] = cart[j + 1];
                    qty[j] = qty[j + 1];
                }

                count--;
                System.out.println("Item removed.");
                return;
            }
        }
        System.out.println("Item not found.");
    }

    public void checkout() {
        double total = 0;

        for (int i = 0; i < count; i++)
            total += cart[i].getPrice() * qty[i];

        double tax = total * 0.06;
        double finalTotal = total + tax;

        System.out.println("Subtotal: $" + total);
        System.out.println("Tax: $" + tax);
        System.out.println("Final Bill: $" + finalTotal);
        System.out.println("Thank you!");
    }
}



public class mainapp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        product[] store = {
                new product("Apple", 0.5, 1),
                new product("Milk", 3.0, 2),
                new product("Bread", 2.5, 3)
        };

        shoppingCart cart = new shoppingCart();

        int choice;

        do {
            System.out.println("\n1.View Products");
            System.out.println("2.Add to Cart");
            System.out.println("3.View Cart");
            System.out.println("4.Remove Item");
            System.out.println("5.Checkout & Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    for (product p : store)
                        System.out.println(p.getId() + ". " + p.getName() + " - $" + p.getPrice());
                    break;

                case 2:
                    System.out.print("Enter id: ");
                    int id = sc.nextInt();
                    System.out.print("Enter qty: ");
                    int q = sc.nextInt();

                    for (product p : store)
                        if (p.getId() == id)
                            cart.add(p, q);
                    break;

                case 3:
                    cart.view();
                    break;

                case 4:
                    System.out.print("Enter id to remove: ");
                    cart.remove(sc.nextInt());
                    break;

                case 5:
                    cart.checkout();
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 5);
    }
}
