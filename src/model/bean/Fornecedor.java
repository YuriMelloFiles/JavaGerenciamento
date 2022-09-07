/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author Yuri
 */
public class Fornecedor {
    private int id;
    private String nome_fornecedor;
    private String cnpj_fornecedor;
    private String tipo_fornecimento;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome_fornecedor() {
        return nome_fornecedor;
    }

    public void setNome_fornecedor(String nome_fornecedor) {
        this.nome_fornecedor = nome_fornecedor;
    }

    public String getCnpj_fornecedor() {
        return cnpj_fornecedor;
    }

    public void setCnpj_fornecedor(String cnpj_fornecedor) {
        this.cnpj_fornecedor = cnpj_fornecedor;
    }

    public String getTipo_fornecimento() {
        return tipo_fornecimento;
    }

    public void setTipo_fornecimento(String tipo_fornecimento) {
        this.tipo_fornecimento = tipo_fornecimento;
    }
    
}
