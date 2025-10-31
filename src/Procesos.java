package src;


import clases.*;
import clases.empleado.*;
import javax.swing.JOptionPane;

public class Procesos {
    private ModeloDatos miModelo;

    public Procesos() {
        miModelo = new ModeloDatos();
        menuPrincipal();
    }

    private void menuPrincipal() {
        String[] opciones = {
            "Registrar Paciente", "Registrar Empleado Eventual", "Registrar Empleado Planilla",
            "Registrar Médico", "Registrar Cita Médica",
            "Imprimir Pacientes", "Imprimir Empleados Eventuales", "Imprimir Empleados por Planilla (incluye médicos)",
            "Imprimir Médicos", "Imprimir Citas",
            "Buscar por DNI", "Salir"
        };

        while (true) {
            String seleccion = (String) JOptionPane.showInputDialog(null, "Seleccione una opción", "Menú", JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);
            if (seleccion == null || seleccion.equals("Salir")) break;

            switch (seleccion) {
                case "Registrar Paciente":
                    registrarPaciente();
                    break;
                case "Registrar Empleado Eventual":
                    registrarEmpleadoEventual();
                    break;
                case "Registrar Empleado Planilla":
                    registrarEmpleadoPlanilla();
                    break;
                case "Registrar Médico":
                    registrarMedico();
                    break;
                case "Registrar Cita Médica":
                    registrarCita();
                    break;
                case "Imprimir Pacientes":
                    miModelo.imprimirPacientes();
                    break;
                case "Imprimir Empleados Eventuales":
                    miModelo.imprimirEmpleadosEventuales();
                    break;
                case "Imprimir Empleados por Planilla (incluye médicos)":
                    miModelo.imprimirEmpleadosPlanillaYNombresMedicos();
                    break;
                case "Imprimir Médicos":
                    miModelo.imprimirMedicos();
                    break;
                case "Imprimir Citas":
                    miModelo.imprimirCitas();
                    break;
                case "Buscar por DNI":
                    buscarPorDNI();
                    break;
            }
        }
    }

    private void registrarPaciente() {
        Paciente p = new Paciente();
        p.registrarDatos();
        if (miModelo.registrarPaciente(p)) {
            JOptionPane.showMessageDialog(null, "Paciente registrado con éxito.");
        }
    }

    private void registrarEmpleadoEventual() {
        EmpleadoEventual e = new EmpleadoEventual();
        e.registrarDatos();
        if (miModelo.registrarEmpleadoEventual(e)) {
            JOptionPane.showMessageDialog(null, "Empleado eventual registrado con éxito.");
        }
    }

    private void registrarEmpleadoPlanilla() {
        EmpleadoPlanilla e = new EmpleadoPlanilla();
        e.registrarDatos();
        if (miModelo.registrarEmpleadoPlanilla(e)) {
            JOptionPane.showMessageDialog(null, "Empleado por planilla registrado con éxito.");
        }
    }

    private void registrarMedico() {
        Medico m = new Medico();
        m.registrarDatos();
        if (miModelo.registrarMedico(m)) {
            JOptionPane.showMessageDialog(null, "Médico registrado con éxito.");
        }
    }

    private void registrarCita() {
        String dniPaciente = JOptionPane.showInputDialog("Ingrese el DNI del paciente para la cita");
        if (dniPaciente == null || dniPaciente.trim().isEmpty()) return;
        Paciente p = miModelo.buscarPacientePorDNI(dniPaciente);
        if (p == null) {
            JOptionPane.showMessageDialog(null, "Paciente no encontrado. Registre al paciente primero.", "No existe", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String nombreMedico = JOptionPane.showInputDialog("Ingrese el DNI del médico (recomendado) o nombre del médico");
        if (nombreMedico == null || nombreMedico.trim().isEmpty()) return;
        // intentamos buscar por DNI primero
        Medico m = miModelo.buscarMedicoPorDNI(nombreMedico);
        if (m == null) {
            // buscar por nombre (simple scan)
            for (Medico med : miModelo.getMapaMedicos().values()) {
                String fullName = med.getNombre() + " " + med.getApellido();
                if (fullName.equalsIgnoreCase(nombreMedico) || med.getNombre().equalsIgnoreCase(nombreMedico)) {
                    m = med;
                    break;
                }
            }
        }
        if (m == null) {
            JOptionPane.showMessageDialog(null, "Médico no encontrado.", "No existe", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String fecha = JOptionPane.showInputDialog("Ingrese la fecha de la cita (dd/mm/yyyy)");
        String hora = JOptionPane.showInputDialog("Ingrese la hora de la cita (hh:mm)");
        String servicio = JOptionPane.showInputDialog("Ingrese el servicio (opcional)");

        CitaMedica cita = new CitaMedica(p, m, fecha, hora, servicio);
        miModelo.registrarCitaMedica(cita);
    }

    private void buscarPorDNI() {
        String dni = JOptionPane.showInputDialog("Ingrese el DNI a buscar");
        if (dni == null || dni.trim().isEmpty()) return;

        Paciente p = miModelo.buscarPacientePorDNI(dni);
        if (p != null) {
            p.imprimirDatosPersona("PACIENTE ENCONTRADO");
            return;
        }
        EmpleadoEventual ev = miModelo.buscarEventualPorDNI(dni);
        if (ev != null) {
            ev.imprimirDatosPersona("EMPLEADO EVENTUAL ENCONTRADO");
            return;
        }
        EmpleadoPlanilla ep = miModelo.buscarPlanillaPorDNI(dni);
        if (ep != null) {
            if (ep instanceof Medico) {
                ((Medico) ep).imprimirDatosPersona("MEDICO ENCONTRADO");
            } else {
                ep.imprimirDatosPersona("EMPLEADO POR PLANILLA ENCONTRADO");
            }
            return;
        }
        JOptionPane.showMessageDialog(null, "No se encontró ninguna persona con DNI: " + dni, "No encontrado", JOptionPane.INFORMATION_MESSAGE);
    }
}
