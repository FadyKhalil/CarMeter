
package getMap;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;



/**
 *
 * @author Mostafa Adel
 */
public class Map {
 
    public static ImageView GetMap()
    {
    
/*Dark Mood*/
//        Image map=new Image("buttons/darkMap.jfif");
//        
   /*Light Mood*/
       Image map=new Image("buttons/darkMap.jfif");
        
            
           
       
        ImageView imgView2=new ImageView(map);
        imgView2.setFitWidth(250);
        imgView2.setFitHeight(250);

        return imgView2;
    }
    
}
