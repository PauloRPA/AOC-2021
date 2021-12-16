package dias.dia_2;

import dias.FileReaderUtil;
import java.io.IOException;
import java.util.List;

//Dive algorithm | Day 2
public class Dive {

    private static final String DEFAULT_FILENAME = "day2.txt";
    private static final String DEFAULT_PATH = "/inputfiles/";

    private static final int INITIAL_DEPTH = 0;
    private static final int INITIAL_HORIZONTAL = 0;
    private static final int INITIAL_AIM = 0;

    private int horizontal = 0;
    private int depth = 0;
    private int aim = 0;

    public void divePartOne(List<String[]> listaValores){
        resetSubmarineStatus();
        for (String[] comandoMovimento : listaValores) {
            switch (comandoMovimento[0]) {
                case "forward":
                    this.horizontal += Integer.parseInt(comandoMovimento[1]);
                    break;
                case "up":
                    this.depth -= Integer.parseInt(comandoMovimento[1]);
                    break;
                case "down":
                    this.depth += Integer.parseInt(comandoMovimento[1]);
                    break;
            }
        }
    }

    public void divePartTwo(List<String[]> listaValores) {
        resetSubmarineStatus();
        for(String[] comandoMovimento: listaValores){
            switch (comandoMovimento[0]) {
                case "forward":
                    forward(Integer.parseInt(comandoMovimento[1]));
                    break;
                case "up":
                    up(Integer.parseInt(comandoMovimento[1]));
                    break;
                case "down":
                    down(Integer.parseInt(comandoMovimento[1]));
                    break;
            }
        }
    }

    private void forward(int amount) {
        this.horizontal += amount;
        this.depth += amount * aim;
    }

    private void up(int amount) {
        this.aim -= amount;
    }

    private void down(int amount) {
        this.aim += amount;
    }

    private void resetSubmarineStatus() {
        setHorizontal(INITIAL_HORIZONTAL);
        setDepth(INITIAL_DEPTH);
        setAim(INITIAL_AIM);
    }

    private void setAim(int aimValue) {
        this.aim = aimValue;
    }

    private void setDepth(int depthValue) {
        this.depth = depthValue;
    }

    private void setHorizontal(int horizontalValue) {
        this.horizontal = horizontalValue;
    }

    public int getAim(){
        return this.aim;
    }

    public int getHorizontal(){
        return this.horizontal;
    }

    public int getDepth(){
        return this.depth;
    }

    public int getDepthXHorizontal(){
        return this.horizontal * this.depth;
    }

    public static List<String[]> getCommandListFromFile(String filePath, String fileName) throws IOException {
        return FileReaderUtil.readFileToStringKeyValue(filePath + fileName, " ");
    }

    public static List<String[]> getCommandListFromFile(String fileName) throws IOException {
        return FileReaderUtil.readFileToStringKeyValue(DEFAULT_PATH + fileName, " ");
    }

    public static List<String[]> getDefaultCommandListFromFile() throws IOException {
        return FileReaderUtil.readFileToStringKeyValue(DEFAULT_PATH + DEFAULT_FILENAME, " ");
    }

    @Override
    public String toString(){
        return String.format("[Horizontal:%s][Depth:%s][Horizontal x Depth: %s][Aim: %s]", this.getHorizontal(), this.getDepth(), this.getDepthXHorizontal(), this.getAim());
    }

}


