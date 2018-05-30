
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
public class AltaTutoria extends ActionSupport {

    private DataSource dataSource;
    private Connection conn;
    private String dia;
    private String hora;
    private int idusuario;

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

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }
    
    
    
    public AltaTutoria() {
    }

    @Override
    public String execute() throws Exception {
        boolean acceso = false;
        Context ctx = new InitialContext();
        if (ctx == null) {
            throw new Exception("Error en el context");
        }
        dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/dbacademia");
        conn = dataSource.getConnection();
        /* Statement s = conn.createStatement(); */
        String qry = "INSERT INTO tutorias (idprofesor, dia, hora) VALUES (?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(qry);
        pstmt.setInt(1, idusuario);
        pstmt.setString(2, dia);
        pstmt.setString(3, hora);
        int rs = pstmt.executeUpdate();
        pstmt.close();
        conn.close();

        pstmt.close();
        conn.close();
        return SUCCESS;
    }
}
