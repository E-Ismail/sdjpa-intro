package guru.springframework.sdjpaintro.domain.composite;

import jakarta.persistence.*;

/**
 * Created by jt on 8/14/21.
 */
@Entity
@IdClass(NameId.class)
public class AuthorComposite {

    @Id
    private String firstName;
    @Id
    private String lastName;

    private String country;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}
