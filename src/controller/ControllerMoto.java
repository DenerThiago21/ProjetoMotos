/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.DaoMoto;
import model.Moto;
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
    //cria daoMoto
    private DaoMoto daoMoto;
    //cria moto atual
    private Moto motoAtual;
    
    /**
     * Construtor
     */
    public ControllerMoto()
    {
        //instancia fCadMoto
        fCadMoto = new FCadMoto(null, true);
        //instancia fPesqMoto
        fPesqMoto = new FPesqMoto(null, true);
        //instance daoMoto
        daoMoto = new DaoMoto();
        //inicialize motoAtual
        motoAtual = null;
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
        //inicialização do botão gravar - chama o méto gravar
        fCadMoto.btGravar.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                gravar();
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
    
    /**
     * mthod gravar - método que contém a gravação e edição de uma moto
     */
    private void gravar()
    {
        //pega a Sting contida num indice do combobox
        String marca = String.valueOf(fCadMoto.cbMarca.getSelectedItem());
        // converte o ano pego na tela em inteiro
        int ano = Integer.parseInt(fCadMoto.edAno.getText());
        // converte as cilindradas pegas da tela em inteiro
        int cilindradas = Integer.parseInt(fCadMoto.edCilindradas.getText());
        // pega o proço da tela e converte em double
        double preco = Double.parseDouble(fCadMoto.edPreco.getText());
        
        // aqui fica a lógica para inserir uma moto no banco de dados
        // casp moto atual é nulo .. então é instanciado uma moto com os valores obtidos da tela
        // é inserido no banco através do DAO
        if(motoAtual == null)
        {
            //utiliza-se o zero no id pois estou utilizando uma sequence para
            //gerar os códigos automaticamente.
            Moto m = new Moto(0,
                            marca,
                            fCadMoto.edModelo.getText(),
                            ano,
                            cilindradas,
                            preco);
            
            if(daoMoto.inserir(m))
            {
                JOptionPane.showMessageDialog(fPesqMoto, "Moto inserida com sucesso...");
                limpar();
            }else
            {
                JOptionPane.showMessageDialog(fPesqMoto, "Erro ao inserir uma moto...");
            }
        }
    }
}
