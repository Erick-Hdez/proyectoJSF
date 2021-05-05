package catalogos;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import modelos.UsuarioModelo;
import objetos.Usuario;
import respuestas.RespuestaUsuario;


/**
 *
 * @author Erick Corral
 */
@ManagedBean
@SessionScoped
@RequestScoped
//@ViewScoped
public class UsuarioBean {

    private Usuario usuario;
    
    public UsuarioBean() {
        usuario = new Usuario();  
    }

    public String autenticar(Usuario usuario) {
        RespuestaUsuario respuesta = UsuarioModelo.getUsuario(usuario);

        try {
            if (respuesta.getRespuesta().getId() == 0) {
                FacesContext context = FacesContext.getCurrentInstance();

                context.getExternalContext().getSessionMap().put("idUsuario", respuesta.getLogin().getIdUsuario());
                context.getExternalContext().getSessionMap().put("usuario", respuesta.getLogin().getUsuario());
                context.getExternalContext().getSessionMap().put("nombreUsuario", respuesta.getLogin().getNombreUsuario());

                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenid@ " , respuesta.getLogin().getNombreUsuario());
                context.addMessage(null, msg);
                return "template.xhtml";

            } else {

                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de autenticación", "Contraseña invalida");
                FacesContext.getCurrentInstance().addMessage(null, msg);
                return "";

            }
        } catch (Exception ex) {
            Logger.getLogger(UsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
    }

    public void verificarSesion() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            Usuario user = (Usuario) context.getExternalContext().getSessionMap().get("usuario");

            if (user == null) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("permisos.xhtml");
            }
        } catch (IOException ex) {
            Logger.getLogger(UsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void logout() {
        ExternalContext ctx
                = FacesContext.getCurrentInstance().getExternalContext();
        String ctxPath
                = ((ServletContext) ctx.getContext()).getContextPath();
        try {
            // Usar el contexto de JSF para invalidar la sesión,
            // NO EL DE SERVLETS (nada de HttpServletRequest)
            ((HttpSession) ctx.getSession(false)).invalidate();

            // Redirección de nuevo con el contexto de JSF,
            // si se usa una HttpServletResponse fallará.
            // Sin embargo, como ya está fuera del ciclo de vida 
            // de JSF se debe usar la ruta completa -_-U
            
            ctx.redirect(ctxPath + "/faces/login.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(UsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  
    //<editor-fold defaultstate="collapsed" desc="GETS y SETS">
    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

  
//</editor-fold>
}