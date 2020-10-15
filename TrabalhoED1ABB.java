package TrabalhoED1_ArvoreBinaria;

import TrabalhoED1_ArvoreBinaria.elementos.ArvoreBinariaBusca;
import TrabalhoED1_ArvoreBinaria.comandos.ComandoLinux;
import java.util.Scanner;

public class TrabalhoED1ABB {

    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String op;
        ArvoreBinariaBusca arvore = new ArvoreBinariaBusca();
        
        System.out.println("Bem vindo ao terminal, digite um comando para iniciar:");
        op = input.nextLine();
        
        while(!op.equals("exit")){
            String[] comandoStrArray = op.split("\\s");
            //separa o comando dado pelo usuario em um array de Strings
            
            try {
                ComandoLinux comando = ComandoLinux.opcaoPelaString(comandoStrArray[0]);
                comando.getFuncao().fazFuncao(arvore, comandoStrArray);
                //A opção feita pelo usuario é recebida através de uma classe de Enum
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
            
            op = input.nextLine();
            
        }
    }
    
}
