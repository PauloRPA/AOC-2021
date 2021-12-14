package dias;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileReaderUtil {

    private static final Charset CHARSET = StandardCharsets.UTF_8;

    public static LineNumberReader readFileAsLineNumberReader(String filePath) throws IOException {
        URL resource = getResource(filePath);
        if(resource==null) throw new IOException("Arquivo inexistente!.");
        return new LineNumberReader(new FileReader(resource.getPath(), CHARSET));
    }

    public static List<String> readFileToString(String filePath) throws IOException {
        LineNumberReader reader = readFileAsLineNumberReader(filePath);
        List<String> listaStrings = new ArrayList<>();
        while(reader.ready()){
            listaStrings.add(reader.readLine());
        }
        return listaStrings;
    }

    public static List<Integer> readFileToInteger(String filePath) throws IOException, NumberFormatException {
        List<String> listaStrings = readFileToString(filePath);
        List<Integer> listaInteger = listaStrings.stream().map(Integer::parseInt).collect(Collectors.toList());
        return listaInteger;
    }

    public static URL getResource(String path){
        return FileReaderUtil.class.getResource(path);
    }
}

