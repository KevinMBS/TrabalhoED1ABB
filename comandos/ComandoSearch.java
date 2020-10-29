package TrabalhoED1_ArvoreBinaria.comandos;

import TrabalhoED1_ArvoreBinaria.elementos.Arquivo;
import TrabalhoED1_ArvoreBinaria.elementos.ArvoreBinariaBusca;
import TrabalhoED1_ArvoreBinaria.elementos.Diretorio;
import TrabalhoED1_ArvoreBinaria.funcoes.Funcao;

public class ComandoSearch implements Funcao{

    @Override
    public void fazFuncao(ArvoreBinariaBusca arvore, String... resComando) throws Exception {
        if(resComando.length == 2){
            System.out.println("Entrou aqui1");
            arvore.procuraChave(".", resComando[1]);
        }else if(resComando.length == 3){
            if(resComando[1].equals("-R")){
                //recursivo
            }else{
                //não recursivo
                System.out.println("Entrou aqui1");
                Arquivo dir = arvore.interpretaPath(resComando[1]);
                ((Diretorio)dir).getDir().procuraChave(resComando[1], resComando[2]);
            }
        }else{
            System.out.println("Deu errado parça");
        }
        
    }
    
}
