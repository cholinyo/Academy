


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
    private String passowrd;
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

    public String getPassowrd() {
        return passowrd;
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

    public void setPassowrd(String passowrd) {
        this.passowrd = passowrd;
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
}
