import org.apache.commons.lang3.StringUtils;

import java.awt.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class Komputer {
 private int lenght;
 private Color color;
 private double price;
 private List<Key> keysList;
 private boolean isActive;

 public static void main(String[] args) {
  BigDecimal n = new BigDecimal("1.659090");
  System.out.println(n.setScale(2, RoundingMode.DOWN));
  System.out.println(n.setScale(2, RoundingMode.FLOOR));
  System.out.println(n.setScale(2, RoundingMode.CEILING));
  System.out.println(n.setScale(2, RoundingMode.HALF_DOWN));
  System.out.println(n.setScale(2, RoundingMode.HALF_UP));
  System.out.println(n.setScale(2, RoundingMode.UP));
 }
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
