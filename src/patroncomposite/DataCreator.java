/*
 * DataCreator.java
 * @author JTorres
 */

package patroncomposite;
import java.io.Serializable;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class DataCreator {
    private static final String DEFAULT_FILE = "data.ser";
    
    public static void main (String [] args){
        String fileName;
        if (args.length == 1){
            fileName = args[0];
        }
        else{
            fileName = DEFAULT_FILE;
        }
        serialize(fileName);
    }
    
    public static void serialize(String fileName){
        try{
            serializeToFile(createData(), fileName);
        }
        catch (IOException exc){
            exc.printStackTrace();
        }
    }
    
    private static Serializable createData(){
        Contact contact1 = new ContactImpl("Ivan", "Ambres", "Jefe de Proyecto", "GDI Informática");
        Contact contact2 = new ContactImpl("Carmen", "García", "Analista Programador", "Microsoft");
        Contact contact3 = new ContactImpl("Guillermo", "Serrano", "Ingeniero de Pruebas", "Funciona BIEN TODO");
        Contact contact4 = new ContactImpl("Jorge", "Mateo", "Arquitecto de Software", "SOFTGAL");
        
        
        Project project = new Project ("Portal GDI", "Desarrollo del Portal Corporativo de GDI");
        
        Deliverable deliverable1 = new Deliverable("Plan Maestro", "Documento del Proyecto", contact1);
        Task task1 = new Task("Definir y Analisar", "Ingeniería de Requisitos del Sistema", contact2, 11.0);
        Task task2 = new Task("Diseño", "Diseño del Sistema", contact4, 7.5);
        Task task3 = new Task("Implementar", "Implementar la aplicación", contact3, 10.2);
        project.addProjectItem(deliverable1);
        project.addProjectItem(task1);
        project.addProjectItem(task2);
        project.addProjectItem(task3);
        
        Deliverable deliverable11 = new Deliverable("SRS","Documento de Requisitos", contact1);
        Task task11 = new Task("Definir Actores", "Analizar los actores que intervienen en el proyecto", contact4, 2.5);
        Task task12 = new Task("Identificar CU", "Desarrollar el modelo de casos de uso del distema", contact1, 14.0);
        task1.addProjectItem(task11);
        task1.addProjectItem(task12);
        task1.addProjectItem(deliverable11);
        
        
        Task task21 = new Task("Diseño Estatático", "Desarrollar los modelos de clases de cada CU", contact1, 1.8);
        Task task22 = new Task("Diseño Dinámico", "Desarrollar los modelos de interación de cada CU", contact4, 5.0);
        Task task23 = new Task("Modelo desplique", "Desarrollar el modelo de despliegue", contact3, 17.5);
        task2.addProjectItem(task21);
        task2.addProjectItem(task22);
        task2.addProjectItem(task23);
        
        Deliverable deliverable31 = new Deliverable("Código Fuente", "Los distintos códigos desarrolladosCo", contact1);
        task3.addProjectItem(deliverable31);
        return project;
    }
    private static void serializeToFile(Serializable content, String fileName) throws IOException{
        ObjectOutputStream serOut = new ObjectOutputStream(new FileOutputStream(fileName));
        serOut.writeObject(content);
        serOut.close();
    }
}
