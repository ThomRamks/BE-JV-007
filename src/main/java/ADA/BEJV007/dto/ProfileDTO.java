package ADA.BEJV007.dto;

import ADA.BEJV007.domain.Address;

import java.time.LocalDate;

public class ProfileDTO {
    private Long id;
    private String nome;
    private String sobrenome;
    private String cpf;
    private Integer telefone;
    private String email;
    private Address endereco;
    private LocalDate registro;
}
