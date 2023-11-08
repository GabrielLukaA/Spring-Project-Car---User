package net.weg.api.view;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import net.weg.api.controller.CarroController;
import net.weg.api.model.entity.Carro;
import net.weg.api.model.entity.Seguro;
import net.weg.api.service.CarroService;

import java.util.Collection;
import java.util.List;


@Route(value = "/meus-autos", layout = NavBarApp.class)
public class MeusAutomoveis extends PaginaPadrao<Carro> {



    public MeusAutomoveis(CarroService carroService) {
        super("Meus automóveis",carroService.buscarTodos(),Carro.class,
                new Button("Novo Carro", e-> new CadastroCarro(carroService).open()));

//        Button salvar = new Button("Salvar", e -> cadastro.close());



    }
}
