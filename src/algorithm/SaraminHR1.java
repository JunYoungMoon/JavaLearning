package algorithm;

import java.io.*;
import java.lang.*;

public class SaraminHR1 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine().trim());
        String input, output;
        for (int i = 0; i < n; i++) {
            input = reader.readLine().trim();

            output = SaraminHR1.stringBeautify(input);

            writer.write(output + "\n");
        }

        writer.flush();
        writer.close();
        reader.close();
    }
    public static String stringBeautify(String input)
    {
        char[] s = input.toCharArray();
        char[] arr = {'a','e','i','o','u'};
        int cnt = 0,flag =0;
        String str ="";


        for (int i = 0; i < s.length; i++) {

            for(int j = 0 ; j < arr.length; j++)
            {
                //직접적으로 비교하면 안될것 같다.
//                if(s[i] == arr[j]){
//                    cnt++;
//                    flag = 0;
//                    break;
//                }else{
//                    flag = 1;
//                }
            }
//            if(cnt < 2 || flag == 1){
//                str += s[i];
//                flag = 0;
//            }
        }

        return str;
    }
}

