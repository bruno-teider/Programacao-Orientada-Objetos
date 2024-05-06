import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Clinica {
    public static void main(String[] args) {
        // Criação dos objetos pelos arquivos csv
        List<Medico> medicos = LeituraDados.gerarMedicos();
        List<Paciente> pacientes = LeituraDados.gerarPacientes();
        List<Consulta> consultas = LeituraDados.gerarConsultas(medicos, pacientes);
        consultas.sort((c1, c2) -> c1.data_hora.compareTo(c2.data_hora)); // Coloca as consultas em ordem cronológica

        Scanner scanner = new Scanner(System.in);

        // Perguntar ao usuário se deseja salvar as respostas
        Operacoes.salvarTxt();

        // Seleção das operações a serem realizadas
        int operacao = 1;
        while (operacao != 0){
            System.out.println("\n-- Visualizar --");
            System.out.println("1 - Pacientes de um médico " +
                    "\n2 - Médicos que um paciente já consultou ou tem consulta" +
                    "\n3 - Consultas de um médico em um determinado período" +
                    "\n4 - Consultas já realizadas por um paciente com um determinado médico" +
                    "\n5 - Consultas futuras de um paciente" +
                    "\n6 - Pacientes que não consultam com um determinado médico a mais de um tempo específico" +
                    "\n0 - Sair do programa");
            System.out.print("Opção desejada: ");
            operacao = scanner.nextInt();

            // Switch para as operações
            switch (operacao){
                case 1:
                    Operacoes.pacientesDeterminadoMedico(medicos, pacientes);
                    break;
                case 2:
                    Operacoes.medicosDeterminadoPaciente(medicos, pacientes);
                    break;
                case 3:
                    Operacoes.consultasAgendadasPeriodo(medicos, consultas);
                    break;
                case 4:
                    Operacoes.consultasPacienteDeterminadoMedico(pacientes, consultas, medicos);
                    break;
                case 5:
                    Operacoes.consultasFuturasPaciente(pacientes, consultas);
                    break;
                case 6:
                    Operacoes.pacienteNaoConsultaTempo(pacientes, consultas, medicos);
                    break;
            }

            // Perguntar se o usuário quer fazer outra busca
            if(operacao != 0){
                System.out.print("\nDeseja realizar mais alguma busca? [1 - Sim | 0 - Não]: ");
                operacao = scanner.nextInt();
            }
        }

        // Chama a função para criar o arquivo texto com as respostas caso o usuario tenha pedido
        Operacoes.criarArquivo();
    }
}