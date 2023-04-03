package ADA.BEJV007.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "PERFIS")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "É preciso inserir um nome")
    private String nome;
    @NotBlank(message = "É preciso inserir um sobrenome")
    private String sobrenome;
    @CPF(message = "Insira um CPF válido")
    private String cpf;
    @NotBlank(message = "O campo telefone é obrigatório.")
    @Pattern(regexp = "\\d{10}", message = "O campo deve conter o ddd e o número no formato: 1144444444")
    private String telefone;
    @NotBlank(message = "O campo e-mail é obrigatório.")
    @Email(message = "Insira um e-mail válido")
    private String email;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_ENDERECO")
    private Address endereco;
    private LocalDate registro;
    @OneToMany(mappedBy = "dono")
    @JsonIgnoreProperties("dono")
    private List<Pet> pets;

}
