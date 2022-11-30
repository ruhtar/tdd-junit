package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

import java.math.BigDecimal;

public class ReajusteService {

    public void reajustaSalario(Funcionario funcionario, Desempenho desempenho){
        funcionario.setSalario(funcionario.getSalario().multiply(desempenho.percentualDeReajuste()));
    }
}
