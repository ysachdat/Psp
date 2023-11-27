import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DelActionListener implements ActionListener {

    private JButton del;
    private JTextField text;
    private JTextArea area;

    public DelActionListener(JButton del, JTextField text, JTextArea area) {
        this.del = del;
        this.text = text;
        this.area = area;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == del) {
            // Очищаем текстовое поле и текстовую область
            text.setText(null);
            area.setText(null);


        }
    }
}
