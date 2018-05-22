
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
public class ListadoUsuarios_v2 extends ActionSupport {
    private int npage=0;
    private int anterior=-1;
    private int posterior=-1;
    private ArrayList<Usuario> listausuarios;

    public int getAnterior() {
        return anterior;
    }

    public int getPosterior() {
        return posterior;
    }

    public ArrayList<Usuario> getListausuarios() {
        return listausuarios;
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

    public void setListausuarios(ArrayList<Usuario> listausuarios) {
        this.listausuarios = listausuarios;
    }
   

    @Override
    public String execute() throws Exception {
        Context ctx = new InitialContext();
        if (ctx == null) throw new Exception("Error en el context");
        DataSource dataSource = (DataSource)ctx.lookup("java:comp/env/jdbc/dbacademia");
        Connection conn = dataSource.getConnection();
        Statement s = conn.createStatement();
 /*       String query = "select * from usuarios where " + "rol= '"+estudiante+"'"; */
        String query ="select * from usuarios"; 
        ResultSet rs = s.executeQuery(query);
        listausuarios = new ArrayList<>();
        while (rs.next())
        {            
            listausuarios.add(new Usuario(rs.getInt(1),rs.getString(2),rs.getString(3)));
	         }
        rs.close();
        s.close();
        conn.close();
        return "Listado";

    }
}
