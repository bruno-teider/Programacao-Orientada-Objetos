public class Principiante extends Jogador{
    private double bonus;

    public Principiante(String nome, int score, double bonus){
        super(nome, score);
        this.bonus = bonus;
    }

    public void imprimir(){
        super.imprimir();
        System.out.println("Bonus: " + bonus);
    }

    public void ganhar(int p){
        score += p;
        bonus += (p * 0.10);
    }

    public void peder(int p){
        score -= p;
        bonus -= (p*0.10);
    }
}
