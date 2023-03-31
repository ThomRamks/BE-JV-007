package ADA.BEJV007.dto;

import ADA.BEJV007.domain.enums.StatusPet;
import ADA.BEJV007.domain.enums.TiposPet;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.LocalDate;

public class PetDTO {
    private Long id;
    private String nome;
    @Enumerated(EnumType.STRING)
    private TiposPet tipo;
    private LocalDate nascimento;
    private String descricao;
    @Enumerated(EnumType.STRING)
    private StatusPet status;
    private String linkImagem;
}
