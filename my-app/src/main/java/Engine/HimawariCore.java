package Engine;

import javax.swing.JFrame;

import Engine.Components.Camera;
import Engine.Map.Room;
import Engine.Map.RoomHandler;
import Engine.Utils.Window;
import Engine.Utils.Geom.Vec2;

public class HimawariCore {

    private static Window window;
    private static Vec2 savedWindowSize = new Vec2();

    public static enum Windowmode{

        WINDOWED,
        FULLSCREEN
    }
    
    public static void CreateWindow(int width, int height, String name){

        window = new Window();
        window.initWindow(width, height, name);

        savedWindowSize = new Vec2(window.getWidth(), window.getHeight());
    }

    public static void LoadRoom(Room room){

        if(RoomHandler.startRoom == null){
            RoomHandler.startRoom = room;
            RoomHandler.currentRoom = room;
        }else{

            //Move to room
        }
        
        if(room.hasObjects())
            room.loadObjects();
    }

    public static void CloseWindow(){

        window.dispose();
        window = null;
    }

    public static void EndProgram(){

        window.closeWindow();
        window = null;

        System.out.println("[Execution Finished]");
        System.exit(0);
    }

    public static void ChangeWindowMode(Windowmode mode){

        if(mode == Windowmode.WINDOWED){

            window.setSize((int) savedWindowSize.x, (int) savedWindowSize.y);
        }else{
            savedWindowSize = new Vec2(window.getWidth(), window.getHeight());

            window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        }
    }
}