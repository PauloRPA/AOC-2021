package app;

import dias.dia_1.SonarSweep;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SonarSweepTest
{
    @Test
    @DisplayName("Deve devolver a quantidade de vezes que o valor posterior for maior que o valor anterior.")
    public void deveDevolverOValorCorreto() throws IOException {
        final int EXPECTED = 7;

        assertEquals(EXPECTED,SonarSweep.sonarSweep("day1Test.txt"));
        assertEquals(EXPECTED,SonarSweep.sonarSweep("/inputfiles/", "day1Test.txt"));
    }

    @Test
    @DisplayName("Deve gerar uma exception pois existe uma String no valor de antrada.")
    public void deveGerarUmaException() throws IOException {
        assertThrows(NumberFormatException.class,
                ()->{SonarSweep.sonarSweep("/inputFiles/", "day1ArquivoInvalidoComStringDentro.txt");}
        );
    }

    @Test
    @DisplayName("Deve gerar uma IOException pois o arquivo/caminho indicado não existe.")
    public void deveGerarUmaIOException() throws IOException {
        assertThrows(IOException.class,
                ()->{SonarSweep.sonarSweep("/inputFiles/", "arquivoInexistente.txt");}
        );
        assertThrows(IOException.class,
                ()->{SonarSweep.sonarSweep("/caminhoInexistente/", "day1Test.txt");}
        );
    }
}
