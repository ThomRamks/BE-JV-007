package org.example.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
public class ONG {
    private static final ONG ong = new ONG();
    @OneToOne
    @JoinColumn(name = "ID_PET")
    private Pet pets;
    public static ONG getInstance() {
        return ong;
    }
}
