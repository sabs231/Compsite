/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package runpatterncomp;
import java.io.File;


/**
 *
 * @author sabs231
 */
public class RunPatternComp 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        System.out.println("Ejemplo pare el Patron Composite");
        System.out.println();
        System.out.println("Este código popaga un método para ejecutar durante todo ");
        System.out.println("una estructura de arbol. El arbol representa un projecto, y es ");
        System.out.println("compuesto de tres tipos de ProjectItems: Project, Task y Deliverable.");
        System.out.println("De estras tres clases, Project y Task pueden almacenar un ArrayList de ProjectItems.");
        System.out.println("Esto significa que ouede actuar como nodo de la rama del arbol");
        System.out.println("El Deriverable es un nodo terminal debido a que no puede llevar a cabo ningún ProjectItem");
        System.out.println();
        System.out.println();
        
        System.out.println("En este ejemplo, el método definido por ProjectItem, getTimeRequired, privee el método para");
        System.out.println("demostrar el patron. Para el nodo de la rama, el método podrá ser pasado sobre los hijos. ");
        System.out.println("Para el nodo terminal (Deliverable), un unico valor puede ser regresado.");
        System.out.println();
        System.out.println("Nota: es posible llamar este métido en DONDEQUIERA en el arbol");
        System.out.println("Puesto que todas las clases implementan el método getTimeRequired");
        System.out.println("Esto significa que podremos calcular el Tiempo requierido para completar el proyecto o alguna");
        System.out.println("parte del proyecto.");
        System.out.println();
        
        System.out.println("Deserializando un Proyecto de prueba para el patron Composite");
        System.out.println();
        if (!(new File("data.ser").exists())){
            DataCreator.serialize("data.ser");
        }
        Project project = (Project) (DataRetriever.deserializeData("data.ser"));
        System.out.println("Calculando el tiempo total estimado para el proyecto");
        System.out.println("\t" + "Nombre del Proyecto: " + project.getName());
        System.out.println("\t" + "Descripción del Proyecto: " + project.getDescription());
        System.out.println("Time Required: " + project.getTimeRequired());
    }
}
