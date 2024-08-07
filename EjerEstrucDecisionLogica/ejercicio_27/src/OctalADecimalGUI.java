import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OctalADecimalGUI {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Conversión Octal a Decimal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 250);
        frame.setLayout(null);

        JLabel lblOctal = new JLabel("Número Octal (5 dígitos):");
        lblOctal.setBounds(30, 30, 150, 25);
        frame.add(lblOctal);

        JTextField txtOctal = new JTextField();
        txtOctal.setBounds(200, 30, 150, 25);
        frame.add(txtOctal);

        JButton btnConvertir = new JButton("Convertir");
        btnConvertir.setBounds(30, 70, 120, 25);
        frame.add(btnConvertir);

        JLabel lblResultado = new JLabel("Resultado:");
        lblResultado.setBounds(30, 110, 350, 25);
        frame.add(lblResultado);

        btnConvertir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String octalStr = txtOctal.getText();

                    if (octalStr.length() != 5) {
                        JOptionPane.showMessageDialog(frame, "Por favor, ingresa un número octal de 5 dígitos.");
                        return;
                    }

                    for (char c : octalStr.toCharArray()) {
                        if (c < '0' || c > '7') {
                            JOptionPane.showMessageDialog(frame, "El número debe estar compuesto únicamente por dígitos octales (0-7).");
                            return;
                        }
                    }

                    OctalConverter converter = new OctalConverter(octalStr);
                    int decimalValue = converter.convertirADecimal();

                    lblResultado.setText("Valor Decimal: " + decimalValue);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Por favor, ingresa un valor válido.");
                }
            }
        });

        frame.setVisible(true);
    }
}

class OctalConverter {
    private String octal;

    public OctalConverter(String octal) {
        this.octal = octal;
    }

    public int convertirADecimal() {
        int decimal = 0;
        int base = 1; // 8^0

        for (int i = octal.length() - 1; i >= 0; i--) {
            char digitChar = octal.charAt(i);
            int digit = Character.getNumericValue(digitChar);
            decimal += digit * base;
            base *= 8; // Increment base to the next power of 8
        }

        return decimal;
    }
}
