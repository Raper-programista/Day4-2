public class Sign {
    public char sign;
    public int count;

    public Sign(char sign){
        this.sign = sign;
        this.count = 1;
    }

    public char getSignChar() {
        return sign;
    }

    public int getCount() {
        return count;
    }

    public void addCount() {
        this.count++;
    }

    public boolean equals(Sign sign){
        if(this == null) return false;
        if((""+sign.sign).equals(""+this.sign)) return true;
        return false;
    }

    public boolean equals(char sign){
        if(this == null) return false;
        if((""+sign).equals(""+this.sign)) return true;
        return false;
    }

    public static int howMuch(String s){
        int counter=0;
        while(s!=""){
            s = s.replace((""+s.charAt(0)),"");
            counter++;
            if(s.equals("")) return counter;
        }

        return counter;
    }

}
