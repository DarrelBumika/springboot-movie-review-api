package darrell.spring.moviereviewapi.controller;

import darrell.spring.moviereviewapi.dto.movie.*;
import darrell.spring.moviereviewapi.entity.Movie;
import darrell.spring.moviereviewapi.service.MovieService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/movies")
public class MovieController {

    private final MovieService movieService;

    @GetMapping
    public ResponseEntity<GetAllMoviesResponse> getMovies() {
        final List<Movie> movieList = movieService.getAllMovies();

        return ResponseEntity.ok(new GetAllMoviesResponse(
                movieList.size(),
                movieList
        ));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetMovieResponse> getMovie(@PathVariable UUID id) {
        Movie movie = movieService.getMovieById(id);

        return ResponseEntity.ok(new GetMovieResponse(
                movie.getId(),
                movie.getTitle(),
                movie.getReleaseYear(),
                movie.getSynopsis(),
                movie.getDirector()
        ));
    }

    @PostMapping
    public ResponseEntity<CreateMovieResponse> createMovie(@RequestBody CreateMovieRequest request) {
        final Movie newMovie = movieService.createMovie(new Movie(
                null,
                request.getTitle(),
                request.getReleaseYear(),
                request.getSynopsis(),
                request.getDirector()
        ));

        return ResponseEntity.ok(new CreateMovieResponse(
                newMovie.getId(),
                newMovie.getTitle(),
                newMovie.getDirector()
        ));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteMovieResponse> deleteMovie(@PathVariable UUID id) {
        final UUID deletedId = movieService.deleteMovie(id);

        return ResponseEntity.ok(new DeleteMovieResponse(
                deletedId
        ));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CreateMovieResponse> updateMovie(@PathVariable UUID id, @RequestBody CreateMovieRequest request) {
        final Movie updatedMovie = movieService.updateMovie(id, request);

        return ResponseEntity.ok(new CreateMovieResponse(
                updatedMovie.getId(),
                updatedMovie.getTitle(),
                updatedMovie.getDirector()
        ));
    }

}
