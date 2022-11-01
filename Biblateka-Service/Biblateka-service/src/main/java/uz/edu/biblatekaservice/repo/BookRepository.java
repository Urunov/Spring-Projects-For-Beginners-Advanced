package uz.edu.biblatekaservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.edu.biblatekaservice.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
