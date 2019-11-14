import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
 public class Sample
{ 
    	public static void main(String[] args) throws FileNotFoundException 
    {
        	boolean f=true;
    	int p=1;
    	while(f)
    	{
        JSONParser jsonParser = new JSONParser();
        String a="E:\\Java application\\Freshworks\\data\\data"+p+".json";
           
        try (FileReader reader = new FileReader(a))
        {p++;
            Object obj = jsonParser.parse(reader);
 JSONObject pugazh=(JSONObject)obj;
     
             
               
	JSONArray js=(JSONArray) pugazh.get("strikers");
	
	
	for(int i=0;i<js.size();i++)
		parsestrikersObject((JSONObject)js.get(i));
	
        }
        catch (FileNotFoundException e) {
            
            f=false;
        } catch (IOException e) {
            e.printStackTrace();
            f=false;
        } catch (ParseException e) {
            f=false;
            
        }
    }
    	  System.out.println(fo.toJSONString());
   }
    	
    	static JSONArray strikers=new JSONArray();
    	static JSONObject fo=new JSONObject();
    private static void parsestrikersObject(JSONObject obj) throws IOException 
    {
                 
        
        String Name = (String)obj.get("name");    
        
         
       String Club = (String) obj.get("club"); 
        
        Map<String,String>result=new HashMap<String,String>();
        result.put("name",Name);
        result.put("club",Club);
          
        JSONObject obj1=new JSONObject();
        obj1.put("name", Name);
        obj1.put("club",Club);
        strikers.add(obj1);
      fo.put("strikers", strikers);
      FileOutputStream fout=new FileOutputStream("E:\\Java application\\Freshworks\\Merge\\merge1.json");
      fout.write(fo.toJSONString().getBytes());
    }
}
       
       
         
       
       
    

