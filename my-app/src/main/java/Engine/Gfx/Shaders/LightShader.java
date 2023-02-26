package Engine.Gfx.Shaders;

import java.awt.*;
import javax.swing.*;

import Engine.Components.Camera;
import Engine.Components.ImageRenderer;
import Engine.Entity.Object;
import Engine.Gfx.ShaderInterface;
import Engine.Utils.Geom.Vec2;

public class LightShader implements ShaderInterface {
 
    private Vec2 position = new Vec2();

    @Override
    public void render(Graphics g, JComponent c) {

      Graphics2D g2 = (Graphics2D)g.create();

    // Create a radial gradient, transparent in the middle.
    java.awt.geom.Point2D center = new java.awt.geom.Point2D.Float(position.x, position.y);
    float radius = 150;
    float[] dist = {0.0f, 1.0f};
    Color[] colors = {new Color(0.0f, 0.0f, 0.0f, 0.0f), Color.BLACK};
    RadialGradientPaint p =
        new RadialGradientPaint(center, radius, dist, colors);
    g2.setPaint(p);
    g2.setComposite(AlphaComposite.getInstance(
        AlphaComposite.SRC_OVER, 0.6f));
    g2.fillRect(0, 0, c.getWidth(), c.getHeight());
  
      g2.dispose();
    }
    
    @Override
    public void graphicsUpdate() {
      
        Object t = Object.FindObject("Ball");
        if(t != null) {

            ImageRenderer renderer = (ImageRenderer) t.getComponent(ImageRenderer.class);
            if(renderer == null) return;
            position.setValues(Camera.calculateWindowTowindowPoint(t.transform.position.inverse()).sumWith(Camera.getOffset()).sumWith(renderer.getDimensions().divide(2)));
        }
    }
}