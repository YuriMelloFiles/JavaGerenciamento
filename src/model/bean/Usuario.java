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
public class Usuario {
    private int id;
    private String login;
    private String senha;
    private String tipo_login;

    public String getTipo_login() {
        return tipo_login;
    }

    public void setTipo_login(String tipo_login) {
        this.tipo_login = tipo_login;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
    
}
