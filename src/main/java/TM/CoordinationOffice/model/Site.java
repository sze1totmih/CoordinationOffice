package TM.CoordinationOffice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "sites")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Site {

    @Id
    @Column(name = "SiteID", length = 11)
    private int siteID;

    @Column(name = "SiteName", length = 64)
    @NotBlank
    @Size(min = 3, max = 50)
    private String siteName;

    @Override
    public String toString() {
        return "Site{" +
                "siteID=" + siteID +
                ", siteName='" + siteName + '\'' +
                '}';
    }
}
