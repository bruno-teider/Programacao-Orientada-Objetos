public class MatrizInversa {

    public static double[][] InverterMatriz(double[][] matriz){
        int tamanho_linhas = matriz.length;
        int tamanho_colunas = matriz[0].length;
        double[][] inverso = new double[tamanho_linhas][tamanho_colunas];

        for(int a = 0, b = tamanho_linhas-1; a < tamanho_linhas; a++, b--){
            for(int c = 0, d = tamanho_colunas-1; c < tamanho_colunas; c++, d--){
                inverso[b][d] = matriz[a][c];
            }
        }

        return inverso;
    }

    public static void main(String[] args){
        double[][] matriz = {{1, 2},{3, 4}};
        double[][] inverso = InverterMatriz(matriz);

        for(int i = 0; i < inverso.length; i++){
            for(int j = 0; j < inverso[i].length; j++) System.out.print("["+inverso[i][j]+ "] ");
            System.out.print('\n');
        }
    }
}
