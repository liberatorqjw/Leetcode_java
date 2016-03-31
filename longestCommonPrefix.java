 public String longestCommonPrefix(String[] strs) {

        if (strs.length <=0)
            return "";
        String prefix = strs[0];
        for(int i=0;i<strs.length;i++)
        {
            if(prefix.length()==0 || strs[i].length()==0)
                return "";
            int len = prefix.length()<strs[i].length()?prefix.length():strs[i].length();
            int j;
            for(j=0; j<len;j++)
            {
                if(strs[i].charAt(j) != prefix.charAt(j))
                {
                    break;
                }
            }
            prefix = prefix.substring(0,j);
        }


        return prefix;
    }