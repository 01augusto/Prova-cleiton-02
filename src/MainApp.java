import javax.swing.*;

public class MainApp {
    public static void main(String[] args) {
        BancoController controller = new BancoController();
        SwingUtilities.invokeLater(() -> new BancoView(controller).createAndShowGUI());
    }
}
