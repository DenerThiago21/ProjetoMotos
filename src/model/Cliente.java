/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 * classe Cliente que contém os dados de cliente
 * @author dener
 */
public class Cliente
{
    // dados
   private int idCliente;
    private String cpf;
    private String nome;
    private Date dataNasc;
    private String email;
    private String telefone;
    private String celular;

    // construtor vazio
    public Cliente()
    {
        
    }

    // construtor preenchido
    public Cliente(int idCliente, String cpf, String nome, Date dataNasc, String email, String telefone, String celular)
    {
        this.idCliente = idCliente;
        this.cpf = cpf;
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.email = email;
        this.telefone = telefone;
        this.celular = celular;
    }

    // sets e gets
    public int getIdCliente()
    {
        return idCliente;
    }

    public void setIdCliente(int idCliente)
    {
        this.idCliente = idCliente;
    }

    public String getCpf()
    {
        return cpf;
    }

    public void setCpf(String cpf)
    {
        this.cpf = cpf;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public Date getDataNasc()
    {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc)
    {
        this.dataNasc = dataNasc;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getTelefone()
    {
        return telefone;
    }

    public void setTelefone(String telefone)
    {
        this.telefone = telefone;
    }

    public String getCelular()
    {
        return celular;
    }

    public void setCelular(String celular)
    {
        this.celular = celular;
    }

    // toString
    @Override
    public String toString()
    {
        return "Cliente{" + "cpf=" + cpf + 
                            ", nome=" + nome + 
                            ", dataNasc=" + dataNasc + 
                            ", email=" + email + 
                            ", telefone=" + telefone + 
                            ", celular=" + celular + '}';
    }
    
    
}
