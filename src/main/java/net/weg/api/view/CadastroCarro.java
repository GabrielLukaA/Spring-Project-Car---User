package net.weg.api.view;

import com.vaadin.flow.component.*;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.login.LoginI18n;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import net.weg.api.model.dto.CarroCadastroDTO;
import net.weg.api.service.CarroService;


import java.util.ArrayList;
import java.util.Collection;

@Route(value = "/cadastro", layout = NavBarApp.class)
public class CadastroCarro extends Dialog {


    private TextField placa = new TextField("Placa");
    private TextField marca = new TextField("Marca");
    private TextField cor = new TextField("Cor");
    private TextField modelo = new TextField("Modelo");
    private IntegerField ano = new IntegerField("Ano");
    private NumberField preco = new NumberField("Preço");

    private FormLayout formLayout = new FormLayout(placa,marca,cor,modelo,ano,preco);

    private final CarroService carroService;
    public CadastroCarro(CarroService carroService) throws Exception {
this.carroService = carroService;
        Button salvar = new BotaoSalvar(carroService,        new CarroCadastroDTO(marca.getValue(),
                placa.getValue(), cor.getValue(),modelo.getValue(), preco.getValue(), ano.getValue())) ;

                this.close();
        Button cancelar = new Button("Cancelar", e -> this.close());
        this.getFooter().add(cancelar, salvar);
        add(formLayout);

    }


}
