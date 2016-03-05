/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Cliente;
import model.DaoCliente;
import view.FCadCliente;
import view.FPesqCliente;
import view.ModelCliente;

/**
 * classe ControllerCliente o "meio de campo" entre view e model
 * @author dener
 */
public class ControllerCliente
{
    //cria fCadCli
    private FCadCliente fCadCli;
    //cria fPesqCli
    private FPesqCliente fPesqCli;
    //cria daoCliente
    private DaoCliente daoCliente;
    //crai clienteAtual
    private Cliente clienteAtual;
    //cria sdf para tratar data
    private SimpleDateFormat sdf;
    //cria modelCliente para porder trabalhar como Table
    private ModelCliente modelCliente;
    
    /**
     * Contrutor
     */
    public ControllerCliente()
    {
        //instancia fCadCliente
        fCadCli = new FCadCliente(null, true);
        //instancia fPesqCli
        fPesqCli = new FPesqCliente(null, true);
        //instancia daoCliente
        daoCliente = new DaoCliente();
        //inicializa clienteAtual
        clienteAtual = null;
        //instancia sdf
        sdf = new SimpleDateFormat("dd/MM/yyyy");
        //instancia modelCliente
        modelCliente = new ModelCliente();        
        //chama função inicializarComponentes
        inicializarComponentes();
    }
    
    /**
     * função inicializar componentes que inicializa os componentes do form
     */
    private void inicializarComponentes()
    {
        //Setando o tableMode do formulário FPesqCli
        fPesqCli.tbCliente.setModel(modelCliente);
        
        //incicializando o botão limpar do formulário FCadCli- chama o método limpar
        fCadCli.btLimpar.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                limpar();
            }
        });
        //inicializaçao do botao cancelar do formulário FCadCli - chama o metodo cancelar
        fCadCli.btCancelar.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                cancelar();
            }
        });
        //inicialização do botão graver do formulário FCadCli  - chama o método gravar
        fCadCli.btGravar.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    gravar();
                } catch (ParseException ex)
                {
                    Logger.getLogger(ControllerCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        //iniclializa o  botão voltar do fomulário FPesCliente - chama o método cancelar
        fPesqCli.btVoltar.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                cancelar();
            }
        });
        //inicializa o botão editar do formulário FPesqCli -
        fPesqCli.btEditar.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    editarCliente();
                } catch (ParseException ex)
                {
                    Logger.getLogger(ControllerCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        //inicializa o botão excluir do formulário FPesqCli
        fPesqCli.btExcluir.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                excluir();
            }
        });
        //inicializa o botão novo do formulario FPesqCliente
        fPesqCli.btNovo.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e)
            {                
                novoCliente();
            }
        });
    }
           
    /**
     * método limpar - método que limpa od edits contidos na tela
     */
    private void limpar()
    {
        // ao limpara capos formatados utiliza-se o campo.setValue(null);
        fCadCli.edCodigo.setText(null);
        fCadCli.edNome.setText(null);
        fCadCli.edfEmail.setText(null);
        fCadCli.edfCelular.setValue(null);
        fCadCli.edfCpf.setValue(null);
        fCadCli.edfNasc.setValue(null);
        fCadCli.edfTelefone.setValue(null);
    }
    
    /**
     * metodo cancelar - simplismentefecha o dialog, setVisible(false)
     */
    private void cancelar()
    {
        fCadCli.setVisible(false);
        fPesqCli.setVisible(false);
    }
    
    /**
     * método gravar - método para graver e editar os clientes no banco de dados
     */
    private void gravar() throws ParseException 
    {
        // criação da String sDate para pegar a data do formulário
        String sData = fCadCli.edfNasc.getText();
        // converção da String sData em um tipo Date
        java.sql.Date data = new java.sql.Date(sdf.parse(sData).getTime());
        // Aqui é feita a lógica para inserir um cliente
        // caso cliente atual esteje null então é instanciado um novo cliente com os ddados obtidos da tela
        // é inserido no banco através do DAO
        if (clienteAtual == null)
        {
            //utiliza-se o zero no id pois estou utilizando uma sequence para
            //gerar os códigos automaticamente.
            Cliente c = new Cliente(0,
                    fCadCli.edfCpf.getText(),
                    fCadCli.edNome.getText(),
                    data,
                    fCadCli.edfEmail.getText(),
                    fCadCli.edfTelefone.getText(),
                    fCadCli.edfCelular.getText());
            
            if(daoCliente.inserir(c))
            {
                JOptionPane.showMessageDialog(fCadCli, "Cliente inserido com Sucesso ...");
                limpar();
                fCadCli.setVisible(false);
            }
            else
            {
                JOptionPane.showMessageDialog(fCadCli, "Erro ao inserir Cliente ...");
            }
        }
        // Aqui é feita a lógica para atualizar um cliente
        // caso a condição aterior "if (clienteAtual == null){ ...}", não for satisfeita 
        // é atualizado no banco através do DAO
        else
        {
            //aqui utiliza-se o integer.parseInt para poder pegar o id para atualizar, senão ele iria passar o id 0 sempre
            Cliente c = new Cliente(Integer.parseInt(fCadCli.edCodigo.getText()),
                    fCadCli.edfCpf.getText(),
                    fCadCli.edNome.getText(),
                    data,
                    fCadCli.edfEmail.getText(),
                    fCadCli.edfTelefone.getText(),
                    fCadCli.edfCelular.getText());
            
            if(daoCliente.atualizar(c))
            {
                JOptionPane.showMessageDialog(fCadCli, "Cliente Editado com Sucesso ...");
                fCadCli.setVisible(false);
            }
            else
            {
                JOptionPane.showMessageDialog(fCadCli, "Erro ao Editar o Cliente ...");
            }
        }
    }
    
    /**
     * método editarCliente - método para editar um cliente, atualizá-lo
     */
    private void editarCliente() throws ParseException
    {
        //String sDate = sdf.format(clienteAtual.getDataNasc().toString());
        int posicao = fPesqCli.tbCliente.getSelectedRow();
        if(posicao >= 0)
        {
            clienteAtual = modelCliente.getCliente(posicao);
            fCadCli.edCodigo.setText(Integer.toString(clienteAtual.getIdCliente()));
            fCadCli.edfCpf.setText(clienteAtual.getCpf());
            fCadCli.edNome.setText(clienteAtual.getNome());
            fCadCli.edfNasc.setText(sdf.format(clienteAtual.getDataNasc()));
            fCadCli.edfEmail.setText(clienteAtual.getEmail());
            fCadCli.edfTelefone.setText(clienteAtual.getTelefone());
            fCadCli.edfCelular.setText(clienteAtual.getCelular());     
            fCadCli.edCodigo.setEditable(false);
            fCadCli.btLimpar.setEnabled(false);
            fCadCli.setVisible(true);
            carregarClienteModel();
        } else
        {
            JOptionPane.showMessageDialog(null, "Selecione um cliente");
        }
        
    }
    
    /**
     * método excluir - método para exdcluir um cliente
     */
    private void excluir()
    {
        //variável posição recebe o valor recorente a linha da tabela
        int posicao = fPesqCli.tbCliente.getSelectedRow();
        if(posicao >= 0)
        {
            clienteAtual = modelCliente.getCliente(posicao);
            if(daoCliente.excluir(clienteAtual))
            {
                JOptionPane.showMessageDialog(null, "cliente removido com sucesso");
                modelCliente.removeCliente(posicao);
            } else
            {
                JOptionPane.showMessageDialog(null, "Erro ao remover o cliente");
            } 
        } else
        {
            JOptionPane.showMessageDialog(null, "Selecione um cliente para excluir");
        }
    }
    
    /**
     *  método carregarClienteModel - serve para carregar os clientes no tablemodel pesquisando no banco
     */
    private void carregarClienteModel()
    {
        modelCliente.limpar();
        ArrayList<Cliente> listaCliente = daoCliente.listar();
        for (Cliente c : listaCliente)
        {
            modelCliente.addCliente(c);
        }
    }
   
    /**
     * função CadastroCliente - onde será feita a lógica para cadastro de cliente
     */
    public void CadastroCliente()
    {
        limpar();
        //torna o form de cadastro de cliente visível
        fCadCli.setVisible(true);
    }
    
    /**
     * função PesqCliente - onde será feita a lógica para pesquisa de cliente
     */
    public void PesqCliente()
    {
        //chama o método carregarClienteModel()
        carregarClienteModel();
        //torna o form de pesquisa de vliente visível
        fPesqCli.setVisible(true);
    }
    
    /**
     * método novoCliente caso não exista cliente cadastrado na lista clica no botão 
     * novo e abre o formulario de cadastro de cliente
     */
    public void novoCliente()
    {
        fCadCli.setVisible(true);
        carregarClienteModel();
    }
}
