import java.util.Scanner;
import java.lang.Math;

public class Projetil {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o angulo em graus: ");
        double a = scanner.nextDouble();
        System.out.print("Digite a distancia em metros: ");
        double r = scanner.nextDouble();

        a = Math.toRadians(a);

        double vel_inicial = Math.sqrt((r * 9.8)/(2 * Math.sin(a) * Math.cos(a)));
        double tempo_lanc = (2 * vel_inicial * Math.sin(a))/ 9.8;
        System.out.println("Velocidade Inicial: " + vel_inicial);
        System.out.println("Tempo lançamento: " + tempo_lanc);

        double t = 0;
        while(t < (tempo_lanc - 0.1)){
            t = t + 0.1;
            double x = (vel_inicial * Math.cos(a))*t;
            double y = (vel_inicial * Math.sin(a)) * t - (9.8 * Math.pow(t, 2))/2;
            System.out.printf("t = %.1f : X = %.4f | Y = %.4f %n", t, x, y);
        }
    }
}
