import java.util.ArrayList;
import java.util.List;
import java.io.*;  

class FindCollisions extends MyHash{
    public static CharSequence toHex(byte[] byteArray){
        StringBuffer hexData = new StringBuffer();
        for (int i = 0; i < byteArray.length; i++) {  
            hexData.append(Integer.toHexString(0xFF & byteArray[i]));  
        }
        return hexData.subSequence(0,6);//return 6 characters of hash
    }
    public static void main(String[] args) {
        List<CharSequence> hashes = new ArrayList<CharSequence>();
        try{  
            File file=new File("passwords.txt"); //open file containing words to check collison
            FileReader fr=new FileReader(file);
            BufferedReader br=new BufferedReader(fr);
            String line;  
            long startTime = System.currentTimeMillis();// start timer to find collision
            while((line=br.readLine())!=null){ //traverse through each line in file
                CharSequence hash = toHex(myHash(line.getBytes())); // convert the string to hex using SHA-256
                if(hashes.contains(hash)){
                    long endTime = System.currentTimeMillis();//stop timer when collision is found
                    System.out.println("Time taken to find collision: " + (endTime - startTime) + " milliseconds");
                    System.out.println("Found collision at: "+line);
                    break;
                }
                System.out.println(hash);// output has of each password
                hashes.add(hash); //add first n (6 in this case) characters from hash elements to arraylist
            }  
            fr.close();
        }
        catch(IOException e){  
            e.printStackTrace();
        }
        //traverse array list
        // for (CharSequence item : hashes) {
        // System.out.println(item);
        //} 
    }
}