/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package runpatterncomp;
import java.io.Serializable;

/**
 *
 * @author sabs231
 */
public interface Contact extends Serializable
{
    public static final String SPACE = " ";
    
    public String getFirstName();
    public String getLastName();
    public String getTitle();
    public String getOrganization();
    
    public void setFirstName(String newFirstName);
    public void setLastName(String newLastName);
    public void setTitle(String newTitle);
    public void setOrganization(String newOrganitazion);
}
