package ADA.BEJV007.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddressSaveDTO {
    @NotNull(message = "CEP é um campo obrigatorio.")
    @Pattern(regexp = "\\d{8}", message = "O campo deve conter o CEP no formato: 12345678")
    private String cep;
    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;
    @NotBlank(message = "Numero é um campo obrigatorio.")
    @Pattern(regexp = "\\d{1,5}", message = "O campo deve conter um número válido de 1 a 5 dígitos")
    private String numero;
    private String adicional;
}
