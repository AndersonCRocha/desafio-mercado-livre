package br.com.challenge.patterns.chain_of_responsability.impl;

import java.util.stream.Stream;

import br.com.challenge.patterns.chain_of_responsability.RuleEvaluator;
import br.com.challenge.patterns.chain_of_responsability.SimianValidator;

public class RowSimianValidator extends SimianValidator {

  private final RuleEvaluator evaluator;

  public RowSimianValidator(RuleEvaluator evaluator) {
    this.evaluator = evaluator;
  }

  @Override
  public boolean validate(String[] dna) {
    return Stream.of(dna).anyMatch(this.evaluator::evaluate) || this.validateNext(dna);
  }

}
