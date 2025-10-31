package clases.empleado;

import javax.swing.JOptionPane;

import clases.Persona;

public class Empleado extends Persona {
    private String codigoEmpleado;
    private int numeroHorasExtras;
    private String fechaIngreso;
    private String area;
    private String cargo;

    @Override
    public void registrarDatos() {
        super.registrarDatos();
        codigoEmpleado = JOptionPane.showInputDialog("Ingrese el código del empleado");
        boolean ok = false;
        do {
            try {
                String input = JOptionPane.showInputDialog("Ingrese el número de horas extras (entero)");
                if (input == null) { numeroHorasExtras = 0; break; }
                numeroHorasExtras = Integer.parseInt(input);
                ok = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Número inválido. Intente de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } while (!ok);
        fechaIngreso = JOptionPane.showInputDialog("Ingrese la fecha de ingreso (dd/mm/yyyy)");
        area = JOptionPane.showInputDialog("Ingrese el área");
        cargo = JOptionPane.showInputDialog("Ingrese el cargo");
    }

    @Override
    public void imprimirDatosPersona(String datos) {
        String msj = datos
            + "\nCodigo Empleado: " + codigoEmpleado
            + "\nHoras Extras: " + numeroHorasExtras
            + "\nFecha Ingreso: " + fechaIngreso
            + "\nArea: " + area
            + "\nCargo: " + cargo;
        super.imprimirDatosPersona(msj);
    }

    // getters y setters
    public String getCodigoEmpleado() { return codigoEmpleado; }
    public void setCodigoEmpleado(String codigoEmpleado) { this.codigoEmpleado = codigoEmpleado; }
    public int getNumeroHorasExtras() { return numeroHorasExtras; }
    public void setNumeroHorasExtras(int numeroHorasExtras) { this.numeroHorasExtras = numeroHorasExtras; }
    public String getFechaIngreso() { return fechaIngreso; }
    public void setFechaIngreso(String fechaIngreso) { this.fechaIngreso = fechaIngreso; }
    public String getArea() { return area; }
    public void setArea(String area) { this.area = area; }
    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }
}
