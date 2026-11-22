package build.run.rpg;

public class Heroi extends Personagem {
    private String classe;
    private int qtdAtaqueEspecial;
    private int qtdPocaVida;
    private String nomeAtaque;

    public Heroi(String nome, int vida, int ataque, int defesa, String classe, int qtdAtaqueEspecial, int qtdPocaVida, String nomeAtaque) {
        super(nome, vida, ataque, defesa);
        this.classe = classe;
        this.qtdAtaqueEspecial = qtdAtaqueEspecial;
        this.qtdPocaVida = qtdPocaVida;
        this.nomeAtaque = nomeAtaque;
    }

    @Override
    public void monstrarApresentacao() {
        System.out.println(this.nome + "(" + "Vida:" + this.vida + "," + "Ataque:" + this.ataque + "," + "Defesa:" + this.defesa + "," + "Especial:" + this.qtdAtaqueEspecial + "," + "Poção de vida:" + this.qtdPocaVida + ")");
    }

    @Override
    public void usarAtaqueEspecial(Personagem alvo) {
        boolean executarJogadaEspecial = this.executarJogadaEspecial();

        if(executarJogadaEspecial && qtdAtaqueEspecial > 0){
            int danoEspecial = (int) (this.ataque * 0.1);
            alvo.receberDano(danoEspecial);
            this.qtdAtaqueEspecial--;
            System.out.println(this.nome + ": Ataque Especial [" + this.nomeAtaque + "] realizado!");
        }else{
            System.out.println("Arrrg!! Ataque Especial não realizado!");
        }
    }
    public void usarPocaoVida() {
        this.vida += 50;
        this.qtdPocaVida --;
    }

}
