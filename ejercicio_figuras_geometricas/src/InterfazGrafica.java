import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazGrafica extends JFrame {
    private JTextField tfRadio, tfBaseRect, tfAlturaRect, tfLado, tfBaseTri, tfAlturaTri;
    private JTextArea taResultados;

    public InterfazGrafica() {
        setTitle("Figuras Geométricas");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(8, 2));

        // Círculo
        add(new JLabel("Radio del Círculo:"));
        tfRadio = new JTextField();
        add(tfRadio);

        // Rectángulo
        add(new JLabel("Base del Rectángulo:"));
        tfBaseRect = new JTextField();
        add(tfBaseRect);

        add(new JLabel("Altura del Rectángulo:"));
        tfAlturaRect = new JTextField();
        add(tfAlturaRect);

        // Cuadrado
        add(new JLabel("Lado del Cuadrado:"));
        tfLado = new JTextField();
        add(tfLado);

        // Triángulo Rectángulo
        add(new JLabel("Base del Triángulo:"));
        tfBaseTri = new JTextField();
        add(tfBaseTri);

        add(new JLabel("Altura del Triángulo:"));
        tfAlturaTri = new JTextField();
        add(tfAlturaTri);

        // Botón para calcular
        JButton btnCalcular = new JButton("Calcular");
        add(btnCalcular);

        // Área de resultados
        taResultados = new JTextArea();
        taResultados.setEditable(false);
        add(new JScrollPane(taResultados));

        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularResultados();
            }
        });
    }

    private void calcularResultados() {
        try {
            // Círculo
            double radio = Double.parseDouble(tfRadio.getText());
            Circulo circulo = new Circulo(radio);
            String resultadoCirculo = String.format("Círculo - Área: %.2f, Perímetro: %.2f%n",
                    circulo.getArea(), circulo.getPerimetro());

            // Rectángulo
            double baseRect = Double.parseDouble(tfBaseRect.getText());
            double alturaRect = Double.parseDouble(tfAlturaRect.getText());
            Rectangulo rectangulo = new Rectangulo(baseRect, alturaRect);
            String resultadoRectangulo = String.format("Rectángulo - Área: %.2f, Perímetro: %.2f%n",
                    rectangulo.getArea(), rectangulo.getPerimetro());

            // Cuadrado
            double lado = Double.parseDouble(tfLado.getText());
            Cuadrado cuadrado = new Cuadrado(lado);
            String resultadoCuadrado = String.format("Cuadrado - Área: %.2f, Perímetro: %.2f%n",
                    cuadrado.getArea(), cuadrado.getPerimetro());

            // Triángulo Rectángulo
            double baseTri = Double.parseDouble(tfBaseTri.getText());
            double alturaTri = Double.parseDouble(tfAlturaTri.getText());
            TrianguloRectangulo tri = new TrianguloRectangulo(baseTri, alturaTri);
            String resultadoTriangulo = String.format("Triángulo Rectángulo - Área: %.2f, Perímetro: %.2f, Hipotenusa: %.2f, Tipo: %s%n",
                    tri.getArea(), tri.getPerimetro(), tri.calcularHipotenusa(), tri.tipoDeTriangulo());

            taResultados.setText(resultadoCirculo + resultadoRectangulo + resultadoCuadrado + resultadoTriangulo);
        } catch (NumberFormatException ex) {
            taResultados.setText("Por favor, ingrese valores válidos.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new InterfazGrafica().setVisible(true);
            }
        });
    }
}

