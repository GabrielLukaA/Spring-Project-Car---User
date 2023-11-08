package net.weg.api.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.api.model.entity.Cliente;
import net.weg.api.model.entity.Endereco;
import org.hibernate.validator.constraints.br.CNPJ;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeguradoraCadastroDTO implements IDTO {
    private Long cnpj;
    private String nome;
    private Endereco endereco;
    private Collection<Cliente> clientes;
}
