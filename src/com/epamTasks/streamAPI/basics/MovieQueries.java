package com.epamTasks.streamAPI.basics;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MovieQueries {
    private final List<String> movies;

    public MovieQueries(List<String> movies) {
        if (movies == null) {
            throw new IllegalArgumentException("Movie list cannot be null");
        }
        this.movies = movies;
    }

    public long getNumberOfMovies() {
        return movies.stream().count();
    }

    public long getNumberOfMoviesThatStartsWith(String start) {
        return movies.stream()
                .filter(m -> m.startsWith(start))
                .count();
    }

    public long getNumberOfMoviesThatStartsWithAndEndsWith(String start, String end) {
        return movies.stream()
                .filter(m -> m.startsWith(start) && m.endsWith(end))
                .count();
    }

    public List<Integer> getLengthOfTitleOfMovies() {
        return movies.stream()
                .map(String::length)
                .collect(Collectors.toList());
    }

    public int getNumberOfLettersInShortestTitle() {
        return movies.stream()
                .mapToInt(String::length)
                .min()
                .orElseThrow(() -> new IllegalArgumentException("Movie list is empty"));
    }

    public Optional<String> getFirstTitleThatContainsThreeWords() {
        return movies.stream()
                .filter(m -> m.trim().split("\\s+").length == 3)
                .findFirst();
    }

    public List<String> getFirstFourTitlesThatContainAtLeastTwoWords() {
        return movies.stream()
                .filter(m -> m.trim().split("\\s+").length >= 2)
                .limit(4)
                .collect(Collectors.toList());
    }

    public void printAllTitleToConsole() {
        movies.forEach(System.out::println);
    }
}
