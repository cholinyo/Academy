
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
public class ActualizarTutorias extends ActionSupport{
    private int idtutoria;
    private String estado;

    public int getIdtutoria() {
        return idtutoria;
    }

    public void setIdtutoria(int idtutoria) {
        this.idtutoria = idtutoria;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
           
    
    
    public ActualizarTutorias() {
    }
    
    public String execute() throws Exception {
        boolean acceso = false;
        Context ctx = new InitialContext();
        if (ctx == null) {
            throw new Exception("Error en el context");
        }
        DataSource dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/dbacademia");
        Connection conn = dataSource.getConnection();
        Statement s = conn.createStatement();
        String query = "UPDATE peticionestutorias SET estado=? WHERE idpeticion='" + idtutoria + "'";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, estado);
        int rs = pstmt.executeUpdate();
        pstmt.close();
        conn.close();
        s.close();
        return SUCCESS;
    }
    
}
