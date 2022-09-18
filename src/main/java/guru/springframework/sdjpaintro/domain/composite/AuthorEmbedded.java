package guru.springframework.sdjpaintro.domain.composite;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "author_composite")
public class AuthorEmbedded {

    @EmbeddedId
    private NameId namedId;
    private String country;

    public AuthorEmbedded(NameId namedId) {
        this.namedId = namedId;
    }

    public AuthorEmbedded() {
    }

    public NameId getNamedId() {
        return namedId;
    }

    public void setNamedId(NameId namedId) {
        this.namedId = namedId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
