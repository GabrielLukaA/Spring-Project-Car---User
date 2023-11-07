package net.weg.api.model.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data@Embeddable@AllArgsConstructor
public class SeguroId implements Serializable {
    private Integer seguroId;
    private Integer seguradoraId;
    private static Integer nextId = 1;

    protected SeguroId(){
        seguroId = nextId;
        nextId++;
    }
//    private Integer veiculoId;

}
