/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.InputMismatchException;
import java.util.Scanner;
import javax.swing.JOptionPane;
import model.Funcoes;

/**
 *
 * @author aluno.laboratorio
 */
public class Principal {
    //perguntas comuns com retorno em string
    public static String message(String frase){
        String pesquisa = JOptionPane.showInputDialog(null, frase);
        return pesquisa; 
    }
    
    public static void main(String[] args) {
        
        Funcoes f = new Funcoes();
        int opcao;
        Scanner ler = new Scanner(System.in);
        String x = "==============================================================================",y = "MENU:";
        boolean status = true;
        do{
            try{
                opcao = Integer.parseInt(JOptionPane.showInputDialog(null,y+"\n1) Cadastrar peça\n2) Pesquisar\n3) Alterar dados\n4) Consultar\n0) Sair\n"+x+"\nEscolha:"));

                switch(opcao){
                    case 0:
                        status = false;
                    break;
                    case 1:
                        f.cadastro();
                    break;
                    case 2:
                        f.pesquisar(message("Qual modelo deseja pesquisar?"));
                    break;
                    case 3:
                        f.alterar(message("Qual modelo deseja alterar"));
                    break;
                    case 4:
                       f.mostrar();
                    break;
                    default:
                        System.out.println("insira uma opcao válida");
                }

            }catch(InputMismatchException e){
                System.out.println("Insira apenas números");
            }
        }while(status);

    }
}
