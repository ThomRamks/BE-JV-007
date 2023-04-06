package ADA.BEJV007.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
    @NotBlank(message = "CEP é um campo obrigatorio.")
    private String cep;
    private String logradouro;
    private String adicional;
    private String bairro;
    private String localidade;
    private String uf;
    private String numero;
}
