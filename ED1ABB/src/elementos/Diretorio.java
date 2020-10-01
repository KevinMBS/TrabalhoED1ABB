package elementos;

import arvoreBinariaBusca.ABB;


public class Diretorio extends Arquivo{
    private ABB dir;

    public ABB getDir() {
        return dir;
    }

    public void setDir(ABB dir) {
        this.dir = dir;
    }
    public Diretorio(String chave) {
        super(chave);
    }
    
}
