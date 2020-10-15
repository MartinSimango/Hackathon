package hackathon.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = 0L;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    @NotNull
    @Column(name = "about_me", nullable = false)
    private String aboutMe;

    @NotNull
    @Column(name = "tags", nullable = true)
    private String tags;

    //todo: Martin review lazy fetch type
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_allocation_id")
    private ProjectAllocation projectAllocation;


}
