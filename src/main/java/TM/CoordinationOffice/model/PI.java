package TM.CoordinationOffice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pis")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PI {

    @Id
    @Column(name = "PIID", length = 11)
    private int piID;

    @Column(name = "PIName", length = 64)
    @NotBlank
    private String piName;

    @Override
    public String toString() {
        return "PI{" +
                "piID=" + piID +
                ", piName='" + piName + '\'' +
                '}';
    }
}
