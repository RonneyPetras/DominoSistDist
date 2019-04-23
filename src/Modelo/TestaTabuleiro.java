package Modelo;

public class TestaTabuleiro {
    public static void main(String[] args) {
        Jogador player1 = new Jogador("Ronney");
        Jogador CPU = new Jogador("CPU");
        
        Tabuleiro t = new Tabuleiro(player1, CPU);

        player1.recebeMao(t.distribuiDominos(14));
        CPU.recebeMao(t.distribuiDominos(14));
        
        System.out.println(player1);
        System.out.println(CPU);
        System.out.println(t);
    }
}
