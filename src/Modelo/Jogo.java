package Modelo;

import java.util.ArrayList;
import java.util.Collections;

public class Jogo {
    private ArrayList<Domino> dominos = new ArrayList();
    private ArrayList<Jogador> jogadores = new ArrayList();
    public ArrayList<Domino> tabuleiro = new ArrayList();
    public Jogador iniciador;
    public Jogo(Jogador j1, Jogador j2){
        this.criarDominos();
        this.jogadores.add(j1);
        this.jogadores.add(j2);
    }

    public void adicionarJogador(Jogador jogador){
        this.jogadores.add(jogador);
    }
    
    public final void criarDominos(){
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
    
    public ArrayList<Domino> entregaDominos(Jogador j, int qtdDominos){
        ArrayList<Domino> retorno = new ArrayList<>();
        for(int i=0; i<qtdDominos; i++){
            this.embaralha();
            if(this.dominos.get(0) == new Domino(6,6) ){
                this.iniciador = j;
            }
            retorno.add(this.dominos.remove(0));
        }
        return retorno;
    }
    
    public void distribuiDominosEntreJogadores(){
        for(Jogador j:this.jogadores){
            j.recebeMao(this.entregaDominos(j,(int) (28/this.jogadores.size())));
        }
    }
    
    //Passe TRUE para pegar o lado disponível da Direita e FALSE para o lado da esquerda
    public int getLadoDominoExtremidade(Boolean lado){
        if(lado){
            return this.tabuleiro.get(this.tabuleiro.size()-1).ligacaoDisponivel();
        }else{
            return this.tabuleiro.get(0).ligacaoDisponivel();
        }   
    }
    
    public void novaJogada(Jogador jogador, int posicao, Boolean extremidade){
        Domino dominoExtremidade;
        if(extremidade){
            dominoExtremidade = this.tabuleiro.get(this.tabuleiro.size()-1);
            if(jogador.dominoNumero(posicao).conectarCom(dominoExtremidade)){
                this.tabuleiro.add(jogador.deita(posicao));
            }else{
                System.out.println("Essa peça não se conecta com a peça da extremidade direita");
            }
        }else{
            dominoExtremidade = this.tabuleiro.get(0);
            if(jogador.dominoNumero(posicao).conectarCom(dominoExtremidade)){
                this.tabuleiro.add(0, jogador.deita(posicao));
            }else{
                System.out.println("Essa peça não se conecta com a peça da extremidade esquerda");
            }
        }
    }
    
    @Override
    public String toString() {
        return "Tabuleiro{" + "dominos=" + dominos + '}';
    }
}
