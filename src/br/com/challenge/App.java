package br.com.challenge;

import br.com.challenge.business.SimianCalculator;
import br.com.challenge.business.impl.SimianCalculatorImpl;

public class App {

  public static void main(String[] args) {
    String[] dna = { 
      "ATGCGA", 
      "AAGTAC", 
      "GTAAGT", 
      "AGAGCG", 
      "CCCGGA", 
      "GCACTG" 
    };

    SimianCalculator calculator = new SimianCalculatorImpl();
    System.out.printf("isSimian: %s", calculator.isSimian(dna));
  }
  
}
