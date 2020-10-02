package mycompany.sebastian.portfolioBackend.Model;

//import sun.util.resources.Bundles;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ProjectData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String title;

    String description;

    String gitUrl;

    String actionOnClick;

    String action;

    @ManyToMany
    @JoinTable(
      name = "used_technology",
      joinColumns = @JoinColumn(name = "project_id"),
      inverseJoinColumns = @JoinColumn(name = "technology_id"))
    Set<Technology> technologies;

    public ProjectData() {
    }

    public ProjectData(String title, String description, String gitUrl, String actionOnClick, String action, Set<Technology> technologies) {
        this.title = title;
        this.description = description;
        this.gitUrl = gitUrl;
        this.actionOnClick = actionOnClick;
        this.action = action;
        this.technologies = technologies;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Set<Technology> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(Set<Technology> technologies) {
        this.technologies = technologies;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGitUrl() {
        return gitUrl;
    }

    public void setGitUrl(String gitUrl) {
        this.gitUrl = gitUrl;
    }

    public String getActionOnClick() {
        return actionOnClick;
    }

    public void setActionOnClick(String actionOnClick) {
        this.actionOnClick = actionOnClick;
    }
}
