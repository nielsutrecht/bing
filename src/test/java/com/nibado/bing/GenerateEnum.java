package com.nibado.bing;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Tool used to generate (long) enums based on the Big API docs.
 */
public class GenerateEnum {
    public static void main(String... argv) throws Exception {
        new GenerateEnum().generate(GenerateEnum.class.getResourceAsStream("/enum-maneuver-type.txt"), "ManeuverType");
        new GenerateEnum().generate(GenerateEnum.class.getResourceAsStream("/enum-warning-type.txt"), "WarningType");
    }

    public void generate(InputStream input, String enumName, PrintStream outs) throws IOException {
        outs.println("package com.nibado.bing.enums;");
        outs.println();
        outs.println("import java.util.HashMap;");
        outs.println("import java.util.Map;");
        outs.println();

        outs.printf(Locale.ROOT, "public enum %s {\n", enumName);
        printEnumValues(input, outs);
        outs.println();
        outs.println("    private String description;");
        outs.println();
        outs.printf(Locale.ROOT, "    %s(String description) {\n", enumName);
        outs.println("        this.description = description;");
        outs.println("    }");
        outs.println();
        outs.println("    public String getDescription() {");
        outs.println("       return description;");
        outs.println("    }");
        outs.println();
        outs.printf(Locale.ROOT, "    public static %s from(String value) {\n", enumName);
        outs.println("       return enumMap.get(value.toLowerCase());");
        outs.println("    }");
        outs.println();
        outs.printf(Locale.ROOT, "    private static Map<String, %s> enumMap = new HashMap<>();\n", enumName);
        outs.println();
        outs.println("    static {");
        outs.printf(Locale.ROOT, "        for(%s e : %s.values()) {\n", enumName, enumName);
        outs.println("            enumMap.put(e.toString().toLowerCase().replace(\"_\", \"\"), e);");
        outs.println("        }");
        outs.println("    }");
        outs.println("}");
    }

    private void printEnumValues(InputStream input, PrintStream outs) throws IOException {
        BufferedReader ins = new BufferedReader(new InputStreamReader(input));

        String line;
        List<String> values = new ArrayList<>();
        StringBuilder builder = new StringBuilder(100);
        while((line = ins.readLine()) != null) {
            builder.setLength(0);

            String[] parts = line.trim().split("\t");

            for(int i = 0;i < parts[0].length();i++) {
                char c = parts[0].charAt(i);
                if(Character.isUpperCase(c) && i > 0) {
                    builder.append('_');
                }
                builder.append(Character.toUpperCase(c));
            }
            builder.append("(\"");
            builder.append(parts[1]);
            builder.append("\")");

            values.add(builder.toString());
        }

        for(int i = 0;i < values.size();i++) {
            outs.print("    ");
            outs.print(values.get(i));
            outs.println(i == values.size() - 1 ? ';' : ',');
        }
    }


    public void generate(InputStream input, String enumName) throws IOException {
        File output = new File(String.format(Locale.ROOT, "src/main/java/com/nibado/bing/enums/%s.java", enumName));
        if (output.exists()) {
            throw new RuntimeException(String.format(Locale.ROOT, "Enum %s already exists", output.getAbsolutePath()));
        }

        PrintStream outs = new PrintStream(new FileOutputStream(output));

        generate(input, enumName, outs);
    }
}
