package concreteEntities;

import java.awt.Color;
import java.awt.Graphics;
import java.util.HashSet;
import java.util.Set;

import logic.GameFrame;
import logic.entities.PhysicsActor;
import logic.entities.shapedefPrimitives.Circle;
import logic.entities.shapedefPrimitives.Shapedef;
import system.InputProvider;

public class PlayerCursor extends PhysicsActor {

  public PlayerCursor(int xLoc, int yLoc) {
    super();
    this.xLoc = xLoc;
    this.yLoc = yLoc;

    Set<Shapedef> hitbox = new HashSet<Shapedef>();
    hitbox.add(new Circle(xLoc, yLoc, 5));
    setHitbox(hitbox);
  }

  public void step(GameFrame currentFrame) {
    setHitboxX(xLoc);
    setHitboxY(yLoc);
    
    if(InputProvider.isUpPressed)
      yLoc -= 1;
    if(InputProvider.isDownPressed)
      yLoc += 1;
    if(InputProvider.isLeftPressed)
      xSpd -= 1;
    if(InputProvider.isRightPressed)
      xSpd += 1;
  }

  @Override
  public void paint(Graphics g) {
    g.setColor(Color.BLACK);
    g.fillOval(xLoc - 5, yLoc - 5, 10, 10);
  }

  private void setHitboxX(int x) {
    for (Shapedef s : hitbox) {
      Circle c = (Circle) s;
      c.xLoc = x;
    }
  }

  private void setHitboxY(int y) {
    for (Shapedef s : hitbox) {
      Circle c = (Circle) s;
      c.yLoc = y;
    }
  }

}
