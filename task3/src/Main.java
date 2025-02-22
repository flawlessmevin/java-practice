import java.util.regex.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        int sum = 0;
        String mul_example = "mul\\((\\d+),(\\d+)\\)";

        //for part 2
        String do_example = "do\\(\\)";
        String dont_do_example = "don't\\(\\)";
        boolean enable = true;


        Pattern pattern = Pattern.compile(mul_example + "|" + do_example + "|" + dont_do_example);

        try {
            BufferedReader br = new BufferedReader(new FileReader("input.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
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
            }
            br.close();
        } catch (IOException e) {
            System.out.println(e);
        }

        //answer
        System.out.println(sum);


    }
}
