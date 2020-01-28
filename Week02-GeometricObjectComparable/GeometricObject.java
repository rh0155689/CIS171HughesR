/**
 * author: Rocky Hughes
 * class: CIS171-W01
 * date: 1/26/2020
 * This is the creation of the superclass that sets the foundation
 * for the geometric objects to be instantiated from and compared by
 */

public abstract class GeometricObject implements Comparable<GeometricObject> {
    public GeometricObject() {      
    }
  
    /** Abstract method getArea */
    protected abstract double getArea();
  
    /** Abstract method getPerimeter */
    public abstract double getPerimeter();  

    /** Since this superclass implements the Comparable interface,
     * it must override the compareTo method
     */
    @Override
    public int compareTo(GeometricObject o) {       
      if (getArea() > o.getArea())
        return 1;
      if (getArea() == o.getArea())        
        return 0;
      else        
        return -1;
    }

    /**Creation of the static max method that will take in two 
     * geometric objects and return the largest
     */
    public static GeometricObject max(GeometricObject o1, GeometricObject o2){
      if (o1.compareTo(o2) > 0)
      return o1;
      else     
      return o2;
    }

    
    
}