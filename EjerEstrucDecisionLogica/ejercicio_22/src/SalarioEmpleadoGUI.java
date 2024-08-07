import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SalarioEmpleadoGUI {

    private static final double SALARIO_MINIMO = 450000.0;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculadora de Salario");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(null);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(30, 30, 100, 25);
        frame.add(lblNombre);

        JTextField txtNombre = new JTextField();
        txtNombre.setBounds(150, 30, 200, 25);
        frame.add(txtNombre);

        JLabel lblSalarioPorHora = new JLabel("Salario Básico por Hora:");
        lblSalarioPorHora.setBounds(30, 70, 200, 25);
        frame.add(lblSalarioPorHora);

        JTextField txtSalarioPorHora = new JTextField();
        txtSalarioPorHora.setBounds(150, 70, 200, 25);
        frame.add(txtSalarioPorHora);

        JLabel lblHorasTrabajadas = new JLabel("Horas Trabajadas:");
        lblHorasTrabajadas.setBounds(30, 110, 200, 25);
        frame.add(lblHorasTrabajadas);

        JTextField txtHorasTrabajadas = new JTextField();
        txtHorasTrabajadas.setBounds(150, 110, 200, 25);
        frame.add(txtHorasTrabajadas);

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
                    String nombre = txtNombre.getText();
                    double salarioPorHora = Double.parseDouble(txtSalarioPorHora.getText());
                    double horasTrabajadas = Double.parseDouble(txtHorasTrabajadas.getText());

                    Empleado empleado = new Empleado(nombre, salarioPorHora, horasTrabajadas);
                    double salarioMensual = empleado.calcularSalarioMensual();

                    if (salarioMensual > SALARIO_MINIMO) {
                        lblResultado.setText(String.format("Nombre: %s\nSalario Mensual: %.2f", nombre, salarioMensual));
                    } else {
                        lblResultado.setText(String.format("Nombre: %s", nombre));
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Por favor, ingresa valores válidos.");
                }
            }
        });

        frame.setVisible(true);
    }
}

class Empleado {
    private String nombre;
    private double salarioPorHora;
    private double horasTrabajadas;

    public Empleado(String nombre, double salarioPorHora, double horasTrabajadas) {
        this.nombre = nombre;
        this.salarioPorHora = salarioPorHora;
        this.horasTrabajadas = horasTrabajadas;
    }

    public double calcularSalarioMensual() {
        return salarioPorHora * horasTrabajadas;
    }
}
