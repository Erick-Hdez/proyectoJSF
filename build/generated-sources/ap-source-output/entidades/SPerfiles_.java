package entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-05-11T11:48:28")
@StaticMetamodel(SPerfiles.class)
public class SPerfiles_ { 

    public static volatile SingularAttribute<SPerfiles, String> descripcion;
    public static volatile SingularAttribute<SPerfiles, Date> fechaBaja;
    public static volatile SingularAttribute<SPerfiles, Date> fechaAlta;
    public static volatile SingularAttribute<SPerfiles, Integer> idPerfil;
    public static volatile SingularAttribute<SPerfiles, Integer> idUsuarioModifica;
    public static volatile SingularAttribute<SPerfiles, String> nombrePerfil;
    public static volatile SingularAttribute<SPerfiles, Date> fechaServidor;
    public static volatile SingularAttribute<SPerfiles, Boolean> activo;

}