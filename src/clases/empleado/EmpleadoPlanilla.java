package clases.empleado;

import javax.swing.JOptionPane;

public class EmpleadoPlanilla extends Empleado {
    private double salarioMensual;
    private double porcentajeAdicionalPorHoraExtra;

    @Override
    public void registrarDatos() {
        super.registrarDatos();
        boolean ok = false;
        do {
            try {
                String input = JOptionPane.showInputDialog("Ingrese el salario mensual (decimal)");
                if (input == null) { salarioMensual = 0.0; break; }
                salarioMensual = Double.parseDouble(input);
                ok = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Valor inválido. Intente de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } while (!ok);

        ok = false;
        do {
            try {
                String input = JOptionPane.showInputDialog("Ingrese el porcentaje adicional por hora extra (por ejemplo 10 para 10%)");
                if (input == null) { porcentajeAdicionalPorHoraExtra = 0.0; break; }
                porcentajeAdicionalPorHoraExtra = Double.parseDouble(input);
                ok = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Valor inválido. Intente de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } while (!ok);
    }

    @Override
    public void imprimirDatosPersona(String datos) {
        String msj = datos
            + "\nSalario Mensual: " + salarioMensual
            + "\n% Adicional por Hora Extra: " + porcentajeAdicionalPorHoraExtra;
        super.imprimirDatosPersona(msj);
    }

    // getters y setters
    public double getSalarioMensual() { return salarioMensual; }
    public void setSalarioMensual(double salarioMensual) { this.salarioMensual = salarioMensual; }
    public double getPorcentajeAdicionalPorHoraExtra() { return porcentajeAdicionalPorHoraExtra; }
    public void setPorcentajeAdicionalPorHoraExtra(double porcentaje) { this.porcentajeAdicionalPorHoraExtra = porcentaje; }
}
