package darrell.spring.moviereviewapi.repository;

import darrell.spring.moviereviewapi.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    Optional<Movie> findByTitle(String title);
    boolean existsByTitle(String title);
    boolean existsByTitleAndDirector(String title, String director);

}