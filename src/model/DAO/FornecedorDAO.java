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
import model.bean.Fornecedor;


/**
 *
 * @author Yuri
 */
public class FornecedorDAO {
    
        public void create(Fornecedor d){
    
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO fornecedores (nome_fornecedor,cnpj_fornecedor,tipo_fornecimento)VALUES(?,?,?)");
            stmt.setString(1, d.getNome_fornecedor());
            stmt.setString(2, d.getCnpj_fornecedor());
            stmt.setString(3, d.getTipo_fornecimento());
     

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    
    
    public List<Fornecedor> read(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Fornecedor> TodosFornecedores = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM fornecedores");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Fornecedor fornecedor = new Fornecedor();
                
                fornecedor.setId(rs.getInt("id"));
                fornecedor.setNome_fornecedor(rs.getString("nome_fornecedor"));
                fornecedor.setCnpj_fornecedor(rs.getString("cnpj_fornecedor"));
                fornecedor.setTipo_fornecimento(rs.getString("tipo_fornecimento"));
                
                
                TodosFornecedores.add(fornecedor);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        
        }
        return TodosFornecedores;
    }
    
    
    
    
    
    
    
    
    
    public void update(Fornecedor d){
    
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE fornecedores  SET nome_fornecedor = ? , cnpj_fornecedor = ? , tipo_fornecimento = ?  WHERE id = ?");
            stmt.setString(1, d.getNome_fornecedor());
            stmt.setString(2, d.getCnpj_fornecedor());
            stmt.setString(3, d.getTipo_fornecimento());
            stmt.setInt(4, d.getId());
            
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }  
    
    public void delete(Fornecedor d){
    
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM fornecedores WHERE id = ?");
            stmt.setInt(1, d.getId());
           
            
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    } 
    
    
}
