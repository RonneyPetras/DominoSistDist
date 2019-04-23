
package Modelo;

import java.util.ArrayList;


public class Jogador {
    private final String nome;
    private ArrayList<Domino> mao = new ArrayList<>();
    
    public Jogador(String nome){
        this.nome = nome;
    }
    
    public void recebeMao(ArrayList<Domino> mao){
        this.mao = mao;
    }

    @Override
    public String toString() {
        return "Jogador{" + "nome=" + nome + ", mao=" + mao + '}';
    }
    
}
