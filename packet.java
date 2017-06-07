public class packet {
    public packet(String str) {
        
    }

    public int hash(String str) {
      int hsh=0;
      for (int i=0;i<str.length();i++)
      {
         hsh+=str.charAt(i);
         hsh*=31;
      }
      return hsh;
    }
    
    //add methods as appropriate

   

} // end of  Class
