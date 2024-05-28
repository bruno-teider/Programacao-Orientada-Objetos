import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeitorBotoes implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e){
        JButton origem = (JButton) e.getSource();
        JOptionPane.showMessageDialog(origem, origem.getText() + " foi apertado");
    }
}
