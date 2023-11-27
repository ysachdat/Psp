import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            System.out.println("Подключение к серверу...");
            Socket clientSocket = new Socket("127.0.0.1", 2525);
            System.out.println("Соединение установлено.");

            BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
            ObjectOutputStream coos = new ObjectOutputStream(clientSocket.getOutputStream());
            ObjectInputStream cois = new ObjectInputStream(clientSocket.getInputStream());

            System.out.println("Введите зарплату сотрудника ('psp1Love:)' для выхода):");
            String input = stdin.readLine();

            while (!input.equalsIgnoreCase("psp1Love:)")) {
                double salary = Double.parseDouble(input);
                coos.writeDouble(salary);
                coos.flush();

                double tax = cois.readDouble();
                System.out.println("Налог на зарплату " + salary + " составляет: " + tax);

                System.out.println("Введите зарплату следующего сотрудника ('psp1Love:)' для выхода):");
                input = stdin.readLine();
            }

            coos.close();
            cois.close();
            clientSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
