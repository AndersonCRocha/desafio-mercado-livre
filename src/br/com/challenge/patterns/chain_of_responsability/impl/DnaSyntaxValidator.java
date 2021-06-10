package br.com.challenge.patterns.chain_of_responsability.impl;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import br.com.challenge.exception.InvalidDnaArgumentException;
import br.com.challenge.patterns.chain_of_responsability.SimianValidator;

public class DnaSyntaxValidator extends SimianValidator {
  
  private static final List<String> ALLOWED_CHARACTERS = Arrays.asList("A", "C", "G", "T");

  @Override
  public boolean validate(String[] dna) {
    if (Objects.isNull(dna)) {
      throw new InvalidDnaArgumentException("DNA parameter cannot be null.");
    } 

    if (Stream.of(dna).anyMatch(word -> word.length() != dna.length)) {
      throw new InvalidDnaArgumentException("The DNA must have an NxN matrix.");
    }
    
    boolean containsInvalidLetters = Stream.of(dna)
      .map(word -> new LinkedList<>(Arrays.asList(word.split(""))))
      .anyMatch(lettersSet -> {
        lettersSet.removeAll(ALLOWED_CHARACTERS);
        return lettersSet.size() != 0;
      });
    
    if (containsInvalidLetters) {
      throw new InvalidDnaArgumentException(
        String.format("DNA contains invalid characters. Allowed: %s", ALLOWED_CHARACTERS)
      );
    }

    return this.validateNext(dna);
  }
  
}
