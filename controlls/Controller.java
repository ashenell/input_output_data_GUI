package controlls;

import listeners.ButtonAddListener;
import listeners.ButtonShowListener;
import models.Model;
import views.View;

import java.io.IOException;

public class Controller {

    private Model model;
    private View view;

    public Controller(Model model, View view) throws IOException {
        this.model = model;
        this.view = view;

        view.registerButtonShow(new ButtonShowListener(model, view));
        view.registerButtonAdd(new ButtonAddListener(model, view));
    }


}
