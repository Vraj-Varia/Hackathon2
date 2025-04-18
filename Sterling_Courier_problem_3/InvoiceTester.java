import java.util.Scanner;

public class InvoiceTester {
    public static void readInvoice() {
        Scanner scan = new Scanner(System.in);
        Invoice i = new Invoice();

        System.out.println("Enter Invoice Details");
        System.out.print("Customer ID: ");
        i.setCustId(Integer.parseInt(scan.nextLine()));

        System.out.print("Month: ");
        i.setMonth(Integer.parseInt(scan.nextLine()));

        System.out.print("Year: ");
        i.setYear(Integer.parseInt(scan.nextLine()));

        System.out.print("Description: ");
        i.setDesc(scan.nextLine());

        SterlingDAO dao = new SterlingDAO();
        dao.saveInvoice(i);
    }
}