//import javafx.scene.Parent;

import java.util.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccessRooms{
    private AccessCode code;
    private int count;
    private long sum;
    int number;
    List<String> realList = new ArrayList<>();
    String password;
    
    public AccessRooms(){
        count=0;
        sum=0;
        number=0;
    }

    public String uploadList(List<String> list){

        String[] convertList =new String[list.size()];
        list.toArray(convertList);
        
        return countRooms(convertList);
    }

    private String countRooms(String[] list){

        for (String line : list)    if(check(line))     realList.add(line);
   
        decrypt();

        for (String s: realList )   if(schearch(s))     return password;
        
        return "nothing";
    }
    
    private void decrypt() {
        
        for (int i=0; i<realList.size(); i++){
            
            String roomName = realList.get(i);
            int sectorID = 0;
            
            Pattern pattern = Pattern.compile(".+-(\\d+)\\[.+]");
            Matcher matcher = pattern.matcher(roomName);
            matcher.find();
            
            try{
                
                sectorID = Integer.parseInt(matcher.group(1));
                
            }catch(IllegalStateException e){
                
                System.out.print("Błędny płąd: "+e+" ");
            }
            
           //System.out.println(sectorID);
            
            for(int j=0; j<sectorID; j++)
                roomName = swap(roomName);
                
            realList.set(i, roomName);
        }
    }

    private boolean schearch(String s) {

        Pattern pattern = Pattern.compile(".*([Nn]orth|[Pp]ole|[Oo]bject).*");
        Matcher matcher = pattern.matcher(s);
        
        if(matcher.find()){
            
            password = s;
            return true;
        }
        
        return false;
    }

    private String swap(String haslo) {
        
        String wynik="";
        
        for (int i=0; i<haslo.length();i++) {
            
            char ch = haslo.charAt(i);

            
            if((ch>=65 && 90>ch) ||
            (ch>=97 && 122> ch)) ch++;
            else if (ch == 90)   ch = 65;
            else if (ch == 122)  ch = 97;
            else if (ch == '-')  ch = ' ';
            
            wynik += ch;
        }
        return wynik;
    }

    private boolean check(String line){
        
        Pattern pattern = Pattern.compile("(.+)-(\\d+)\\[(.+?)]"); //text-text-nuber[text]
        Matcher matcher = pattern.matcher(line);
        matcher.matches();
        
        String encrypedName = matcher.group(1);
        number = Integer.parseInt(matcher.group(2));
        String checksum  = matcher.group(3);

        code = new AccessCode(encrypedName);
        String wynik = code.getCode();

        if(wynik.equals(checksum)) return true;

        return false;
    }
}