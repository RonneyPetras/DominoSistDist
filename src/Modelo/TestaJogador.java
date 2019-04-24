package Modelo;

public class TestaJogador {
    public static void main(String[] args) {
        Jogador p1 = new Jogador("Ronney");
        Jogador CPU = new Jogador("CPU");

        Jogo t = new Jogo(p1, CPU);

        
    }
}
