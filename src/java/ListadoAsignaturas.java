
import static com.opensymphony.xwork2.Action.SUCCESS;
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
public class ListadoAsignaturas extends ActionSupport{
    private ArrayList<Asignatura> listaasignaturas;
    private int npage = 0;
    private int anterior = -1;
    private int posterior = -1;
    
    public ListadoAsignaturas() {
    }

    public ArrayList<Asignatura> getListaasignaturas() {
        return listaasignaturas;
    }

    public int getNpage() {
        return npage;
    }

    public int getAnterior() {
        return anterior;
    }

    public int getPosterior() {
        return posterior;
    }

    public static int getEltosXpage() {
        return eltosXpage;
    }

    public void setListaasignaturas(ArrayList<Asignatura> listaasignaturas) {
        this.listaasignaturas = listaasignaturas;
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

    public static void setEltosXpage(int eltosXpage) {
        ListadoAsignaturas.eltosXpage = eltosXpage;
    }
    
    
    private static int eltosXpage = 10;
    
    
    public String execute() throws Exception {
        Context ctx = new InitialContext();
        if (ctx == null) {
            throw new Exception("Error en el context");
        }
        DataSource dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/dbacademia");
        Connection conn = dataSource.getConnection();
        Statement s = conn.createStatement();
        String query = "select * from asignaturas limit " + (npage * eltosXpage) + "," + eltosXpage;
        ResultSet rs = s.executeQuery(query);
        anterior = npage - 1;
        posterior = npage + 1;
        listaasignaturas = new ArrayList<>();
        int contadorEltos = 0;
        while (rs.next() && contadorEltos < eltosXpage) {
            Asignatura asig = new Asignatura();
            asig.setIdasignatura(rs.getInt(1));
            asig.setNombre(rs.getString(2));
            asig.setHorario(rs.getString(3));
            asig.setProfesor(rs.getString(4));
            asig.setEstado(rs.getString(5));
            listaasignaturas.add(asig);
            contadorEltos++;
        }
        if (contadorEltos < eltosXpage) {
            posterior = -1;
        }
        rs.close();
        s.close();
        conn.close();
        return SUCCESS;
        
    }
}
    
