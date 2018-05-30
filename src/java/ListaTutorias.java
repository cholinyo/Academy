


import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
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
public class ListaTutorias extends ActionSupport {
    private int idusuario;
    private String dia;
    private String hora;
    private Tutorias tutoria;
    private ArrayList<Tutorias> listatutorias;

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public ArrayList<Tutorias> getListatutorias(int idusuario) throws NamingException, Exception {
        Context ctx = new InitialContext();
        if (ctx == null) {
            throw new Exception("Error en el context");
        }
        DataSource dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/dbacademia");
        Connection conn = dataSource.getConnection();
        Statement s = conn.createStatement();
        String query = "select * from tutorias where idprofesor='"+idusuario+"'"; 
        ResultSet rs = s.executeQuery(query);
        listatutorias = new ArrayList<>();
        while (rs.next()) {
            Tutorias tutoria = new Tutorias();
            tutoria.setDia(rs.getString(2));
            tutoria.setHora(rs.getString(3));
         
            listatutorias.add(tutoria);
        }
        rs.close();
        s.close();
        conn.close();
        
        return listatutorias;
    }

    public void setListatutorias(ArrayList<Tutorias> listatutorias) {
        this.listatutorias = listatutorias;
    }
    
    
    
    public ListaTutorias() {
    }
    
    public String execute() throws Exception {
        return SUCCESS;
    }

}
