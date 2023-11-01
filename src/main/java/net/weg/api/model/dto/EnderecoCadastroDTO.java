package net.weg.api.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class EnderecoCadastroDTO {
    private String rua;
    private String bairro;
    private Integer numero;
}
