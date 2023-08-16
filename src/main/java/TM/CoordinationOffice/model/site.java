package TM.CoordinationOffice.model;

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
public class site {

    private int siteID;
    @NotBlank
    @Size(min = 3, max = 50)
    private String siteName;
}
