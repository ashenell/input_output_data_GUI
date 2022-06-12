import controlls.Controller;
import models.Model;
import views.View;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.io.IOException;

public class App {

    public App() throws IOException {
        Model model = new Model();
        View view = new View(model);
        new Controller(model, view);

        view.pack();
        view.setLocationRelativeTo(null);
        view.setVisible(true);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new App();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }


        });
    }
}
