/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.ConexaoPostgree;

/**
 * classe DaoMoto - classe DAO de moto onde fica a lógica para manipulação em banco de dados
 * @author dener
 */
public class DaoMoto
{
    /**
     * método inserir - insere uma moto no banco de dados
     * @param moto
     * @return 
     */
    public boolean inserir(Moto moto)
    {
        try
        {
            //prepara o comando
            PreparedStatement comando = null;
            //cria a query e passa os valores
            comando = ConexaoPostgree.getConexaoPostgree().prepareStatement("insert into tbmoto(idmoto, marca, modelo, ano, "
                    + "cilindradas, preco) values (nextval('tbmoto_seq'),?,?,?,?,?)");
            comando.setString(1, moto.getMarca());
            comando.setString(2, moto.getModelo());
            comando.setInt(3, moto.getAno());
            comando.setInt(4, moto.getCilindradas());
            comando.setDouble(5, moto.getPreco());
            //executa o comando
            return (comando.executeUpdate() > 0);
        } catch (SQLException ex)
        {
            System.out.println("erro: "+ ex);
            return false;
        }finally
        {
            ConexaoPostgree.fecharConnection();
        }
    }
    
    /**
     * método atualizar que utilizará uma query para atuaklizar determinado registro no banco de dados
     * @param moto
     * @return 
     */
    public boolean atualzar(Moto moto)
    {
        // prepara o comando
        PreparedStatement comando = null;
        try
        {
            // cria uma String com a query
            String sql = "update tbmoto set idmoto = "+moto.getIdMoto()+
                ", marca = '"+moto.getMarca()+"'"+
                ", modelo = '"+moto.getModelo()+"'"+
                ", ano = "+moto.getAno()+
                ", cilindradas = "+moto.getCilindradas()+
                ", preco = "+moto.getPreco()+
                " where idmoto = "+moto.getIdMoto();
            
            //System.out.println(sql);
            comando = ConexaoPostgree.getConexaoPostgree().prepareStatement(sql);
            //executa o comando
            return(comando.executeUpdate() > 0);
        } catch (SQLException ex)
        {
            return false;
        }finally
        {
            ConexaoPostgree.fecharConnection();
        }        
    }
    
    /**
     * implementação do método excluir que utilizará uma query para excluir determinado registro do banc de dados
     * @param moto
     * @return 
     */
    public boolean excluir(Moto moto)
    {
        // prepara o comando 
        PreparedStatement comando = null;
        try
        {
            // cria a query 
            String sql = "delete from tbmoto where idmoto = ?";
            // executa o comando
            comando = ConexaoPostgree.getConexaoPostgree().prepareStatement(sql);
            comando.setInt(1, moto.getIdMoto());
            return (comando.executeUpdate() > 0);
        } catch (SQLException ex)
        {
            return false;
        }finally
        {
            ConexaoPostgree.fecharConnection();
        }
    }
    
    /**
     * implementação do método listar que pega os valores contidos na tabela do banco e armazena em um arrayList
     * @return 
     */
    public ArrayList<Moto> listar()
    {
        Statement comando = null;
        
        try
        {
            // criaççao do statement
            comando = ConexaoPostgree.getConexaoPostgree().createStatement();
             // execução da query
            ResultSet resultado = comando.executeQuery("select * from tbmoto");
            ArrayList<Moto> listaMoto = new ArrayList<>();
            while(resultado.next())
            {
                Moto m = new Moto();
                m.setIdMoto(resultado.getInt("idmoto"));
                m.setMarca(resultado.getString("marca"));
                m.setModelo(resultado.getString("modelo"));
                m.setAno(resultado.getInt("ano"));
                m.setCilindradas(resultado.getInt("cilindradas"));
                m.setPreco(resultado.getDouble("preco"));
                
                listaMoto.add(m);
            }
            return listaMoto;
            
        } catch (SQLException ex)
        {
            return null;
        }finally
        {
            ConexaoPostgree.fecharConnection();
        }
       
    }
}
