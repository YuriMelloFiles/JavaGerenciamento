/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Projetos;
import model.bean.Usuario;

/**
 *
 * @author Yuri
 */
public class  UsuarioDAO {
    
    public void create(Usuario h){
    
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO usuario (login,senha,tipo_login)VALUES(?,?,?)");
            stmt.setString(1, h.getLogin());
            stmt.setString(2, h.getSenha());
            stmt.setString(3, h.getTipo_login());
            

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    
    public List<Usuario> read(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Usuario> TodosUsuarios = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM usuario");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Usuario Usuario = new Usuario();
                
                Usuario.setId(rs.getInt("id"));
                Usuario.setLogin(rs.getString("login"));
                Usuario.setSenha(rs.getString("senha"));
                Usuario.setTipo_login(rs.getString("tipo_login"));
                
                
                TodosUsuarios.add(Usuario);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProjetosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        
        }
        return TodosUsuarios;
    }
    
    
    public void update(Usuario h){
    
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE usuario SET login = ? , senha = ? , tipo_login = ?  WHERE id = ?");
            
            stmt.setString(1, h.getLogin());
            stmt.setString(2, h.getSenha());
            stmt.setString(3, h.getTipo_login());
            stmt.setInt(4, h.getId());
            
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public void delete(Usuario h){
    
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM usuario WHERE id = ?");
            stmt.setInt(1, h.getId());
           
            
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    } 
    
    
    
    
    
    
    
    
    public boolean checkLogin(String login, String senha) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        boolean check = false;

        try {

            stmt = con.prepareStatement("SELECT * FROM usuario WHERE login = ? and senha = ?");
            stmt.setString(1, login);
            stmt.setString(2, senha);

            rs = stmt.executeQuery();

            if (rs.next()) {
                
                String perfil = rs.getString(4);
                
                
                check = true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return check;
        


  }
    
    public int checktype(String login, String senha) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

       

        try {

            stmt = con.prepareStatement("SELECT * FROM usuario WHERE login = ? and senha = ?");
            stmt.setString(1, login);
            stmt.setString(2, senha);

            rs = stmt.executeQuery();

            if (rs.next()) {
                
                String perfil = rs.getString(4);
                if ("administrador".equals(perfil)) {
                    
                    return 0;
                }
                
                if ("usuario".equals(perfil)) {
                    
                    return 1;
                }
                
                if ("supervisor".equals(perfil)) {
                    
                    return 2;
                }
                
                
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return 3;
        


  }

//    public int checkType(String login) {
//
//        Connection con = ConnectionFactory.getConnection();
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//
//        int check = 0;
//
//        try {
//
//            stmt = con.prepareStatement("SELECT login FROM usuario WHERE tipo_login = admin ");
//            rs = stmt.executeQuery();
//            Usuario usuario = new Usuario();
//            
//            System.out.println(rs);
//            
//            
////            if (rs.getString("login").equals(login)) {
////                check = 1;
////            }
////            }else{
////                stmt = con.prepareStatement("SELECT * FROM usuario WHERE tipo_login = 'usuario' ");
////                rs = stmt.executeQuery();
////                while(rs.next()){
////                
////                    if (rs.getString("login").equals(login)) {
////                        check = 2;
////                    }
////                
////                }
////                
////            }
////            check = 3;
//
//        } catch (SQLException ex) {
//            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            ConnectionFactory.closeConnection(con, stmt, rs);
//        }
//
//        return check;
//
//    }
    
    

}
