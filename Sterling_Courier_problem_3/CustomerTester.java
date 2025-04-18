import java.text.SimpleDateFormat;
import java.util.Scanner;

public class CustomerTester {
    public static void readCustomer() {
        Scanner scan = new Scanner(System.in);
        Customer c = new Customer();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");

        System.out.println("Enter Customer Details");
        System.out.print("Name: ");
        c.setName(scan.nextLine());

        System.out.print("Reg Date (DD-MMM-YYYY): ");
        try {
            c.setRegDate(sdf.parse(scan.nextLine()));
        } catch (Exception e) {
            System.out.println("Bad date");
            return;
        }

        System.out.print("Address: ");
        c.setAddr(scan.nextLine());

        System.out.print("City: ");
        c.setCity(scan.nextLine());

        System.out.print("Pin: ");
        c.setPin(scan.nextLine());

        System.out.print("Phone: ");
        c.setPhone(scan.nextLine());

        System.out.print("Email: ");
        c.setEmail (scan.nextLine());

        SterlingDAO dao = new SterlingDAO();
        dao.saveCustomer(c);
    }
}