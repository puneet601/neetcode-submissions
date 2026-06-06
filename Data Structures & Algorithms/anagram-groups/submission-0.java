class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();

        for(String s: strs){
            char arr[] = s.toCharArray();
            Arrays.sort(arr);
            String sorted = Arrays.toString(arr);
            // System.out.println(sorted);
            if(map.containsKey(sorted)){
                // System.out.println("sorted"+ ":"+s);
                List<String> temp = map.get(sorted);
                temp.add(s);
                map.put(sorted,temp);
                
            }else{
                List<String> temp = new ArrayList<>();
                temp.add(s);
                map.put(sorted,temp);
                
            }
            
        }
        for(String s:map.keySet()){
        
            res.add(map.get(s));
        }
        return res;
    }
}
