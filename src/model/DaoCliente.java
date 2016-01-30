/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.ConexaoPostgree;

/**
 * classe DaoCliente - classe DAO de cliente onde fica toda a logica para manipulação em banco de dados
 * @author dener
 */
public class DaoCliente
{
    /**
     * método inserir - insere um cliente no banco de dados
     * @param cliente
     * @return comando
     */
    public boolean inserir(Cliente cliente)
    {
        //prepara o comando
        PreparedStatement comando = null;
        try
        {
            java.util.Date d = cliente.getDataNasc();
            //cria a query e passa os valores
            comando = ConexaoPostgree.getConexaoPostgree().prepareStatement("insert into tbcliente (idcliente, cpf, nome, datanasc, "
                    + "email, telefone, celular) values (nextval('tbcliente_seq'),?,?,?,?,?,?)");
            //comando.setInt(1, cliente.getIdCliente());
            comando.setString(1, cliente.getCpf());
            comando.setString(2, cliente.getNome());
            comando.setDate(3, (Date) d);
            comando.setString(4, cliente.getEmail());
            comando.setString(5, cliente.getTelefone());
            comando.setString(6, cliente.getCelular());
            //executa o comando
            return (comando.executeUpdate() > 0);
        }catch (SQLException e)
        {
            System.out.println("erro "+e);
            return false;
        }finally
        {
            ConexaoPostgree.fecharConnection();
        }
    }
    
    /**
     * métudo atualizar - método que atualiza as informações no banco de dados
     * @param cliente
     * @return comando
     */
    public boolean atualizar(Cliente cliente)
    {
        //prepara comando
        PreparedStatement comando = null;
        try
        {
            //cria uma String com a query
            String sql = "update tbcliente set idcliente ="+cliente.getIdCliente()+
                    ", cpf= '"+cliente.getCpf()+"'"+
                    ", nome='"+cliente.getNome()+"'"+
                    ", datanasc= '"+cliente.getDataNasc()+"'"+
                    ", email='"+cliente.getEmail()+"'"+
                    ", telefone='"+cliente.getTelefone()+"'"+
                    ", celular='"+cliente.getCelular()+"'"+
                    "where idcliente = "+cliente.getIdCliente();
           
            comando = ConexaoPostgree.getConexaoPostgree().prepareStatement(sql);
            System.out.println(sql);
            //executa o comando
            return(comando.executeUpdate() > 0);
        } catch (SQLException e)
        {
            return false;
        }finally
        {
            ConexaoPostgree.fecharConnection();
        }
    }
    
    /**
     * método Listar - que executa uma query que retorna todos os dados de uma tabela e armazena em um ArrayList
     * @return  ArrayList<Cliente> listaCliente
     */
    public ArrayList<Cliente> listar()
    {
        Statement comando = null;
        
        try
        {
            //criação do statement
            comando = ConexaoPostgree.getConexaoPostgree().createStatement();
            //execução da query
            ResultSet resultado = comando.executeQuery("select * from tbcliente");
            ArrayList<Cliente> listaCliente = new ArrayList<>();
            while (resultado.next())
            {
                Cliente c = new Cliente();
                c.setIdCliente(resultado.getInt("idcliente"));
                c.setCpf(resultado.getString("cpf"));
                c.setNome(resultado.getString("nome"));
                c.setDataNasc(resultado.getDate("datanasc"));
                c.setEmail(resultado.getString("email"));
                c.setTelefone(resultado.getString("telefone"));
                c.setCelular(resultado.getString("celular"));
                
                listaCliente.add(c);
            }
            return listaCliente;
        } catch (SQLException ex)
        {
            return null;
            //Logger.getLogger(DaoCliente.class.getName()).log(Level.SEVERE, null, ex);
        }finally
        {
            ConexaoPostgree.fecharConnection();
        }
    }
}


