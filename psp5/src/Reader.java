import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Reader extends JFrame {
    // Переменные управления
    static int k;
    static JButton b, del;
    static JTextField text;
    static JTextArea area;
    static JComboBox box_1, box_2, box_3;
    static JRadioButton flag1, flag2;
    static ButtonGroup bg;
    static String[] box1 = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
    static String[] box2 = {"январь", "февраль", "март", "апрель", "май", "июнь", "июль", "август", "сентябрь", "октябрь", "ноябрь", "декабрь"};
    static String[] box3 = {"2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020"};
    static Object boxA, boxB, boxC;


    // Инициализация интерфейса
    public Reader(String str) {
        super(str);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // компоненты  интерфейса
        b = new JButton("Внесение в базу");
        del = new JButton("Очистить");
        text = new JTextField(9);
        area = new JTextArea(9, 9);
        JLabel l1 = new JLabel("Название медикамента");
        JLabel l2 = new JLabel("Описание лекарственных свойств");
        JLabel l3 = new JLabel("Дата поступления");
        JLabel l4 = new JLabel("Нужен рецепт");
        box_1 = new JComboBox(box1);
        box_2 = new JComboBox(box2);
        box_3 = new JComboBox<Object>(box3);
        flag1 = new JRadioButton("No");
        flag2 = new JRadioButton("Da");
        bg = new ButtonGroup();

        bg.add(flag1);
        bg.add(flag2);

        setLayout(null);
    // :) элементы в форме
        b.setSize(200, 30);
        b.setLocation(150, 400);

        del.setSize(100, 30);
        del.setLocation(10, 400);

        text.setSize(220, 25);
        text.setLocation(250, 20);

        area.setSize(220, 150);
        area.setLocation(250, 60);

        l1.setSize(200, 25);
        l1.setLocation(30, 20);

        l2.setSize(220, 25);
        l2.setLocation(30, 60);

        l3.setSize(200, 25);
        l3.setLocation(30, 250);

        l4.setSize(200, 25);
        l4.setLocation(30, 310);

        box_1.setSize(40, 25);
        box_1.setLocation(250, 250);

        box_2.setSize(100, 25);
        box_2.setLocation(300, 250);

        box_3.setSize(70, 25);
        box_3.setLocation(410, 250);

        flag1.setSize(40, 25);
        flag1.setLocation(250, 310);

        flag2.setSize(50, 25);
        flag2.setLocation(300, 310);

        add(b);
        add(del);
        add(text);
        add(area);
        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(box_1);
        add(box_2);
        add(box_3);
        add(flag1);
        add(flag2);
// обработка сценариев
        b.addActionListener(new ButtonActionListener());
        flag1.addActionListener(new FlagActionListener());
        flag2.addActionListener(new FlagActionListener());
        del.addActionListener(new DelActionListener());
        box_1.addActionListener(new BoxActionListener());
        box_2.addActionListener(new BoxActionListener());
        box_3.addActionListener(new BoxActionListener());
    }
    // Вложенный класс для обработки внесения в базу
    public static class ButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                // Проверка выбора даты поступления
                if (boxA == null || boxB == null || boxC == null) {
                    JOptionPane.showMessageDialog(null, "Выберите дату поступления");
                    return;
                }

                if (!medicineList.isVisible()) {
                    medicineList.setVisible(true);
                }
                        // Формирование информации о медикаменте
                String medicineInfo = text.getText() + " - " + area.getText();
                if (k == 1) {
                    medicineInfo += "Отпуск медикамента осуществляется без рецепта. \n";
                } else if (k == -1) {
                    medicineInfo += "Отпуск медикамента осуществляется при наличии рецепта. \n";
                }
                medicineInfo += " (Дата поступления:" + boxA + " " + boxB + " " + boxC + ")";
                        // Обнова списка
                medicineList.updateMedicineList(medicineInfo);
// Запись в файл! Этой темы в задании не было, но без нее лаба
                // выглядит фигово, поэтому сюда это внедрил
                FileWriter out = new FileWriter(System.getProperty("user.home") + "/Desktop/GUI.txt", true);
                try {
                    out.write(medicineInfo + "\n");
                } finally {
                    out.close();
                }
            } catch (IOException e1) {
                throw new RuntimeException(e1);
            }
        }
    }

    public static class FlagActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            k = 0;
            if (e.getSource() == flag1) {
                k++;
            } else if (e.getSource() == flag2) {
                k--;
            }
        }
    }

    public static class DelActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == del) {
                text.setText(null);
                area.setText(null);
            }
        }
    }

    public static class BoxActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == box_1) {
                boxA = box_1.getSelectedItem();
            }
            if (e.getSource() == box_2) {
                boxB = box_2.getSelectedItem();
            }
            if (e.getSource() == box_3) {
                boxC = box_3.getSelectedItem();
            }
        }
    }

    public static class MedicineList extends JFrame {
        private JTextArea medicineTextArea;

        public MedicineList() {
            setSize(300, 300);
            setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            setLayout(new BorderLayout());

            medicineTextArea = new JTextArea();
            medicineTextArea.setEditable(false);

            JScrollPane scrollPane = new JScrollPane(medicineTextArea);
            add(scrollPane, BorderLayout.CENTER);
        }

        public void updateMedicineList(String medicineInfo) {
            medicineTextArea.append(medicineInfo + "\n");
        }
    }

    private static MedicineList medicineList = new MedicineList();

    public static void main(String[] args) {
        Reader med = new Reader("Регистрация медикаментов");
        med.setVisible(true);
        med.setResizable(false);
        med.setLocationRelativeTo(null);
    }
}
