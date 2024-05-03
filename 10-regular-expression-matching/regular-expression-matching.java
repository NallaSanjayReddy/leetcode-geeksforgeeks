import java.util.regex.Pattern;
import java.util.regex.Matcher;

class Solution {
    public boolean isMatch(String s, String p) {
        StringBuilder str=new StringBuilder();
        boolean curstr=false;
        for(int i=0;i<p.length();i++){
            if(p.charAt(i)=='*' && curstr!=true){
                curstr=true;
                str.append('*');
            }
            else if(p.charAt(i)!='*'){
                curstr=false;
                str.append(p.charAt(i));
            }
        }
        String val=str.toString();
        Pattern ptn = Pattern.compile(val);
        Matcher matcher = ptn.matcher(s);
        return matcher.matches();
    }
}
