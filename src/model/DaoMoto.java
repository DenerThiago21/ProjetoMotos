/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;
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
                    + "cilidradas, preco) values (nextval('tbmoto_seq'),?,?,?,?,?)");
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
}
