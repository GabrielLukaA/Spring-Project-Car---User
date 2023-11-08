package net.weg.api.view;


import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import net.weg.api.model.entity.Seguradora;
import net.weg.api.service.SeguradoraService;

@Route(value = "/seguradoras", layout = NavBarApp.class)
public class SeguradorasView extends PaginaPadrao<Seguradora> {

    private SeguradoraService seguradoraService;



    public SeguradorasView(SeguradoraService seguradoraService){
        super("Seguradoras", seguradoraService.buscar(), Seguradora.class);

        this.seguradoraService = seguradoraService;




    }
}
