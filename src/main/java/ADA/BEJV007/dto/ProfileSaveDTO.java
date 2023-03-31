package ADA.BEJV007.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import ADA.BEJV007.domain.Address;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Setter
@Getter
public class ProfileSaveDTO {
    @NotBlank(message = "É preciso inserir um nome")
    private String nome;
    @NotBlank(message = "É preciso inserir um sobrenome")
    private String sobrenome;
    @CPF
    private String cpf;
    @NotNull(message = "É preciso inserir um telefone.")
    private Integer telefone;
    @NotBlank(message = "É preciso inserir um endereço de e-mail")
    private String email;
    @NotBlank(message = "É preciso inserir um endereço")
    private Address endereco;
    @NotNull
    private LocalDate registro;
}
