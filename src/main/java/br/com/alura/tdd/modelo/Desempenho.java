package br.com.alura.tdd.modelo;

import java.math.BigDecimal;

public enum Desempenho {
    A_DESEJAR {
        @Override
        public BigDecimal percentualDeReajuste() {
            return new BigDecimal("1.03") ;
        }
    },
    BOM {
        @Override
        public BigDecimal percentualDeReajuste() {
            return new BigDecimal("1.15") ;
        }
    },
    OTIMO{
        @Override
        public BigDecimal percentualDeReajuste() {
            return new BigDecimal("1.20") ;
        }
    };

    public abstract BigDecimal percentualDeReajuste();

}
