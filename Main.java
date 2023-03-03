import Assets.Objects.Alarm1;
import Assets.Objects.GameCamera;
import Engine.HimawariCore;
import Engine.Components.RectCollider;
import Engine.Database.Storage;
import Engine.Entity.Object;
import Engine.Gfx.Debugging;
import Engine.Gfx.Sprite;
import Engine.Map.Room;
import Engine.Map.RoomData;
import Engine.Map.TileSet;
import Engine.Sound.Sound;
import Engine.Utils.Alarm;
import Engine.Utils.AlarmPack;
import Engine.Utils.Renderer;
import Engine.Utils.Geom.Vec2;
import javafx.util.Pair;

public class Main extends HimawariCore{

    public static void main(String[] args) {

        CreateWindow(800, 600, "Nice Game");

        //CreateObject("Wall", new Vec2(-200, 400), 0, new Vec2(40, 7));
        //CreateObject("Wall", new Vec2(100, 300), 0, new Vec2(1,1));

        //TileSet set = new TileSet(new Sprite("Grass.png"), 16, 16);
        Room r = new Room(null,  new RoomData("room1"));
        LoadRoom(r);
        System.out.println(Object.objects.size());
        
        CreateObject("Ball", new Vec2(40,0), 0, new Vec2(1, 1));
        CreateObject("GameCamera", Vec2.ZERO, 0, Vec2.ZERO);

        /*Object obj = CreateObject("Wall", new Vec2(50, -50), 0, new Vec2(1,1));
        //Object objOther = CreateObject("WallChild", new Vec2(50, -100), 0, new Vec2(1,1));
        player.node.addChild(obj);
        //obj.node.addChild(objOther);
        */
        //player.getComponent(RectCollider.class);

        Debugging.drawColliders = true;


        //Object.sendMessageTo("Paredezinha", null);

        // Sound s = new Sound("idk but sounds decent.mp3", false);
        // s.play();

        //Storage.put("Pontos", String.valueOf(1));

        //Storage.CreateCluster("newCluster", (byte) 4);
    }
}