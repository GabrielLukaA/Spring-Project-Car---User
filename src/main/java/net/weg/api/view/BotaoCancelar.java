package net.weg.api.view;


import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;

public class BotaoCancelar extends Button {

    BotaoCancelar(ComponentEventListener<ClickEvent<Button>> event){
        super("Cancelar", event);
    }
}
