package net.weg.api.view;

import com.vaadin.flow.component.*;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.login.LoginI18n;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import lombok.Getter;
import net.weg.api.model.dto.CarroCadastroDTO;
import net.weg.api.service.CarroService;


import java.util.ArrayList;
import java.util.Collection;

@Route(value = "/cadastro", layout = NavBarApp.class)
public class CadastroCarro extends IFormulario {


    private TextField placa = new TextField("Placa");
    private TextField marca = new TextField("Marca");
    private TextField cor = new TextField("Cor");
    private TextField modelo = new TextField("Modelo");
    private IntegerField ano = new IntegerField("Ano");
    private NumberField preco = new NumberField("Preço");

    @Getter
    private Button salvar;





    private CarroService carroService;

    public CadastroCarro(CarroService carroService) {
        this.carroService = carroService;
        this.salvar = criarBotaoSalvar();
        this.add(placa, marca, cor, modelo, ano, preco);

    }


    private Button criarBotaoSalvar(){
        return new BotaoSalvar(event ->{
            Notification notification = new Notification();
            notification.setDuration(3000);
            try {
                carroService.cadastrar(new CarroCadastroDTO(marca.getValue(),
                        placa.getValue(), cor.getValue(), modelo.getValue(), preco.getValue(), ano.getValue()));
                notification.setText("Cadastro realizado com sucesso!");
                notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
            } catch (Exception e) {
                notification.setText("Erro no cadastro!");
                notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
                throw new RuntimeException(e);
            } finally {
                notification.open();
            }
        });
    }

}
