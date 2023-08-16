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
@Table(name = "roles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    @Id
    @Column(name = "RoleID", length = 11)
    private int roleID;

    @Column(name = "RoleName", length = 64)
    @NotBlank
    private int roleName;

    @Override
    public String toString() {
        return "Role{" +
                "roleID=" + roleID +
                ", roleName=" + roleName +
                '}';
    }
}
