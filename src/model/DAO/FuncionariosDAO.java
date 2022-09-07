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
import model.bean.Funcionarios;

/**
 *
 * @author Yuri
 */
public class FuncionariosDAO {
    public void create(Funcionarios f){
    
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO funcionarios (nome,cargo,funcao,salario)VALUES(?,?,?,?)");
            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getCargo());
            stmt.setString(3, f.getFuncao());
            stmt.setInt(4, f.getSalario());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    
    
    public List<Funcionarios> read(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Funcionarios> TodosFuncionarios = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM funcionarios");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Funcionarios funcionarios = new Funcionarios();
                
                funcionarios.setId(rs.getInt("id"));
                funcionarios.setNome(rs.getString("nome"));
                funcionarios.setCargo(rs.getString("cargo"));
                funcionarios.setFuncao(rs.getString("funcao"));
                funcionarios.setSalario(rs.getInt("salario"));
                
                TodosFuncionarios.add(funcionarios);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FuncionariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        
        }
        return TodosFuncionarios;
    }
    
    
    
    
    
    
    
    
    
    public void update(Funcionarios f){
    
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE funcionarios  SET nome = ? , cargo = ? , funcao = ? , salario = ? WHERE id = ?");
            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getCargo());
            stmt.setString(3, f.getFuncao());
            stmt.setInt(4, f.getSalario());
            stmt.setInt(5, f.getId());
            
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }  
    
    public void delete(Funcionarios f){
    
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM funcionarios WHERE id = ?");
            stmt.setInt(1, f.getId());
           
            
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    } 
    public double relatorio(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
       double somatorio = 0;
        
        try {
            stmt = con.prepareStatement("SELECT salario FROM funcionarios");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                somatorio = rs.getDouble("salario") + somatorio;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProjetosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        
        }
        return somatorio;
        
    }
    
}
