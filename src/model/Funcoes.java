package model;

import javax.swing.JOptionPane;

/**
 *
 * @author aluno.laboratorio
 */
public class Funcoes {
    int cont = 0,col=0,COLUNA = 10,local = 0,contador = 0,contador2 = 0;
    boolean achou = false,validar;
    String[] modelo = new String[10];
    String[][] nomePeca = new String[modelo.length][COLUNA];
    double[][] preco = new double[modelo.length][COLUNA];
    int[][] quantidade = new int[modelo.length][COLUNA];
    String resposta = "";
   
    public void cadastro(){
        modelo[cont] = JOptionPane.showInputDialog(null, "Insira o modelo do carro");
        do{
            nomePeca[cont][col] = JOptionPane.showInputDialog(null, "Insira o nome da peça do "+ modelo[cont]);
            preco[cont][col] = Double.parseDouble(JOptionPane.showInputDialog(null,"Insira o preço da peça do "+ modelo[cont]));
            quantidade[cont][col] = Integer.parseInt(JOptionPane.showInputDialog(null,"Insira a quantidade desta peça do "+ modelo[cont]));
            resposta = JOptionPane.showInputDialog("Deseja cadastrar mais alguma peça pra esse modelo?s/n");
            col++;
        }while(resposta.equalsIgnoreCase("s"));
        cont++;
    }
    
    //alterar cadastro
    public void cadastro(int posicao){
        modelo[posicao] = JOptionPane.showInputDialog(null, "Modelo do "+ (posicao+1) + "° carro");
        nomePeca[posicao][posicao] = JOptionPane.showInputDialog(null, "Nome da peça");
        preco[posicao][posicao] = Double.parseDouble(JOptionPane.showInputDialog(null,"Preço da peça "));
        quantidade[posicao][posicao] = Integer.parseInt(JOptionPane.showInputDialog(null,"Quantidade de peça"));
    }
    
    public void pesquisar(String valor){
        for (int i = 0; i < modelo.length; i++) {
            if(valor.equals(modelo[i])){
                local = i;
                achou  = true;
            }
        }
        if(achou){
            for (int i = 0; i < nomePeca[0].length; i++) {
                System.out.print("Nome da peça: "+nomePeca[local][i]);
                System.out.print("\nvalor da peça: "+preco[local][i]);
                System.out.println("\nquantidade em estoque: "+quantidade[local][i]);
            }
        }else{
            System.out.println("Não existe esse nome ou não foi cadastrado");
        }
    }
    
    public void mostrar(){  
       //mostrar matriz por matriz
        for (int i = 0; i < modelo.length ; i++) {
            if(modelo[i] != null){
                System.out.println("----------------------------------------------");
                System.out.println("Modelo: "+modelo[i]+" ");
            }else{
                validar = true;
            }
            for (int j = 0; j < nomePeca[0].length; j++) {
                if(nomePeca[i][j] != null){
                    System.out.print("Peça: "+nomePeca[i][j]+"  ");
                    System.out.println(" ");
                    System.out.print("preço: "+preco[i][j]+" R$");     
                    System.out.println(" ");
                    System.out.print("Quantidade: "+quantidade[i][j]);
                    System.out.println(" ");
                }
            }
        }
        if(validar){
            System.out.println("Efetue um cadastro!");
        }
    }
    
    public void alterar(String peca){
        for (int i = 0; i < nomePeca.length; i++) {
            for (int j = 0; j < nomePeca[0].length; j++) {
                if(peca.equals(nomePeca[i][j])){
                    System.out.print("Peça: "+nomePeca[i][j]+"  ");
                    System.out.println(" ");
                    System.out.print("preço: "+preco[i][j]);     
                    System.out.println(" ");
                    System.out.print("Quantidade: "+quantidade[i][j]);
                    System.out.println(" ");
                    System.out.println("=============================");
                    cadastro(i);
                }
            }
        }
    }


}
    
