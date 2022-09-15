package MVC.Model.GerenciadorSolicitacao;

import java.io.IOException;
import java.util.ArrayList;

import java.io.FileWriter;

import MVC.Model.Aluno.Aluno;
import MVC.Model.Disciplina.Disciplina;  
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class GerenciadorSolicitacao
{
    public static String CriaSaida()
    {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(timestamp.getTime());
        String filename = "Solicitacao_" + timeStamp + ".txt";
        System.out.print(filename);
        return filename;

    }

   public static Boolean EscreveArquivo(ArrayList<String> disciplinaSolicitada, ArrayList<Integer> prioridade, String nomeSaida, Aluno aluno, ArrayList<Disciplina> barreiraRest ){
        try{
            FileWriter escritor = new FileWriter(nomeSaida);
            //Cabeçário
            escritor.write("PEDIDO DE QUEBRA DE REQUISITOS / BARREIRA \n");
            escritor.write("Este formulário serve para encaminhamento de pedido ao colegiado do curso para a quebra de requisitos da barreira dos três períodos iniciais, conforme previsto na definição do currículo do curso.Deve ser entregue na secretaria do curso. \n");
            escritor.write("\n");
            escritor.write("Nome: " + aluno.getNomePessoa() + "\n");
            escritor.write("GRR: " + aluno.getMatrAluno() + "\n");
            escritor.write("Curso: Curso de Ciência da Computação - Bacharelado \n");
            escritor.write("É formando? ( ) Sim ( ) Não ( )Barreira ( ) Requisito \n");
            escritor.write("Telefone:_______________ Email:_________________________ \n\n");

            //Disciplinas restantes da barreira
            escritor.write("1. Disciplinas que faltam aprovar na barreira: \n");// escrever disciplinas da barreira
            
            for(int i = 0; i < barreiraRest.size(); i++)
            {
                escritor.write(barreiraRest.get(i).getNomeDisciplina() + "\n");
            }

            //Condição sem conflito de horário
            escritor.write("\n2. Tem condições de se matricular nesta disciplina, sem colisão de horários com as disciplinas faltantes,possuindo condições de finalizar as atividades formativas complementares seguindo as regras vigentes do seu curso? (   ) Sim (   ) Não \n");
            
            //Disciplinas solicitadas
            escritor.write("3. Disciplinas Solicitadas: \n");
            for(int i = 0; i < disciplinaSolicitada.size(); i++)
            {
            escritor.write(disciplinaSolicitada.get(i)); 
            escritor.write(" prioridade:  " + prioridade.get(i));
            escritor.write("\n");
            }
            
            //Justificar pedido
            escritor.write("\n4. Justifique seu pedido:\n");
            escritor.write("_____________________________________________________________________________________________________\n");
            escritor.write("_____________________________________________________________________________________________________\n");
            escritor.write("_____________________________________________________________________________________________________\n");
            escritor.write("_____________________________________________________________________________________________________\n");
            escritor.write("_____________________________________________________________________________________________________\n");
            escritor.write("Data do Pedido: ___________________________________________________\n\n\n\n\n");
            escritor.write("                                  ______________________________________\n");
            escritor.write("                                          Assinatura do aluno");


            escritor.close();
            System.out.println("Escrito com sucesso no arquivo");
            return true;
        } catch (IOException e){
            System.out.println("Erro ao escrever em arquivo");
            e.printStackTrace();
            return false;
        }
   }
}
