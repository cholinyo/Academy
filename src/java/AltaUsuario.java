

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Validateable;
import com.opensymphony.xwork2.ModelDriven;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 *
 * @author vcaruncho
 */
public class AltaUsuario extends ActionSupport implements ModelDriven<Usuario> , Validateable{
    
    private Usuario usuario = new Usuario();
    private DataSource dataSource;
    private Connection conn;
    
    @Override
    public Usuario getModel() {
        return usuario;
    }

    @Override
    public void validate() {
        if (usuario.getLogin().length() == 0) {
            addFieldError("login", "Es necesario introducir un login");
        }
        if (usuario.getPassword().length() <= 0) {
            addFieldError("password", "El password tiene que tener mas de 4 carcacteres");
        }
        if (usuario.getRol()== null) {
            addFieldError("rol", "Hay que seleccionar un rol");
        }
    }

    @Override
    public String execute() throws Exception {
        boolean acceso = false;
        Context ctx = new InitialContext();
        if (ctx == null) {
            throw new Exception("Error en el context");
        }
        dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/dbacademia");
        conn = dataSource.getConnection();
        /* Statement s = conn.createStatement(); */

        String qry = "INSERT INTO usuarios (login, password, nombre, apellidos, rol, baja) VALUES (?, ?, ?, ?, ? ,?)";
        PreparedStatement pstmt = conn.prepareStatement(qry);
        pstmt.setString(1, usuario.getLogin());
        pstmt.setString(2, usuario.getPassword());
        pstmt.setString(3, usuario.getNombre());
        pstmt.setString(4, usuario.getApellidos());
        pstmt.setString(5, usuario.getRol());
        pstmt.setString(6, "no");
        pstmt.executeUpdate();
        pstmt.close();
        conn.close();
        return SUCCESS;
    }

}
