package guru.springframework.sdjpaintro;

import guru.springframework.sdjpaintro.domain.AuthorUuid;
import guru.springframework.sdjpaintro.domain.BookNatural;
import guru.springframework.sdjpaintro.domain.BookUuid;
import guru.springframework.sdjpaintro.domain.composite.AuthorComposite;
import guru.springframework.sdjpaintro.domain.composite.AuthorEmbedded;
import guru.springframework.sdjpaintro.domain.composite.NameId;
import guru.springframework.sdjpaintro.repositories.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * Created by jt on 7/4/21.
 */
@ActiveProfiles("local")
@DataJpaTest
@ComponentScan(basePackages = {"guru.springframework.sdjpaintro.bootstrap"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MySQLIntegrationTest {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    BookUuidRepository bookUuidRepository;

    @Autowired
    AuthorUuidRepository authorUuidRepository;

    @Autowired
    BookNaturalRepository bookNaturalRepository;

    @Autowired
    AuthorCompositeRepository authorCompositeRepository;

    @Autowired
    AuthorEmbeddedRepository authorEmbeddedRepository;

    @Test
    void testAuthorEmbedded() {
        NameId nameId= new NameId("JOHN", "DOE");
        AuthorEmbedded authorEmbedded=  new AuthorEmbedded(nameId);
        AuthorEmbedded saved = authorEmbeddedRepository.save(authorEmbedded);
        assertThat(saved).isNotNull();

        AuthorEmbedded fetched = authorEmbeddedRepository.getById(nameId);
        assertThat(fetched).isNotNull();

    }

    @Test
    void testAuthorComposite() {
        NameId nameId= new NameId("JOHN", "DOE");
        AuthorComposite authorComposite= new AuthorComposite();
        authorComposite.setFirstName(nameId.getFirstName());
        authorComposite.setLastName(nameId.getLastName());
        authorComposite.setCountry("Luxembourg");
        AuthorComposite saved = authorCompositeRepository.save(authorComposite);
        AuthorComposite fetched= authorCompositeRepository.getById(nameId);
        assertThat(fetched).isNotNull();
        assertThat(fetched.getCountry()).isEqualTo("Luxembourg");
    }

    @Test
    void testBookNatural() {
        BookNatural bookNatural= new BookNatural();
        bookNatural.setTitle("My Book");
        BookNatural saveBookNatural = bookNaturalRepository.save(bookNatural);
        BookNatural fetched= bookNaturalRepository.getById(saveBookNatural.getTitle());
        assertThat(fetched).isNotNull();
    }



    @Test
    void testBookUuid() {
        BookUuid bookUuid= new BookUuid();
        bookUuid.setTitle("TEST_TITLE");
        bookUuid.setIsbn("123456");
        bookUuid.setPublisher("TEST_PUBLISHER");
        BookUuid saveBookUuid = bookUuidRepository.save(bookUuid);
        assertThat(saveBookUuid).isNotNull();
        assertThat(saveBookUuid.getId());

        BookUuid fetchedBookUuid = bookUuidRepository.getById(bookUuid.getId());
        assertThat(fetchedBookUuid).isNotNull();
        assertThat(fetchedBookUuid.getPublisher()).isEqualTo("TEST_PUBLISHER");
    }

    @Test
    void testAuthorUuid() {
        AuthorUuid authorUuid= new AuthorUuid();
        authorUuid.setFirstName("TEST_UUID");
        authorUuid.setLastName("TEST_LASTNAME");
        AuthorUuid saveAuthorUuid = authorUuidRepository.save(authorUuid);
        assertThat(saveAuthorUuid).isNotNull();
        assertThat(saveAuthorUuid.getId());
        AuthorUuid fetchedAuthorUuid = authorUuidRepository.getReferenceById(saveAuthorUuid.getId());
        assertThat(fetchedAuthorUuid.getFirstName()).isEqualTo("TEST_UUID");
        assertThat(fetchedAuthorUuid).isNotNull();
    }


    @Test
    void testMySQL() {
        long countBefore = bookRepository.count();
        assertThat(countBefore).isEqualTo(2);

    }

}


