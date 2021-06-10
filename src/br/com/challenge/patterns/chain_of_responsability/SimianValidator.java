package br.com.challenge.patterns.chain_of_responsability;

import java.util.Objects;

public abstract class SimianValidator {

  private SimianValidator next;

  public SimianValidator withNext(SimianValidator simianValidator) {
    this.next = simianValidator;
    return this.next;
  }

  protected boolean validateNext(String[] dna) {
    return Objects.nonNull(this.next) && this.next.validate(dna);
  }

  public abstract boolean validate(String[] dna);

}
