import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket clientAccepted = null;
        ObjectInputStream sois = null;
        ObjectOutputStream soos = null;

        try {
            System.out.println("Server starting...");
            serverSocket = new ServerSocket(2525);
            clientAccepted = serverSocket.accept();
            System.out.println("Connection established.");

            sois = new ObjectInputStream(clientAccepted.getInputStream());
            soos = new ObjectOutputStream(clientAccepted.getOutputStream());

            while (true) {
                double salary = sois.readDouble();
                double tax = calculateTax(salary);
                soos.writeDouble(tax);
                soos.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                sois.close();
                soos.close();
                clientAccepted.close();
                serverSocket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static double calculateTax(double salary) {
        if (salary < 100000) {
            return salary * 0.05;
        } else if (salary >= 100000 && salary <= 500000) {
            return salary * 0.10;
        } else {
            return salary * 0.15;
        }
    }
}
