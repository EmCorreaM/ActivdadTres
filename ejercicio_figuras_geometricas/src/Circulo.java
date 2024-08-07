// Círculo
class Circulo {
    private double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    public double getArea() {
        return Math.PI * radio * radio;
    }

    public double getPerimetro() {
        return 2 * Math.PI * radio;
    }
}

// Rectángulo
class Rectangulo {
    private double base;
    private double altura;

    public Rectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    public double getArea() {
        return base * altura;
    }

    public double getPerimetro() {
        return 2 * (base + altura);
    }
}

// Cuadrado
class Cuadrado {
    private double lado;

    public Cuadrado(double lado) {
        this.lado = lado;
    }

    public double getArea() {
        return lado * lado;
    }

    public double getPerimetro() {
        return 4 * lado;
    }
}

// Triángulo Rectángulo
class TrianguloRectangulo {
    private double base;
    private double altura;

    public TrianguloRectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    public double getArea() {
        return 0.5 * base * altura;
    }

    public double getPerimetro() {
        double hipotenusa = calcularHipotenusa();
        return base + altura + hipotenusa;
    }

    public double calcularHipotenusa() {
        return Math.sqrt(base * base + altura * altura);
    }

    public String tipoDeTriangulo() {
        double hipotenusa = calcularHipotenusa();
        if (base == altura && base == hipotenusa) {
            return "Equilátero";
        } else if (base == altura || base == hipotenusa || altura == hipotenusa) {
            return "Isósceles";
        } else {
            return "Escaleno";
        }
    }
}
