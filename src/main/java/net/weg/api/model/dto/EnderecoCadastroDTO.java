package net.weg.api.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class EnderecoCadastroDTO implements IDTO {
    private String rua;
    private String bairro;
    private Integer numero;
}
