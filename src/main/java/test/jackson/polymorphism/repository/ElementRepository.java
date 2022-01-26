package test.jackson.polymorphism.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import test.jackson.polymorphism.domain.interfaces.Element;

@Repository
public interface ElementRepository extends MongoRepository<Element, String> {
}
