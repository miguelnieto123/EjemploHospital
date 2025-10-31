package clases.empleado;

import javax.swing.JOptionPane;

public class Medico extends EmpleadoPlanilla {
    private String especialidad;
    private int numeroDeConsultorio;

    @Override
    public void registrarDatos() {
        super.registrarDatos();
        especialidad = JOptionPane.showInputDialog("Ingrese la especialidad");
        boolean ok = false;
        do {
            try {
                String input = JOptionPane.showInputDialog("Ingrese el número de consultorio (entero)");
                if (input == null) { numeroDeConsultorio = 0; break; }
                numeroDeConsultorio = Integer.parseInt(input);
                ok = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Número inválido. Intente de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } while (!ok);
    }

    @Override
    public void imprimirDatosPersona(String datos) {
        String msj = datos
            + "\nESPECIALIDAD: " + especialidad
            + "\nNumero de Consultorio: " + numeroDeConsultorio;
        super.imprimirDatosPersona("MEDICO\n" + msj);
    }

    // getters y setters
    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }
    public int getNumeroDeConsultorio() { return numeroDeConsultorio; }
    public void setNumeroDeConsultorio(int numeroDeConsultorio) { this.numeroDeConsultorio = numeroDeConsultorio; }
}
