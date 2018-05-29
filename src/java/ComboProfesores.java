
import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
public class ComboProfesores extends ActionSupport {
    private ArrayList<Usuario> listaprofesores;
    
    
    
    public ArrayList<Usuario> getListaprofesores() throws NamingException, Exception {
        Context ctx = new InitialContext();
        if (ctx == null) throw new Exception("Error en el context");
        DataSource dataSource = (DataSource)ctx.lookup("java:comp/env/jdbc/dbacademia");
        Connection conn = dataSource.getConnection();
        Statement s = conn.createStatement();
        String query ="select * from usuarios where rol='profesor'"; 
        ResultSet rs = s.executeQuery(query);
        listaprofesores = new ArrayList<>();
        int contadorEltos = 0;
        while (rs.next()) 
        {   
        Usuario user = new Usuario();
        user.setIdusuario(rs.getInt(1));
        user.setLogin(rs.getString(2));
        user.setNombre(rs.getString(4));
        user.setApellidos(rs.getString(5));
        user.setBaja(rs.getString(7));
        listaprofesores.add(user);
        contadorEltos++;
	         }
        rs.close();
        s.close();
        conn.close(); 
        return listaprofesores;
    }
    

    @Override
    public String execute() throws Exception {
        return "profes";

    }
    
}
