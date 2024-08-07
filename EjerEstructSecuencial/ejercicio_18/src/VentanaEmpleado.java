import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaEmpleado extends JFrame {
    private JTextField tfCodigo;
    private JTextField tfNombres;
    private JTextField tfHorasTrabajadas;
    private JTextField tfValorHora;
    private JTextField tfPorcentajeRetencion;
    private JTextArea taResultados;

    public VentanaEmpleado() {
        setTitle("Información del Empleado");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lbCodigo = new JLabel("Código:");
        lbCodigo.setBounds(10, 10, 100, 25);
        add(lbCodigo);

        tfCodigo = new JTextField();
        tfCodigo.setBounds(120, 10, 250, 25);
        add(tfCodigo);

        JLabel lbNombres = new JLabel("Nombres:");
        lbNombres.setBounds(10, 40, 100, 25);
        add(lbNombres);

        tfNombres = new JTextField();
        tfNombres.setBounds(120, 40, 250, 25);
        add(tfNombres);

        JLabel lbHorasTrabajadas = new JLabel("Horas trabajadas:");
        lbHorasTrabajadas.setBounds(10, 70, 150, 25);
        add(lbHorasTrabajadas);

        tfHorasTrabajadas = new JTextField();
        tfHorasTrabajadas.setBounds(170, 70, 200, 25);
        add(tfHorasTrabajadas);

        JLabel lbValorHora = new JLabel("Valor hora:");
        lbValorHora.setBounds(10, 100, 100, 25);
        add(lbValorHora);

        tfValorHora = new JTextField();
        tfValorHora.setBounds(120, 100, 250, 25);
        add(tfValorHora);

        JLabel lbPorcentajeRetencion = new JLabel("Porcentaje retención:");
        lbPorcentajeRetencion.setBounds(10, 130, 150, 25);
        add(lbPorcentajeRetencion);

        tfPorcentajeRetencion = new JTextField();
        tfPorcentajeRetencion.setBounds(170, 130, 200, 25);
        add(tfPorcentajeRetencion);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(10, 160, 150, 30);
        add(btnCalcular);

        taResultados = new JTextArea();
        taResultados.setBounds(10, 200, 360, 50);
        taResultados.setEditable(false);
        add(taResultados);

        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcular();
            }
        });
    }

    private void calcular() {
        String codigo = tfCodigo.getText();
        String nombres = tfNombres.getText();
        int horasTrabajadas = Integer.parseInt(tfHorasTrabajadas.getText());
        double valorHora = Double.parseDouble(tfValorHora.getText());
        double porcentajeRetencion = Double.parseDouble(tfPorcentajeRetencion.getText());

        Empleado empleado = new Empleado(codigo, nombres, horasTrabajadas, valorHora, porcentajeRetencion);

        double salarioBruto = empleado.calcularSalarioBruto();
        double salarioNeto = empleado.calcularSalarioNeto();

        taResultados.setText(String.format(
                "Código: %s\nNombres: %s\nSalario Bruto: %.2f\nSalario Neto: %.2f",
                empleado.getCodigo(),
                empleado.getNombres(),
                salarioBruto,
                salarioNeto
        ));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaEmpleado ventana = new VentanaEmpleado();
            ventana.setVisible(true);
        });
    }
}
