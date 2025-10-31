package clases;

import javax.swing.JOptionPane;

public class Persona {
    private String dni;
    private String nombre;
    private String apellido;
    private String fechaNacimiento;
    private String direccion;
    private String ciudadProcedencia;

    public void registrarDatos() {
        dni = JOptionPane.showInputDialog("Ingrese el número de documento (DNI)");
        nombre = JOptionPane.showInputDialog("Ingrese el nombre");
        apellido = JOptionPane.showInputDialog("Ingrese el apellido");
        fechaNacimiento = JOptionPane.showInputDialog("Ingrese la fecha de nacimiento (dd/mm/yyyy)");
        direccion = JOptionPane.showInputDialog("Ingrese la dirección");
        ciudadProcedencia = JOptionPane.showInputDialog("Ingrese la ciudad de procedencia");
    }

    public void imprimirDatosPersona(String datos) {
        String msj = datos 
            + "\nDNI: " + dni
            + "\nNombre: " + nombre + " " + apellido
            + "\nFecha Nac.: " + fechaNacimiento
            + "\nDirección: " + direccion
            + "\nCiudad: " + ciudadProcedencia;
        JOptionPane.showMessageDialog(null, msj, "Datos Persona", JOptionPane.INFORMATION_MESSAGE);
    }

    // Método por si alguna subclase necesita registrar cita; por defecto no hace nada.
    public void registrarCitaMedica() {
        // Implementado en Procesos / CitaMedica según necesidad
    }

    // getters y setters
    public String getDni() { 
        return dni; 
    }
    public void setDni(String dni) { 
        this.dni = dni; 
    }
    public String getNombre() { 
        return nombre; 
    }
    public void setNombre(String nombre) { 
        this.nombre = nombre; 
    }
    public String getApellido() {
         return apellido; 
        }
    public void setApellido(String apellido) { 
        this.apellido = apellido; 
    }
    public String getFechaNacimiento() { 
        return fechaNacimiento; 
    }
    public void setFechaNacimiento(String fechaNacimiento) { 
        this.fechaNacimiento = fechaNacimiento; 
    }
    public String getDireccion() { 
        return direccion; 
    }
    public void setDireccion(String direccion) { 
        this.direccion = direccion; 
    }
    public String getCiudadProcedencia() { 
        return ciudadProcedencia; 
    }
    public void setCiudadProcedencia(String ciudadProcedencia) { 
        this.ciudadProcedencia = ciudadProcedencia; 
    }
}
