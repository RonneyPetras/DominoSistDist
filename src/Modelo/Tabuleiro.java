
package Modelo;

import java.util.ArrayList;
import java.util.Collections;

public class Tabuleiro {
    private ArrayList<Domino> dominos = new ArrayList();
    private ArrayList<Jogador> jogadores = new ArrayList();
    
    public Tabuleiro(Jogador j1, Jogador j2){
        this.jogadores.add(j1);
        this.jogadores.add(j2);
        this.criarDominos();
    }

    public void adicionarJogador(Jogador jogador){
        this.jogadores.add(jogador);
    }
    
    public void criarDominos(){
        this.dominos.add(new Domino(0,0));
        this.dominos.add(new Domino(0,1));
        this.dominos.add(new Domino(0,2));
        this.dominos.add(new Domino(0,3));
        this.dominos.add(new Domino(0,4));
        this.dominos.add(new Domino(0,5));
        this.dominos.add(new Domino(0,6));
        this.dominos.add(new Domino(1,1));
        this.dominos.add(new Domino(1,2));
        this.dominos.add(new Domino(1,3));
        this.dominos.add(new Domino(1,4));
        this.dominos.add(new Domino(1,5));
        this.dominos.add(new Domino(1,6));
        this.dominos.add(new Domino(2,2));
        this.dominos.add(new Domino(2,3));
        this.dominos.add(new Domino(2,4));
        this.dominos.add(new Domino(2,5));
        this.dominos.add(new Domino(2,6));
        this.dominos.add(new Domino(3,3));
        this.dominos.add(new Domino(3,4));
        this.dominos.add(new Domino(3,5));
        this.dominos.add(new Domino(3,6));
        this.dominos.add(new Domino(4,4));
        this.dominos.add(new Domino(4,5));
        this.dominos.add(new Domino(4,6));
        this.dominos.add(new Domino(5,5));
        this.dominos.add(new Domino(5,6));
        this.dominos.add(new Domino(6,6));
    }
    public void embaralha(){
        Collections.shuffle(dominos);
    }
    
    public ArrayList<Domino> distribuiDominos(int qtdDominos){
        ArrayList<Domino> retorno = new ArrayList<>();
        for(int i=0; i<qtdDominos; i++){
            this.embaralha();
            retorno.add(this.dominos.remove(0));
        }
        return retorno;
    }
    @Override
    public String toString() {
        return "Tabuleiro{" + "dominos=" + dominos + '}';
    }
    
}
