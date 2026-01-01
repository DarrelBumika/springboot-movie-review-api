package darrell.spring.moviereviewapi.service;

import darrell.spring.moviereviewapi.entity.Movie;
import darrell.spring.moviereviewapi.exception.AlreadyExistException;
import darrell.spring.moviereviewapi.exception.NotExistException;
import darrell.spring.moviereviewapi.repository.MovieRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie createMovie(Movie newMovie) {
        if (movieRepository.existsByTitleAndDirector(newMovie.getTitle(), newMovie.getDirector())) {
            throw new AlreadyExistException(
                    String.format("The movie with title: %s and director: %s already exist",
                            newMovie.getTitle(),
                            newMovie.getDirector()
                    )
            );
        }

        return movieRepository.save(new Movie(
                null,
                newMovie.getTitle(),
                newMovie.getReleaseYear(),
                newMovie.getSynopsis(),
                newMovie.getDirector()
        ));
    }

    @Transactional
    public UUID deleteMovie(UUID id) {
        if (!movieRepository.existsById(id)) {
            throw new NotExistException(
                    String.format("The movie with id: %s", id)
            );
        }

        movieRepository.deleteById(id);
        return id;
    }

}
