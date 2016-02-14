/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.Moto;

/**
 * Classe ModelMoto que extende AbstractModel
 * Essa classe é a classe que implementa  o tableModel
 * @author dener
 */
public class ModelMoto extends AbstractTableModel
{
    private ArrayList<Moto> listaMoto = new ArrayList<Moto>();

    //implementação dos métodos do AbtractTable model    
    
    /**
     * método getRowCount que retorna o tamanho da lista de moto
     * @return listaMoto.size
     */
    @Override
    public int getRowCount()
    {
        return listaMoto.size();
    }
    
    /**
     * implementação de getColumnCount retorna 6 que é o numero de colunas
     * @return 6
     */
    @Override
    public int getColumnCount()
    {
        return 6;
    }
    
    /**
     *  implementação do método getValueAt que mostra as colunas formatadas
     * @param rowIndex
     * @param columnIndex
     * @return valores de moto
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        //cria um objeto motoque retorna uma moto, buscando pela posição
        Moto moto = listaMoto.get(rowIndex);
        // percorre e de acordo com os casos retorna o valor respectivo
        switch(columnIndex)
        {
            case 0:
            {
                return moto.getIdMoto();
            }
            case 1:
            {
                return moto.getMarca();
            }
            case 2:
            {
                return moto.getModelo();
            }
            case 3:
            {
                return moto.getAno();
            }
            case 4:
            {
                return moto.getCilindradas();
            }
            default:
            {
                return moto.getPreco();
            }
        }
    }
    
    /**
     * implementação do médoto getColumnName que mostra os títulos da tabela
     * @param column
     * @return null
     */
    public String getColumnName(int column)
    {
        switch(column)
        {
            case 0:
            {
                return "Cód.";
            }
            case 1:
            {
                return "Marca";
            }
            case 2:
            {
                return "Modelo";
            }
            case 3:
            {
                return "Ano";
            }
            case 4:
            {
                return "Cilindradas";
            }
            case 5:
            {
                return "Preço";
            }
        }
        return null;
    }
    
    /**
     * implementação do método limpar que limpa a lista de moto
     */
    public void limpar()
    {
        listaMoto.clear();
    }
    
    /**
     * implementação do método removeMoto que limpa a moto do table model
     * @param posicao 
     */
    public void removeMoto(int posicao)
    {
        //remove de acordo com a posição passada por parâmetro
        listaMoto.remove(posicao);
        //utilização de fireTableRowsDeleted - para remover a linha de acordo com a posição
        fireTableRowsDeleted(posicao, posicao);
    }
    
    /**
     * implementação getMoto que busca o cliente de acrodo com a posição passada
     * @param posicao
     * @return listaMoto
     */
    public Moto getMoto(int posicao)
    {
        return listaMoto.get(posicao);
    }
    
    /**
     * implementação do método addModo que adiciona uma moto no tableModel
     * @param moto 
     */
    public void addMoto(Moto moto)
    {
        //adiciona uma moto na lista
        listaMoto.add(moto);
        //insere uma linha na tabela
        fireTableRowsInserted(listaMoto.size() - 1, listaMoto.size() - 1);
    }
}
