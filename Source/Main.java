import MVC.Controller.Controller;

public class Main
{
    public static void main(String[] args)
    {
        Controller controller = Controller.getSingleton();
        controller.initializeAluno("TAP_historico.csv");
        controller.initializeDisciplinas("Disciplina_2011.csv");
        controller.initializeGUI();
    }
}