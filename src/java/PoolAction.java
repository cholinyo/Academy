/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vcaruncho
 */
import com.opensymphony.xwork2.*;
import java.sql.*;
import java.util.Map;
import javax.naming.*;
import javax.sql.DataSource;
import org.apache.struts2.interceptor.SessionAware;


public class PoolAction extends ActionSupport implements SessionAware {

    private DataSource dataSource;
    private Connection conn;
    private String usuario;
    private String contrasena;
    private Map<String, Object> sesion;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setSession(Map<String, Object> map) {
        this.sesion = map;
    }

    public Map<String, Object> getSession() {
        return sesion;
    }
    
    @Override
    public String execute() throws Exception {
        boolean acceso = false;
        Context ctx = new InitialContext();
        if (ctx == null) throw new Exception("Error en el context");
        dataSource = (DataSource)ctx.lookup("java:comp/env/jdbc/dbacademia");
        conn = dataSource.getConnection();
        Statement s = conn.createStatement();
        String query = "select * from usuarios where " + "user='"+usuario+"' and password='"+contrasena+"'";
        ResultSet rs = s.executeQuery(query);
        if (rs.next()) acceso=true;
        rs.close();
        s.close();
        conn.close();
        if (acceso) {
            sesion.put("usuario", usuario);
            sesion.put("rol", 1);
            
            /*Faltara el rol*/
            return SUCCESS;
        }
        else {
            usuario="";
            contrasena="";
            return INPUT;
        }
    }
}
