package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @Test
    void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
        BonusService service = new BonusService();
        //Primeira maneira
        //assertThrows(IllegalArgumentException.class, () -> service.calcularBonus(new Funcionario("Fulano de Tal", LocalDate.now(), new BigDecimal("999999999"))));
        try{
            service.calcularBonus(new Funcionario("Fulano de Tal", LocalDate.now(), new BigDecimal("999999999")));
            fail("Não deu a exception.");
        }
        catch(Exception e){
            assertEquals("Funcionário com salário muito alto.",e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    void bonusDeveriaSerDezPorcento() {
        BonusService service = new BonusService();
        BigDecimal salarioEsperado =  service.calcularBonus(new Funcionario("Fulano de Tal", LocalDate.now(), new BigDecimal("50")));
        assertEquals(new BigDecimal("5.0"), salarioEsperado);
    }

    @Test
    void bonusParaSalarioExatamenteIgualADezMilReaisDeveriaSerMilReais() {
        BonusService service = new BonusService();
        BigDecimal salarioEsperado =  service.calcularBonus(new Funcionario("Fulano de Tal", LocalDate.now(), new BigDecimal("10000")));
        assertEquals(new BigDecimal("1000.0"), salarioEsperado);
    }

}