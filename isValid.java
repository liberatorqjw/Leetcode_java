 public boolean isValid(String s) {


        if(s.length() ==0)
            return Boolean.TRUE;
        int i =0;

        Stack stack = new Stack();
        if(s.length() % 2 !=0)
            return Boolean.FALSE;
        while(i < s.length()) {
            char c1 = s.charAt(i);

            if (c1 == '('||c1 == '[' || c1=='{')
            {
                stack.push(c1);
            }
            else {
                if (stack.isEmpty())
                    return Boolean.FALSE;
                char c2 = (char)stack.pop();
                if (c2 == '(')
                {
                    if (c1 != ')')
                        return Boolean.FALSE;
                }
                else if(c2 == '[')
                {
                    if(c1!= ']')
                        return Boolean.FALSE;
                }
                else if(c2 == '{')
                {
                    if(c1 != '}')
                        return Boolean.FALSE;
                }
            }
            i++;
        }
        if (!stack.isEmpty())
            return Boolean.FALSE;
        return Boolean.TRUE;
    }