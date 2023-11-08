package net.weg.api.view;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import lombok.AllArgsConstructor;
import net.weg.api.model.dto.CarroCadastroDTO;
import net.weg.api.model.dto.IDTO;
import org.hibernate.annotations.AnyKeyJavaClass;

@AllArgsConstructor
public class BotaoSalvar<T, ID> extends Button {

    BotaoSalvar(IService<T, ID> service, IDTO dto) {
        Notification notification = new Notification();
        notification.setDuration(3000);
        this.setText("Salvar");
        try {
            service.cadastrar(dto);
            notification.setText("Cadastro realizado com sucesso!");
            notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
        } catch (Exception exception) {
            notification.setText("Erro no cadastro!");
            notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
        } finally {
            notification.open();
        }
    }

    BotaoSalvar(ComponentEventListener<ClickEvent<Button>> event){
        super("Salvar", event);
    }


    BotaoSalvar(Grid<T> grid, IDTO dto){
        Notification notification = new Notification();
        notification.setDuration(3000);
        try {
            grid.getListDataView().addItem((T) dto);
            notification.setText("Cadastro realizado com sucesso!");
            notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
        } catch (Exception exception) {
            notification.setText("Erro no cadastro!");
            notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
        } finally {
            notification.open();
        }
    }
}
