package generator;


import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.sun.jdi.connect.IllegalConnectorArgumentsException;
import common.CommonFunctions;
import model.GroupData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class Generator {

    @Parameter(names = {"--type", "-t"})
    String type;

    @Parameter(names = {"--output", "-o"})
    String output;

    @Parameter(names = {"--format", "-f"})
    String format;

    @Parameter(names = {"--count", "-n"})
    int count;

    public static void main(String[] args) throws IllegalConnectorArgumentsException, IOException {
        var generator = new Generator();

        JCommander.newBuilder()
                .addObject(generator)
                .build()
                .parse(args);

        generator.run();
    }

    private void run() throws IllegalConnectorArgumentsException, IOException {
        var data = generate();
        save(data);
    }

    private ArrayList<GroupData> generate() throws IllegalConnectorArgumentsException {
        if ("groups".equals(type)) {
            return generateGroups();
        } else if ("contacts".equals(type)) {
            return generateContacts();
        } else {
            throw new IllegalConnectorArgumentsException("Неизвестный тип данных " + type, "");
        }
    }

    private ArrayList<GroupData> generateContacts() {
        return null;
    }

    private ArrayList<GroupData> generateGroups() {
        var result = new ArrayList<GroupData>();
        for (int i = 0; i < count; i++){
            result.add(new GroupData()
                    .withName(CommonFunctions.randomString(i * 10))
                    .withHeader(CommonFunctions.randomString(i * 10))
                    .withFooter(CommonFunctions.randomString(i * 10)));
        }
        return result;
    }

    private void save(ArrayList<GroupData> data) throws IllegalConnectorArgumentsException, IOException {
        if("json".equals(format)){
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            var json = mapper.writeValueAsString(data);

            try (var writer = new FileWriter(output)){
                writer.write(json);
            };
        }
        else {
            throw  new IllegalConnectorArgumentsException("Неизвестный формат данных " + format, "");
        }
    }
}
