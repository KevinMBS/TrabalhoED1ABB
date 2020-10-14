package TrabalhoED1_ArvoreBinaria.comandos;

import TrabalhoED1_ArvoreBinaria.funcoes.Funcao;

public interface Comando {
    public abstract String getOpcao();
    public abstract Funcao getFuncao();
}
