package ADA.BEJV007.domain;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "adocao")
public class Adocao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn (name = "id_dono")
    private Profile idDono;
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn (name = "id_pet")
    private Pet idPet;
}
