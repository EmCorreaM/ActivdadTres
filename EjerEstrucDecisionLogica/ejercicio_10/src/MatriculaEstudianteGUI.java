import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MatriculaEstudianteGUI {

    private static final double VALOR_CONSTANTE = 50000.0;
    private static final double PORCENTAJE_INCREMENTO = 0.03;
    private static final double PATRIMONIO_LIMITE = 2000000.0;
    private static final int ESTRATO_LIMITE = 3;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculadora de Pago de Matrícula");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 350);
        frame.setLayout(null);

        JLabel lblNumeroInscripcion = new JLabel("Número de Inscripción:");
        lblNumeroInscripcion.setBounds(30, 30, 150, 25);
        frame.add(lblNumeroInscripcion);

        JTextField txtNumeroInscripcion = new JTextField();
        txtNumeroInscripcion.setBounds(200, 30, 150, 25);
        frame.add(txtNumeroInscripcion);

        JLabel lblNombres = new JLabel("Nombres:");
        lblNombres.setBounds(30, 70, 150, 25);
        frame.add(lblNombres);

        JTextField txtNombres = new JTextField();
        txtNombres.setBounds(200, 70, 150, 25);
        frame.add(txtNombres);

        JLabel lblPatrimonio = new JLabel("Patrimonio:");
        lblPatrimonio.setBounds(30, 110, 150, 25);
        frame.add(lblPatrimonio);

        JTextField txtPatrimonio = new JTextField();
        txtPatrimonio.setBounds(200, 110, 150, 25);
        frame.add(txtPatrimonio);

        JLabel lblEstrato = new JLabel("Estrato Social:");
        lblEstrato.setBounds(30, 150, 150, 25);
        frame.add(lblEstrato);

        JTextField txtEstrato = new JTextField();
        txtEstrato.setBounds(200, 150, 150, 25);
        frame.add(txtEstrato);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(30, 190, 120, 25);
        frame.add(btnCalcular);

        JLabel lblResultado = new JLabel("Resultado:");
        lblResultado.setBounds(30, 230, 350, 25);
        frame.add(lblResultado);

        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String numeroInscripcion = txtNumeroInscripcion.getText();
                    String nombres = txtNombres.getText();
                    double patrimonio = Double.parseDouble(txtPatrimonio.getText());
                    int estrato = Integer.parseInt(txtEstrato.getText());

                    double pagoMatricula = calcularPagoMatricula(patrimonio, estrato);

                    lblResultado.setText(String.format(
                            "Número de Inscripción: %s\nNombres: %s\nPago de Matrícula: %.2f",
                            numeroInscripcion, nombres, pagoMatricula));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Por favor, ingresa valores válidos.");
                }
            }
        });

        frame.setVisible(true);
    }

    public static double calcularPagoMatricula(double patrimonio, int estrato) {
        double pago = VALOR_CONSTANTE;
        if (patrimonio > PATRIMONIO_LIMITE && estrato > ESTRATO_LIMITE) {
            double incremento = patrimonio * PORCENTAJE_INCREMENTO;
            pago += incremento;
        }
        return pago;
    }
}
