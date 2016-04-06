/*
    171. Excel Sheet Column Number
    26 hexadecimal number
     */
    public int pow(int num, int ite){
        for (int i =0; i<ite;i++)
            num *= 26;
        return num;
    }
    public int titleToNumber(String s) {

        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("A", 1);
        hashMap.put("B", 2);
        hashMap.put("C", 3);
        hashMap.put("D", 4);
        hashMap.put("E", 5);
        hashMap.put("F", 6);
        hashMap.put("G", 7);
        hashMap.put("H", 8);
        hashMap.put("I", 9);
        hashMap.put("J", 10);
        hashMap.put("K", 11);
        hashMap.put("L", 12);
        hashMap.put("M", 13);
        hashMap.put("N", 14);
        hashMap.put("O", 15);
        hashMap.put("P", 16);
        hashMap.put("Q", 17);
        hashMap.put("R", 18);
        hashMap.put("S", 19);
        hashMap.put("T", 20);
        hashMap.put("U", 21);
        hashMap.put("V", 22);
        hashMap.put("W", 23);
        hashMap.put("X", 24);
        hashMap.put("Y", 25);
        hashMap.put("Z", 26);

        int sum =0;
        int j =0;
        for(int i = s.length()-1; i>=0; i--)
        {
            int temp = hashMap.get(String.valueOf(s.charAt(i)));
            sum +=pow(temp, j);
            j++;
        }
        return sum;
    }
