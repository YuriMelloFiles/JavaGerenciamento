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
public class Projetos {
    private int id;
    private String nome_projeto;
    private String cliente;
    private int valor_contrato;
    private String status_projeto;
    private String status_pagamento;
    private int gasto_materiais;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome_projeto() {
        return nome_projeto;
    }

    public void setNome_projeto(String nome_projeto) {
        this.nome_projeto = nome_projeto;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public int getValor_contrato() {
        return valor_contrato;
    }

    public void setValor_contrato(int valor_contrato) {
        this.valor_contrato = valor_contrato;
    }

    public String getStatus_projeto() {
        return status_projeto;
    }

    public void setStatus_projeto(String status_projeto) {
        this.status_projeto = status_projeto;
    }

    public String getStatus_pagamento() {
        return status_pagamento;
    }

    public void setStatus_pagamento(String status_pagamento) {
        this.status_pagamento = status_pagamento;
    }

    public int getGasto_materiais() {
        return gasto_materiais;
    }

    public void setGasto_materiais(int gasto_materiais) {
        this.gasto_materiais = gasto_materiais;
    }
    
}
