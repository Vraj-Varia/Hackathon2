import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SterlingDAO {

    // Save customer details to a text file
    public int saveCustomer(Customer c) {
        File file = new File("customers.txt");
        try {
            // If file doesn't exist, create it
            if (!file.exists()) {
                file.createNewFile();
                System.out.println("File created: " + file.getName());
            }

            // Log where the file is being created
            System.out.println("File path: " + file.getAbsolutePath());

            // Write to the file
            try (PrintWriter writer = new PrintWriter(new FileWriter(file, true))) {
                writer.println("Name: " + c.getName());
                writer.println("Reg Date: " + c.getRegDate());
                writer.println("Address: " + c.getAddr());
                writer.println("City: " + c.getCity());
                writer.println("Pin: " + c.getPin());
                writer.println("Phone: " + c.getPhone());
                writer.println("Email: " + c.getEmail());
                writer.println("-------------------------------------------------");
                System.out.println("Customer details saved successfully.");
                return 1;  // Success
            } catch (IOException e) {
                System.out.println("Error while saving customer: " + e.getMessage());
                return 0;  // Failure
            }
        } catch (IOException e) {
            System.out.println("Error while creating the file: " + e.getMessage());
            return 0;  // Failure
        }
    }

    // Placeholder methods for other objects
    public int saveOrder(Order o) {
        System.out.println("Saved order");
        return 0;
    }

    public int saveDistribution(Date d) {
        System.out.println("Saved distribution");
        return 0;
    }

    public int saveDelivery(Delivery d) {
        System.out.println("Saved delivery");
        return 0;
    }

    public int saveInvoice(Invoice i) {
        System.out.println("Saved invoice");
        return 0;
    }
}
