package Leetecode;

import java.util.*;

/**
 * Created by qinjiawei on 16-12-28.
 */
public class InsertDeleteGetRandomDuplicatesallowed {
    /**
     * 381
     *
     */

}
//class RandomizedCollection{
//
//    List<Integer> nums = new ArrayList<>();
//    Map<Integer, Set<Integer>> map = new HashMap<>();
//
//
//    /** Initialize your data structure here. */
//    public RandomizedCollection() {
//
//    }
//
//    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
//    public boolean insert(int val) {
//        nums.add(val);
//        int size = nums.size();
//        if (map.containsKey(val)) {
//            map.get(val).add(size - 1);
//            return false;
//        }else {
//            Set<Integer> ret = new HashSet<>();
//            ret.add(size - 1);
//            map.put(val, ret);
//            return true;
//        }
//    }
//
//    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
//    public boolean remove(int val) {
//        if (!map.containsKey(val))
//            return false;
//        int index = map.get(val).iterator().next();
//
//        //删除的不是末尾元素
//        if ( index < nums.size()-1 && val != nums.get(nums.size() -1))
//        {
//            int lastval = nums.get(nums.size() -1);
//            map.get(lastval).remove(nums.size() -1);
//            map.get(lastval).add(index);
//            nums.set(index, lastval);
//        }
//
//        nums.remove(nums.size()-1);
//        map.get(val).remove(index);
//
//        if (map.get(val).isEmpty())
//            map.remove(val);
//        return true;
//
//    }
//
//    /** Get a random element from the collection. */
//    public int getRandom() {
//        if (nums.size() <1)
//            return 0;
//        return nums.get(new Random().nextInt(nums.size()));
//
//    }
//}

 class RandomizedCollection {
    HashMap<Integer, HashSet<Integer>> map1;
    HashMap<Integer, Integer> map2;
    Random r;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        map1 = new HashMap<Integer, HashSet<Integer>>();
        map2 = new HashMap<Integer, Integer>();
        r = new Random();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        //add to map2
        int size2 = map2.size();
        map2.put(size2+1, val);

        if(map1.containsKey(val)){
            map1.get(val).add(size2+1);
            return false;
        }else{
            HashSet<Integer> set = new HashSet<Integer>();
            set.add(size2+1);
            map1.put(val, set);
            return true;
        }
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(map1.containsKey(val)){
            HashSet<Integer> set = map1.get(val);
            int toRemove = set.iterator().next();


            //remove from set of map1
            set.remove(toRemove);

            if(set.size()==0){
                map1.remove(val);
            }

            if(toRemove == map2.size()){
                map2.remove(toRemove);
                return true;
            }

            int size2 = map2.size();
            int key = map2.get(size2);

            HashSet<Integer> setChange = map1.get(key);
            setChange.remove(size2);
            setChange.add(toRemove);



            map2.remove(size2);
            map2.remove(toRemove);

            map2.put(toRemove, key);

            return true;
        }

        return false;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        if(map1.size()==0)
            return -1;

        if(map2.size()==1){
            return map2.get(1);
        }

        return map2.get(r.nextInt(map2.size())+1); // nextInt() returns a random number in [0, n).
    }
}