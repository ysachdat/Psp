// Со стороны клиента отправляются значения x, y и z серверу через UDP-пакет, ожидает получения результата и выводит его.

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client {

    // Метод для выполнения  клиента
    public void runClient() throws IOException {
        DatagramSocket s = null;
        try {
            byte[] buf = new byte[512];
            s = new DatagramSocket();
            System.out.println("Client: Started");

            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите значения x, y, z через запятую: ");
            String input = scanner.nextLine();

            // Преобразование введенных данных в байты и отправка
            byte[] data = input.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(data, data.length,
                    InetAddress.getByName("127.0.0.1"), 8001);
            s.send(sendPacket);

            // Получение результатов
            DatagramPacket recvPacket = new DatagramPacket(buf, buf.length);
            s.receive(recvPacket);
            String result = new String(recvPacket.getData(), 0, recvPacket.getLength());
            System.out.println("Client: Результат: " + result);

        } finally {
            if (s != null) {
                s.close();
            }
        }
    }

    // Точка входа
    public static void main(String[] args) {
        try {
            Client client = new Client();
            client.runClient();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
