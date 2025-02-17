import java.util.regex.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        int sum = 0;
        String example = "mul\\((\\d+),(\\d+)\\)";

        //for part 2
        String do_example = "do\\(\\)";
        String dont_do_example = "dont\\(\\)";
        Boolean enable = true;

        try {
            BufferedReader br = new BufferedReader(new FileReader("input.txt"));
            String line;

            Pattern mul_pattern = Pattern.compile(example);

            while ((line = br.readLine()) != null) {
                
                Matcher matcher = mul_pattern.matcher(line);

                while (matcher.find()) {
                    int a = Integer.parseInt(matcher.group(1));
                    int b = Integer.parseInt(matcher.group(2));

                    sum += a * b;
                }
            }
            br.close();

        }catch (IOException e){
            System.out.println(e);
        }


        System.out.println(sum);



    }
}