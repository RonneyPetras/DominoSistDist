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

    public Domino deita(Domino domino){
        int idex = mao.indexOf(domino);
        if(this.mao.isEmpty()){
            System.out.println("Mão está vazia");
            return null;
        }else{
            return mao.remove(idex);
        }  
    }
    
    public Domino deita(int dominoPosicao){
        if(this.mao.isEmpty()){
            System.out.println("Mão está vazia");
            return null;
        }else{
            return mao.remove(dominoPosicao);
        }
    }
    
    public Domino dominoNumero(int dominoPosicao){
        return mao.get(dominoPosicao);
    }

    public ArrayList<Domino> getMao() {
        return mao;
    }
    
    @Override
    public String toString() {
        return "Jogador{" + "nome=" + nome + ", mao=" + mao + '}';
    }
}
