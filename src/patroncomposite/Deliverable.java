/*
 * Deliverable.java
 *
 ** @author JTorres
 */

package patroncomposite;

import java.util.Date;


public class Deliverable implements ProjectItem{
    private String name;
    private String description;
    private Contact owner;
    private Date startDate, finishDate;
    
    public Deliverable(){}
    
    public Deliverable (String newName, String newDescription, Contact newOwner){
        name = newName;
        description = newDescription;
        owner = newOwner;
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
    
    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
    public Contact getOwner(){
        return owner;
    }
    public double getTimeRequired(){
        return 0;
    }
    public void setName(String newName){
        name = newName;
    }
    public void setDescription(String newDescription){
        description = newDescription;
    }
    public void setOwner(Contact newOwner){
        owner = newOwner;
    }
}
