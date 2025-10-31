package clases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;
import clases.empleado.EmpleadoPlanilla;
import clases.empleado.*;


public class ModeloDatos {
    // Mapas por DNI
    private HashMap<String, Paciente> mapaPacientes;
    private HashMap<String, EmpleadoEventual> mapaEventuales;
    private HashMap<String, EmpleadoPlanilla> mapaPlanilla; // incluye medicos por herencia
    private HashMap<String, Medico> mapaMedicos; // mapa para facilitar busquedas por nombre/dni
    private List<CitaMedica> listaCitas;

    public ModeloDatos() {
        mapaPacientes = new HashMap<>();
        mapaEventuales = new HashMap<>();
        mapaPlanilla = new HashMap<>();
        mapaMedicos = new HashMap<>();
        listaCitas = new ArrayList<>();
    }

    // Registro con validacion de duplicados por DNI
    public boolean registrarPaciente(Paciente p) {
        if (p == null || p.getDni() == null) return false;
        if (mapaPacientes.containsKey(p.getDni())) {
            JOptionPane.showMessageDialog(null, "Paciente con DNI " + p.getDni() + " ya existe.", "Duplicado", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        mapaPacientes.put(p.getDni(), p);
        return true;
    }

    public boolean registrarEmpleadoEventual(EmpleadoEventual e) {
        if (e == null || e.getDni() == null) return false;
        if (mapaEventuales.containsKey(e.getDni()) || mapaPlanilla.containsKey(e.getDni()) || mapaMedicos.containsKey(e.getDni())) {
            JOptionPane.showMessageDialog(null, "Empleado con DNI " + e.getDni() + " ya existe.", "Duplicado", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        mapaEventuales.put(e.getDni(), e);
        return true;
    }

    public boolean registrarEmpleadoPlanilla(EmpleadoPlanilla e) {
        if (e == null || e.getDni() == null) return false;
        if (mapaPlanilla.containsKey(e.getDni()) || mapaEventuales.containsKey(e.getDni()) || mapaMedicos.containsKey(e.getDni()) ) {
            JOptionPane.showMessageDialog(null, "Empleado con DNI " + e.getDni() + " ya existe.", "Duplicado", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        mapaPlanilla.put(e.getDni(), e);
        return true;
    }

    public boolean registrarMedico(Medico m) {
        if (m == null || m.getDni() == null) return false;
        if (mapaMedicos.containsKey(m.getDni()) || mapaPlanilla.containsKey(m.getDni()) || mapaEventuales.containsKey(m.getDni())) {
            JOptionPane.showMessageDialog(null, "Médico con DNI " + m.getDni() + " ya existe.", "Duplicado", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        mapaMedicos.put(m.getDni(), m);
        // además guardarlo en planilla para cumplir la impresión de empleados por planilla
        mapaPlanilla.put(m.getDni(), m);
        return true;
    }

    public void registrarCitaMedica(CitaMedica c) {
        if (c != null) {
            listaCitas.add(c);
            JOptionPane.showMessageDialog(null, "Cita registrada correctamente.", "OK", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // Impresiones con validacion de existencia
    public void imprimirPacientes() {
        if (mapaPacientes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay pacientes registrados.", "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        for (Paciente p : mapaPacientes.values()) {
            p.imprimirDatosPersona("PACIENTE");
        }
    }

    public void imprimirEmpleadosEventuales() {
        if (mapaEventuales.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay empleados eventuales registrados.", "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        for (EmpleadoEventual e : mapaEventuales.values()) {
            e.imprimirDatosPersona("EMPLEADO EVENTUAL");
        }
    }

    public void imprimirEmpleadosPlanillaYNombresMedicos() {
        if (mapaPlanilla.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay empleados por planilla ni médicos registrados.", "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        // Recorremos planilla; si la entrada es instancia de Medico se marca
        for (EmpleadoPlanilla e : mapaPlanilla.values()) {
            if (e instanceof Medico) {
                ((Medico) e).imprimirDatosPersona("EMPLEADO POR PLANILLA (MEDICO)");
            } else {
                e.imprimirDatosPersona("EMPLEADO POR PLANILLA");
            }
        }
    }

    public void imprimirMedicos() {
        if (mapaMedicos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay medicos registrados.", "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        for (Medico m : mapaMedicos.values()) {
            m.imprimirDatosPersona("MEDICO");
        }
    }

    public void imprimirCitas() {
        if (listaCitas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay citas registradas.", "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        for (CitaMedica c : listaCitas) {
            c.imprimirInformacion();
        }
    }

    // Busquedas por DNI (retornan null si no existe)
    public Paciente buscarPacientePorDNI(String dni) {
        return mapaPacientes.get(dni);
    }
    public EmpleadoEventual buscarEventualPorDNI(String dni) { return mapaEventuales.get(dni); }
    public EmpleadoPlanilla buscarPlanillaPorDNI(String dni) { return mapaPlanilla.get(dni); }
    public Medico buscarMedicoPorDNI(String dni) { return mapaMedicos.get(dni); }

    // getters (si necesitas)
    public HashMap<String, Paciente> getMapaPacientes() { return mapaPacientes; }
    public HashMap<String, EmpleadoEventual> getMapaEventuales() { return mapaEventuales; }
    public HashMap<String, EmpleadoPlanilla> getMapaPlanilla() { return mapaPlanilla; }
    public HashMap<String, Medico> getMapaMedicos() { return mapaMedicos; }
    public List<CitaMedica> getListaCitas() { return listaCitas; }
}
