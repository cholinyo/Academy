


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author vcaruncho
 */
public class Usuario {

    private int idusuario;
    private String login;
    private String password;
    private String nombre;
    private String apellidos;
    private String rol;
    private String baja;

    public int getIdusuario() {
        return idusuario;
    }

    public String getLogin() {
        return login;
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

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public void setLogin(String login) {
        this.login = login;
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

    public static Usuario getUsuario(int id) {
        Usuario usuario = new Usuario();
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/dbacademia", "root", "root");
            PreparedStatement ps = conexion.prepareStatement("select * from usuarios where idusuario=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                usuario.setIdusuario(rs.getInt("idusuario"));
                usuario.setLogin(rs.getString("login"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellidos(rs.getString("apellidos"));
                usuario.setRol(rs.getString("rol"));
                rs.close();
                ps.close();
                conexion.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuario;
    }
}
