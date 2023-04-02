package ADA.BEJV007.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "ENDERECOS")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Logradouro é um campo obrigatorio.")
    private String logradouro;
    @NotBlank(message = "O campo número é obrigatório.")
    @Pattern(regexp = "\\d{5}", message = "O campo deve conter um número válido")
    private String numero;
    @NotBlank(message = "O campo CEP é obrigatório.")
    @Pattern(regexp = "\\d{8}", message = "O campo deve conter o CEP no formato: 12345678")
    private String cep;
    @NotBlank(message = "Bairro é um campo obrigatorio.")
    private String bairro;
    @NotBlank(message = "Cidade é um campo obrigatorio.")
    private String cidade;
    @NotBlank(message = "Estado é um campo obrigatorio.")
    private String estado;
}
