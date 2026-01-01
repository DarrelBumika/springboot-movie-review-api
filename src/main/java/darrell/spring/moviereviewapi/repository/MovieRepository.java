package darrell.spring.moviereviewapi.repository;

import darrell.spring.moviereviewapi.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    Movie findById(UUID id);
    boolean existsById(UUID id);
    boolean existsByTitleAndDirector(String title, String director);
    void deleteById(UUID id);

}