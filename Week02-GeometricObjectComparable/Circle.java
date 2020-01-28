/**
 * author: Rocky Hughes
 * class: CIS171-W01
 * date: 1/26/2020
 * 
 * This class is used to create a Circle object
 * and extends the base class GeometricObject
 */
public class Circle extends GeometricObject {
    private double radius;
    /** Default constructor */
    public Circle() {
    }
    /** Constructor with args */
    public Circle(double radius) {
      this.radius = radius;
    }
  
    /** Return radius */
    public double getRadius() {
      return radius;
    }
  
    /** Set a new radius */
    public void setRadius(double radius) {
      this.radius = radius;
    }
  
    @Override /** Return area */
    public double getArea() {
      return radius * radius * Math.PI;
    }    
  
    @Override /** Return perimeter */
    public double getPerimeter() {
      return 2 * radius * Math.PI;
    }   
  }