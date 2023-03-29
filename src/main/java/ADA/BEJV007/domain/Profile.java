package ADA.BEJV007.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

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
    private String nome;
    private String sobrenome;
    @Column(unique = true)
    private String cpf;
    private Integer telefone;
    @Column(name = "e_mail")
    private String email;
    @OneToOne
    @JoinColumn(name = "ID_ENDERECO")
    private Address endereco;
    private LocalDate registro;
}
