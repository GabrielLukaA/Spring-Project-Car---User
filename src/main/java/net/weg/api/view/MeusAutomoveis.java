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


@Route(value = "/meus-autos", layout = NavBarApp.class)
public class MeusAutomoveis extends VerticalLayout {



    public MeusAutomoveis(CarroService carroService) {

        Grid grid = new Grid(Carro.class);
        HorizontalLayout hl = new HorizontalLayout();
        hl.add(new H1("Meus automoveis"));
        Dialog cadastro = new Dialog();
        cadastro.add(new CadastroCarro(carroService, cadastro));
        grid.setItems(carroService.buscarTodos());





//        Button salvar = new Button("Salvar", e -> cadastro.close());




        hl.add(new Button("Cadastrar Carro", e -> cadastro.open()));
        add(hl, grid);

    }
}
