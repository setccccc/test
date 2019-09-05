import org.zardJSON.JSONArray;
import org.zardJSON.JSONObject;

import java.io.FileInputStream;

/**
 * Created by Administrator on 2019/8/19 0019.
 */
public class test {
    public static void main(String[] args){
        try {
            FileInputStream fis = new FileInputStream("E:\\tmp_can_delete\\eclipseWorkspace\\purpletube\\WebContent\\videos\\v\\all");
            byte[] buf = new byte[fis.available()];
            fis.read(buf);
            String vinfo = new String(buf,"utf-8");
            JSONObject job = new JSONObject(vinfo);
            JSONArray ja = job.getJSONArray("list");
            for(int i=0;i<ja.length();i++){
                JSONObject jb = ja.getJSONObject(i);
                System.out.println("id="+jb.getString("id"));
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
