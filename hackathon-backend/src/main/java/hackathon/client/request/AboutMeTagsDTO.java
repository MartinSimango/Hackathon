package hackathon.client.request;

import io.micronaut.core.annotation.Introspected;

import java.util.List;

@Introspected
public class AboutMeTagsDTO  {

    private String name;
    private String aboutMe;
    private List<String> tags;

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "AboutMeTagsDTO{" +
                "name='" + name + '\'' +
                ", aboutMe='" + aboutMe + '\'' +
                ", tags=" + tags +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }
}
