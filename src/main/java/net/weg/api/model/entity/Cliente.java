package net.weg.api.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

//@Getter
//@Setter
//@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_cliente")
public class Cliente extends Usuario {

    @OneToMany(fetch = FetchType.EAGER)
    private Set<Carro> carro;
//    @OneToOne(cascade = CascadeType.PERSIST)
//    private Habilitacao habilitacao;
    @OneToMany(mappedBy = "cliente", fetch = FetchType.EAGER) // Serve para evitar duplicidade de ids foreign key, alguma coisa assim
    private Set<Seguro> seguros;


    @Override
    public String toString(){
        return super.toString();
    }
}
