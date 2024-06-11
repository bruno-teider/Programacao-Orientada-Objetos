import java.io.*;
import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class LeituraDados {

    // Função para leitura e geração de médicos (Retorna um ArrayList contendo todos os médicos)
    public static List<Medico> gerarMedicos(){
        // Caminho para o arquivo pode precisar ser mudado dependendo do computador
        String NOME_ARQUIVO = ".\\src\\medicos.csv";
        List<Medico> medicos = new ArrayList<>(); //ArrayList onde ficaram armazenados os objetos do tipo Medico

        try {
            // Realiza a leitura do arquivo
            FileReader arquivo = new FileReader(NOME_ARQUIVO);
            BufferedReader br = new BufferedReader(arquivo);
            String linha;

            // While roda a cada linha lida
            while ((linha = br.readLine()) != null) {
                // Joga os valores lidos separados por ; na lista valores
                String[] tokens = linha.split(";");
                List<String> valores = Arrays.asList(tokens);

                String codigoStr = valores.get(1);

                // Coverter código de String Para Int e gerar médicos com método construtor
                try {
                    int codigo = Integer.parseInt(codigoStr);
                    Medico medico = new Medico(valores.get(0), codigo);
                    medicos.add(medico);
                } catch (NumberFormatException e) { System.err.close(); }
            }
        }
        catch(Exception e){ e.printStackTrace(); }

        return medicos;
    }

    // Função para leitura e geração de pacientes (Retorna um ArrayList contendo todos os pacientes)
    public static List<Paciente> gerarPacientes(){
        // Caminho do arquivo pode precisar ser mudado dependendo do computador
        String NOME_ARQUIVO = ".\\src\\pacientes.csv";
        List<Paciente> pacientes = new ArrayList<>(); //ArrayList para geração de vários médicos

        try {
            // Realiza a leitura do arquivo
            FileReader arquivo = new FileReader(NOME_ARQUIVO);
            BufferedReader br = new BufferedReader(arquivo);
            String linha;

            // While roda a cada linha lida
            while ((linha = br.readLine()) != null) {
                // Joga os dados lidos (separados por ; na lista valores
                String[] tokens = linha.split(";");
                List<String> valores = Arrays.asList(tokens);

                // Checa se não é a primeira linha do arquivo csv
                if(!(valores.get(0).equals("nome"))){
                    // Pega os dados da lista valores e coloca no método construtor
                    Paciente paciente = new Paciente(valores.get(0), valores.get(1));
                    pacientes.add(paciente);
                }
            }
        }
        catch(Exception e){ e.printStackTrace(); }

        return pacientes;
    }

    // Função para leitura e geração das Consultas
    public static List<Consulta> gerarConsultas(List<Medico> medicos, List<Paciente> pacientes){
        // Caminho para o arquivo (precisa mudar dependendo do computador)
        String NOME_ARQUIVO = ".\\src\\consultas.csv";
        List<Consulta> consultas = new ArrayList<>(); //ArrayList para geração de várias Consultas

        try {
            // Realizar a leitura do arquivo
            FileReader arquivo = new FileReader(NOME_ARQUIVO);
            BufferedReader br = new BufferedReader(arquivo);
            String linha;

            // While que roda a cada linha lida
            while ((linha = br.readLine()) != null) {
                // Joga os dados lidos para a lista valores
                String[] tokens = linha.split(";");
                List<String> valores = Arrays.asList(tokens);

                // Pega os dados da lista valores e joga para as variáveis
                String data_horaStr = valores.get(0);
                String codigo_medicoStr = valores.get(1);
                String CPF = valores.get(2);

                // Faz a conversão de tipos das variáveis e a inclusão dos objetos
                try {
                    LocalDateTime data_hora = LocalDateTime.parse(data_horaStr, DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")); // Converter Str para LocalDateTime
                    Consulta consulta = new Consulta(data_hora); // Chama o método Construtor

                    int codigo_medico = Integer.parseInt(codigo_medicoStr);
                    for(Medico medico : medicos){
                        if(codigo_medico == medico.codigo){ consulta.incluir_medico(medico); } // Inclui o médico na consulta

                        // Incluir o paciente para o médico
                        for(Paciente paciente : pacientes){
                            if(codigo_medico == medico.codigo && CPF.equals(paciente.CPF)){
                                medico.incluir_paciente(paciente);
                            }
                        }
                    }

                    // Incluir a consulta no paciente
                    for(Paciente paciente : pacientes){
                        if(CPF.equals(paciente.CPF)){ paciente.incluir_consulta(consulta); }
                    }

                    // Adicionar a consulta na ArrayList consultas
                    consultas.add(consulta);
                } catch (Exception e) { System.err.close(); }
            }
        }
        catch(Exception e){ e.printStackTrace(); }

        return consultas;
    }
}