import java.util.regex.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        String full_input = "";
        int sum = 0;
        String mul_example = "mul\\((\\d+),(\\d+)\\)";

        //for part 2
        String do_example = "do\\(\\)";
        String dont_do_example = "don't\\(\\)";
        boolean enable = true;

        //read file and put in String
        try {
            BufferedReader br = new BufferedReader(new FileReader("input.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                full_input += line;
            }
            br.close();
        } catch (IOException e) {
            System.out.println(e);
        }


        Pattern pattern = Pattern.compile(mul_example + "|" + do_example + "|" + dont_do_example);
        Matcher matcher = pattern.matcher(full_input);
        while (matcher.find()) {
            if (matcher.group().equals("do()")){
                enable = true;
            } else if(matcher.group().equals("don't()")){
                enable = false;
            } else if (enable){
                int a = Integer.parseInt(matcher.group(1));
                int b = Integer.parseInt(matcher.group(2));
                sum += a * b;
            }
        }

        //answer
        System.out.println(sum);


        }
    }
