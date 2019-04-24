package Controle;

import Modelo.Domino;
import Modelo.Jogador;
import Modelo.Jogo;
import java.util.ArrayList;
import java.util.Collections;

public class Controlador {
    private static Jogo jogo;
    private ArrayList<Domino> jogadas = new ArrayList();
    private Jogador iniciador;
    private Jogador proxAJogar;

    public Controlador(Jogo jogo){
        this.jogo = jogo;
    }
    
    public void embaralha(){
        Collections.shuffle(jogo.getDominos());
    }
    
    public ArrayList<Domino> entregaDominos(Jogador j, int qtdDominos){
        ArrayList<Domino> retorno = new ArrayList<>();
        for(int i=0; i<qtdDominos; i++){
            this.embaralha();
            if(jogo.getDominos().get(0).getLado1() == 6 && jogo.getDominos().get(0).getLado2() == 6 ){
                this.setIniciador(j);
            }
            retorno.add(jogo.getDominos().remove(0));
        }
        return retorno;
    }
    
    public void setIniciador(Jogador j){
        this.iniciador = j;
    }
    
    public void distribuiDominosEntreJogadores(){
        for(Jogador j:jogo.getJogadores()){
            j.recebeMao(this.entregaDominos(j,(int) (28/jogo.getJogadores().size())));
        }
    }
    
    public void primeiraJogada(){
        int posicaoDaBucha = this.iniciador.getMao().indexOf(this.jogo.getDominos().get(27));  
        this.jogadas.add(this.iniciador.getMao().get(posicaoDaBucha));
    }
    
    public void validaJogada(Jogador jogador, int posicao, Boolean extremidade){
        Domino dominoExtremidade;
        if(extremidade){
            dominoExtremidade = this.jogadas.get(this.jogadas.size()-1);
            if(jogador.dominoNumero(posicao).conectarCom(dominoExtremidade)){
                this.jogadas.add(jogador.deita(posicao));
            }else{
                System.out.println("Essa peça não se conecta com a peça da extremidade direita");
            }
        }else{
            dominoExtremidade = this.jogadas.get(0);
            if(jogador.dominoNumero(posicao).conectarCom(dominoExtremidade)){
                this.jogadas.add(0, jogador.deita(posicao));
            }else{
                System.out.println("Essa peça não se conecta com a peça da extremidade esquerda");
            }
        }
    }

    public ArrayList<Domino> getJogadas() {
        return jogadas;
    }
}
