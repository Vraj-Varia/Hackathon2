import java.text.SimpleDateFormat;
import java.util.Scanner;

public class DeliveryTester {
    public static void readDelivery() {
        Scanner scan = new Scanner(System.in);
        Delivery d = new Delivery();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");

        System.out.println("Enter Delivery Details");
        System.out.print("Employee ID: ");
        d.setEmpId(Integer.parseInt(scan.nextLine()));

        System.out.println("Couriers: 2001, 2002, 2003");

        System.out.print("Order ID: ");
        d.setOrderId(Integer.parseInt(scan.nextLine()));

        System.out.print("Delivery Date (DD-MMM-YYYY): ");
        try {
            d.setDelDate(sdf.parse(scan.nextLine()));
        } catch (Exception e) {
            System.out.println("Bad date");
            return;
        }

        System.out.print("Status: ");
        d.setStatus(scan.nextLine());

        System.out.print("Remarks: ");
        d.setRemarks(scan.nextLine());

        SterlingDAO dao = new SterlingDAO();
        dao.saveDelivery(d);
    }
}