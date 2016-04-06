/*
     242. Valid Anagram
     anagram
     */
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return Boolean.FALSE;

        List<Character> list = new ArrayList<>();
        List<Character> list1 = new ArrayList<>();
        for(int i =0; i<s.length();i++)
        {
            list.add(s.charAt(i));
            list1.add(t.charAt(i));
        }
        Collections.sort(list);
        Collections.sort(list1);
        for (int i=0 ; i < list.size(); i++)
        {
            if(list.get(i) != list1.get(i))
                return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }