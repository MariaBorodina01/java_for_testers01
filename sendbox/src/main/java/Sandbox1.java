import java.io.File;

public class Sandbox1 {
    public static void main(String[] args) {
        System.out.println("Hello, world!");

        var configFile = new File("sandbox/build.gradle");
        System.out.println(configFile.getAbsolutePath());
        System.out.println(configFile.exists());

        System.out.println(new File("").getAbsolutePath());
    }
}
