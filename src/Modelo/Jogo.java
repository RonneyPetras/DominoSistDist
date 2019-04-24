package Modelo;

import java.util.ArrayList;

public class Jogo {
    private ArrayList<Domino> dominos = new ArrayList();
    private ArrayList<Jogador> jogadores = new ArrayList();
    public ArrayList<Domino> tabuleiro = new ArrayList();
    public ArrayList<Domino> buchas = new ArrayList();
    
    public Jogo(Jogador j1, Jogador j2){
        this.criarDominos();
        
        this.buchas.add(dominos.get(0));
        this.buchas.add(dominos.get(7));
        this.buchas.add(dominos.get(13));
        this.buchas.add(dominos.get(18)); 
        this.buchas.add(dominos.get(22));
        this.buchas.add(dominos.get(25));
        this.buchas.add(dominos.get(27));
        
        this.jogadores.add(j1);
        this.jogadores.add(j2);
    }

    public void adicionarJogador(Jogador jogador){
        this.jogadores.add(jogador);
    }
    
    public final void criarDominos(){
            this.dominos.add(new Domino(0,0));//0
        this.dominos.add(new Domino(0,1));//1
        this.dominos.add(new Domino(0,2));//2
        this.dominos.add(new Domino(0,3));//3
        this.dominos.add(new Domino(0,4));//4
        this.dominos.add(new Domino(0,5));//5
        this.dominos.add(new Domino(0,6));//6
            this.dominos.add(new Domino(1,1));//7
        this.dominos.add(new Domino(1,2));//8
        this.dominos.add(new Domino(1,3));//9
        this.dominos.add(new Domino(1,4));//10
        this.dominos.add(new Domino(1,5));//11
        this.dominos.add(new Domino(1,6));//12
            this.dominos.add(new Domino(2,2));//13
        this.dominos.add(new Domino(2,3));//14
        this.dominos.add(new Domino(2,4));//15
        this.dominos.add(new Domino(2,5));//16
        this.dominos.add(new Domino(2,6));//17
            this.dominos.add(new Domino(3,3));//18
        this.dominos.add(new Domino(3,4));//19
        this.dominos.add(new Domino(3,5));//20
        this.dominos.add(new Domino(3,6));//21
            this.dominos.add(new Domino(4,4));//22
        this.dominos.add(new Domino(4,5));//23
        this.dominos.add(new Domino(4,6));//24
            this.dominos.add(new Domino(5,5));//25
        this.dominos.add(new Domino(5,6));//26
            this.dominos.add(new Domino(6,6));//27
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

    public ArrayList<Domino> getDominos() {
        return dominos;
    }

    public ArrayList<Jogador> getJogadores() {
        return jogadores;
    }
    
    @Override
    public String toString() {
        return "Tabuleiro{" + "dominos=" + dominos + '}';
    }
}
