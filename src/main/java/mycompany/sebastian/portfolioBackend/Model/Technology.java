package mycompany.sebastian.portfolioBackend.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Technology {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "technologies")
    Set<ProjectData> projects;

    public Technology() {
    }

    public Technology(String name, Set<ProjectData> projects) {
        this.name = name;
        this.projects = projects;
    }

    public Set<ProjectData> getProjects() {
        return projects;
    }

    public void setProjects(Set<ProjectData> projects) {
        this.projects = projects;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
