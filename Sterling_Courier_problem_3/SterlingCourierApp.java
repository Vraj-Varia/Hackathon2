import java.util.Scanner;

public class SterlingCourierApp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean run = true;

        while (run) {
            System.out.println("=========================================");
            System.out.println("             Sterling Courier");
            System.out.println("=========================================");
            System.out.println("1. Add Customer");
            System.out.println("2. Add Order");
            System.out.println("3. Add Distribution");
            System.out.println("4. Add Delivery");
            System.out.println("5. Add Invoice");
            System.out.println("6. Exit");
            System.out.print("Pick: ");

            String choice = scan.nextLine();
            int opt;
            try {
                opt = Integer.parseInt(choice);
            } catch (Exception e) {
                System.out.println("Enter a number");
                continue;
            }

            if (opt == 1) {
                CustomerTester.readCustomer();
            } else if (opt == 2) {
                OrderTester.readOrder();
            } else if (opt == 3) {
                DistributionTester.readDistribution();
            } else if (opt == 4) {
                DeliveryTester.readDelivery();
            } else if (opt == 5) {
                InvoiceTester.readInvoice();
            } else if (opt == 6) {
                run = false;
                System.out.println("Bye");
            } else {
                System.out.println("Wrong choice");
            }
        }
        scan.close();
    }
}