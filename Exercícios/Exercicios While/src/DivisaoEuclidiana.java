import java.util.Scanner;

public class DivisaoEuclidiana {
    public static void main(String [] args){

        Scanner scanner = new Scanner(System.in);

        int q = 0;
        System.out.print("Digite o valor de x: ");
        int x = scanner.nextInt();
        System.out.print("Digite o valor de y: ");
        int y = scanner.nextInt();
        int r = x;

        while(r >= y){
            r = r - y;
            q = q + 1;
        }
        System.out.println("Quociente: " + q);
        System.out.println("Resto: " + r);
    }
}
