import java.util.*;

import java.io.*;

public class Main {
    public static void main(String[] args) {


        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        int distance = 0; // for part 1
        int similarity_score = 0; //for part 2

        //read input file and split to 2 lists - left and right
        try{
            BufferedReader br = new BufferedReader(new FileReader("src/input.txt"));
            String line;

            while((line = br.readLine()) != null){
                String[] parts = line.split("\\s+");
                left.add(Integer.parseInt(parts[0]));
                right.add(Integer.parseInt(parts[1]));

            }

        } catch (IOException e){
            System.out.println(e);
            }

        //part 1
        Collections.sort(left);
        Collections.sort(right);

        for (int i = 0; i < left.size(); i++){
            if (left.get(i) > right.get(i)){
                distance += left.get(i) - right.get(i);
            }
            else{
                distance += right.get(i) - left.get(i);
            }
        }
        //first part answer
        System.out.println("distance: " + distance);



        //part 2
        for (int i = 0; i < left.size(); i++){
            int count = 0;
            int left_number = left.get(i);

            for (int j = 0; j < right.size(); j++){
                if (left_number == right.get(j)){
                    count ++;
                }
            }
            similarity_score += left_number * count;
            }
        //part 2 answer
        System.out.println("similarity_score: " + similarity_score);

    }
}
