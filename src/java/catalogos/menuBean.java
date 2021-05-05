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
import javax.servlet.ServletContext;

/**
 *
 * @author Erick Corral
 */
@ManagedBean(name = "menu")
@RequestScoped
@ViewScoped
public class menuBean {

    private String pagina;

    public void redirecionar(int id) {
        
        ExternalContext ctx
                = FacesContext.getCurrentInstance().getExternalContext();

        
        try {
            switch (id) {
            case 1:
                ctx.redirect("/faces/catalogos/catalogoCiudad.xhtml");
//                setPagina("/catalogos/catalogoCiudad.xhtml");
                break;
            case 2:
                ctx.redirect("/faces/catalogos/CatalogoTipoTelefono");
//                setPagina("/catalogos/catalogoTipoTelefono.xhtml");
                break;
            default:
                ctx.redirect("/faces/index.xhtml");
////                setPagina("/index.xhtml");
                break;
        }
        }catch (IOException ex) {
            Logger.getLogger(UsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

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

}
