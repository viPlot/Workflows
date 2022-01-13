package MVC.repository;

import MVC.domain.Assignment;
import MVC.domain.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, Long> {
    Document findByIdAssigment(Long id_doc);
}
