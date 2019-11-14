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
        String a="E:\\Java application\\Freshworks\\data\\data"+p+".json";  //To read JSONFiles from a particular path
           
        try (FileReader reader = new FileReader(a))
        {p++;
            Object obj = jsonParser.parse(reader);                           //To read all the JSONObjects and convert it to Java Objects
 JSONObject pugazh=(JSONObject)obj;                                           //To read the JSONObject
     
             
               
	JSONArray js=(JSONArray) pugazh.get("strikers");                       //To read the JSONArray of strikers
	
	
	for(int i=0;i<js.size();i++)
		parsestrikersObject((JSONObject)js.get(i));                    //To read all JSONObjects
	
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
    	  System.out.println(fo.toJSONString());                                   //To print the final JSONObjects
   }
    	
    	static JSONArray strikers=new JSONArray();                                  //To read strikers Array 
    	static JSONObject fo=new JSONObject();                                      //To read all ojects from array
    private static void parsestrikersObject(JSONObject obj) throws IOException 
    {
                 
        
        String Name = (String)obj.get("name");    
        
         
       String Club = (String) obj.get("club"); 
        
        Map<String,String>result=new HashMap<String,String>();                          //To store all values of JSON objects of name and club
        result.put("name",Name);
        result.put("club",Club);
          
        JSONObject obj1=new JSONObject();
        obj1.put("name", Name);
        obj1.put("club",Club);
        strikers.add(obj1);
      fo.put("strikers", strikers);
      FileOutputStream fout=new FileOutputStream("E:\\Java application\\Freshworks\\Merge\\merge1.json");//To locate the Output file
      fout.write(fo.toJSONString().getBytes());//To write the JSONObject in a desired file
    }
}
       
       
         
       
       
    

