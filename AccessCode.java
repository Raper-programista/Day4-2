public class AccessCode
{
    private int index=0;
    Sign signs[];
    private String code;
    private int length;
    private int coutner;

    public AccessCode (String code)
    {
        this.code = code.replace ("-", "").trim ();
        this.length = this.code.length ();
        coutner = Sign.howMuch(this.code);
        signs = new Sign[coutner];
    }

    public String getCode (){

        for (int i = 0; i < length; i++)
            add(code.charAt(i));
        sort();

        return createCode();
    }

    private String createCode() {
        String result ="";

        for(int i=0; i<5; i++)
            result +=""+signs[i].getSignChar();

        return result;
    }

    private void sort() {
        for(int i=signs.length-1; i>0; i--)
            for(int j=i-1; j>=0; j--)
                if(signs[i].getCount()==signs[j].getCount()){

                    int getI = signs[i].getSignChar();
                    int getJ = signs[j].getSignChar();

                    if(getI<getJ){
                        Sign temp = signs[i];
                        signs[i] = signs[j];
                        signs[j] = temp;
                    }}
                else if(signs[i].getCount()>signs[j].getCount()){
                    Sign temp = signs[i];
                    signs[i] = signs[j];
                    signs[j] = temp;
                }
    }

    private void add(char sign){

            for(int i=0; i<index; i++)
                if(signs[i].equals(sign)) {
                    signs[i].addCount();
                    return;
                }
            if(index< coutner) signs[index++] = new Sign(sign);
    }

}