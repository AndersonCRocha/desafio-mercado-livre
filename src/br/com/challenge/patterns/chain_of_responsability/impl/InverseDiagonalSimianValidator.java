package br.com.challenge.patterns.chain_of_responsability.impl;

import java.util.stream.Stream;

import br.com.challenge.patterns.chain_of_responsability.RuleEvaluator;
import br.com.challenge.patterns.chain_of_responsability.SimianValidator;

public class InverseDiagonalSimianValidator extends SimianValidator {

  private final RuleEvaluator evaluator;

  public InverseDiagonalSimianValidator(RuleEvaluator evaluator) {
    this.evaluator = evaluator;
  }

  @Override
  public boolean validate(String[] dna) {
    String[] inverseDna = Stream.of(dna)
      .map(row -> new StringBuilder(row).reverse().toString())
      .toArray(String[]::new);

    SimianValidator diagonalValidator = new DiagonalSimianValidator(this.evaluator);
    return diagonalValidator.validate(inverseDna) || validateNext(dna);
  }

}
