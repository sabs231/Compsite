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
    
    public ProjectItem getFirstTask(){
        if(!this.projectItems.isEmpty())
        {
            ProjectItem firstSon = this.projectItems.get(0);
            if(firstSon instanceof Project) return ((Project)firstSon).getFirstTask();
            return firstSon;
        }
        return null;
    }
    
    public ProjectItem getLastTask(){
        if(!this.projectItems.isEmpty())
        {
            ProjectItem lastSon = this.projectItems.get(this.projectItems.size()-1);
            if(lastSon instanceof Project) return ((Project)lastSon).getFirstTask();
            return lastSon;
        }
        return null;
    }
    
    public ProjectItem getNextTask(){
        if(!this.projectItems.isEmpty())
        {
            for (ProjectItem item : projectItems)
            {
                if (item instanceof Project)
                {
                    if(((Project)item).getNextTask()!=null){
                        return ((Project)item).getNextTask();
                    }
                }
                else
                {
                    if (item.getCompletionTime()>0) return item;
                    return null;
                }
            }
        }
        return null;
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
