import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) {

        List<List<Integer>> reports = new ArrayList<>();
        int safe_reports_count = 0; //for part 1
        int safe_reports_count2 = 0; //for part 2

        List<List<Integer>> safe_reports = new ArrayList<>();
        List<List<Integer>> unsafe_reports = new ArrayList<>();

        //read input file and split each report to list of levels and put each to reports list
        try{
            BufferedReader br = new BufferedReader(new FileReader("input.txt"));
            String line;
            while ((line = br.readLine()) != null ) {
                String[] parts = line.split("\\s+");

                List<Integer> report = new ArrayList<>();

                for (String part : parts) {
                    report.add(Integer.parseInt(part));
                }
                reports.add(report);
            }
        } catch (IOException e){
            System.out.println(e);
            }


        //part 1
        for (List<Integer> report : reports) {

            boolean safe = check_safety(report);

            if (safe) {
                safe_reports_count++;
                safe_reports.add(report);
            } else {
                unsafe_reports.add(report);
            }
        }
        //answer part 1
        System.out.println("answer 1 part: " + safe_reports_count);




        //part 2
        for (List<Integer> report : unsafe_reports) {
            for (int i = 0; i < report.size(); i++) {
                List<Integer> report_copy = new ArrayList<>(report);
                report_copy.remove(i);
                boolean safe = check_safety(report_copy);
                if (safe) {
                    safe_reports_count2++;
                    break;
                }
            }
        }
        //answer part 2
        int all_safe_reports_count = safe_reports_count + safe_reports_count2;
        System.out.println("answer 2 part: " + all_safe_reports_count);

    }

    //check safety function
    public static boolean check_safety(List<Integer>report) {
        int levels_count = report.size();
        boolean up = (report.get(0) < report.get(1));
        
        for (int i = 1; i < levels_count; i++) {
            int step = report.get(i) - report.get(i-1);
            if (up) {
                if (step > 3 || step < 1) return false;
            }else{
                if (step < -3 || step > -1) return false;
            }
        }
        return true;
    }
}