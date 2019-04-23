package Modelo;

public class TestaJogador {
    public static void main(String[] args) {
        Jogador p1 = new Jogador("Ronney");
        Jogador CPU = new Jogador("CPU");

        Jogo t = new Jogo(p1, CPU);

        System.out.println(p1);
        System.out.println("");
        
        p1.deita(p1.dominoNumero(1));
        System.out.println(p1);
        System.out.println("");
        
        p1.deita(0);
        System.out.println(p1);
    }
}
