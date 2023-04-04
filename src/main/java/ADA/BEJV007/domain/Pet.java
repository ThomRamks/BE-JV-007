package ADA.BEJV007.domain;

import ADA.BEJV007.domain.enums.StatusPet;
import ADA.BEJV007.domain.enums.TiposPet;
import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotBlank(message = "É preciso inserir um nome")
    private String nome;
    @NotNull(message = "É preciso inserir um tipo de animal")
    @Enumerated(EnumType.STRING)
    private TiposPet tipo;
    private LocalDate nascimento;
    @NotBlank(message = "Insira uma descrição do animal (cor, pelagem, raça...)")
    private String descricao;
    @NotNull(message = "É preciso inserir um status ao animal")
    @Enumerated(EnumType.STRING)
    private StatusPet status;
    @NotBlank(message = "É preciso inserir uma imagem")
    private String linkImagem;
}