package Modelo;

public class Domino {
    private final int lado1;
    private final int lado2;
    private final boolean bucha;
    private Domino ligacao1 = null;
    private Domino ligacao2 = null;
    
    public Domino(int lado1, int lado2){
        this.lado1 = lado1;
        this.lado2 = lado2;
        bucha = (this.lado1 == this.lado2);
    }
    
    private int ligaCom(Domino peca){
        if(this.lado1 == peca.getLado1())
            return this.lado1;
        else if(this.lado1 == peca.getLado2())
            return this.lado1;
        else if(this.lado2 == peca.getLado1())
            return this.lado2;
        else if(this.lado2 == peca.getLado2())
            return this.lado2; 
        else return -1;
    }
    
    public int estaConectado(Domino domino){
        if(this.ligacao1 == domino){
            return 1;
        }else if(this.ligacao2 == domino){
            return 2;
        }else{
            return 0;
        }
    }
    public boolean conectarCom(Domino domino){
        int ladoDeLigacao = this.ligaCom(domino);
                 
        if( ladoDeLigacao != -1 ){
            if( ladoDeLigacao == this.getLado1() ){
                this.ligacao1 = domino;
                
                if( ladoDeLigacao == domino.getLado1() )
                    domino.ligacao1 = this;
                else{
                    domino.ligacao2 = this;
                }
                
                return true;
            }
            else if( ladoDeLigacao == this.getLado2() ){
                this.ligacao2 = domino;
                
                if( ladoDeLigacao == domino.getLado1() )
                    domino.ligacao1 = this;
                else{
                    domino.ligacao2 = this;
                }
                return true;
            }  
        }
        return false;
    }
    
    public boolean compararCom(Domino domino){
        if(this.lado1 == domino.lado1 && this.lado2 == domino.lado2){
            return true;
        }else if(this.lado2 == domino.lado1 && this.lado1 == domino.lado2)
            return true;
        return false;
    }
    public int getLado1(){
        return this.lado1;
    }
    
    public int getLado2(){
        return this.lado2;
    }

    public int ligacaoDisponivel(){
        if(ligacao1 != null && ligacao2 != null){
            return -2;
        }else if(ligacao1 != null){
            return this.getLado1();
        }else if(ligacao2 != null){
            return this.getLado2();
        }else{
            return -1;
        }
    }
    
    public Domino getLigacao1() {
        return ligacao1;
    }

    public Domino getLigacao2() {
        return ligacao2;
    }
    
    public boolean ehBucha(){
        return this.bucha;
    }

    @Override
    public String toString() {
        return "\nDomino{" + "lado1= " + lado1 + ", lado2= " + lado2 + ", bucha=" + bucha + '}';
    }
}
