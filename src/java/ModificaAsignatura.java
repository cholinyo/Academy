
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class ModificaAsignatura extends ActionSupport {
    private DataSource dataSource;
    private Connection conn;
    private int idasignatura;
    private String nombre;
    private String horario;
    private String profesor;
    private String estado;
    Asignatura asignatura = new Asignatura();

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }
    
    
    
    public ModificaAsignatura() {
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
        String query = "UPDATE asignaturas SET Nombre=?, Horario=?, Profesor=? WHERE iduasignatura='" + idasignatura + "'";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, nombre);
        pstmt.setString(2, horario);
        pstmt.setString(3, profesor);
        int rs = pstmt.executeUpdate();
        pstmt.close();
        conn.close();
        s.close();
        return SUCCESS;

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
    
    
}
