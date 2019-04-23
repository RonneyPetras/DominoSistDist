package Modelo;

public class TestaJogo {
    public static void main(String[] args) {
        Jogador p1 = new Jogador("Ronney");
        Jogador CPU = new Jogador("CPU");
        
        Jogo j = new Jogo(p1, CPU);
        j.distribuiDominosEntreJogadores();
        j.novaJogada(p1, 0, Boolean.TRUE);
        j.novaJogada(CPU, 0, Boolean.TRUE);
        j.novaJogada(CPU, 1, Boolean.TRUE);
        j.novaJogada(CPU, 2, Boolean.TRUE);
        j.novaJogada(CPU, 3, Boolean.TRUE);
    }
}
