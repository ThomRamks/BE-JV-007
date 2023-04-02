package ADA.BEJV007.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import ADA.BEJV007.domain.enums.StatusPet;
import ADA.BEJV007.domain.enums.TiposPet;

import java.time.LocalDate;

@Setter
@Getter
public class PetSaveDTO {
    @NotBlank(message = "É preciso inserir um nome")
    private String nome;
    @NotNull(message = "É preciso inserir um tipo de animal")
    private TiposPet tipo;
    @NotNull(message = "É preciso inserir um status ao animal")
    private StatusPet status;
    @NotNull(message = "É preciso inserir uma data de resgate ou nascimento")
    private LocalDate nascimento;
    @NotBlank(message = "Insira uma descrição do animal (cor, pelagem, raça...)")
    private String descricao;
    @NotBlank(message = "É preciso inserir uma imagem")
    private String linkImagem;
}
