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
@Table(name = "studys")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Study {

    @Id
    @Column(name = "StudyID", length = 11)
    private int studyID;

    @Column(name = "Protocol", length = 64)
    @NotBlank
    private String protocol;

    @Column(name = "indication", length = 64)
    @NotBlank
    private String indication;

    @Column(name = "Phase", length = 11)
    @NotBlank
    private int phase;

    @Column(name = "IP", length = 64)
    @NotBlank
    private String ip;

    @Column(name = "Comparator", length = 64)
    private String comparator;

    @Column(name = "Nickname", length = 64)
    private String nickname;


    @Override
    public String toString() {
        return "Study{" +
                "studyID=" + studyID +
                ", protocol='" + protocol + '\'' +
                ", indication='" + indication + '\'' +
                ", phase=" + phase +
                ", ip='" + ip + '\'' +
                ", comparator='" + comparator + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
