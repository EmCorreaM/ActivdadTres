public class Empleado {
    private String codigo;
    private String nombres;
    private int horasTrabajadas;
    private double valorHora;
    private double porcentajeRetencion;

    public Empleado(String codigo, String nombres, int horasTrabajadas, double valorHora, double porcentajeRetencion) {
        this.codigo = codigo;
        this.nombres = nombres;
        this.horasTrabajadas = horasTrabajadas;
        this.valorHora = valorHora;
        this.porcentajeRetencion = porcentajeRetencion;
    }

    public double calcularSalarioBruto() {
        return horasTrabajadas * valorHora;
    }

    public double calcularSalarioNeto() {
        double salarioBruto = calcularSalarioBruto();
        double retencion = salarioBruto * (porcentajeRetencion / 100);
        return salarioBruto - retencion;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombres() {
        return nombres;
    }
}
