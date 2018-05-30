
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
public class SolicitarTutoria extends ActionSupport {

    private int idtutoria;
    private int idprofesor;
    private String dia;
    private String hora;
    private String nombreprofesor;
    private ArrayList<SolicitarTutoria> ltutorias;

    public int getIdtutoria() {
        return idtutoria;
    }

    public void setIdtutoria(int idtutoria) {
        this.idtutoria = idtutoria;
    }

    public int getIdprofesor() {
        return idprofesor;
    }

    public void setIdprofesor(int idprofesor) {
        this.idprofesor = idprofesor;
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

    public String getNombreprofesor() {
        return nombreprofesor;
    }

    public void setNombreprofesor(String nombreprofesor) {
        this.nombreprofesor = nombreprofesor;
    }

    public ArrayList<SolicitarTutoria> getLtutorias() {
        return ltutorias;
    }

    public void setLtutorias(ArrayList<SolicitarTutoria> ltutorias) {
        this.ltutorias = ltutorias;
    }

    public SolicitarTutoria() {
    }

    public String execute() throws Exception {
        Context ctx = new InitialContext();
        if (ctx == null) {
            throw new Exception("Error en el context");
        }
        DataSource dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/dbacademia");
        Connection conn = dataSource.getConnection();
        Statement s = conn.createStatement();
        String query = "select * from tutorias";
        ResultSet rs = s.executeQuery(query);
        ltutorias = new ArrayList<>();
        while (rs.next()) {
            SolicitarTutoria tut = new SolicitarTutoria();
            tut.setIdtutoria(rs.getInt(1));
            tut.setIdprofesor(rs.getInt(2));
            tut.setDia(rs.getString(3));
            tut.setHora(rs.getString(4));
            int valor = rs.getInt(2);
            Connection conn1 = dataSource.getConnection();
            Statement s1 = conn1.createStatement();
            String query1 = "select * from usuarios where idusuario='" + valor + "'";
            ResultSet rs1 = s1.executeQuery(query1);
            if (rs1.next()) {
                tut.setNombreprofesor(rs1.getString(4) + " " + rs1.getString(5));
            }
            conn1.close();
            rs1.close();
            s1.close();
            ltutorias.add(tut);
        }

        rs.close();
        s.close();
        conn.close();
        return SUCCESS;
    }

}
