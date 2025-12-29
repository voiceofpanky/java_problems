package leetcode.meta;

public class MinRemoveToMakeValidParanthesis {

    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        int open =0;
        for(char c :s.toCharArray()){
            if(c == '(')
            {
                open++;
                sb.append(c);
            }
            else if(c == ')')
            {
                if(open>0){
                    open --;
                    sb.append(c);
                }
            }
            else
            {
                sb.append(c);
            }
        }

        //check from right side
        StringBuilder result =new StringBuilder();
        int toRemove =open;
        for(int i=sb.length()-1;i>=0;i--){
            char c =sb.charAt(i);
            if(c=='(' && toRemove >0){
                toRemove --;
                continue;
            }
            result.append(c);
        }



        return result.reverse().toString();
    }


    public static void main(String[] args) {
        MinRemoveToMakeValidParanthesis obj = new MinRemoveToMakeValidParanthesis();
        String input = "a)b(c)d";
        String output = obj.minRemoveToMakeValid(input);
        System.out.println("Input: " + input);
        System.out.println("Output: " + output); // Expected: "ab(c)d"
    }
}
