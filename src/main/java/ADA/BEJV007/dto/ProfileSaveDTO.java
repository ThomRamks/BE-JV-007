package ADA.BEJV007.dto;

import ADA.BEJV007.domain.Pet;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import ADA.BEJV007.domain.Address;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
public class ProfileSaveDTO {
    @NotBlank(message = "É preciso inserir um nome")
    private String nome;
    @NotBlank(message = "É preciso inserir um sobrenome")
    private String sobrenome;
    @CPF
    private String cpf;
    @NotBlank(message = "É preciso inserir um telefone.")
    @Pattern(regexp = "\\d{10}", message = "O campo deve conter o ddd e o número no formato: 1144444444")
    private String telefone;
    @NotBlank(message = "É preciso inserir um endereço de e-mail")
    @Email(message = "Insira um e-mail válido")
    private String email;
    private Address endereco;
    @NotNull(message = "o campo data não pode ser nulo")
    private LocalDate registro;
}
