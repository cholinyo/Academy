
import static com.opensymphony.xwork2.Action.INPUT;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
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
public class ListadoUsuarios extends ActionSupport {
    private int npage=0;
    private int anterior=-1;
    private int posterior=-1;
    private ArrayList<Usuario> listaestudiantes;
    private ArrayList<Usuario> listaprofesores;

    public int getAnterior() {
        return anterior;
    }

    public int getPosterior() {
        return posterior;
   
    }

    public void setNpage(int npage) {
        this.npage = npage;
    }

    public void setAnterior(int anterior) {
        this.anterior = anterior;
    }
    
    public void setPosterior(int posterior) {
        this.posterior = posterior;
    }
    private static int eltosXpage = 10;
    
    public int getNpage() {
        return npage;
    }

    public ArrayList<Usuario> getListaestudiantes() throws NamingException, Exception {
        Context ctx = new InitialContext();
        if (ctx == null) throw new Exception("Error en el context");
        DataSource dataSource = (DataSource)ctx.lookup("java:comp/env/jdbc/dbacademia");
        Connection conn = dataSource.getConnection();
        Statement s = conn.createStatement();
        String query ="select * from usuarios where rol='estudiante' limit " + (npage*eltosXpage)+","+eltosXpage; 
        ResultSet rs = s.executeQuery(query);
        anterior = npage -1;
        posterior = npage +1;
        listaestudiantes = new ArrayList<>();
        int contadorEltos = 0;
        while (rs.next() && contadorEltos<eltosXpage) 
        {   
        Usuario user = new Usuario();
        user.setIdusuario(rs.getInt(1));
        user.setLogin(rs.getString(2));
        user.setNombre(rs.getString(4));
        user.setApellidos(rs.getString(5));
         user.setBaja(rs.getString(7));
        listaestudiantes.add(user);
        contadorEltos++;
	         }
        if (contadorEltos<eltosXpage) posterior=-1;
        rs.close();
        s.close();
        conn.close(); 
        return listaestudiantes;
    }
    
    
    public ArrayList<Usuario> getListaprofesores() throws NamingException, Exception {
        Context ctx = new InitialContext();
        if (ctx == null) throw new Exception("Error en el context");
        DataSource dataSource = (DataSource)ctx.lookup("java:comp/env/jdbc/dbacademia");
        Connection conn = dataSource.getConnection();
        Statement s = conn.createStatement();
        String query ="select * from usuarios where rol='profesor' limit " + (npage*eltosXpage)+","+eltosXpage; 
        ResultSet rs = s.executeQuery(query);
        anterior = npage -1;
        posterior = npage +1;
        listaprofesores = new ArrayList<>();
        int contadorEltos = 0;
        while (rs.next() && contadorEltos<eltosXpage) 
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
        if (contadorEltos<eltosXpage) posterior=-1;
        rs.close();
        s.close();
        conn.close(); 
        return listaprofesores;
    }
    

    @Override
    public String execute() throws Exception {
        return "Listado";

    }
}
