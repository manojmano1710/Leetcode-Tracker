// Last updated: 03/10/2026, 20:30:51
1class Solution {
2    public String validIPAddress(String IP) {
3        if(IP.length()==0) return "Neither";
4        
5        if(IP.indexOf(".")>=0) return validateIPV4(IP);
6        
7        if(IP.indexOf(":")>=0) return validateIPV6(IP);
8        
9        return "Neither";
10    }
11    
12    private  String validateIPV4(String ip){
13	   // step 1 
14        if(ip.charAt(0)=='.' || ip.charAt(ip.length()-1)=='.') return "Neither";
15           
16		  //step 2 
17          String[] component=ip.split("\\.");
18          
19		  //step 3
20           if(component.length!=4) return "Neither";
21           
22		   //step 4
23           for(String comp:component){
24             if(comp.length()==0 || comp.length()>3 || (comp.charAt(0)=='0' && comp.length()>1)){
25                 return "Neither";
26             }
27               
28			   //step5
29              for(char ch:comp.toCharArray()){
30                  if(ch<'0' || ch>'9') return "Neither";
31              }
32               
33			   //step6
34              int num=Integer.parseInt(comp);
35              if(num<0 || num>255) return "Neither";
36               
37           }
38           
39           return "IPv4";
40           }
41           
42   private String validateIPV6(String ip){
43     if(ip.charAt(0)==':' || ip.charAt(ip.length()-1)==':') return "Neither";
44       
45       String[] component=ip.split(":");
46       
47       if(component.length!=8) return "Neither";
48       
49       for(String comp:component){
50       if(comp.length()==0 || comp.length()>4) return "Neither";
51           
52           
53           for(char ch:comp.toLowerCase().toCharArray()){
54             if((ch<'0' || ch>'9') && (ch!='a' && ch!='b' && ch!='c' && ch!='d' && ch!='e' && ch!='f')){
55                 return "Neither";
56             }  
57           }
58       }
59       return "IPv6";
60     }
61 }