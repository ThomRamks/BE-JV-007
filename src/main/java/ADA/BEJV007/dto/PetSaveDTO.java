package ADA.BEJV007.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import ADA.BEJV007.domain.StatusPet;
import ADA.BEJV007.domain.TiposPet;

import java.time.LocalDate;

@Setter
@Getter
public class PetSaveDTO {
    @NotBlank(message = "É preciso inserir um nome")
    private String nome;
    @NotBlank(message = "É preciso inserir um tipo de animal")
    private TiposPet tipo;
    @NotBlank(message = "É preciso inserir um status ao animal")
    private StatusPet status;
    @NotBlank(message = "É preciso inserir uma data de resgate ou nascimento")
    private LocalDate nascimento;
    @NotBlank(message = "Insira uma descrição do animal (cor, pelagem, raça...)")
    private String descricao;


}
