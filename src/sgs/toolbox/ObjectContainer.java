package toolbox;

import processing.core.*;
import processing.opengl.*;
import processing.javafx.*;
import processing.event.*;
import processing.data.*;
import processing.awt.*;
import java.util.ArrayList;

public class ObjectContainer extends GUIContainer {
  
  private int bgCol;
  
  public ObjectContainer(PApplet p, int x, int y, int w, int h) {
    super(p, x, y, w, h);
    bgCol = -1;
    addProperty("Background Color", bgCol);
  }
  
  protected Object getCurrentPropertyValue(String tag, int number) {
    switch (number) {
      case 9 : return bgCol;
      default: return super.getCurrentPropertyValue(tag, number);
    } // end of switch
  }
  
  protected void updateProperty(String tag, int number, Object value) {
    super.updateProperty(tag, number, value);
    switch (number) {
      case 9 : bgCol = (int)value;
      break;
    } // end of switch
  }
  
  public void setBackgroundColor(int c) {
    bgCol = c;
  }
  
  public void draw() {
    parent.noStroke();
    if (bgCol >= 0) {
      parent.fill(bgCol);
      parent.rect(xPos, yPos, width, height);
    } // end of if
    
    super.draw();
  }
  
  public void add(GUIObject o) {
    objects.add(o);
  }
  
  public void remove(GUIObject o) {
    objects.remove(o);
  }
  
  public int getSize() {
    return objects.size();
  }
  
  
}