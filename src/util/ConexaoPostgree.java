/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * classe ConexaPostgree - classe que contem os dados do banco de dados para conexão.
 * @author dener
 */
public class ConexaoPostgree
{
    public static String status = "não conectou!";
    
    /**
     * Construtor
     */
    public ConexaoPostgree()
    {
        
    }
    
    /**
     * método getConexaoPostgree - contém os dados do banco de dados.
     * @return 
     */
    public static java.sql.Connection getConexaoPostgree()
    {
        //cria connecrion que recebe null
        Connection connection = null;
        
        try
        {
            String driverName = "org.postgresql.Driver";
            Class.forName("org.postgresql.Driver");
            String serverName = "localhost:5432";
            String myDataBase = "moto";
            String url = "jdbc:postgresql://" + serverName + "/" + myDataBase;
            String username = "postgres";
            String password = "root";
            connection = DriverManager.getConnection(url, username, password);
            
            if(connection != null)
            {
                status=("STATUS: ...Conectado com Sucesso ...");
            }
            else
            {
                status=("STATUS: ...Não foi Possível realizar a Conexão ...");
            }
            return connection;
        } catch (ClassNotFoundException e)
        {
            System.out.println("O driver especificado não foi encontrado ... "+ e);
            return null;
        } catch (SQLException e)
        {
            System.out.println("Não foi possível conectar ao Banco de Dados ... "+ e);
            return null;
        }
    }
    
    //método para mostrar os status da conexão
    private String statusConnection()
    {
        return status;
    }
    
    //método para fechar a conexão
    public static boolean fecharConnection()
    {
        try
        {
            ConexaoPostgree.getConexaoPostgree().close();
            return true;
        } catch (SQLException e)
        {
            return false;
        }
    }
    
    //método para reiniciar a conexão
    private static java.sql.Connection reiniciarConnection()
    {
        fecharConnection();
        return ConexaoPostgree.getConexaoPostgree();
    }
}
