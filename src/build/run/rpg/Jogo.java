package build.run.rpg;

import java.util.Scanner;

public class Jogo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // 1.Mostrar  menu de herois
        Heroi guerreiro = new Heroi
                ("Guerreiro", 100, 20, 10, "Guerreiro", 1, 1, "Corte dimencional!");
        Heroi mago = new Heroi
                ("Mago", 80, 25, 5, "Mago", 1, 2, "Bola de fogo!");
        Heroi arqueiro = new Heroi
                ("Arqueiro", 90, 18, 8, "Arqueiro", 3, 1, "Raio negro!");

        mostrarApresentacoes(guerreiro, mago, arqueiro);
        // 2.user seleciona seu heroi
        int menuSelecao = sc.nextInt();
        Heroi heroiSelecionado = selecionarHeroi(menuSelecao, guerreiro, mago, arqueiro);

        // 3.Monstrar o monstro
        Monstro dragao = new Monstro
                ("Dragão", 100, 15, 5, 2, "Vento da Morte!", 0.2);
        dragao.monstrarApresentacao();
        // 4. Começar os turnos
        boolean jogoAcabou = false;
        do {
            // 4.1 turno do heroi
            realizarTurnoDoHeroi(sc, heroiSelecionado, dragao);

            if(dragao.estaMorto()){
                jogoAcabou = true;
                System.out.println("Você Eliminou o Dragão!");
            }
            // 4.2 monstrar vidas
            heroiSelecionado.monstrarVida();
            dragao.monstrarVida();

            // 4.3 executa o turno do monstro
            realizarTurnoDragao(dragao, heroiSelecionado);

            // 4.4 mostrar as vidas
            heroiSelecionado.monstrarVida();
            dragao.monstrarVida();

            // 4.5 verificar vidas e finalizar (se for o caso) loop
            if(heroiSelecionado.estaMorto()){
                System.out.println("Você morreu!");
            }
            if(dragao.estaMorto()){
                jogoAcabou = true;
                System.out.println("Você Eliminou o Dragão!");
            }

        } while (!jogoAcabou);

    }

    private static void realizarTurnoDragao(Monstro dragao, Heroi heroiSelecionado) {
        System.out.println("### Turno do Dragão ###");
        dragao.regenerarVida();
        dragao.atacar(heroiSelecionado);
    }

    private static void realizarTurnoDoHeroi(Scanner sc, Heroi heroSelecionado, Monstro dragao) {
        System.out.println("\n Seu Truno!");
        System.out.println("1. Atacar / 2. Usar Habilidade especial / 3. Beber poção de vida");
        int opcaoAtaque = sc.nextInt();

        switch (opcaoAtaque) {
            case 1 -> heroSelecionado.atacar(dragao);
            case 2 -> heroSelecionado.usarAtaqueEspecial(dragao);
            case 3 -> heroSelecionado.usarPocaoVida();
        }
    }

    private static Heroi selecionarHeroi(int menuSelecao, Heroi guerreiro, Heroi mago, Heroi arqueiro) {
        switch (menuSelecao) {
            case 1 -> {
                return guerreiro;
            }
            case 2 -> {
                return mago;
            }
            case 3 -> {
                return arqueiro;
            }
        }
        ;
        return null;
    }

    private static void mostrarApresentacoes(Heroi guerreiro, Heroi mago, Heroi arqueiro) {
        System.out.println("Heróis disponívies:");
        System.out.print("1 - ");
        guerreiro.monstrarApresentacao();
        System.out.print("2 - ");
        mago.monstrarApresentacao();
        System.out.print("3 - ");
        arqueiro.monstrarApresentacao();

        System.out.println("Escolha o seu herói: ");
    }


}
