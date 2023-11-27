import javax.swing.*;
import java.awt.event.*;

public class MedicineList extends JFrame {

    private JTextArea medicineListArea;

    public MedicineList() {
        super("Список медикаментов");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        medicineListArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(medicineListArea);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        JButton deleteButton = new JButton("Удалить выбранный медикамент");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteSelectedMedicine();
            }
        });

        JPanel panel = new JPanel();
        panel.add(scrollPane);
        panel.add(deleteButton);

        add(panel);
    }

    // Обновления списка
    public void updateMedicineList(String medicine) {
        medicineListArea.append(medicine + "\n");
    }

    // Метод удаления
    private void deleteSelectedMedicine() {
        int start = medicineListArea.getSelectionStart();
        int end = medicineListArea.getSelectionEnd();

        if (start != end) {
            try {

                medicineListArea.getDocument().remove(start, end - start);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
