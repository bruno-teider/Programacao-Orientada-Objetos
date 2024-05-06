import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Operacoes {
    static Scanner scanner = new Scanner(System.in);

    // Variáveis para a escrita do texto
    static String texto_arquivo = "Respostas do programa: \n";
    static boolean txt;
    static String nome_arquivo = "";

    // -- Funções Auxiliares --

    public static void salvarTxt(){
        // Perguntar ao usuário se ele quer as respostas salvas em txt
        System.out.print("Deseja que todas as respostas sejam salvas em um arquivo .txt? [S/N]: ");
        String aux = scanner.next().toUpperCase();
        if (aux.equals("S")){
            txt = true;
            System.out.print("Nome do arquivo que será gerado: ");
            nome_arquivo = scanner.next() + ".txt";
        } else txt = false;
    }

    private static int selecionarMedicos(List<Medico> medicos){
        // Listar todos os méidocs
        System.out.println("\nLista de todos os médicos: ");
        for(Medico medico : medicos){
            System.out.println("Código: " + medico.codigo + " | Nome: " + medico.nome);
        }

        // Pedir ao usuário qual médico ele deseja selecionar
        System.out.print("Digite o código do médico que deseja ver: ");
        int cod = scanner.nextInt();

        // Checa se o valor inserido foi válido
        if(cod > medicos.size()) {
            System.out.println("Valor inserido inválido. Programa encerrado!");
            criarArquivo();
        }

        return cod;
    }

    private static int selecionarPacientes(List<Paciente> pacientes){
        // Imprimir uma lista de pacientes
        int i = 1;
        System.out.println("\nLista de todos os pacientes: ");
        for(Paciente paciente : pacientes){
            System.out.println("Código: " + i + " | Nome: " + paciente.nome);
            i++;
        }

        // Pedir ao usuário qual paciente deseja ver
        System.out.print("Digite o código do paciente que deseja ver: ");
        int cod = scanner.nextInt();

        if(cod > pacientes.size()){
            System.out.println("Valor inserido inválido. Programa encerrado.");
            criarArquivo();
        }

        return cod;
    }

    // -- Funções Das Operações com o Usuário --

    public static void pacientesDeterminadoMedico(List<Medico> medicos, List<Paciente> pacientes){
        int cod = selecionarMedicos(medicos);
        Medico medico = medicos.get(cod-1);
        List<String> nomes_pacientes = new ArrayList<>(); // Lista para não repetir o nome dos pacientes

        // Mostra todos os pacientes do médico escolhido
        String print = "\nLista pacientes do(a) "+ medico.nome + ":";
        int i = 1;
        for(Paciente paciente : medico.pacientes){
            if (!nomes_pacientes.contains(paciente.nome)){
                nomes_pacientes.add(paciente.nome);
                print += "\nPaciente " + i + ": "+paciente.nome;
                i++;
            }
        }

        System.out.println(print);
        texto_arquivo += print+"\n";
    }

    public static void medicosDeterminadoPaciente(List<Medico> medicos, List<Paciente> pacientes){
        int cod = selecionarPacientes(pacientes);
        Paciente paciente = pacientes.get(cod-1);
        List<String> nomes_medicos = new ArrayList<>(); // Serve para não repetir o nome do médico

        String print = "\nLista médicos que "+ paciente.nome + " já se consultou ou tem agendado:";
        int i = 1;
        for(Consulta consulta : paciente.consultas){
            if(!nomes_medicos.contains(consulta.medicos.get(0).nome)){
                print += "\nMédico " + i + ": " + consulta.medicos.get(0).nome;
                nomes_medicos.add(consulta.medicos.get(0).nome);
                i++;
            }
        }
        System.out.println(print);
        texto_arquivo += print+"\n";
    }

    public static void consultasAgendadasPeriodo(List<Medico> medicos, List<Consulta> consultas){
        int cod = selecionarMedicos(medicos);
        String print = "";

        try{
            // Leitura inicio do período
            System.out.print("Digite a data de início do período. [dd/mm/yyyy]: ");
            String data_inicioStr = scanner.next() + " 00:00:00";
            LocalDateTime data_hora_inicio = LocalDateTime.parse(data_inicioStr, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));

            // Faz o mesmo para a data de fim
            System.out.print("Digite a data de fim do período. [dd/mm/yyyy]: ");
            String data_fimStr = scanner.next() + " 23:00:00";
            LocalDateTime data_hora_fim = LocalDateTime.parse(data_fimStr, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));

            print += ("\nDatas das consultas do(a) " + medicos.get(cod-1).nome + " no período citadao: \n");
            for(Consulta consulta : consultas){
                if(consulta.medicos.get(0).codigo == cod){
                    if(consulta.data_hora.isAfter(data_hora_inicio) && consulta.data_hora.isBefore(data_hora_fim)){
                        String dataFormatada = consulta.data_hora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                        dataFormatada += " as "+consulta.data_hora.format(DateTimeFormatter.ofPattern("HH")) + " horas.";
                        print += (dataFormatada) + "\n";
                    }
                }
            }

            System.out.print(print);
            texto_arquivo += print+"\n";
        } catch (Exception e) {
            System.out.println("Valor inserido inválido. Programa encerrado!");
            criarArquivo();
        }
    }

    public static void consultasPacienteDeterminadoMedico(List<Paciente> pacientes, List<Consulta> consultas, List<Medico> medicos){
        int cod = selecionarPacientes(pacientes);
        String print = "";
        List<String> nomes_medicos = new ArrayList<>();
        int counter = 0;
        Paciente paciente = pacientes.get(cod-1);

        System.out.println("\nMédicos que o(a) " + paciente.nome + " já se consultou: ");

        // Mostrar a lista de médicos que o usuário já se consultou
        for(Medico medico : medicos){
            for(Paciente paciente1 : medico.pacientes){
                // Checa se o é o mesmo paciente e se não irá repetir o nome do médico
                if(paciente1.CPF.equals(paciente.CPF) && !(nomes_medicos.contains(medico.nome))){
                    // Checa se a data da consulta já passou
                    if(paciente.consultas.get(0).data_hora.isBefore(LocalDateTime.now())){
                        nomes_medicos.add(medico.nome);
                        System.out.println("Código: " + medico.codigo + " | Nome: " + medico.nome);
                        counter ++;
                    }
                }
            }
        }

        // Caso não há consultas anteriores, a função acaba aqui
        if(counter == 0){
            print = "\nO(a) paciente " + paciente.nome + " não teve nenhuma consulta passada. \n";
        } else{
            System.out.print("Código do médico que deseja ver: ");
            cod = scanner.nextInt();
            print += "\nConsultas passadas do(a) paciente " + paciente.nome + " com médico(a) " + medicos.get(cod-1).nome + " :\n";
            for (Consulta consulta : paciente.consultas){
                if(consulta.medicos.get(0).codigo == cod){
                    print += consulta.data_hora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    print += " as "+consulta.data_hora.format(DateTimeFormatter.ofPattern("HH")) + " horas.\n";
                }
            }
        }

        System.out.println(print);
        texto_arquivo += print+"\n";
    }

    public static void consultasFuturasPaciente(List<Paciente> pacientes, List<Consulta> consultas){
        int cod = selecionarPacientes(pacientes);
        String print = "";

        Paciente paciente = pacientes.get(cod-1); // Cria um objeto paciente com o paciente selecionado
        print += "\nConsultas futuras do(a) "+pacientes.get(cod-1).nome +": \n";

        // Checa todas as consultas do paciente e a data
        int counter = 0;
        for (Consulta consulta : paciente.consultas){
            if(consulta.data_hora.isAfter(LocalDateTime.now())){
                String dataFormatada = consulta.data_hora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                dataFormatada += " as "+consulta.data_hora.format(DateTimeFormatter.ofPattern("HH")) + " horas.";
                print += dataFormatada;
                counter++;
            }
        }

        if (counter == 0 ) print += "Não há nenhuma consulta futura";
        System.out.println(print);
        texto_arquivo += print+"\n";
    }

    public static void pacienteNaoConsultaTempo(List<Paciente> pacientes, List<Consulta> consultas, List<Medico> medicos){
        int cod = selecionarMedicos(medicos);
        Medico medico = medicos.get(cod-1);
        List<Paciente> nomes_pacientes = new ArrayList<>();

        // Pegar a data de hoje - a quantidade de meses escolhidas
        LocalDateTime data_comp = LocalDateTime.now();
        int meses = 0;

        System.out.print("Digite quantos meses: ");
        meses = scanner.nextInt();

        data_comp = data_comp.minusMonths(meses);

        // Para todos os pacientes do médico escolhido
        for(Paciente paciente : medico.pacientes){
            // Para todas as consultas do paciente
            for(Consulta consulta : paciente.consultas){
                // Se é a consulta com o médico escolhido
                if(consulta.medicos.get(0).codigo == medico.codigo){
                    // Se a consulta foi a mais tempo do q a mais antiga
                    if(consulta.data_hora.isBefore(data_comp)){
                        // Adiciona o nome e a data mais antigos
                        nomes_pacientes.add(paciente);
                    }
                }
            }
        }

        String print = "\nPacientes que não se consultam com " + medico.nome + " a mais de " + meses + " meses: \n";
        if(nomes_pacientes.size() <= 0){
            print += "Não há nenhum paciente.\n";
        } else {
            for(Paciente paciente : nomes_pacientes){
                print += paciente.nome + "\n";
            }
            print += "\n";
        }

        System.out.println(print);
        texto_arquivo += print;
    }

    public static void criarArquivo(){
        if(txt){
            System.out.println("Arquivo com as respostas geradas em ./" + nome_arquivo);
            try {
                FileWriter arq = new FileWriter(nome_arquivo);
                arq.write(texto_arquivo);
                arq.close();
            } catch (IOException e) { e.printStackTrace(); }

        }
    }
}