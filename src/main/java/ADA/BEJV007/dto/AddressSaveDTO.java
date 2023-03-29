package org.example.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddressSaveDTO {
    @NotBlank(message = "Logradouro é um campo obrigatorio.")
    private String logradouro;
    @NotNull(message = "Numero é um campo obrigatorio.")
    private Integer numero;
    @NotNull(message = "CEP é um campo obrigatorio.")
    private Integer cep;
    @NotBlank(message = "Bairro é um campo obrigatorio.")
    private String bairro;
    @NotBlank(message = "Cidade é um campo obrigatorio.")
    private String cidade;
    @NotBlank(message = "Estado é um campo obrigatorio.")
    private String estado;
}
