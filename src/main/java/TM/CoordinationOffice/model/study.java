package TM.CoordinationOffice.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class study {

    private int studyID;
    @NotBlank
    private String protocol;
    @NotBlank
    private String indication;
    @NotBlank
    private int phase;
    @NotBlank
    private String ip;
    private String comparator;
    private String nickname;
}
