/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package redirect;

import java.io.IOException;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

/**
 *
 * @author usuario
 */
public class Redireccionar {
    public static void redirect(String pagina){
        ExternalContext ctx =  FacesContext.getCurrentInstance().getExternalContext();
        String ctxPath = ((ServletContext) ctx.getContext()).getContextPath();
        try {
              ctx.redirect(ctxPath+"/"+pagina);
            } 
        catch (IOException ex) {
               ex.printStackTrace();
            }
        
    }
    
}
