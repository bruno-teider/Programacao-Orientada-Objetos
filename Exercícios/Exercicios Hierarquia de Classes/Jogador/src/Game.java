import java.util.ArrayList;

public class Game {
    public static void main(String[] args){
        ArrayList<Jogador> jogadores = new ArrayList<Jogador>();
        Principiante bruno = new Principiante("Bruno", 5, 10);
        Profissional nicolas = new Profissional("Nicolas", 10, 5);
        Senior vini = new Senior("Vinicius", 15, 5, 10);

        bruno.imprimir();
        nicolas.imprimir();
        vini.imprimir();

        System.out.println("\n");

        bruno.ganhar(10);
        nicolas.ganhar(10);
        vini.ganhar(10);

        bruno.imprimir();
        nicolas.imprimir();
        vini.imprimir();
    }
}
