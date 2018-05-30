
import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.naming.Context;
import javax.naming.InitialContext;
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
public class GestionTutorias extends ActionSupport {

    private ArrayList<PeticionTutoria> listapeticiones;
    private DataSource dataSource;
    private Connection conn;
    private int idusuario;

    public ArrayList<PeticionTutoria> getListapeticiones() {
        return listapeticiones;
    }

    public void setListapeticiones(ArrayList<PeticionTutoria> listapeticiones) {
        this.listapeticiones = listapeticiones;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }



    public GestionTutorias() {
    }

    @Override
    public String execute() throws Exception {
        boolean acceso = false;
        Context ctx = new InitialContext();
        if (ctx == null) {
            throw new Exception("Error en el context");
        }
        DataSource dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/dbacademia");
        conn = dataSource.getConnection();
        Statement s = conn.createStatement();
        int valor = idusuario;
        String query = "Select * from peticionestutorias where idprofesor='" + idusuario + "'";
        ResultSet rs = s.executeQuery(query);
        listapeticiones = new ArrayList<>();
        while (rs.next()) {
            PeticionTutoria peticion = new PeticionTutoria();
            peticion.setIdtutoria(rs.getInt(1));
            peticion.setIdalumno(rs.getInt(3));
            peticion.setDia(rs.getString(4));
            peticion.setHora(rs.getString(5));
            peticion.setEstado(rs.getString(6));

            listapeticiones.add(peticion);
        }
        rs.close();
        s.close();
        conn.close();
        return "success";
    }
}
