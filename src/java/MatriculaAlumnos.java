
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
public class MatriculaAlumnos extends ActionSupport {

    private int npage = 0;
    private int anterior = -1;
    private int posterior = -1;
    private ArrayList<Asignatura> listamatriculadas;
    private int idusuario;
    private String login;

    public MatriculaAlumnos() {
    }

    public int getNpage() {
        return npage;
    }

    public void setNpage(int npage) {
        this.npage = npage;
    }

    public int getAnterior() {
        return anterior;
    }

    public void setAnterior(int anterior) {
        this.anterior = anterior;
    }

    public int getPosterior() {
        return posterior;
    }

    public void setPosterior(int posterior) {
        this.posterior = posterior;
    }

    public void setListamatriculadas(ArrayList<Asignatura> listamatriculadas) {
        this.listamatriculadas = listamatriculadas;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    private static int eltosXpage = 8;
    
    public ArrayList<Asignatura> getListamatriculadas() throws NamingException, Exception {
        Context ctx = new InitialContext();
        if (ctx == null) {
            throw new Exception("Error en el context");
        }
        DataSource dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/dbacademia");
        Connection conn = dataSource.getConnection();
        Statement s = conn.createStatement();
        String query = "select * from matriculas where idusuario='" + idusuario + "' limit " + (npage * eltosXpage) + "," + eltosXpage;
        ResultSet rs = s.executeQuery(query);
        anterior = npage - 1;
        posterior = npage + 1;
        listamatriculadas = new ArrayList<>();
        int contadorEltos = 0;
        while (rs.next() && contadorEltos < eltosXpage) {
            Asignatura asig = new Asignatura();
            int valor = rs.getInt(2);
            asig.setIdasignatura(rs.getInt(3));
            Statement s1 = conn.createStatement();
            String query1 = "select * from asignaturas where idasignatura='" + valor + "'";
            ResultSet rs1 = s1.executeQuery(query1);
            if (rs1.next()) {
                asig.setNombre(rs1.getString(2));
                asig.setProfesor(rs1.getString(3));
                asig.setHorario(rs1.getString(3));
            }
            listamatriculadas.add(asig);
            contadorEltos++;
        }
        if (contadorEltos < eltosXpage) {
            posterior = -1;
        }
        rs.close();
        s.close();
        conn.close();
        
        
        
        return listamatriculadas;
    }

    public String execute() throws Exception {
        return SUCCESS;
    }

}
