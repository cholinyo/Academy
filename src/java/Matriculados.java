
import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class Matriculados extends ActionSupport {

    private int npage = 0;
    private int anterior = -1;
    private int posterior = -1;
    private ArrayList<Usuario> listamatriculados;
    private int idasignatura;
    private String nombre;

    public Matriculados() {
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

    public int getIdasignatura() {
        return idasignatura;
    }

    public void setIdasignatura(int idasignatura) {
        this.idasignatura = idasignatura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static int getEltosXpage() {
        return eltosXpage;
    }

    public static void setEltosXpage(int eltosXpage) {
        Matriculados.eltosXpage = eltosXpage;
    }

    private static int eltosXpage = 20;


    public ArrayList<Usuario> getListamatriculados() throws NamingException, Exception {
        Context ctx = new InitialContext();
        if (ctx == null) {
            throw new Exception("Error en el context");
        }
        DataSource dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/dbacademia");
        Connection conn = dataSource.getConnection();
        Statement s = conn.createStatement();
        String query = "select * from matriculas where idasignatura='" + idasignatura + "' limit " + (npage * eltosXpage) + "," + eltosXpage;
        ResultSet rs = s.executeQuery(query);
        anterior = npage - 1;
        posterior = npage + 1;
        listamatriculados = new ArrayList<>();
        int contadorEltos = 0;
        while (rs.next() && contadorEltos < eltosXpage) {
            Usuario user = new Usuario();
            int valor = rs.getInt(2);
            user.setIdusuario(rs.getInt(2));
            Statement s1 = conn.createStatement();
            String query1 = "select * from usuarios where idusuario='" + valor + "'";
            ResultSet rs1 = s1.executeQuery(query1);
            if (rs1.next()) {
                user.setLogin(rs1.getString(2));
                user.setNombre(rs1.getString(4));
                user.setApellidos(rs1.getString(5));
            }
            listamatriculados.add(user);
            contadorEltos++;
        }
        if (contadorEltos < eltosXpage) {
            posterior = -1;
        }
        rs.close();
        s.close();
        conn.close();
        return listamatriculados;
    }

    public String execute() throws Exception {
        return SUCCESS;

    }

}
