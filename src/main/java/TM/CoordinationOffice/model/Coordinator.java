package TM.CoordinationOffice.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Coordinator {

    private int coordinatorId;
    @NotBlank
    @Size(min = 3, max=50)
    private String coordinatorName;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String password;
    private boolean backup;
    private boolean blind;
}
