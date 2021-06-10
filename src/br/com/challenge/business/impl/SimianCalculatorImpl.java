package br.com.challenge.business.impl;

import java.util.regex.Pattern;

import br.com.challenge.business.SimianCalculator;
import br.com.challenge.patterns.chain_of_responsability.RuleEvaluator;
import br.com.challenge.patterns.chain_of_responsability.SimianValidator;
import br.com.challenge.patterns.chain_of_responsability.impl.ColumnSimianValidator;
import br.com.challenge.patterns.chain_of_responsability.impl.DiagonalSimianValidator;
import br.com.challenge.patterns.chain_of_responsability.impl.DnaSyntaxValidator;
import br.com.challenge.patterns.chain_of_responsability.impl.InverseDiagonalSimianValidator;
import br.com.challenge.patterns.chain_of_responsability.impl.RowSimianValidator;

/**
 * SimianCalculator
 */
public class SimianCalculatorImpl implements SimianCalculator {

  @Override
  public boolean isSimian(String[] dna) {
    RuleEvaluator evaluator = word -> Pattern.compile("([A-Z])\\1{3}").matcher(word).find();

    SimianValidator dnaSyntaxValidator = new DnaSyntaxValidator();
    dnaSyntaxValidator
      .withNext(new RowSimianValidator(evaluator))
      .withNext(new ColumnSimianValidator(evaluator))
      .withNext(new DiagonalSimianValidator(evaluator))
      .withNext(new InverseDiagonalSimianValidator(evaluator));
    
    return dnaSyntaxValidator.validate(dna);
  }

}