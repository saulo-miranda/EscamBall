import Visao.LoginFrame;
import javax.swing.*;

public class MainClient {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        LoginFrame newApp = new LoginFrame();
    }
}
