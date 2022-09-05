import org.apache.commons.lang3.StringUtils;

import java.awt.*;
import java.util.List;

public class Komputer {
 private int lenght;
 private Color color;
 private double price;
 private List<Key> keysList;
 private boolean isActive;

 public Komputer(int lenght, Color color, double price){
  this.lenght = lenght;
  this.color = color;
  this.price = price;
 }

 public void switchOn(){
  this.isActive = true;
 }

 public double priceChange(double newPrice){
  this.price = newPrice;
  return newPrice;
 }

 public Color colorChange(Color newColor){
  this.color = newColor;
  return newColor;
 }


}
