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
    private String fileName;
    private int fileSize;
    
    public Deliverable(){}
    
    public Deliverable (String newName, String newDescription, Contact newOwner, String newFileName){
        name = newName;
        description = newDescription;
        owner = newOwner;
        fileName = newFileName;
        fileSize = 0;
    }

    /**
     * @return the fileName
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * @param fileName the fileName to set
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * @return the fileSize
     */
    public int getFileSize() {
        return fileSize;
    }

    /**
     * @param fileSize the fileSize to set
     */
    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
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
    
    @Override
    public double getCompletionTime(){
        if(this.startDate == null || this.finishDate == null) return 0;
        long diff;
        diff = this.getStartDate().getTime()-this.getFinishDate().getTime();
        diff = diff / (1000*60*60*24);
        return (double) diff;
    }
    
    @Override
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
