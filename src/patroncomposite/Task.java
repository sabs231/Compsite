/*
 * Task.java
 *
 * @author JTorres
 */

package patroncomposite;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class Task implements ProjectItem{
    private String name;
    private String details;
    private ArrayList projectItems = new ArrayList();
    private Contact owner;
    private Date startDate, finishDate;
    private double timeRequired;
    
    
    public Task(){}
    
    public Task(String newName, String newDetails, Contact newOwner, double newTimeRequired){
        name = newName;
        details = newDetails;
        owner = newOwner;
        timeRequired = newTimeRequired;
    }
    
    public String getName (){
        return name;
    }
    
    public String getDetails(){
        return details;
    }
    
    public ArrayList getProjectItems(){
        return projectItems;
    }
    
    public Contact getOwner(){
        return owner;
    }
    
    public double getTimeRequired(){
        double totalTime = timeRequired;
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
    
    public void setDetails(String newDetails){
        details = newDetails;
    }
    
    public void setOwner(Contact newOwner){
        owner = newOwner;
    }
    
    @Override
    public double getCompletionTime(){
        if(this.startDate == null || this.finishDate == null) return 0;
        long diff;
        diff = this.getStartDate().getTime()-this.getFinishDate().getTime();
        diff = diff / (1000*60*60*24);
        return (double) diff;
    }
    
    public void setTimeRequired(double newTimeRequired){
        timeRequired = newTimeRequired;
    }
    
    /**
     * @return the startDate
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the finishDate
     */
    public Date getFinishDate() {
        return finishDate;
    }

    /**
     * @param finishDate the finishDate to set
     */
    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }
    public void addProjectItem(ProjectItem element){
        if(!projectItems.contains(element)){
            projectItems.add(element);
        }
    }
    
    public void removeProjectItem(ProjectItem element){
        projectItems.remove(element);
    }
}