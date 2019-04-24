package Modelo;

import Controle.Controlador;

public class TestaJogo {
    public static void main(String[] args) {
        Jogador p1 = new Jogador("Ronney");
        Jogador CPU = new Jogador("CPU");
        
        Controlador c = new Controlador(new Jogo(p1,CPU));
        c.distribuiDominosEntreJogadores();
        
        c.primeiraJogada();
        
        System.out.println(p1.getMao());
        System.out.println(CPU.getMao());
        
        
        c.validaJogada(p1, 0, true);
        c.validaJogada(CPU, 0, true);
        c.validaJogada(p1, 1, false);
        c.validaJogada(CPU, 1, false);
        
        System.out.println(c.getJogadas());
        
    }
}
