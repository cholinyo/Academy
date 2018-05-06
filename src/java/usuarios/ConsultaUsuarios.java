package usuarios;

import java.sql.*;
import java.util.LinkedList;

public class ConsultaUsuarios {

	public static LinkedList<Usuario> getUsuarios()
	   {
	      LinkedList<Usuario> listaUsuarios=new LinkedList<Usuario>();
	      try
	      {
	    	  	Class.forName("org.gjt.mm.mysql.Driver");
	    	  	Connection conexion = DriverManager.getConnection ("jdbc:mysql://localhost/dbacademia","root", "root");
	        Statement st = conexion.createStatement();
	        ResultSet rs = st.executeQuery("select * from usuarios" );
	         while (rs.next())
	         {
	            Usuario usuario = new Usuario();
	            usuario.setIdusuario(rs.getInt("idusuario"));
	            usuario.setLogin(rs.getString("login"));
	            usuario.setNombre(rs.getString("nombre"));
	            usuario.setApellidos(rs.getString("apellidos"));
	            usuario.setRol(rs.getString("rol"));
	            listaUsuarios.add(usuario);
	         }
	         rs.close();
	         st.close();
	         conexion.close();
	      }
	      catch (Exception e)
	      {
	         e.printStackTrace();
	      }
	      return listaUsuarios;
	   }
	public static LinkedList<Usuario> getUltimosUsuarios()
	   {
	      LinkedList<Usuario> listaUsuarios=new LinkedList<Usuario>();
	      try
	      {
	    	  	Class.forName("org.gjt.mm.mysql.Driver");
	    	  	Connection conexion = DriverManager.getConnection ("jdbc:mysql://localhost/dbacademia","root", "root");
	        Statement st = conexion.createStatement();
	        ResultSet rs = st.executeQuery("select * from usuarios WHERE baja='no' ORDER by idusuario desc LIMIT 8" );
	         while (rs.next())
	         {
	            Usuario usuario = new Usuario();
	            usuario.setIdusuario(rs.getInt("idusuario"));
	            usuario.setLogin(rs.getString("login"));
	            usuario.setNombre(rs.getString("nombre"));
	            usuario.setApellido(rs.getString("apellidos"));
	            usuario.setRol(rs.getString("rol"));
	            listaUsuarios.add(usuario);
	         }
	         rs.close();
	         st.close();
	         conexion.close();
	      }
	      catch (Exception e)
	      {
	         e.printStackTrace();
	      }
	      return listaUsuarios;
	   }
	public static LinkedList<Usuario> getUsuariostipo(String tipo)
	   {
	      LinkedList<Usuario> listaUsuarios=new LinkedList<Usuario>();
	      try
	      {
	    	  	Class.forName("org.gjt.mm.mysql.Driver");
	    	  	Connection conexion = DriverManager.getConnection ("jdbc:mysql://localhost/dbacademia","root", "root");
	        Statement st = conexion.createStatement();
	        ResultSet rs = st.executeQuery("select * from usuarios where baja='no' AND rol='" + tipo + "'");
	         while (rs.next())
	         {
	            Usuario usuario = new Usuario();
	            usuario.setIdusuario(rs.getInt("idusuario"));
	            usuario.setLogin(rs.getString("login"));
	            usuario.setNombre(rs.getString("nombre"));
	            usuario.setApellidos(rs.getString("apellidos"));
	            usuario.setRol(rs.getString("rol"));
	            listaUsuarios.add(usuario);
	         }
	         rs.close();
	         st.close();
	         conexion.close();
	      }
	      catch (Exception e)
	      {
	         e.printStackTrace();
	      }
	      return listaUsuarios;
	   }
	public static Usuario getUsuario(int id)
	   {
		Usuario usuario = new Usuario();
	      try
	      {
	    	  	Class.forName("org.gjt.mm.mysql.Driver");
	    	  	Connection conexion = DriverManager.getConnection ("jdbc:mysql://localhost/dbacademia","root", "root");
	        PreparedStatement ps = conexion.prepareStatement("select * from usuarios where idusuario=?");
	        ps.setInt(1,id);
	        ResultSet rs = ps.executeQuery(); 
	        if (rs.next()) {
	        usuario.setIdusuario(rs.getInt("idusuario"));
	        usuario.setLogin(rs.getString("login"));
	        usuario.setNombre(rs.getString("nombre"));
	        usuario.setApellidos(rs.getString("apellidos"));
	        usuario.setRol(rs.getString("rol"));
	         rs.close();
	         ps.close();
	         conexion.close();
	        }
	      }
	      catch (Exception e)
	      {
	         e.printStackTrace();
	      }
	      return usuario;
	   }

	public static LinkedList<Usuario> getUsuariostipopPag(String tipo, int pagina)
	   {
	      LinkedList<Usuario> listaUsuarios=new LinkedList<Usuario>();
	      try
	      {
	    	  	Class.forName("org.gjt.mm.mysql.Driver");
	    	  	Connection conexion = DriverManager.getConnection ("jdbc:mysql://localhost/dbacademia","root", "root");
	        Statement st = conexion.createStatement();
	        ResultSet rs = st.executeQuery("select * from usuarios where baja='no' AND rol='" + tipo + "' LIMIT "+ (pagina-1)*5 + ",5;");
	         while (rs.next())
	         {
	            Usuario usuario = new Usuario();
	            usuario.setIdusuario(rs.getInt("idusuario"));
	            usuario.setLogin(rs.getString("login"));
	            usuario.setNombre(rs.getString("nombre"));
	            usuario.setApellidos(rs.getString("apellidos"));
	            usuario.setRol(rs.getString("rol"));
	            listaUsuarios.add(usuario);
	         }
	         rs.close();
	         st.close();
	         conexion.close();
	      }
	      catch (Exception e)
	      {
	         e.printStackTrace();
	      }
	      return listaUsuarios;
	   }
	public static LinkedList<Usuario> gettodosUsuariostipo(String tipo)
	   {
	      LinkedList<Usuario> listaUsuarios=new LinkedList<Usuario>();
	      try
	      {
	    	  	Class.forName("org.gjt.mm.mysql.Driver");
	    	  	Connection conexion = DriverManager.getConnection ("jdbc:mysql://localhost/dbacademia","root", "root");
	        Statement st = conexion.createStatement();
	        ResultSet rs = st.executeQuery("select * from usuarios where rol='" + tipo + "'");
	         while (rs.next())
	         {
	            Usuario usuario = new Usuario();
	            usuario.setIdusuario(rs.getInt("idusuario"));
	            usuario.setLogin(rs.getString("login"));
	            usuario.setNombre(rs.getString("nombre"));
	            usuario.setApellidos(rs.getString("apellidos"));
	            usuario.setRol(rs.getString("rol"));
	            listaUsuarios.add(usuario);
	         }
	         rs.close();
	         st.close();
	         conexion.close();
	      }
	      catch (Exception e)
	      {
	         e.printStackTrace();
	      }
	      return listaUsuarios;
	   }
}