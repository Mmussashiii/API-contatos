package api.contatos.contatos.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
//Todos os atributos do objeto com Getters e Setters pelo Lombok
public class Contatos {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name="nome")
    private String nome;

    @Column(name="dt_nascimento")
    private Date dataNascimento;

    @Column(name="email")
    private String email;

    @Column(name="telefone")
    private String telefone;

    @Column(name="endereco")
    private String endereco;

    @Transient
    public int getIdade() {
        if (this.dataNascimento == null) return 0;

        LocalDate nascimento = this.dataNascimento.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        return Period.between(nascimento, LocalDate.now()).getYears();
    }
}


