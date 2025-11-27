package krakedev.entidades;

import java.util.ArrayList;

public class Curso {
    private ArrayList<Estudiante> estudiantes;

    public Curso() {
        this.estudiantes = new ArrayList<>();
    }

    // Getters y Setters
    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public void matricularEstudiante(Estudiante estudiante) {
        // Verificar si el estudiante ya está en el curso usando su cédula
        for (Estudiante est : estudiantes) {
            if (est.getCedula().equals(estudiante.getCedula())) {
                System.out.println("Error: El estudiante con cédula " + estudiante.getCedula() + " ya está matriculado");
                return;
            }
        }
        
        // Si no existe, agregar al estudiante
        this.estudiantes.add(estudiante);
    }

    public double calcularPromedioCurso() {
        if (estudiantes.isEmpty()) {
            return 0.0;
        }
        
        double sumaPromedios = 0;
        int estudiantesConNotas = 0;
        
        for (Estudiante estudiante : estudiantes) {
            double promedioEstudiante = estudiante.calcularPromedioNotasEstudiante();
            if (promedioEstudiante > 0) {
                sumaPromedios += promedioEstudiante;
                estudiantesConNotas++;
            }
        }
        
        if (estudiantesConNotas == 0) {
            return 0.0;
        }
        
        return sumaPromedios / estudiantesConNotas;
    }

    public void mostrar() {
        String resultado = "Curso [estudiantes=[";
        
        for (int i = 0; i < estudiantes.size(); i++) {
            if (i > 0) {
                resultado += ", ";
            }
            Estudiante estudiante = estudiantes.get(i);
            resultado += "Estudiante [cedula=" + estudiante.getCedula() + 
                        ", nombre=" + estudiante.getNombre() + 
                        ", apellido=" + estudiante.getApellido() + 
                        ", notas=[";
            
            ArrayList<Nota> notas = estudiante.getNotas();
            for (int j = 0; j < notas.size(); j++) {
                if (j > 0) {
                    resultado += ", ";
                }
                Nota nota = notas.get(j);
                Materia materia = nota.getMateria();
                resultado += "Nota [materia:" + materia.getNombre() + 
                           "[codigo=" + materia.getCodigo() + 
                           "], calificacion=" + nota.getCalificacion() + "]";
            }
        }
        System.out.println(resultado);
    }
}
