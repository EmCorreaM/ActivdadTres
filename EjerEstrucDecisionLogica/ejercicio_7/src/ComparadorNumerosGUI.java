import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComparadorNumerosGUI {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Comparador de Números");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(null);

        JLabel lblNumeroA = new JLabel("Número A:");
        lblNumeroA.setBounds(30, 30, 100, 25);
        frame.add(lblNumeroA);

        JTextField txtNumeroA = new JTextField();
        txtNumeroA.setBounds(150, 30, 100, 25);
        frame.add(txtNumeroA);

        JLabel lblNumeroB = new JLabel("Número B:");
        lblNumeroB.setBounds(30, 70, 100, 25);
        frame.add(lblNumeroB);

        JTextField txtNumeroB = new JTextField();
        txtNumeroB.setBounds(150, 70, 100, 25);
        frame.add(txtNumeroB);

        JButton btnComparar = new JButton("Comparar");
        btnComparar.setBounds(30, 110, 120, 25);
        frame.add(btnComparar);

        JLabel lblResultado = new JLabel("Resultado:");
        lblResultado.setBounds(30, 150, 300, 25);
        frame.add(lblResultado);

        btnComparar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double numeroA = Double.parseDouble(txtNumeroA.getText());
                    double numeroB = Double.parseDouble(txtNumeroB.getText());

                    String resultado = compararNumeros(numeroA, numeroB);
                    lblResultado.setText("Resultado: " + resultado);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Por favor, ingresa números válidos.");
                }
            }
        });

        frame.setVisible(true);
    }

    public static String compararNumeros(double a, double b) {
        if (a > b) {
            return "A es mayor que B.";
        } else if (a < b) {
            return "A es menor que B.";
        } else {
            return "A es igual a B.";
        }
    }
}
