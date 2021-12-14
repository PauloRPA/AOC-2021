package app;

import dias.dia_1.SonarSweep;

import java.io.IOException;

public class App {
    public static void main( String[] args ) throws IOException {

        //Dia 1
        int sonarSweep = SonarSweep.sonarSweep("day1.txt");
        System.out.printf("[SonarSweep: %d]\n", sonarSweep);




    }
}
