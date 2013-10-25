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
public class Document extends Deliverable{
    private String language;
    private String keywords;
    private String format;
    private String URI;

    public Document(){
        super();
        this.language = "";
        this.keywords = "";
        this.format = "";
        this.URI = "";
    }
    
    public Document(String name, String description, Contact owner, String fileName, String language, String keywords, String format, String URI)
    {
        super(name,description,owner,fileName);
        this.language = language;
        this.keywords = keywords;
        this.format = format;
        this.URI = URI;
    }
    
    /**
     * @return the language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * @param language the language to set
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * @return the keywords
     */
    public String getKeywords() {
        return keywords;
    }

    /**
     * @param keywords the keywords to set
     */
    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    /**
     * @return the format
     */
    public String getFormat() {
        return format;
    }

    /**
     * @param format the format to set
     */
    public void setFormat(String format) {
        this.format = format;
    }

    /**
     * @return the URI
     */
    public String getURI() {
        return URI;
    }

    /**
     * @param URI the URI to set
     */
    public void setURI(String URI) {
        this.URI = URI;
    }
    
    
}
