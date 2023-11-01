package net.weg.api.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import net.weg.api.model.dto.CarroCadastroDTO;
import net.weg.api.model.dto.SeguroCadastroDTO;
import net.weg.api.model.entity.*;
import net.weg.api.service.CarroService;
import net.weg.api.service.ClienteService;
import net.weg.api.service.SeguradoraService;
import net.weg.api.service.SeguroService;
import org.springframework.beans.BeanUtils;

public class CadastroSeguro extends FormLayout {
    private  SeguroService seguroService;

    CadastroSeguro(SeguradoraService seguradoraService, CarroService carroService,
                   ClienteService usuarioService, Dialog dialog, SeguroService seguroService){
        this.seguroService = seguroService;

        NumberField valor = new NumberField("Valor");
//        TextField nome = new TextField("Nome");
        TextField descricao = new TextField("Descrição");
        NumberField valorFranquia = new NumberField("Valor Franquia");
        Select<Seguradora> seguradora = new Select<>();
        seguradora.setLabel("Seguradora");
        seguradora.setItems(seguradoraService.buscar());
        Select<Carro> veiculo = new Select<>();
        veiculo.setLabel("Veículo");
        veiculo.setItems(carroService.buscarTodos());
        Select<Cliente> usuario = new Select<>();
        usuario.setLabel("Usuário");
        usuario.setItems(usuarioService.buscarTodos());

        add(valor,descricao,valorFranquia,seguradora,veiculo,usuario);

        Button salvar = new Button("Salvar", event -> {

            SeguroCadastroDTO seguroCadastroDTO = new SeguroCadastroDTO(valor.getValue(), descricao.getValue(), valorFranquia.getValue(), seguradora.getValue(), veiculo.getValue(), usuario.getValue());
            try {

                seguroService.salvar(seguroCadastroDTO);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            dialog.close();

        });
        Button cancelar = new Button("Cancelar", e -> dialog.close());
        dialog.getFooter().add(cancelar, salvar);
    }
}
