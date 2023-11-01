package net.weg.api.view;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
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

public class CadastroUsuario extends FormLayout {


    private ClienteService usuarioService ;
    private TextField usuario =  new TextField("Usuário");;
    private PasswordField senha = new PasswordField("Senha");
    private PasswordField confirmacaoSenha = new PasswordField("Confirmar Senha");
    private IntegerField idade = new IntegerField("Idade");

    private Grid<EnderecoCadastroDTO> gridEnderecos = new Grid<>(EnderecoCadastroDTO.class);
    private Dialog cadastroEndereco = new Dialog();

    private Button novoEndereco;
    private Button cancelar;
    private Button salvar;

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
                usuarioService.salvar(
                        new UsuarioCadastroDTO(usuario.getValue(), senha.getValue(), idade.getValue(), enderecos));

                notification.setText("Usuário Cadastrado com sucesso!");
                notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
            } catch (Exception exception) {
                notification.setText("Erro no cadastro do usuário!");
                notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
            } finally {
                notification.open();
            }});

cancelar = new Button("Cancelar", e ->{
    new UI().navigate("/");
});
            add(usuario, senha, confirmacaoSenha, idade, novoEndereco, gridEnderecos, salvar, cancelar);



    }
}
