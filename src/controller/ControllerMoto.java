/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.DaoMoto;
import model.Moto;
import view.FCadMoto;
import view.FPesqMoto;
import view.ModelMoto;

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
    // cria modelMoto para Trabalhar com o table
    private ModelMoto modelMoto;
    
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
        // instancia o modelMoto
        modelMoto = new ModelMoto();
        //chama função inicializarComponentes
        inicializarComponentes();
    }
    
    /**
     * função inicializar componentes que inicializa os componentes do form
     */
    private void inicializarComponentes()
    {
        // setando o table mode do Formulario FPesqMoto
        fPesqMoto.tbMoto.setModel(modelMoto);
        
        //INICIALIZAÇÃO DOS BOTÕES DO FORMULÁRIO FCadMoto
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
        
        //INICIALIZAÇÃO DOS BOTÕES DO FROMULÁRIO FPesMoto
        //inicializa o botão Voltar
        fPesqMoto.btVoltar.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                cancelar();
            }
        });
        //inicialização do botão Editar
        fPesqMoto.btEditar.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                editarMoto();
            }
        });
        //inicialização do botão Excluir
        fPesqMoto.btExcluir.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                excluir();
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
        carregarMotoModel();
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
        fPesqMoto.setVisible(false);
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
        // Aquie é feita a lógica para atualizar um cliente
        // caso a condição aterior "if (motoAtual == null){ ...}", não for satisfeita 
        // é atualizado no banco de dados através do DAO
        else
        {
            Moto m = new Moto(Integer.parseInt(fCadMoto.edCodigo.getText()),
                            marca,
                            fCadMoto.edModelo.getText(),
                            ano,
                            cilindradas,
                            preco);
            
            if(daoMoto.atualzar(m))
            {
                JOptionPane.showMessageDialog(fPesqMoto, "Moto Editada com sucesso...");
                fCadMoto.setVisible(false);
            }else
            {
                JOptionPane.showMessageDialog(fPesqMoto, "Erro ao Editar Moto...");
            }
        }
    }
    
    /**
     * implementação do método editarMoto
     */
    private void editarMoto()
    {
        int posicao = fPesqMoto.tbMoto.getSelectedRow();
        //pega a Sting contida num indice do combobox
        String marca = String.valueOf(fCadMoto.cbMarca.getSelectedItem());
        if(posicao >= 0)
        {
            motoAtual = modelMoto.getMoto(posicao);
            fCadMoto.edCodigo.setText(Integer.toString(motoAtual.getIdMoto()));
            fCadMoto.cbMarca.setSelectedItem(marca);
            fCadMoto.cbMarca.setSelectedItem(motoAtual.getMarca());
            fCadMoto.edModelo.setText(motoAtual.getModelo());
            fCadMoto.edAno.setText(Integer.toString(motoAtual.getAno()));
            fCadMoto.edCilindradas.setText(Integer.toString(motoAtual.getCilindradas()));
            fCadMoto.edPreco.setText(Double.toString(motoAtual.getPreco()));
            fCadMoto.edCodigo.setEditable(false);
            fCadMoto.btLimpar.setEnabled(false);
            fCadMoto.setVisible(true);
            carregarMotoModel();
        }else
        {
            JOptionPane.showMessageDialog(fPesqMoto, "Escolha uma moto...");
        }
    }
    
    /**
     * implementação do método excluir
     */
    private void excluir()
    {
        //variável posição revcebe a linha correspondentae na tabela
        int posicao = fPesqMoto.tbMoto.getSelectedRow();
        if(posicao >= 0)
        {
            motoAtual = modelMoto.getMoto(posicao);
            if(daoMoto.excluir(motoAtual))
            {
                JOptionPane.showMessageDialog(null, "Moto removida com Sucesso...");
                modelMoto.removeMoto(posicao);
            }else
            {
                JOptionPane.showMessageDialog(null, "Erro ao Remover Moto...");
            }
        }else
        {
            JOptionPane.showMessageDialog(null, "Selecione uma moto para excluir...");
        }
    }
    
    /**
     * implementação do método carregarMotoModel que carrega todas as motos em um array
     */
    private void carregarMotoModel()
    {
        modelMoto.limpar();
        ArrayList<Moto> listaMoto = daoMoto.listar();
        for(Moto m : listaMoto)
        {
            modelMoto.addMoto(m);
        }
    }
    
    /**
     * implementação da função cadastroMoto
     */
    public void cadastroMoto()
    {
        limpar();
        fCadMoto.setVisible(true);
    }
}
