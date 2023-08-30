package TM.CoordinationOffice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "coordinators")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Coordinator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="CoordinatorID",nullable = false)
    private long coordinatorId;

    @Column(name = "CoordinatorName",unique = true,length = 64)
    @NotBlank
    @Size(min = 3, max=64)
    private String coordinatorName;

    @Column(name = "Email",unique = true, length = 64)
    @NotBlank
    @Email
    private String email;

    @Column(name = "Password", length = 64)
    @NotBlank
    private String password;

    @Column(name = "Backup", nullable = false)
    private boolean backup;

    @Column(name = "Blind", nullable = false)
    private boolean blind;

    @Override
    public String toString() {
        return "Coordinator{" +
                "coordinatorId=" + coordinatorId +
                ", coordinatorName='" + coordinatorName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", backup=" + backup +
                ", blind=" + blind +
                '}';
    }
}
