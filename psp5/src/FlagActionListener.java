import javax.swing.*;
import java.awt.event.*;

public class FlagActionListener implements ActionListener {

    private int k;
    private JRadioButton flag1;
    private JRadioButton flag2;

    // Конструктор класса с передачей радиокнопок для управления
    public FlagActionListener(JRadioButton flag1, JRadioButton flag2) {
        this.flag1 = flag1;
        this.flag2 = flag2;
    }

    // Обработчик события
    public void actionPerformed(ActionEvent e) {
        k = 0;

        // Определение выбранной радиокнопки
        if (e.getSource() == flag1) {
            k++;
        } else if (e.getSource() == flag2) {
            k--;
        }

        // Вывод информации в консоль и диалоговое окно
        if (k == 1) {
            System.out.println("Выбрана опция 'да'");
            JOptionPane.showMessageDialog(null, "Выбрана опция 'да'");
        } else if (k == -1) {
            System.out.println("Выбрана опция 'нет'");
            JOptionPane.showMessageDialog(null, "Выбрана опция 'нет'");
        }
    }
}
