package darrell.spring.moviereviewapi.service;

import darrell.spring.moviereviewapi.entity.Movie;
import darrell.spring.moviereviewapi.exception.AlreadyExistException;
import darrell.spring.moviereviewapi.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

}
