
import static com.opensymphony.xwork2.Action.SUCCESS;
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
public class PeticionTutoria {
    private DataSource dataSource;
    private Connection conn;
    private int idtutoria;
    private int idalumno;
    private int idprofesor;
    private String dia;
    private String hora;
    private String estado;
    

    public int getIdtutoria() {
        return idtutoria;
    }

    public void setIdtutoria(int idtutoria) {
        this.idtutoria = idtutoria;
    }

    public int getIdalumno() {
        return idalumno;
    }

    public void setIdalumno(int idalumno) {
        this.idalumno = idalumno;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
   
    public PeticionTutoria() {
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

        String qry = "INSERT INTO peticionestutorias (idprofesor, idalumno, dia, hora, estado) VALUES (?, ?, ?, ?, ? )";
        PreparedStatement pstmt = conn.prepareStatement(qry);
        pstmt.setInt(1, idprofesor);
        pstmt.setInt(2,idalumno );
        pstmt.setString(3, dia);
        pstmt.setString(4, hora);
        pstmt.setString(5, "pendiente");
        pstmt.executeUpdate();
        pstmt.close();
        conn.close();
        return SUCCESS;
    }
    
}
