package guru.springframework.sdjpaintro.domain.composite;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class NameId implements Serializable {
    private String firstName;
    private String lastName;

    public NameId() {
    }

    public NameId(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NameId nameId = (NameId) o;

        return firstName.equals(nameId.firstName);
    }

    @Override
    public int hashCode() {
        return firstName.hashCode();
    }
}
