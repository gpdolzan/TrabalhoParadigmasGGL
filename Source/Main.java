import MVC.Controller.Controller;
import MVC.Model.GerenciadorSolicitacao.GerenciadorSolicitacao;

public class Main
{
    public static void main(String[] args)
    {
        Controller controller = Controller.getSingleton();
        controller.initializeAluno("TAP_historico_B.csv");
        controller.initializeDisciplinas("Disciplina_2011.csv");
        controller.initializeGUI();

    }
}