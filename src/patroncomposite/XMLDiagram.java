/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package patroncomposite;

/**
 *
 * @author acamargob
 */
public class XMLDiagram extends Deliverable{
    private String URISchema;
    private String URISource;
    
    public XMLDiagram()
    {
        super();
        URISchema = "";
        URISource = "";
    }
    
    public XMLDiagram(String name, String description, Contact owner, String fileName, String URISchema, String URISource)
    {
        super(name,description,owner,fileName);
        this.URISchema = URISchema;
        this.URISource = URISource;
    }

    /**
     * @return the URISchema
     */
    public String getURISchema() {
        return URISchema;
    }

    /**
     * @param URISchema the URISchema to set
     */
    public void setURISchema(String URISchema) {
        this.URISchema = URISchema;
    }

    /**
     * @return the URISource
     */
    public String getURISource() {
        return URISource;
    }

    /**
     * @param URISource the URISource to set
     */
    public void setURISource(String URISource) {
        this.URISource = URISource;
    }
}
