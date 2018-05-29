
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author vcaruncho
 */
public class EditarUsuario extends ActionSupport {

    Usuario usuario = new Usuario();
    private DataSource dataSource;
    private Connection conn;
    private int idusuario;
    private String login;
    private String nombre;

    public void setLogin(String login) {
        this.login = login;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLogin() {
        return login;
    }

    public String getNombre() {
        return nombre;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public Connection getConn() {
        return conn;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    @Override
    public String execute() throws Exception {
      /*  boolean acceso = false;
        Context ctx = new InitialContext();
        if (ctx == null) {
            throw new Exception("Error en el context");
        }
        dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/dbacademia");
        conn = dataSource.getConnection();
        Statement s = conn.createStatement();
        String query = "select * from usuarios where idusuario='" + idusuario + "'";
        ResultSet rs = s.executeQuery(query);
        if (rs.next()) {
            Usuario usuario = new Usuario();
            usuario.setIdusuario(rs.getInt(1));
            usuario.setLogin(rs.getString(2));
            usuario.setNombre(rs.getString(4));
            usuario.setApellidos(rs.getString(5));
            usuario.setBaja(rs.getString(7));
            acceso = true;
        }
        rs.close();
        s.close();
        conn.close(); */
        return SUCCESS;
    }

}
