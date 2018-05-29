
import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import org.apache.struts2.interceptor.SessionAware;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vcaruncho
 */
public class Profesor  extends ActionSupport {
    private String login;
    private ArrayList<Asignatura> listaasignaturas;

    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    
    public Profesor(){    
    }

    public ArrayList<Asignatura> getListaasignaturas() throws Exception {
        Context ctx = new InitialContext();
        if (ctx == null) throw new Exception("Error en el context");
        DataSource dataSource = (DataSource)ctx.lookup("java:comp/env/jdbc/dbacademia");
        Connection conn = dataSource.getConnection();
        Statement s = conn.createStatement();
        String query ="select * from asignaturas where Profesor='"+login+"' "; 
        ResultSet rs = s.executeQuery(query);;
        listaasignaturas = new ArrayList<>();
        while (rs.next()) 
        {   
        Asignatura asignatura = new Asignatura();
        asignatura.setIdasignatura(rs.getInt(1));
        asignatura.setNombre(rs.getString(2));
        asignatura.setHorario(rs.getString(3));
        asignatura.setEstado(rs.getString(5));
        listaasignaturas.add(asignatura);
        
	         }
        rs.close();
        s.close();
        conn.close();
        return listaasignaturas;
    }

    public void setListaasignaturas(ArrayList<Asignatura> listaasignaturas) {
        this.listaasignaturas = listaasignaturas;
    }
    
    
    public String execute() throws Exception {
 
        return SUCCESS;
    }  
}
