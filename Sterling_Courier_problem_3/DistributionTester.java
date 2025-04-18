import java.text.SimpleDateFormat;
import java.util.Scanner;

public class DistributionTester {
    public static void readDistribution() {
        Scanner scan = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");

        System.out.println("Enter Distribution Date");
        System.out.print("Date (DD-MMM-YYYY): ");
        try {
            SterlingDAO dao = new SterlingDAO();
            dao.saveDistribution(sdf.parse(scan.nextLine()));
        } catch (Exception e) {
            System.out.println("Bad date");
        }
    }
}