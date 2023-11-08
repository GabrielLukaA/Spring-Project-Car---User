package net.weg.api.view;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.dom.Style;
import com.vaadin.flow.router.Route;
import javassist.util.proxy.RuntimeSupport;
import net.weg.api.model.dto.EnderecoCadastroDTO;
import net.weg.api.model.dto.UsuarioCadastroDTO;
import net.weg.api.model.entity.Endereco;
import net.weg.api.service.ClienteService;
import org.springframework.beans.BeanUtils;

import java.util.HashSet;
import java.util.Set;

@Route(value = "/cadastro-usuario", layout = NavBarApp.class)

public class CadastroUsuario extends VerticalLayout {


    private ClienteService usuarioService;

    private TextField nome = new TextField("Nome");
    ;
    private TextField sobrenome = new TextField("Sobrenome");
    ;

    private TextField usuario = new TextField("Usuário");
    ;
    private PasswordField senha = new PasswordField("Senha");
    private PasswordField confirmacaoSenha = new PasswordField("Confirmar Senha");
    private IntegerField idade = new IntegerField("Idade");

    private Grid<EnderecoCadastroDTO> gridEnderecos = new Grid<>(EnderecoCadastroDTO.class);
    private Dialog cadastroEndereco = new Dialog();

    private Button novoEndereco;
    private Button cancelar;
    private Button salvar;

    private FormLayout formLayout = new FormLayout();

    CadastroUsuario(ClienteService usuarioService) {
        this.usuarioService = usuarioService;
        cadastroEndereco.add(new CadastroEndereco(gridEnderecos, cadastroEndereco));


        novoEndereco = new Button("Novo endereço", e -> cadastroEndereco.open());
        salvar = new Button("Salvar", e -> {
            Notification notification = new Notification();
            notification.setDuration(5000);
            try {
                if (!senha.getValue().equals(confirmacaoSenha.getValue())) {
                    throw new RuntimeException();
                }
                Set<Endereco> enderecos = new HashSet<>();
                gridEnderecos.getListDataView().getItems().forEach(enderecoCadastroDTO -> {
                    Endereco endereco = new Endereco();
                    BeanUtils.copyProperties(enderecoCadastroDTO, endereco);
                    enderecos.add(endereco);
                });
                usuarioService.cadastrar(
                        new UsuarioCadastroDTO(nome.getValue(), sobrenome.getValue(), usuario.getValue(), senha.getValue(), idade.getValue(), enderecos));

                notification.setText("Usuário Cadastrado com sucesso!");
                notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
            } catch (Exception exception) {
                notification.setText("Erro no cadastro do usuário!");
                notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
            } finally {
                notification.open();
            }
        });
        salvar.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        cancelar = new Button("Cancelar", e -> {
            new UI().navigate("/");
        });

        idade.getStyle().setWidth("auto");
        var div = new Div(gridEnderecos);
        div.setHeight("128px");
        div.getStyle().set("overflow", "scroll");
        var name = new Div(nome, sobrenome);
        name.getStyle().setDisplay(Style.Display.FLEX);
        name.getStyle().set("gap", "16px");
        var user = new Div(usuario, idade);
        user.getStyle().setDisplay(Style.Display.FLEX);
        user.getStyle().set("gap", "16px");
        var password = new Div(senha, confirmacaoSenha);
        gridEnderecos.getStyle().set("width", "100%");
        gridEnderecos.setWidth("400px");
        gridEnderecos.setHeight("200px");
        div.setWidth("400px");
        div.setHeight("200px");
        password.getStyle().setDisplay(Style.Display.FLEX);
        password.getStyle().set("gap", "16px");
        novoEndereco.getStyle().set("width", "400px");
        gridEnderecos.getStyle().set("margin-top", "16px");
        var confirm = new Div(cancelar, salvar);
        confirm.getStyle().setDisplay(Style.Display.FLEX);
        confirm.getStyle().set("gap", "16px");
        confirm.getStyle().set("margin-top", "16px");
        confirm.getStyle().set("justify-content", "end");
        confirm.setWidth("400px");
        var form = new Div(name, user, password, gridEnderecos, novoEndereco, confirm);
        getStyle().setColor("#FCFCFC");
        setWidth("100vw");
        setHeight("100vh");
        getStyle().setDisplay(Style.Display.FLEX);
        getStyle().set("justify-content", "center");
        getStyle().set("align-items", "center");
        var container = new Div(form);
        container.getStyle().set("padding", "64px");
        container.getStyle().set("display", "flex");
        container.getStyle().set("justify-content", "center");
        container.getStyle().set("align-items", "center");
        container.getStyle().setBoxShadow("0px 0px 15px 0px rgba(0,0,0,0.2)");
        container.getStyle().set("border-radius", "24px");
        container.getStyle().setBackground("#fcfcfc");
        getStyle().setBackground("#26547C");
        add(container);


    }
}
