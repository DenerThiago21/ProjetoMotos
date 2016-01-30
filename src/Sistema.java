
import controller.ControllerPrincipal;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * classe Sistema - essa é a classe que executa tudo, por aqui começa o sistema
 * Projeto Motos - Sistema de uma loja de motos simpres
 * @author dener
 */
public class Sistema
{
    /**
     * método Main - p principal metodo do programa, aqui começa a mágica
     * @param args 
     */
    public static void main(String[] args)
    {
        // criação e instanciação do objeto controllerprincipal
        ControllerPrincipal ctlrPrincipal = new ControllerPrincipal();
        // chamada para executar em ctlrPrincipal
        ctlrPrincipal.executar();
    }   
}
