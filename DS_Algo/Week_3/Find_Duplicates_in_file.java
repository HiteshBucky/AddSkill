class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> list = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        
        for(int i = 0; i < paths.length; i++){
            
            String[] data = paths[i].split(" ");
            
            for(int j=1;j<data.length;j++){
                String s = data[j];
                int index = s.indexOf("(");
                String content = s.substring(index+1, s.length() - 1);
                
                if(map.containsKey(content))
                    map.get(content).add(data[0]+"/"+s.substring(0,index));
                else{
                    map.put(content, new ArrayList<>());
                    map.get(content).add(data[0]+"/"+s.substring(0,index));
                }
            }
        }
        
        for(List<String> currList: map.values())
            if(currList.size() > 1)
                list.add(currList);
            
        return list;
    }
}