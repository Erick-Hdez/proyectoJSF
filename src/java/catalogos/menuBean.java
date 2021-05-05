/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catalogos;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author Erick Corral
 */
@ManagedBean(name = "menu")
@RequestScoped
@ViewScoped
public class menuBean {

    private String pagina;

    /*
    *MÉTODO PARA SELECCIÓN DINÁMICA DEL MENÚ
    */
    
    public void redirecionar(int id) {
        
        ExternalContext ctx
                = FacesContext.getCurrentInstance().getExternalContext();

        
        try {
            switch (id) {
            case 1:
                ctx.redirect("catalogos/catalogoCiudad.xhtml");
                break;
            case 2:
                ctx.redirect("catalogos/CatalogoTipoTelefono");
                break;
            default:
                ctx.redirect("index.xhtml");
                break;
        }
        }catch (IOException ex) {
            Logger.getLogger(UsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    

//<editor-fold defaultstate="collapsed" desc="GetsySets">
    /**
     * @return the pagina
     */
    public String getPagina() {
        return pagina;
    }
    
    /**
     * @param pagina the pagina to set
     */
    public void setPagina(String pagina) {
        this.pagina = pagina;
    }
//</editor-fold>

}
