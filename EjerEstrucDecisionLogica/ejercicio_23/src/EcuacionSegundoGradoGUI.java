import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EcuacionSegundoGradoGUI {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Resolución de Ecuación de Segundo Grado");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(null);

        JLabel lblA = new JLabel("Valor de A:");
        lblA.setBounds(30, 30, 100, 25);
        frame.add(lblA);

        JTextField txtA = new JTextField();
        txtA.setBounds(150, 30, 200, 25);
        frame.add(txtA);

        JLabel lblB = new JLabel("Valor de B:");
        lblB.setBounds(30, 70, 100, 25);
        frame.add(lblB);

        JTextField txtB = new JTextField();
        txtB.setBounds(150, 70, 200, 25);
        frame.add(txtB);

        JLabel lblC = new JLabel("Valor de C:");
        lblC.setBounds(30, 110, 100, 25);
        frame.add(lblC);

        JTextField txtC = new JTextField();
        txtC.setBounds(150, 110, 200, 25);
        frame.add(txtC);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(30, 150, 120, 25);
        frame.add(btnCalcular);

        JLabel lblResultado = new JLabel("Resultado:");
        lblResultado.setBounds(30, 190, 350, 25);
        frame.add(lblResultado);

        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double a = Double.parseDouble(txtA.getText());
                    double b = Double.parseDouble(txtB.getText());
                    double c = Double.parseDouble(txtC.getText());

                    EcuacionSegundoGrado ecuacion = new EcuacionSegundoGrado(a, b, c);
                    String resultado = ecuacion.obtenerSoluciones();

                    lblResultado.setText("Resultado: " + resultado);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Por favor, ingresa valores válidos.");
                }
            }
        });

        frame.setVisible(true);
    }
}

class EcuacionSegundoGrado {
    private double a;
    private double b;
    private double c;

    public EcuacionSegundoGrado(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public String obtenerSoluciones() {
        double discriminante = b * b - 4 * a * c;
        if (a == 0) {
            return "No es una ecuación de segundo grado.";
        } else if (discriminante > 0) {
            double x1 = (-b + Math.sqrt(discriminante)) / (2 * a);
            double x2 = (-b - Math.sqrt(discriminante)) / (2 * a);
            return String.format("Soluciones: x1 = %.2f, x2 = %.2f", x1, x2);
        } else if (discriminante == 0) {
            double x = -b / (2 * a);
            return String.format("Solución única: x = %.2f", x);
        } else {
            return "No tiene soluciones reales.";
        }
    }
}
