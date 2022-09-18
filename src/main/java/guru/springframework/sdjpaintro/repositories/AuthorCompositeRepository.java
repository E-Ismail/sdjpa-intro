package guru.springframework.sdjpaintro.repositories;

import guru.springframework.sdjpaintro.domain.BookNatural;
import guru.springframework.sdjpaintro.domain.composite.AuthorComposite;
import guru.springframework.sdjpaintro.domain.composite.NameId;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jt on 6/12/21.
 */
public interface AuthorCompositeRepository extends JpaRepository<AuthorComposite, NameId> {
}
