import java.text.SimpleDateFormat;
import java.util.Scanner;

public class OrderTester {
    public static void readOrder() {
        Scanner scan = new Scanner(System.in);
        Order o = new Order();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");

        System.out.println("Enter Order Details");
        System.out.print("Customer ID: ");
        o.setCustId(Integer.parseInt(scan.nextLine()));

        System.out.print("Order Date (DD-MMM-YYYY): ");
        try {
            o.setOrderDate(sdf.parse(scan.nextLine()));
        } catch (Exception e) {
            System.out.println("Bad date");
            return;
        }

        System.out.print("Recipient Name: ");
        o.setRecName(scan.nextLine());

        System.out.print("Recipient Address: ");
        o.setRecAddr(scan.nextLine());

        System.out.print("Recipient City: ");
        o.setRecCity(scan.nextLine());

        System.out.print("Weight: ");
        o.setWeight(Double.parseDouble(scan.nextLine()));

        System.out.print("Description: ");
        o.setDesc(scan.nextLine());

        SterlingDAO dao = new SterlingDAO();
        dao.saveOrder(o);
    }
}