// - Create an array variable named `nimals`
//   with the following content: `["kuty", "macsk", "cic"]`
// - Add all elements an `"a"` at the end

import java.util.Arrays;

public class AppendA2 {
    public static void main(String[] args) {
        String[] nimals = {"kuty", "macsk", "cic"};

        for (int i = 0; i < nimals.length; i++){
            nimals[i] += "a";
        }
        System.out.println(Arrays.toString(nimals));
    }
}
