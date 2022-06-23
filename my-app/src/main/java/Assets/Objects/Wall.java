package Assets.Objects;

import Engine.Entity.Object;
import Engine.Gfx.Sprite;
import Engine.Utils.StdBehaviour;
import Engine.Utils.Geom.Vec2;
import Engine.Components.*;

import java.awt.Graphics2D;

public class Wall extends Object implements StdBehaviour{

    public Wall() { super("Wall"); Object.behaviours.add(getBehaviour()); Object.objects.add(this); Start();}
    
    @Override
    public StdBehaviour getBehaviour(){ return this; }

    RectCollider collider;
    boolean updateable = false;

    //Called once the object is initialized
    @Override
    public void Start() {
        Sprite sprite = new Sprite("square.png");

        ImageRenderer rend = new ImageRenderer(sprite);
        collider = new RectCollider(transform, rend.getDimensions());

        setLayer(1);
        addComponent(rend);
        addComponent(collider);

        collider.solid = false;
        transform.setPosition(-100,-100);

        updateable = true;
    }

    @Override
    public void Update(float deltaTime) {

        if(updateable){
            
            if(collider.isCollidingWith(Object.FindObject("Player")))
                DestroyInstance();
        }
    }
    @Override
    public void DrawGUI(Graphics2D g) {
     
        //g.drawRect((int) collider.transform.position.x, (int) collider.transform.position.y, (int) collider.bounds.x, (int) collider.bounds.y);
    }
    
    @Override
    protected Object makeCopy(){

        return new Wall();
    }
}
