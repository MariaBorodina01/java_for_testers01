package generator;


import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

import com.sun.jdi.connect.IllegalConnectorArgumentsException;
import common.CommonFunctions;
import model.GroupData;

import java.util.ArrayList;
import java.util.Objects;


public class Generator {

    @Parameter(names={"--type", "-t"})
    String type;

    @Parameter(names={"--output", "-o"})
    String output;

    @Parameter(names={"--format", "-f"})
    String format;

    @Parameter(names={"--count", "-n"})
    int count;

    public static void main(String[] args) throws IllegalConnectorArgumentsException {
        var generator = new Generator();

        JCommander.newBuilder()
                .addObject(generator)
                .build()
                .parse(args);

        generator.run();
    }

    private void run() throws IllegalConnectorArgumentsException {
        var data = generate();
        save(data);
    }

    private Objects generate() throws IllegalConnectorArgumentsException {
       if ("groups".equals(type)){
           return generateGroups();
       } else if ("contacts".equals(type)){
           return generateContacts(); 
       } else {
           throw new IllegalConnectorArgumentsException("Неизвестный тип данных " + type, "");
       }
    }

    private Objects generateContacts() {
        var result = new ArrayList<GroupData>();
        for (int i = 0; count < 5; i++){
            result.add(new GroupData()
                    .withName(CommonFunctions.randomString(i * 10))
                    .withHeader(CommonFunctions.randomString(i * 10))
                    .withFooter(CommonFunctions.randomString(i * 10)));
        }
        return null;
    }

    private Objects generateGroups() {
        return null;
    }

    private void save(Objects data) {
    }
}
