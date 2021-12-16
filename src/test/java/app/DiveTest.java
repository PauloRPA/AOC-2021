package app;

import dias.dia_2.Dive;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DiveTest {

    @Test
    @DisplayName("Verifica se os resultados de movimento horizontal, profundidade e mira respeitam as regras descritas a segunda fase do desafio.")
    public void deveDevolverOValorCorretoParteDois() throws IOException {
        final String DEFAULT_FILEPATH = "/inputfiles/";
        final String DEFAULT_FILENAME = "day2Test.txt";
        final int expectedDepth = 60;
        final int expectedHorizontal = 15;
        final int expectedAim = 10;

        Dive submarine = new Dive();
        submarine.divePartTwo(Dive.getCommandListFromFile(DEFAULT_FILEPATH, DEFAULT_FILENAME));

        assertEquals(expectedDepth, submarine.getDepth());
        assertEquals(expectedHorizontal, submarine.getHorizontal());
        assertEquals(expectedAim, submarine.getAim());
    }

    @Test
    @DisplayName("Verifica se os resultados de movimento horizontal e profundidade respeitam as regras descritas na primeira fase do desafio.")
    public void deveDevolverOValorCorretoParteUm() throws IOException {
        final String DEFAULT_FILEPATH = "/inputfiles/";
        final String DEFAULT_FILENAME = "day2Test.txt";
        final int expectedDepthXHorizontal = 150;
        final int expectedDepth = 10;
        final int expectedHorizontal = 15;

        Dive submarine = new Dive();
        submarine.divePartOne(Dive.getCommandListFromFile(DEFAULT_FILEPATH, DEFAULT_FILENAME));

        assertEquals(expectedDepth, submarine.getDepth());
        assertEquals(expectedHorizontal, submarine.getHorizontal());
        assertEquals(expectedDepthXHorizontal, submarine.getDepthXHorizontal());
    }

    @Test
    @DisplayName("Deve gerar uma exception pois existe uma letra onde deveria ser um numero.")
    public void deveGerarUmaException() throws IOException {
        assertThrows(NumberFormatException.class,
                ()->{new Dive().divePartOne(Dive.getCommandListFromFile("/inputFiles/", "day2TestArquivoInvalido.txt"));}
        );
    }

    @Test
    @DisplayName("Deve gerar uma IOException pois o arquivo/caminho indicado não existe.")
    public void deveGerarUmaIOException() throws IOException {
        assertThrows(IOException.class,
                ()->{new Dive().divePartOne(Dive.getCommandListFromFile("/inputFiles/", "arquivoInexistente.txt"));}
        );
        assertThrows(IOException.class,
                ()->{new Dive().divePartOne(Dive.getCommandListFromFile("/caminhoInexistente/", "day1Test.txt"));}
        );
    }
}
