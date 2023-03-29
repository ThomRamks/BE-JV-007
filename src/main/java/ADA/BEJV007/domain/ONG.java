package ADA.BEJV007.domain;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
public class ONG {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private static final ONG ong = new ONG();
    @OneToOne
    @JoinColumn(name = "ID_PET")
    private Pet pets;
    public static ONG getInstance() {
        return ong;
    }
}
