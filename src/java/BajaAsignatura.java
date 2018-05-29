
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
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
public class BajaAsignatura extends ActionSupport {
    private DataSource dataSource;
    private Connection conn;
    private int idasignatura;
    
    public BajaAsignatura() {
    }

    public int getIdasignatura() {
        return idasignatura;
    }

    public void setIdasignatura(int idasignatura) {
        this.idasignatura = idasignatura;
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
        String valor=null;
        String query = "UPDATE asignaturas SET  Estado='baja' WHERE idasignatura='" + idasignatura + "'";
        PreparedStatement pstmt = conn.prepareStatement(query);
        int rs = pstmt.executeUpdate();
        pstmt.close();
        conn.close();
        s.close();
        return SUCCESS;
    }
}
