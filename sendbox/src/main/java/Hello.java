import java.io.File;

public class Hello {
    public static void main(String[] args) {
        System.out.println("Hello, world!");

        var configFile = new File("sendbox/build.gradle");
        System.out.println(configFile.getAbsolutePath());
        System.out.println(configFile.exists());
    }
}
