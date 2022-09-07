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

/**
 *
 * @author Yuri
 */
public class ProjetosDAO {
    public void create(Projetos p){
    
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO Projetos (nome_projeto,cliente,valor_contrato,status_projeto,status_pagamento,gasto_materiais)VALUES(?,?,?,?,?,?)");
            stmt.setString(1, p.getNome_projeto());
            stmt.setString(2, p.getCliente());
            stmt.setInt(3, p.getValor_contrato());
            stmt.setString(4, p.getStatus_projeto());
            stmt.setString(5, p.getStatus_pagamento());
            stmt.setInt(6, p.getGasto_materiais());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    
    
    public List<Projetos> read(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Projetos> TodosProjetos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM Projetos");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Projetos Projetos = new Projetos();
                
                Projetos.setId(rs.getInt("id"));
                Projetos.setNome_projeto(rs.getString("nome_projeto"));
                Projetos.setCliente(rs.getString("cliente"));
                Projetos.setValor_contrato(rs.getInt("valor_contrato"));
                Projetos.setStatus_projeto(rs.getString("status_projeto"));
                Projetos.setStatus_pagamento(rs.getString("status_pagamento"));
                Projetos.setGasto_materiais(rs.getInt("gasto_materiais"));
                
                TodosProjetos.add(Projetos);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProjetosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        
        }
        return TodosProjetos;
    }
    
    
    
    
    
    
    
    
    
    public void update(Projetos p){
    
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE Projetos  SET nome_projeto = ? , cliente = ? , valor_contrato = ? , status_projeto = ?, status_pagamento = ?, gasto_materiais = ? WHERE id = ?");
            stmt.setString(1, p.getNome_projeto());
            stmt.setString(2, p.getCliente());
            stmt.setInt(3, p.getValor_contrato());
            stmt.setString(4, p.getStatus_projeto());
            stmt.setString(5, p.getStatus_pagamento());
            stmt.setInt(6, p.getGasto_materiais());
            stmt.setInt(7, p.getId());
            
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }  
    
    public void delete(Projetos p){
    
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM Projetos WHERE id = ?");
            stmt.setInt(1, p.getId());
           
            
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    } 
    
    public double relatorioMaterial(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
       double somatorio = 0;
        
        try {
            stmt = con.prepareStatement("SELECT gasto_materiais FROM Projetos");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                somatorio = rs.getDouble("gasto_materiais") + somatorio;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProjetosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        
        }
        return somatorio;
    
    
    }
    
    public double relatorioContrato(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
       double somatorio = 0;
        
        try {
            stmt = con.prepareStatement("SELECT valor_contrato FROM Projetos");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                somatorio = rs.getDouble("valor_contrato") + somatorio;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProjetosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        
        }
        return somatorio;
    
    
    }

  
    
}
