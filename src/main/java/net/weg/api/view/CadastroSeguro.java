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

public class CadastroSeguro extends Dialog {
    private  SeguroService seguroService;


    private NumberField valor = new NumberField("Valor");
//        TextField nome = new TextField("Nome");
    private TextField descricao = new TextField("Descrição");
    private NumberField valorFranquia = new NumberField("Valor Franquia");
    private Select<Seguradora> seguradora = new Select<>();
    private Select<Carro> veiculo = new Select<>();
    private         Select<Cliente> usuario = new Select<>();

    private FormLayout formLayout = new FormLayout(valor,descricao,valorFranquia,seguradora,veiculo,usuario);

    CadastroSeguro(SeguradoraService seguradoraService, CarroService carroService,
                   ClienteService usuarioService, SeguroService seguroService){
        this.seguroService = seguroService;

        seguradora.setLabel("Seguradora");
        seguradora.setItems(seguradoraService.buscar());
        veiculo.setLabel("Veículo");
        veiculo.setItems(carroService.buscarTodos());
//        usuario.setItemLabelGenerator(Usuario::toString);
        usuario.setLabel("Usuário");
        usuario.setItems(usuarioService.buscarTodos());



        Button salvar = new Button("Salvar", event -> {

            SeguroCadastroDTO seguroCadastroDTO = new SeguroCadastroDTO(valor.getValue(), descricao.getValue(), valorFranquia.getValue(), seguradora.getValue(), veiculo.getValue(), usuario.getValue());
            try {

                seguroService.salvar(seguroCadastroDTO);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            this.close();

        });
        Button cancelar = new Button("Cancelar", e -> this.close());
        this.getFooter().add(cancelar, salvar);
        add(formLayout);
    }
}
