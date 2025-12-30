package org.example.cinemamilestone.utilities;

public class FilmNotFoundException extends RuntimeException {
  public FilmNotFoundException(String message) {
    super(message);
  }
}
