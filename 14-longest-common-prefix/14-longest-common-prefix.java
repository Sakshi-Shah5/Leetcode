class Solution {
    public String longestCommonPrefix(String[] strs) {
            if(strs.length == 0)
            return "";
       
        String prefix = strs[0];
        for(int i=1; i<strs.length;i++){
            
   //eg:   strs = ["flower","flow","flight"]     
//here, prefix = strs[0] = "flower" 
//rest of the array:  ["flow","flight"]
//while we do not find the prefix at the beginning of current string,
//then we will decrease the size of the string in prefix 
            
        while(strs[i].indexOf(prefix) != 0){  //jab tak flow ke andar flower ye string nahi hai, tab tak flower string se ek ek character kam karte jao
            
            
            prefix = prefix.substring(0,prefix.length()-1);
        }
        }
        
        return prefix;
    }
}