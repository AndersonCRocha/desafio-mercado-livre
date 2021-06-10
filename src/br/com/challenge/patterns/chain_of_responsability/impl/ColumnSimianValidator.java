package br.com.challenge.patterns.chain_of_responsability.impl;

import java.util.stream.Stream;

import br.com.challenge.patterns.chain_of_responsability.RuleEvaluator;
import br.com.challenge.patterns.chain_of_responsability.SimianValidator;

public class ColumnSimianValidator extends SimianValidator {

  private final RuleEvaluator evaluator;

  public ColumnSimianValidator(RuleEvaluator evaluator) {
    this.evaluator = evaluator;
  }

  @Override
  public boolean validate(String[] dna) {
    for (int colIndex = 0; colIndex < dna.length; colIndex++) {
      int col = colIndex;
      String word = Stream.of(dna)
        .reduce(
          new StringBuilder(), 
          (acc, val) -> acc.append(val.charAt(col)), 
          StringBuilder::append
        )
        .toString();

      if (this.evaluator.evaluate(word)) {
        return true;
      }
    }

    return this.validateNext(dna);
  }

}
