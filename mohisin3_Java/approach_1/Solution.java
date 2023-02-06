import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        DictionaryApi dict = new DictionaryApi();
        File file = new File("C:\\Users\\mohit\\Desktop\\A Cryptographic Problem\\EncryptedMessage.txt");
        List<String> words = new ArrayList<>();
        List<String> res = new ArrayList<>();
        try {
            //read by space in the text file
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null) {
                String[] singleword = st.split(" ");
                for (String word : singleword) {
                    words.add(word.toLowerCase());
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        boolean isFound = false;
        for(int i=1;i<=26;i++){
            for(String word:words){
                String newWord = "";
                for(int j=0;j<word.length();j++){
                    char ch = word.charAt(j);
                    int val = ch-'a'+1;
                    val+=i;
                    val%=26;
                    newWord+=(char)(val+'a'-1);
                }
                if(dict.getMeaning(newWord)){
                    res.add(newWord);
                    if(res.size()==words.size()){
                        isFound = true;
                    }
                } else {
                    res.clear();
                    break;
                }
            }
            if(isFound){
                break;
            }
        }
        System.out.print("The Decrypted text is: ");
        for(String word:res){
            System.out.print(word + " ");
        }
    }
}