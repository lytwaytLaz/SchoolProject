package util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * Created by Elev1 on 2016-09-07.
 */
public class SchoolUtil {

    private SchoolUtil(){}

    public static void addErrorMessage(String id, String message){

        FacesMessage facesMsg = new FacesMessage( FacesMessage.SEVERITY_ERROR, message, "" );
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.addMessage( id, facesMsg );
    }
}
