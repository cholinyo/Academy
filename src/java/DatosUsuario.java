
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class DatosUsuario extends ActionSupport {

    Usuario usuario = new Usuario();
    private DataSource dataSource;
    private Connection conn;
    private int idusuario;
    private String login;
    private String nombre;
    private String apellidos;
    private String estado;

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getEstado() {
        return estado;
    }

    public DatosUsuario() {
    }


    /*  public Usuario getUsuario() {
        return usuario;
    } */
    public Usuario getUsuario() throws NamingException, Exception {
        boolean acceso = false;
        Context ctx = new InitialContext();
        if (ctx == null) {
            throw new Exception("Error en el context");
        }
        dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/dbacademia");
        conn = dataSource.getConnection();
        Statement s = conn.createStatement();
        String query = "select * from usuarios where idusuario='" + idusuario + "'";
        ResultSet rs = s.executeQuery(query);
        Usuario usuario = new Usuario();
        if (rs.next()) {

            usuario.setIdusuario(rs.getInt(1));
            usuario.setLogin(rs.getString(2));
            usuario.setNombre(rs.getString(4));
            usuario.setApellidos(rs.getString(5));
            usuario.setRol(rs.getString(6));
            usuario.setBaja(rs.getString(7));
            acceso = true;
        }
        rs.close();
        s.close();
        conn.close();
        return usuario;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public Connection getConn() {
        return conn;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public String getLogin() {
        return login;
    }

    public String getNombre() {
        return nombre;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }

}
