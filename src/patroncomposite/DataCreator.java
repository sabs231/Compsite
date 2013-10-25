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
        Contact contact1 = new ContactImpl("Ivan", "Ambres", "Jefe de Proyecto", "GDI Inform�tica");
        Contact contact2 = new ContactImpl("Carmen", "Garc�a", "Analista Programador", "Microsoft");
        Contact contact3 = new ContactImpl("Guillermo", "Serrano", "Ingeniero de Pruebas", "Funciona BIEN TODO");
        Contact contact4 = new ContactImpl("Jorge", "Mateo", "Arquitecto de Software", "SOFTGAL");
        
        
        Project project = new Project ("Portal GDI", "Desarrollo del Portal Corporativo de GDI");
        
        Deliverable deliverable1 = new Document("Plan Maestro", "Documento del Proyecto", contact1, "Plan_Maestro.docx","ES","Documento, Maestro, Chingon","docx","C:/path/to/file/");
        Task task1 = new Task("Definir y Analisar", "Ingenier�a de Requisitos del Sistema", contact2, 11.0);
        Task task2 = new Task("Dise�o", "Dise�o del Sistema", contact4, 7.5);
        Task task3 = new Task("Implementar", "Implementar la aplicaci�n", contact3, 10.2);
        project.addProjectItem(deliverable1);
        project.addProjectItem(task1);
        project.addProjectItem(task2);
        project.addProjectItem(task3);
        
        Deliverable deliverable11 = new XMLDiagram("SRS","Documento de Requisitos", contact1, "SRS.xml", "C:/path/to/schema/", "C:/path/to/source");
        Task task11 = new Task("Definir Actores", "Analizar los actores que intervienen en el proyecto", contact4, 2.5);
        Task task12 = new Task("Identificar CU", "Desarrollar el modelo de casos de uso del distema", contact1, 14.0);
        task1.addProjectItem(task11);
        task1.addProjectItem(task12);
        task1.addProjectItem(deliverable11);
        
        
        Task task21 = new Task("Dise�o Estat�tico", "Desarrollar los modelos de clases de cada CU", contact1, 1.8);
        Task task22 = new Task("Dise�o Din�mico", "Desarrollar los modelos de interaci�n de cada CU", contact4, 5.0);
        Task task23 = new Task("Modelo desplique", "Desarrollar el modelo de despliegue", contact3, 17.5);
        task2.addProjectItem(task21);
        task2.addProjectItem(task22);
        task2.addProjectItem(task23);
        
        Deliverable deliverable31 = new Document("C�digo Fuente", "Los distintos c�digos desarrolladosCo", contact1, "src.zip", "JAVA", "source, code, codigo, fuente, codigo fuente, tripas", "ZIP", "C:/path/to/source/");
        task3.addProjectItem(deliverable31);
        return project;
    }
    private static void serializeToFile(Serializable content, String fileName) throws IOException{
        ObjectOutputStream serOut = new ObjectOutputStream(new FileOutputStream(fileName));
        serOut.writeObject(content);
        serOut.close();
    }
}
