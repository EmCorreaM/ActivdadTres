import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrianguloEquilateroGUI {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculadora de Triángulo Equilátero");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(null);

        JLabel lblLado = new JLabel("Lado:");
        lblLado.setBounds(30, 30, 100, 25);
        frame.add(lblLado);

        JTextField txtLado = new JTextField();
        txtLado.setBounds(150, 30, 100, 25);
        frame.add(txtLado);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(30, 70, 100, 25);
        frame.add(btnCalcular);

        JLabel lblPerimetro = new JLabel("Perímetro:");
        lblPerimetro.setBounds(30, 110, 200, 25);
        frame.add(lblPerimetro);

        JLabel lblAltura = new JLabel("Altura:");
        lblAltura.setBounds(30, 150, 200, 25);
        frame.add(lblAltura);

        JLabel lblArea = new JLabel("Área:");
        lblArea.setBounds(30, 190, 200, 25);
        frame.add(lblArea);

        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double lado = Double.parseDouble(txtLado.getText());

                    TrianguloEquilatero triangulo = new TrianguloEquilatero(lado);

                    lblPerimetro.setText("Perímetro: " + triangulo.calcularPerimetro());
                    lblAltura.setText("Altura: " + triangulo.calcularAltura());
                    lblArea.setText("Área: " + triangulo.calcularArea());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Por favor, ingresa un número válido.");
                }
            }
        });

        frame.setVisible(true);
    }
}

class TrianguloEquilatero {
    private double lado;

    public TrianguloEquilatero(double lado) {
        this.lado = lado;
    }

    public double calcularPerimetro() {
        return 3 * lado;
    }

    public double calcularAltura() {
        return (Math.sqrt(3) / 2) * lado;
    }

    public double calcularArea() {
        return (Math.sqrt(3) / 4) * Math.pow(lado, 2);
    }
}
