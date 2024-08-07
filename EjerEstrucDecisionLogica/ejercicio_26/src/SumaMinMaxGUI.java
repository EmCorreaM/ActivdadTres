import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SumaMinMaxGUI {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Suma del Menor y Mayor de Cuatro Datos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(null);

        JLabel lblDato1 = new JLabel("Dato 1:");
        lblDato1.setBounds(30, 30, 100, 25);
        frame.add(lblDato1);

        JTextField txtDato1 = new JTextField();
        txtDato1.setBounds(150, 30, 200, 25);
        frame.add(txtDato1);

        JLabel lblDato2 = new JLabel("Dato 2:");
        lblDato2.setBounds(30, 70, 100, 25);
        frame.add(lblDato2);

        JTextField txtDato2 = new JTextField();
        txtDato2.setBounds(150, 70, 200, 25);
        frame.add(txtDato2);

        JLabel lblDato3 = new JLabel("Dato 3:");
        lblDato3.setBounds(30, 110, 100, 25);
        frame.add(lblDato3);

        JTextField txtDato3 = new JTextField();
        txtDato3.setBounds(150, 110, 200, 25);
        frame.add(txtDato3);

        JLabel lblDato4 = new JLabel("Dato 4:");
        lblDato4.setBounds(30, 150, 100, 25);
        frame.add(lblDato4);

        JTextField txtDato4 = new JTextField();
        txtDato4.setBounds(150, 150, 200, 25);
        frame.add(txtDato4);

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
                    double dato1 = Double.parseDouble(txtDato1.getText());
                    double dato2 = Double.parseDouble(txtDato2.getText());
                    double dato3 = Double.parseDouble(txtDato3.getText());
                    double dato4 = Double.parseDouble(txtDato4.getText());

                    DatosMinMax datosMinMax = new DatosMinMax(dato1, dato2, dato3, dato4);
                    double sumaMinMax = datosMinMax.sumarMenorYMayor();

                    lblResultado.setText("Suma del menor y mayor: " + sumaMinMax);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Por favor, ingresa valores válidos.");
                }
            }
        });

        frame.setVisible(true);
    }
}

class DatosMinMax {
    private double dato1;
    private double dato2;
    private double dato3;
    private double dato4;

    public DatosMinMax(double dato1, double dato2, double dato3, double dato4) {
        this.dato1 = dato1;
        this.dato2 = dato2;
        this.dato3 = dato3;
        this.dato4 = dato4;
    }

    public double sumarMenorYMayor() {
        double menor = dato1;
        double mayor = dato1;

        if (dato2 < menor) menor = dato2;
        if (dato3 < menor) menor = dato3;
        if (dato4 < menor) menor = dato4;

        if (dato2 > mayor) mayor = dato2;
        if (dato3 > mayor) mayor = dato3;
        if (dato4 > mayor) mayor = dato4;

        return menor + mayor;
    }
}
