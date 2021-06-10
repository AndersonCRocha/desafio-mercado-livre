package br.com.challenge.patterns.chain_of_responsability.impl;

import br.com.challenge.patterns.chain_of_responsability.RuleEvaluator;
import br.com.challenge.patterns.chain_of_responsability.SimianValidator;

public class DiagonalSimianValidator extends SimianValidator {

  private final RuleEvaluator evaluator;

  public DiagonalSimianValidator(RuleEvaluator evaluator) {
    this.evaluator = evaluator;
  }

  @Override
  public boolean validate(String[] dna) {
    int dnaLength = dna.length;
    
    for (int colIndex = 0; colIndex < dnaLength; colIndex++) {
      int pointer = colIndex;

      StringBuilder wordBuilder = new StringBuilder();
      for (int rowIndex = 0; rowIndex < dnaLength && pointer < dnaLength; rowIndex++, pointer++) {
        wordBuilder.append(dna[rowIndex].charAt(pointer));
      }

      if (this.evaluator.evaluate(wordBuilder.toString())) {
        return true;
      }
    }

    for (int rowIndex = 1; rowIndex < dnaLength; rowIndex++) {
      int pointer = rowIndex;

      StringBuilder wordBuilder = new StringBuilder();
      for (int colIndex = 0; colIndex < dnaLength && pointer < dnaLength; colIndex++, pointer++) {
        wordBuilder.append(dna[pointer].charAt(colIndex));
      }

      if (this.evaluator.evaluate(wordBuilder.toString())) {
        return true;
      }
    }

    return this.validateNext(dna);
  }

}
