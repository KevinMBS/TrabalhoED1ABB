package TrabalhoED1_ArvoreBinaria.comandos;

import TrabalhoED1_ArvoreBinaria.elementos.ArvoreBinariaBusca;
import TrabalhoED1_ArvoreBinaria.funcoes.Funcao;


public class ComandoLs implements Funcao{

    @Override
    public void fazFuncao(ArvoreBinariaBusca arvore, String... resComando) throws Exception {
        System.out.println("Comando ls...");
    }
    
}
