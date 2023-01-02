import java.util.Objects;
import java.util.Stack;

public class PostfixEvaluationLeetcode150 {
    public static void main(String[] args) {
        String[] tokens = {"2","1","+","3","*"};
        System.out.println(evalRPN(tokens));
    }
    static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for(String s : tokens){
            if(Objects.equals(s, "+") || Objects.equals(s, "-") || Objects.equals(s, "*") || Objects.equals(s, "/")){
                int a = stack.peek();
                stack.pop();
                int b = stack.peek();
                stack.pop();
                int c = evaluate(a,b,s);
                stack.push(c);
            }else{
                int x = Integer.parseInt(s);
                stack.push(x);
            }
        }
        return stack.peek();
    }
    static int evaluate(int a, int b, String c){
        int ans=0;
        switch(c){
            case "+" -> ans = b+a;
            case "-" -> ans = b-a;
            case "*" -> ans = b*a;
            case "/" -> ans = b/a;
        }
        return ans;
    }
}
