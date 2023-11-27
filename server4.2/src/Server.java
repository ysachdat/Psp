// Server слушает UDP-пакеты на порту - принимает данные от клиента,
// выполняет вычисление функции для полученных значений x, y, z и отправляет результат обратно клиенту.
// Также сохраняет результаты в файл results.txt.

import java.net.*;
import java.io.*;
import java.util.Arrays;

public class Server {
    // Порт сервака
    public final static int DEFAULT_PORT = 8001;
    // Сообщение об неизвестной команде, если нажать не на ту клавишу :)
    public final byte[] UNKNOWN_CMD = { 'U', 'n', 'k', 'n', 'o', 'w', 'n', ' ', 'c', 'o', 'm', 'm', 'a', 'n', 'd' };

    // Запуска UDP-сервера
    public void runServer() throws IOException {
        DatagramSocket s = null;
        try {
            byte[] buf = new byte[512];
            s = new DatagramSocket(DEFAULT_PORT);
            System.out.println("Server: Started on " + s.getLocalAddress() + ":" + s.getLocalPort());

            while (true) {
                DatagramPacket recvPacket = new DatagramPacket(buf, buf.length);
                s.receive(recvPacket);
                String data = new String(recvPacket.getData(), 0, recvPacket.getLength());
                System.out.println("Server: Received data: " + data);

                // Разбор полученных данных как значений x, y и z
                String[] values = data.split(",");
                if (values.length != 3) {
                    // Неверные данные, отправка ответа о неизвестной команде
                    sendUnknownCommandResponse(s, recvPacket);
                    continue;
                }

                double x = Double.parseDouble(values[0]);
                double y = Double.parseDouble(values[1]);
                double z = Double.parseDouble(values[2]);

                // Вычисление функции и отправка результата клиенту
                double result = calculateFunction(x, y, z);
                String resultStr = Double.toString(result);
                byte[] resultBytes = resultStr.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(resultBytes, resultBytes.length,
                        recvPacket.getAddress(), recvPacket.getPort());
                s.send(sendPacket);

                // Сохранение результатов в файл
                saveResultToFile(x, y, z, result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (s != null) {
                s.close();
            }
        }
    }

    // Вычисление значения функции A
    private double calculateFunction(double x, double y, double z) {
        // Определение функции A = (2cos(x - Pi/6) / e^(0.5) + sin^2(y)) * ((1 + z^2) / (3 - z^5 / 5))
        double result = (2 * Math.cos(x - Math.PI / 6) / Math.pow(Math.E, 0.5) + Math.pow(Math.sin(y), 2))
                * ((1 + Math.pow(z, 2)) / (3 - Math.pow(z, 5) / 5));
        return result;
    }

    // Отправка ответа о неизвестной команде
    private void sendUnknownCommandResponse(DatagramSocket socket, DatagramPacket recvPacket) throws IOException {
        DatagramPacket sendPacket = new DatagramPacket(UNKNOWN_CMD, UNKNOWN_CMD.length,
                recvPacket.getAddress(), recvPacket.getPort());
        socket.send(sendPacket);
    }

    // Сохранение результатов в файл
    private void saveResultToFile(double x, double y, double z, double result) {
        try {
            File file = new File("results.txt");
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter writer = new FileWriter(file, true);
            writer.write("x=" + x + ", y=" + y + ", z=" + z + " => result=" + result + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Точка входа в прогу
    public static void main(String[] args) {
        try {
            Server udpSvr = new Server();
            udpSvr.runServer();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
