package clases.empleado;

import javax.swing.JOptionPane;

public class EmpleadoEventual extends Empleado {
    private double honorariosPorHora;
    private String fechaTerminoContrato;

    @Override
    public void registrarDatos() {
        super.registrarDatos();
        boolean ok = false;
        do {
            try {
                String input = JOptionPane.showInputDialog("Ingrese los honorarios por hora (decimal)");
                if (input == null) { honorariosPorHora = 0.0; break; }
                honorariosPorHora = Double.parseDouble(input);
                ok = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Valor inválido. Intente de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } while (!ok);
        fechaTerminoContrato = JOptionPane.showInputDialog("Ingrese la fecha de término del contrato (dd/mm/yyyy)");
    }

    @Override
    public void imprimirDatosPersona(String datos) {
        String msj = datos
            + "\nHonorarios por hora: " + honorariosPorHora
            + "\nFecha término contrato: " + fechaTerminoContrato;
        super.imprimirDatosPersona(msj);
    }

    // getters y setters
    public double getHonorariosPorHora() { return honorariosPorHora; }
    public void setHonorariosPorHora(double honorariosPorHora) { this.honorariosPorHora = honorariosPorHora; }
    public String getFechaTerminoContrato() { return fechaTerminoContrato; }
    public void setFechaTerminoContrato(String fechaTerminoContrato) { this.fechaTerminoContrato = fechaTerminoContrato; }
}
