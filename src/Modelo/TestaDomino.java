
package Modelo;

public class TestaDomino {
    public static void main(String[] args) {
        Domino d1 = new Domino(2,4);
        Domino d2 = new Domino(3,4);
        Domino d3 = new Domino(4,5);
        Domino d4 = new Domino(4,6);
        Domino d5 = new Domino(0,6);
        
        System.out.println(d3.conectarCom(d1));

        System.out.println(d1.estaConectado(d3));

        System.out.println(d3.estaConectado(d1));

       
    }
 
}
