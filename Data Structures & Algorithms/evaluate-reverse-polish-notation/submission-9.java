class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String c : tokens) {
            if (!c.equals("+") && !c.equals("-") && !c.equals("*") && !c.equals("/")) {
                int i = Integer.valueOf(c);
                stack.push(i);
            }
            if (c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/")) {
                int val = stack.pop();

                if (c.equals("+")) {
                    val += stack.pop();
                } else if (c.equals("-")) {
                    val = stack.pop() - val;
                } else if ( c.equals("/")) {
                    System.out.println(c);
                    val = stack.pop()/val;
                } else if (c.equals("*")) {
                    val *= stack.pop();
                }

                stack.push(val);
            }
        }

        return stack.pop();
    }
}
