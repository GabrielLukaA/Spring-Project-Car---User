package net.weg.api.view;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import lombok.Data;


import java.util.Collection;
import java.util.List;

@Data
public abstract class PaginaPadrao<T> extends VerticalLayout {
    protected Grid<T> grid;
    protected H1 titulo;
    protected HorizontalLayout horizontalLayout;

    PaginaPadrao(String titulo, Collection<T> itens, Class classe){
        this.grid = new Grid<>(classe);
        this.grid.setItems(itens);
        this.titulo = new H1(titulo);
        this.horizontalLayout = new HorizontalLayout(this.titulo);
        this.add(this.horizontalLayout,this.grid);
    }
    PaginaPadrao(String titulo, Collection<T> itens, Class classe, Component button){
        this.grid = new Grid<>(classe);
        this.grid.setItems(itens);
        this.titulo = new H1(titulo);
        this.horizontalLayout = new HorizontalLayout(this.titulo, button);
        this.add(this.horizontalLayout,this.grid);
    }
}
