import processing.core.PApplet;

public class Main {
    public static void main(String[] args) {
        var snake= new Snake();

        PApplet.runSketch(new String[]{"SnakeSpiel"}, snake);

    }
}