/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.FPrincipal;

/**
 * classe Controllerprincipal o "meio de campo" etntre view w model
 * @author dener
 */
public class ControllerPrincipal
{
    //cria form principal
    private FPrincipal fPrin;
    //cria  controle de cliente
    private ControllerCliente ctlrCliente;
    //cria controle de moto
    private ControllerMoto ctlrMoto;
    
    /**
     * construtor de ControllerPrincipal
     */
    public ControllerPrincipal()
    {
        //instancia fPrin
        fPrin = new FPrincipal();
        //instancia ctlrCliente
        ctlrCliente = new ControllerCliente();
        //instãncia ctlrMoto
        ctlrMoto = new ControllerMoto();
        //chama função inicializarComponentes
        inicializarComponentes();
    }
    
    /**
     * função inicializarComponentes - que trabalha em cima das ações(exemplo trabalha com ações do menu)
     */
    private void inicializarComponentes()
    {
        //evento do menu de cadastro de cliente
        fPrin.miCadCliente.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                //chama a função 
                executarCadatroCliente();
            }
        });
        //evento do menu de cadastro de moto
        fPrin.miCadMoto.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                //chama a função
                executarCadastroMoto();
            }
        });
        //evento de menu de pesquisa de cliente
        fPrin.miPesqCliente.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                //chama a função
                executarPesquisaCliente();
            }
        });
        //evento de emnu de pesquisa de moto
        fPrin.miPesqMoto.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                //chama a função
                executarPesquisaMoto();
            }
        });
       
    }
    
    //função executarCadastroCliente
    private void executarCadatroCliente()
    {
        //acessa o controle de cliente que cham a a função CadastroCliente
        ctlrCliente.CadastroCliente();
    }
    // função executarPesquisaCliente
    private void executarPesquisaCliente()
    {
        //acessa o controle de cliente que chama a função PesqCliente
        ctlrCliente.PesqCliente();
    }
    //função executarCadastroMoto
    private void executarCadastroMoto()
    {
        //acessa o controle de moto que chama a função CadastroMoto
        ctlrMoto.CadastroMoto();
    }
    //função executarPesquisaMoto
    private void executarPesquisaMoto()
    {
        //acess o controle de moto que chama a função pesqmoto
        ctlrMoto.PesqMoto();
    }
    //função executar
    public void executar()
    {
        //seta a tela como visível
        fPrin.setVisible(true);
    }
}
