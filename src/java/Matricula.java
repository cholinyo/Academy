


import com.opensymphony.xwork2.ActionSupport;
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
public class Matricula extends ActionSupport {

    int idusuario;
    int idasignatura;

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public int getIdasignatura() {
        return idasignatura;
    }

    public void setIdasignatura(int idasignatura) {
        this.idasignatura = idasignatura;
    }

    public Matricula() {
    }

    public String execute() throws Exception {
        Context ctx = new InitialContext();
        if (ctx == null) {
            throw new Exception("Error en el context");
        }
        DataSource dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/dbacademia");
        Connection conn = dataSource.getConnection();
        Statement s = conn.createStatement();
        String qry = "INSERT INTO matriculas (idusuario , idasignatura) VALUES (?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(qry);
        pstmt.setInt(1, idusuario);
        pstmt.setInt(2, idasignatura);
        int rs = pstmt.executeUpdate();
        pstmt.close();
        conn.close();
        return SUCCESS;

    }
}
