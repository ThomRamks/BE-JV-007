package ADA.BEJV007.domain;

import ADA.BEJV007.domain.enums.StatusPet;
import ADA.BEJV007.domain.enums.TiposPet;
import jakarta.persistence.*;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "PETS")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Enumerated(EnumType.STRING)
    private TiposPet tipo;
    private LocalDate nascimento;
    private String descricao;
    @Enumerated(EnumType.STRING)
    private StatusPet status;
    private String linkImagem;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PERFIS_ID", referencedColumnName = "ID")
    private Profile dono;
}
