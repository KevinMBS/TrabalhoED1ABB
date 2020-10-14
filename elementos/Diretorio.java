package TrabalhoED1_ArvoreBinaria.elementos;

public class Diretorio extends Arquivo{
    private ArvoreBinariaBusca dir;

    public ArvoreBinariaBusca getDir() {
        return dir;
    }

    public void setDir(ArvoreBinariaBusca dir) {
        this.dir = dir;
    }
    public Diretorio(String chave) {
        super(chave);
    }
    
}
