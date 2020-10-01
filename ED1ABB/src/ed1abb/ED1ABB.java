package ed1abb;

import comandos.ComandoLinux;
import arvoreBinariaBusca.ABB;
import java.util.Scanner;

public class ED1ABB {

    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String op;
        ABB arvore = new ABB();
        
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
                System.err.print(ex.getMessage() + "\n");
            }
            
            op = input.nextLine();
            
        }
    }
    
}
