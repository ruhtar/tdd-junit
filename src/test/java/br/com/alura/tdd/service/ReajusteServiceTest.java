package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReajusteServiceTest {
    ReajusteService service;
    Funcionario funcionario;

    @BeforeEach
    public void inicilizar(){
        System.out.println("Inicializando atributos.");
        service = new ReajusteService();
        funcionario = new Funcionario("Fulano de Tal", LocalDate.now(), new BigDecimal("1000"));
    }

    @AfterAll
    public static void finalizar(){
        System.out.println("Fim.");
    }


    @Test
    void reajusteDeveSerDeTresPorcentoQuandoDesempenhoForADesejar(){
        service.reajustaSalario(funcionario, Desempenho.A_DESEJAR);
        assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }

    @Test
    void reajusteDeveSerDeQuinzePorcentoQuandoDesempenhoForBom(){
        service.reajustaSalario(funcionario, Desempenho.BOM);
        assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }

    @Test
    void reajusteDeveSerDeVinteorcentoQuandoDesempenhoForOtimo(){
        service.reajustaSalario(funcionario, Desempenho.OTIMO);
        assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }

}
