package net.weg.api.view;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;

public class BotaoCancelar extends Button {

    BotaoCancelar(Dialog dialog){
        super("Cancelar", event -> {
            dialog.close();
        });
    }
}
