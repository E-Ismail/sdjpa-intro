package guru.springframework.sdjpaintro.repositories;

import guru.springframework.sdjpaintro.domain.Book;
import guru.springframework.sdjpaintro.domain.BookNatural;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jt on 6/12/21.
 */
public interface BookNaturalRepository extends JpaRepository<BookNatural, String> {
}
