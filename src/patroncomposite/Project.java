/*
 * Project.java
 *
 ** @author JTorres
 */

package patroncomposite;
import java.util.ArrayList;
import java.util.Iterator;

public class Project implements ProjectItem{
    private String name;
    private String description;
    private ArrayList<ProjectItem> projectItems = new ArrayList<ProjectItem>();
    
    public Project(){
    }
    
    public Project(String newName, String newDescription){
        name = newName;
        description = newDescription;
    }
    
    public String getName(){
        return name;
    }
    
    public String getDescription(){
        return description;
    }
    
    public ArrayList<ProjectItem> getProjectItems(){
        return projectItems;
    }
    
    @Override
    public double getCompletionTime(){
        double totalTime = 0;
        for (ProjectItem item : projectItems){
            totalTime += item.getCompletionTime();
        }
        return totalTime;
    }
    
    @Override
    public double getTimeRequired(){
        double totalTime = 0;
        Iterator items = projectItems.iterator();
        while (items.hasNext()){
            ProjectItem item = (ProjectItem)items.next();
            totalTime += item.getTimeRequired();
        }
        return totalTime;
    }
    
    public void setName(String newName){
        name = newName;
    }
    
    public void SetDescription(String newDescription){
        description = newDescription;
    }
    
    public void addProjectItem(ProjectItem element){
        if (!projectItems.contains(element)){
            projectItems.add(element);
        }
    }
    
    public void removeProjectItem(ProjectItem element){
        projectItems.remove(element);
    }
}
