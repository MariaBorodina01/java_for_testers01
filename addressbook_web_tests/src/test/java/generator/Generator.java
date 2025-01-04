package generator;


import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.mysql.cj.x.protobuf.MysqlxExpr;
import com.sun.jdi.connect.IllegalConnectorArgumentsException;
import common.CommonFunctions;
import model.ContactData;
import model.GroupData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;


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

    private Object generate() throws IllegalConnectorArgumentsException {
        if ("groups".equals(type)) {
            return generateGroups();
        } else if ("contacts".equals(type)) {
            return generateContacts();
        } else {
            throw new IllegalConnectorArgumentsException("Неизвестный тип данных " + type, "");
        }
    }

    private Object generateData(Supplier dataSupplier){
        return Stream.generate(dataSupplier).limit(count).collect(Collectors.toList());
    }

    private Object generateContacts() {
        return generateData(() -> new ContactData()
                        .withFirstName(CommonFunctions.randomString(10))
                        .withLasttName(CommonFunctions.randomString(10))
                        .withHomeAddress(CommonFunctions.randomString(10))
                        .withMobilePhone(CommonFunctions.randomString(10))
                        .withMail(CommonFunctions.randomString(10))
                        .withPhoto(CommonFunctions.randomFile("src/test/resources/images"))
            );
        }


    private Object generateGroups() {
        return  generateData(() -> new GroupData()
                    .withName(CommonFunctions.randomString(10))
                    .withHeader(CommonFunctions.randomString(10))
                    .withFooter(CommonFunctions.randomString(10)));
        }


    private void save(Object data) throws IllegalConnectorArgumentsException, IOException {
        if ("json".equals(format)) {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            var json = mapper.writeValueAsString(data);

            try (var writer = new FileWriter(output)) {
                writer.write(json);
            }
        }
        if ("yaml".equals(format)) {
            var mapper = new YAMLMapper();
            mapper.writeValue(new File(output), data);
        }
        if ("xml".equals(format)) {
            var mapper = new XmlMapper();
            mapper.writeValue(new File(output), data);
        } else {
            throw new IllegalConnectorArgumentsException("Неизвестный формат данных " + format, "");
        }
    }
}
