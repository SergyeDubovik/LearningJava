package com.epamTasks.beginner.streamAPI.intermediate.datastore;

import com.epamTasks.beginner.streamAPI.intermediate.datastore.model.Genre;
import com.epamTasks.beginner.streamAPI.intermediate.datastore.model.Movie;
import com.epamTasks.beginner.streamAPI.intermediate.datastore.model.Person;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MovieQueries {
    private final List<Movie> movies;

    public MovieQueries(List<Movie> movies) {
        if (movies == null) {
            throw new IllegalArgumentException("Movies list cannot be null");
        }
        this.movies = movies;
    }


    public boolean checkGenreOfAllMovies(Genre genre) {
        return movies.stream()
                .allMatch(movie -> movie.getGenres().contains(genre));
    }

    public boolean checkGenreOfAnyMovies(Genre genre) {
        return movies.stream()
                .anyMatch(movie -> movie.getGenres().contains(genre));
    }

    public boolean checkMovieIsDirectedBy(Person person) {
        return movies.stream()
                .anyMatch(movie -> movie.getDirectors().contains(person));

    }

    public int calculateTotalLength() {
        return movies.stream()
                .mapToInt(Movie::getLength)
                .sum();
    }

    public long moviesLongerThan(int minutes) {
        return movies.stream()
                .filter(movie -> movie.getLength() > minutes)
                .count();
    }

    public List<Person> listOfWriters() {
        return movies.stream()
                .flatMap(movie -> movie.getWriters().stream())
                .distinct()
                .collect(Collectors.toList());
    }

    public String[] movieTitlesWrittenBy(Person person) {
        return movies.stream()
                .filter(movie -> movie.getWriters().contains(person))
                .map(Movie::getTitle)
                .toArray(String[]::new);
    }

    public List<Integer> listOfLength() {
        return movies.stream()
                .map(Movie::getLength)
                .collect(Collectors.toList());
    }

    public Movie longestMovie() {
        if (movies.isEmpty()) {
            throw new IllegalArgumentException("Movies list is empty");
        }

        return movies.stream()
                .max(Comparator.comparingInt(Movie::getLength))
                .get();
    }

    public Movie oldestMovie() {
        if (movies.isEmpty()) {
            throw new IllegalArgumentException("Movies list is empty");
        }

        return movies.stream()
                .min(Comparator.comparingInt(Movie::getReleaseYear))
                .get();
    }

    public List<Movie> sortedListOfMoviesBasedOnReleaseYear() {
        return movies.stream()
                .sorted(Comparator.comparingInt(Movie::getReleaseYear))
                .collect(Collectors.toList());
    }

    public List<Movie> sortedListOfMoviesBasedOnTheDateOfBirthOfOldestDirectorsOfMovies() {
        return movies.stream()
                .sorted(Comparator.comparing(movie ->
                        movie.getDirectors().stream()
                                .map(Person::getDateOfBirth)
                                .min(Comparator.naturalOrder())
                                .orElseThrow()
                ))
                .collect(Collectors.toList());
    }

    public List<Movie> moviesReleasedEarlierThan(int releaseYear) {
        return movies.stream()
                .filter(movie -> movie.getReleaseYear() <= releaseYear)
                .collect(Collectors.toList());
    }

}
