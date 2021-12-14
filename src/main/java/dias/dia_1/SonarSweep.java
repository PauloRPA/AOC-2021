package dias.dia_1;

import dias.FileReaderUtil;

import java.io.IOException;
import java.util.List;
import java.util.StringJoiner;

public class SonarSweep {

    private static final String DEFAULT_FILENAME = "day1.txt";
    private static final String DEFAULT_PATH = "/inputfiles/";
    private static final String NEWLINE = System.getProperty("line.separator");
    private static final int COLUMN_SIZE = 10;

    private static StringJoiner stringJoiner;

    public static int sonarSweep(List<Integer> listaValores) {
        int contadorNumerosMaiores = 0;

        for (int i = 1; i < listaValores.size(); i++) {
            addValueToString(i, listaValores.get(i).toString());
            if(listaValores.get(i) > listaValores.get(i-1)) contadorNumerosMaiores++;
        }
        return contadorNumerosMaiores;
    }

    private static void addValueToString(int index, String value){
        if(index == 1) stringJoiner = new StringJoiner("-", "[", "]");
        stringJoiner.add(value);
        if(index % COLUMN_SIZE == 0) stringJoiner.add(NEWLINE);
    }

    public static int sonarSweep(String filePath, String fileName) throws IOException {
        return sonarSweep(FileReaderUtil.readFileToInteger(filePath + fileName));
    }

    public static int sonarSweep(String fileName) throws IOException {
        return sonarSweep(DEFAULT_PATH, fileName);
    }

    public static int sonarSweep() throws IOException {
        return sonarSweep(DEFAULT_PATH, DEFAULT_FILENAME);
    }








}
