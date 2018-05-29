
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Validateable;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class AltaAsignatura extends ActionSupport implements ModelDriven<Asignatura> , Validateable{
    private Asignatura asignatura = new Asignatura();
    private DataSource dataSource;
    private Connection conn;
    
    @Override
    public Asignatura getModel() {
        return asignatura;
    }
    
       @Override
    public void validate() {
        if (asignatura.getNombre() == null) {
            addFieldError("login", "Es necesario introducir el nombre de la asginatura");
        }
        if (asignatura.getProfesor()== null) {
            addFieldError("profesor", "El password tiene que tener mas de 4 carcacteres");
        }
        if (asignatura.getHorario()== null) {
            addFieldError("horario", "Hay que seleccionar un rol");
        }
    }
    
    public String execute() throws Exception {
       boolean acceso = false;
        Context ctx = new InitialContext();
        if (ctx == null) {
            throw new Exception("Error en el context");
        }
        dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/dbacademia");
        conn = dataSource.getConnection();
        /* Statement s = conn.createStatement(); */

        String qry = "INSERT INTO asignaturas (nombre, horario, profesor, estado) VALUES (?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(qry);
        pstmt.setString(1, asignatura.getNombre());
        pstmt.setString(2, asignatura.getHorario());
        pstmt.setString(3, asignatura.getProfesor());
        pstmt.setString(4, "alta");
        pstmt.executeUpdate();
        pstmt.close();
        conn.close();
        return SUCCESS;
    }
    
}
