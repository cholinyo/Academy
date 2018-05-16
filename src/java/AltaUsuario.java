/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static com.opensymphony.xwork2.Action.INPUT;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Validateable;
import com.opensymphony.xwork2.ModelDriven;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 *
 * @author vcaruncho
 */
public class AltaUsuario extends ActionSupport implements ModelDriven<Usuario> , Validateable{

    private String login;
    private String password;
    private String nombre;
    private String apellidos;
    private String rol;
    private String baja;
    private DataSource dataSource;
    private Connection conn;
    
    private Usuario usuario = new Usuario();
    
    @Override
    public Usuario getModel() {
        return usuario;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public void setBaja(String baja) {
        this.baja = baja;
    }

    public String getPassword() {
        return password;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getRol() {
        return rol;
    }

    public String getBaja() {
        return baja;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    @Override
    public void validate() {
        if (getLogin().length() == 0) {
            addFieldError("login", "El nombre es necesario");
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
        pstmt.setString(1, login);
        pstmt.setString(2, password);
        pstmt.setString(3, nombre);
        pstmt.setString(4, apellidos);
        pstmt.setString(5, rol);
        pstmt.setString(6, "no");
        pstmt.executeUpdate();
        pstmt.close();
        conn.close();
        return SUCCESS;
    }

}
