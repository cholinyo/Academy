
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Validateable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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
public class DatosAsignatura extends ActionSupport {

    Asignatura asignatura = new Asignatura();
    private DataSource dataSource;
    private Connection conn;
    private int idasignatura;
    private String nombre;
    private String horario;
    private String profesor;
    private String estado;

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
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

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    

    public Asignatura getAsignatura() throws NamingException, Exception {
        boolean acceso = false;
        Context ctx = new InitialContext();
        if (ctx == null) {
            throw new Exception("Error en el context");
        }
        dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/dbacademia");
        conn = dataSource.getConnection();
        Statement s = conn.createStatement();
        String query = "select * from asignaturas where idasignatura ='" + idasignatura + "'";   
        ResultSet rs = s.executeQuery(query);
        Asignatura asignatura = new Asignatura();
        if (rs.next()) {
            asignatura.setIdasignatura(rs.getInt(1));
            asignatura.setNombre(rs.getString(2));
            asignatura.setHorario(rs.getString(3));
            asignatura.setProfesor(rs.getString(4));
           
            acceso = true;
        }
        rs.close();
        s.close();
        conn.close();
        return asignatura;
    }

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }



}
