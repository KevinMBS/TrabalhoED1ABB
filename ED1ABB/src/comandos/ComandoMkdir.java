package comandos;

import arvoreBinariaBusca.ABB;
import funcoes.Funcao;


public class ComandoMkdir implements Funcao{

    @Override
    public void fazFuncao(ABB arvore, String... resComando) throws Exception {
        System.out.println("Comando Mkdir");
    }
    
}
