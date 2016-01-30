/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.FCadMoto;
import view.FPesqMoto;

/**
 * classe3 ControllerMoto o "meio de campo" entre view e model 
 * @author dener
 */
public class ControllerMoto
{
    //cria fCadMoto
    private FCadMoto fCadMoto;
    //cria fPesqMoto
    private FPesqMoto fPesqMoto;
    
    /**
     * Construtor
     */
    public ControllerMoto()
    {
        //instancia fCadMoto
        fCadMoto = new FCadMoto(null, true);
        //instancia fPesqMoto
        fPesqMoto = new FPesqMoto(null, true);
        //chama função inicializarComponentes
        inicializarComponentes();
    }
    
    /**
     * função inicializar componentes que inicializa os componentes do form
     */
    private void inicializarComponentes()
    {
        //incicializando o botão limpar - chama o método limpar
        fCadMoto.btLimpar.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                limpar();
            }
        });
        //inicializaçao do botao cancelar - chama o metodo cancelar
        fCadMoto.btCancelar.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                cancelar();
            }
        });
    }
    
    /**
     * função CadastroMoto - onde será feita a lógica para cadastro de moto
     */
    public void CadastroMoto()
    {
        //torna o form de cadastro de moto visível
        fCadMoto.setVisible(true);
    }
    
    /**
     * função PesqMoto - onde será feita a lógica para pesquisa de motos
     */
    public void PesqMoto()
    {
        //torna o form de pesquisa de moto visível
        fPesqMoto.setVisible(true);
    }
    
    /**
     * método limpar - método que limpa od edits contidos na tela
     */
    private void limpar()
    {
        fCadMoto.cbMarca.setSelectedIndex(0);
        fCadMoto.edAno.setText(null);
        fCadMoto.edCilindradas.setText(null);
        fCadMoto.edCodigo.setText(null);
        fCadMoto.edModelo.setText(null);
        fCadMoto.edPreco.setText(null);
    }
    
    /**
     * metodo cancelar - simplismentefecha o dialog, setVisible(false)
     */
    private void cancelar()
    {
        fCadMoto.setVisible(false);
    }
    
}
