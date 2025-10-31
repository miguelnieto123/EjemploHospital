package clases;
import clases.empleado.*;

public class CitaMedica {
    private Paciente paciente;
    private Medico medico;
    private String fecha;
    private String hora;
    private String servicio; // opcional

    public CitaMedica(Paciente paciente, Medico medico, String fecha, String hora, String servicio) {
        this.paciente = paciente;
        this.medico = medico;
        this.fecha = fecha;
        this.hora = hora;
        this.servicio = servicio;
    }

    public void imprimirInformacion() {
        StringBuilder sb = new StringBuilder();
        sb.append("CITA MEDICA")
          .append("\nPaciente: ").append(paciente.getNombre()).append(" ").append(paciente.getApellido())
          .append("\nDNI Paciente: ").append(paciente.getDni())
          .append("\nMedico: ").append(medico.getNombre()).append(" ").append(medico.getApellido())
          .append("\nDNI Medico: ").append(medico.getDni())
          .append("\nEspecialidad: ").append(medico.getEspecialidad())
          .append("\nConsultorio: ").append(medico.getNumeroDeConsultorio())
          .append("\nServicio: ").append(servicio)
          .append("\nFecha: ").append(fecha)
          .append("\nHora: ").append(hora);
        javax.swing.JOptionPane.showMessageDialog(null, sb.toString(), "Cita Medica", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }

    // getters
    public Paciente getPaciente() { return paciente; }
    public Medico getMedico() { return medico; }
    public String getFecha() { return fecha; }
    public String getHora() { return hora; }
    public String getServicio() { return servicio; }
}

