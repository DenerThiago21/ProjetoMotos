/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * classe Moto - contém os dados de moto
 * @author dener
 */
public class Moto
{
    // dados
    private int idMoto;
    private String marca;
    private String modelo;
    private int ano;
    private int cilindradas;
    private double preco;

    // construtor vazio
    public Moto()
    {
        //this.idMoto = idMoto;
    }

    // construtor preenchido
    public Moto(int idMoto, String marca, String modelo, int ano, int cilindradas, double preco)
    {
        this.idMoto = idMoto;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.cilindradas = cilindradas;
        this.preco = preco;
    }

    // sets e gets
    public int getIdMoto()
    {
        return idMoto;
    }

    public void setIdMoto(int idMoto)
    {
        this.idMoto = idMoto;
    }

    public String getMarca()
    {
        return marca;
    }

    public void setMarca(String marca)
    {
        this.marca = marca;
    }

    public String getModelo()
    {
        return modelo;
    }

    public void setModelo(String modelo)
    {
        this.modelo = modelo;
    }

    public int getAno()
    {
        return ano;
    }

    public void setAno(int ano)
    {
        this.ano = ano;
    }

    public int getCilindradas()
    {
        return cilindradas;
    }

    public void setCilindradas(int cilindradas)
    {
        this.cilindradas = cilindradas;
    }

    public double getPreco()
    {
        return preco;
    }

    public void setPreco(double preco)
    {
        this.preco = preco;
    }

    // toString
    @Override
    public String toString()
    {
        return "Moto{" + "idMoto=" + idMoto + 
                        ", marca=" + marca + 
                        ", modelo=" + modelo + 
                        ", ano=" + ano + 
                        ", cilindradas=" + cilindradas + 
                        ", preco=" + preco + '}';
    }
    
}
