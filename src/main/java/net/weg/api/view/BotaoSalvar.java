package net.weg.api.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import net.weg.api.model.dto.CarroCadastroDTO;
import net.weg.api.model.dto.IDTO;

public class BotaoSalvar extends Button {

    BotaoSalvar(IService service, IDTO dto) throws Exception {
        Notification notification = new Notification();
        notification.setDuration(5000);
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

//    CarroCadastroDTO carroCadastroDTO = new CarroCadastroDTO(marca.getValue(),
//            placa.getValue(), cor.getValue(),modelo.getValue(), preco.getValue(), ano.getValue());
//
//        try {
//        carroService.cadastrar(carroCadastroDTO);
//
//    } catch (Exception e) {
//        throw new RuntimeException(e);
//    }
//        this.close();
}
