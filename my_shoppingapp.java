```java
package shopping_app;
import java.util.Scanner;

class product {
    int id;
    String name;
    double price;

    product() {
        id = 1;
        name = " ";
        price = 0.0;
    }

    product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public void view(product[] pdt) {
        for (product p : pdt) {
            System.out.println("|ID:" + p.id + "|Name:" + p.name + "|Price:" + p.price);
        }
    }
}

class cart {
    int id;
    String name;
    double price;
    int qty;

    cart(int id, String name, double price, int qty) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.qty = qty;
    }

    static void add(product[] pdt, cart[] arr, int ID, int qty) {
        for (product p : pdt) {
            if (ID == p.id) {
                int c = 0;

                while (c < arr.length) {
                    if (arr[c] == null) {
                        arr[c] = new cart(p.id, p.name, p.price, qty);
                        System.out.println("Item added");
                        return;
                    }
                    c++;
                }

                System.out.println("Cart is full");
                return;
            }
        }

        System.out.println("Product not found");
    }

    static void viewcart(cart[] arr) {
        for (cart e : arr) {
            if (e != null) {
                double ind_price = e.price * e.qty;

                System.out.println("|ID:" + e.id +
                        "|Name:" + e.name +
                        "|Price: " + e.price +
                        "|Qty:" + e.qty +
                        "|Ind price: " + ind_price);
            }
        }
    }

    static void remove(cart[] arr, int pdtID) {
        int i = 0;

        for (cart c : arr) {
            if (c != null && pdtID == c.id) {

                while (i < arr.length - 1) {
                    arr[i] = arr[i + 1];
                    i++;
                }

                arr[arr.length - 1] = null;

                System.out.println("Item removed");
                return;
            }

            i++;
        }

        System.out.println("Item not found");
    }

    static void exit(cart[] arr) {
        double tt = 0;

        for (cart e : arr) {
            if (e != null) {
                double ind_price = e.price * e.qty;

                System.out.println("|ID:" + e.id +
                        "|Name:" + e.name +
                        "|Price: " + e.price +
                        "|Qty:" + e.qty +
                        "|Ind price: " + ind_price);

                tt += ind_price;
            }
        }

        System.out.println("Your total:" + tt);
    }
}

public class shopping_app {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        product[] pdt = new product[3];

        product pdt1 = new product(1, "Rice", 4);
        product pdt2 = new product(2, "Wheat", 3);
        product pdt3 = new product(3, "Milk", 2);

        pdt[0] = pdt1;
        pdt[1] = pdt2;
        pdt[2] = pdt3;

        cart[] arr = new cart[50];

        product obj = new product();

        int ch = 0;

        do {
            System.out.println("---Welcome to our app---");
            System.out.println("1.View products");
            System.out.println("2.Add item to cart");
            System.out.println("3.View cart and subtotal");
            System.out.println("4.Remove/update cart");
            System.out.println("5.Check out and exit");

            System.out.print("Enter choice: ");
            ch = sc.nextInt();

            switch (ch) {

                case 1:
                    obj.view(pdt);
                    break;

                case 2:
                    System.out.print("Enter pdt id:");
                    int ID = sc.nextInt();

                    System.out.print("Enter qty:");
                    int qty = sc.nextInt();

                    cart.add(pdt, arr, ID, qty);
                    break;

                case 3:
                    cart.viewcart(arr);
                    break;

                case 4:
                    System.out.println("Enter id of pdt to be removed");
                    int pdtID = sc.nextInt();

                    cart.remove(arr, pdtID);
                    break;

                case 5:
                    cart.exit(arr);
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (ch != 5);

        sc.close();
    }
}
```
