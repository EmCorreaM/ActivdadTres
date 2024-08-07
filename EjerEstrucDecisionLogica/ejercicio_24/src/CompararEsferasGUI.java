import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CompararEsferasGUI {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Comparador de Esferas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(null);

        JLabel lblPesoA = new JLabel("Peso Esfera A:");
        lblPesoA.setBounds(30, 30, 150, 25);
        frame.add(lblPesoA);

        JTextField txtPesoA = new JTextField();
        txtPesoA.setBounds(200, 30, 150, 25);
        frame.add(txtPesoA);

        JLabel lblPesoB = new JLabel("Peso Esfera B:");
        lblPesoB.setBounds(30, 70, 150, 25);
        frame.add(lblPesoB);

        JTextField txtPesoB = new JTextField();
        txtPesoB.setBounds(200, 70, 150, 25);
        frame.add(txtPesoB);

        JLabel lblPesoC = new JLabel("Peso Esfera C:");
        lblPesoC.setBounds(30, 110, 150, 25);
        frame.add(lblPesoC);

        JTextField txtPesoC = new JTextField();
        txtPesoC.setBounds(200, 110, 150, 25);
        frame.add(txtPesoC);

        JButton btnComparar = new JButton("Comparar");
        btnComparar.setBounds(30, 150, 120, 25);
        frame.add(btnComparar);

        JLabel lblResultado = new JLabel("Resultado:");
        lblResultado.setBounds(30, 190, 350, 25);
        frame.add(lblResultado);

        btnComparar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double pesoA = Double.parseDouble(txtPesoA.getText());
                    double pesoB = Double.parseDouble(txtPesoB.getText());
                    double pesoC = Double.parseDouble(txtPesoC.getText());

                    EsferaComparador comparador = new EsferaComparador(pesoA, pesoB, pesoC);
                    String resultado = comparador.esferaMayorPeso();

                    lblResultado.setText("Resultado: " + resultado);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Por favor, ingresa valores válidos.");
                }
            }
        });

        frame.setVisible(true);
    }
}

class EsferaComparador {
    private double pesoA;
    private double pesoB;
    private double pesoC;

    public EsferaComparador(double pesoA, double pesoB, double pesoC) {
        this.pesoA = pesoA;
        this.pesoB = pesoB;
        this.pesoC = pesoC;
    }

    public String esferaMayorPeso() {
        if (pesoA > pesoB && pesoA > pesoC) {
            return "La esfera A tiene el mayor peso.";
        } else if (pesoB > pesoA && pesoB > pesoC) {
            return "La esfera B tiene el mayor peso.";
        } else if (pesoC > pesoA && pesoC > pesoB) {
            return "La esfera C tiene el mayor peso.";
        } else {
            return "Hay esferas con el mismo peso máximo.";
        }
    }
}
