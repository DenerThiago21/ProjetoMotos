/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.AbstractTableModel;
import model.Cliente;

/**
 * Classe ModelCliente que extende de AbtractTableModel
 * Essa classe, é a classe que implementará os TableModel. que irá aparecer no Formulário.
 * @author dener
 */
public class ModelCliente extends AbstractTableModel
{
    private ArrayList<Cliente> listaCliente = new ArrayList<Cliente>();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    // imprementação dos métodos do AbstractTableModel
    /**
     * implementação do getRowCount que retorna o tamanho da lista de cliente.
     * @return listaCliente
     */
    @Override
    public int getRowCount()
    {
        return listaCliente.size();
    }

    /**
     * implementação do getColumnCount que retorna o tamnho das colunas
     * @return 7
     */
    @Override
    public int getColumnCount()
    {
        return 7;
    }

    /**
     * implementação do getValueAt passa por paramentros o indice de linhas e o indice de colunas
     * @param rowIndex
     * @param columnIndex
     * @return valores de clientes
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        // cria um cliente e retorna o mesmo buscando pela posição
        Cliente cliente = listaCliente.get(rowIndex);
        // percorre e de acordo com os casos, retorna o valor respectico contido.
        switch(columnIndex)
        {
            case 0:
            {
                return cliente.getIdCliente();
            }
            case 1:
            {
                return cliente.getCpf();
            }
            case 2:
            {
                return cliente.getNome();
            }
            case 3:
            {
                //return cliente.getDataNasc();
                return sdf.format(cliente.getDataNasc());
            }
            case 4:
            {                
                return cliente.getEmail();
            }
            case 5:
            {
                return cliente.getTelefone();
            }
            default:
            {
                return cliente.getCelular();
            }
        }
    }
    
    /**
     * método getColumnName - método que implementa título das colunas.
     * @param column
     * @return o nome das colunas de acrodo com os casos
     */
    @Override
    public String getColumnName(int column)
    {
        switch(column)
        {
            case 0:
            {
                return "id Cliente";
            }
            case 1:
            {
                return "CPF";
            }
            case 2:
            {
                return "Nome";
            }
            case 3:
            {
                return "Data Nasc.";
            }
            case 4:
            {
                return "Email";
            }
            case 5:
            {
                return "Telefone";
            }
            case 6:
            {                
                return "Celular";
            }
        }
        return null;
    }
    
    /**
     * método limpar - limpa a lista de cliente
     */
    public void limpar()
    {
        listaCliente.clear();
    }
    
    /**
     * método removeCliente - método que remove o cliente do teble model
     * @param posicao 
     */
    public void removeCliente(int posicao)
    {
        // remove de acordo com a posição passada por paramêtro
        listaCliente.remove(posicao);
        // utilização do fireTableRowsDeleted - para deletar a linha de acordo com a posição passada
        fireTableRowsDeleted(posicao, posicao);
    }
    
    /**
     * método getCliente - método que busca o cliente de acordo com a posição passada
     * @param posicao
     * @return listaCliente.get(posicao)
     */
    public Cliente getCliente(int posicao)
    {
        return listaCliente.get(posicao);
    }
            
    /**
     * método addCliente - método para adicionar cliente no TableModel
     * @param cliente 
     */
    public void addCliente(Cliente cliente)
    {
        //adiciona um cliente na lista
        listaCliente.add(cliente);
        //insere uma linha na tabela.
        fireTableRowsInserted(listaCliente.size() - 1, listaCliente.size() - 1);
    }
}
