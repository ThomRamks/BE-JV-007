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
    @Nullable
    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH})
    @JoinColumn (name = "id_dono")
    private Profile dono;
    @Nullable
    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH})
    @JoinColumn (name = "id_pet")
    private Pet pet;
}
