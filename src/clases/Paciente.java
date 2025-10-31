package clases;

import java.util.ArrayList;
import javax.swing.JOptionPane;



public class Paciente extends Persona {
    private int numeroHistoriaClinica;
    private String sexo;
    private String grupoSanguineo;
    private ArrayList<String> listaMedicamentosAlergico;

    @Override
    @SuppressWarnings("Convert2Diamond")
    public void registrarDatos() {
        super.registrarDatos();
        listaMedicamentosAlergico = new ArrayList<String>();

        boolean ok = false;
       // 4: Excepciones para datos numéricos inválidos
       do {
           try {
              numeroHistoriaClinica = Integer.parseInt(
                  JOptionPane.showInputDialog("Ingrese número de historia clínica")
            );
               ok = true;
            } catch (NumberFormatException e) {
                   JOptionPane.showMessageDialog(null, "Ingrese un número válido", "Error", JOptionPane.ERROR_MESSAGE);
            }
            } while (!ok);
            // El punto 4 seria este ya que aqui se generan las excepciones para todos los datos numericos  que sean invalidos 


        sexo = JOptionPane.showInputDialog("Ingrese el sexo");
        grupoSanguineo = JOptionPane.showInputDialog("Ingrese el grupo sanguíneo");

        String pregunta = JOptionPane.showInputDialog("¿Es alérgico a algún medicamento? Ingrese 'si' o 'no'");
        if (pregunta != null && pregunta.equalsIgnoreCase("si")) {
            String medicamento;
            String continuar;
            do {
                medicamento = JOptionPane.showInputDialog("Ingrese el nombre del medicamento al que es alérgico");
                if (medicamento != null && !medicamento.trim().isEmpty()) {
                    listaMedicamentosAlergico.add(medicamento.trim());
                }
                continuar = JOptionPane.showInputDialog("¿Desea ingresar otro medicamento? Ingrese 'si' o 'no'");
            } while (continuar != null && continuar.equalsIgnoreCase("si"));
        }
    }

    @Override
    public void imprimirDatosPersona(String datos) {
        StringBuilder sb = new StringBuilder();
        sb.append(datos)
          .append("\nHistoria Clinica: ").append(numeroHistoriaClinica)
          .append("\nSexo: ").append(sexo)
          .append("\nGrupo Sanguineo: ").append(grupoSanguineo)
          .append("\nMedicamentos alergicos:");
        if (listaMedicamentosAlergico == null || listaMedicamentosAlergico.isEmpty()) {
            sb.append(" Ninguno");
        } else {
            for (String m : listaMedicamentosAlergico) {
                sb.append("\n - ").append(m);
            }
        }
        super.imprimirDatosPersona(sb.toString());
    }

    // getters y setters
    public int getNumeroHistoriaClinica() { 
        return numeroHistoriaClinica; 
    }
    public void setNumeroHistoriaClinica(int numeroHistoriaClinica) { 
        this.numeroHistoriaClinica = numeroHistoriaClinica; 
    }
    public String getSexo() { 
        return sexo; 
    }
    public void setSexo(String sexo) { 
        this.sexo = sexo; 
    }
    public String getGrupoSanguineo() { 
        return grupoSanguineo; 
    }
    public void setGrupoSanguineo(String grupoSanguineo) { 
        this.grupoSanguineo = grupoSanguineo; 
    }
    public ArrayList<String> getListaMedicamentosAlergico() { 
        return listaMedicamentosAlergico; 
    }
    public void setListaMedicamentosAlergico(ArrayList<String> lista) { 
        this.listaMedicamentosAlergico = lista; 
    }
}
