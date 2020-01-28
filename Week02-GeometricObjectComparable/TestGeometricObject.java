/**
 * author: Rocky Hughes
 * class: CIS171-W01
 * date: 1/26/2020
 * 
 * This program will instantiate two rectangles and two circles. It 
 * will return the area for each and compare them and return the largest
 * of the two.
 * 
 */

public class TestGeometricObject {
    public static void main(String[] args){
        /**Instantiating two circle objects to be compared and printing 
         * their area
         */
        GeometricObject circ1 = new Circle(5);
        displayFirstGeometricObject(circ1);
        GeometricObject circ2 = new Circle(7);  
        displaySecondGeometricObject(circ2);
        /**Instantiating a third object to hold the max of the two circles
         * and printing which was largest
         */
        GeometricObject maxCirc = GeometricObject.max(circ1, circ2);
        System.out.println("\nThe area of the max circle is: " + (maxCirc.getArea()) + "\n");
        /**A bit of formatting for asthetics */
        System.out.println("------------------------------------------------------------");

        /**Instantiating two rectangle objects to be compared and printing 
         * their area
         */
        GeometricObject rect1 = new Rectangle(7, 6);
        displayFirstGeometricObject(rect1);
        GeometricObject rect2 = new Rectangle(6, 6);
        displaySecondGeometricObject(rect2);

        /**Instantiating a third object to hold the max of the two circles
         * and printing which was largest
         */
        GeometricObject maxRect = GeometricObject.max(rect1, rect2);
        System.out.println(" \nThe area of the max rectangle is: " + (maxRect.getArea()) + "\n");
    }

    /**Created two methods. One to display the first of each object and one
     * to display the second of each object.
     */
    public static void displayFirstGeometricObject(GeometricObject o) {
        System.out.println();
        System.out.println("The area of the first object is: " + o.getArea());
    }

    public static void displaySecondGeometricObject(GeometricObject o) {
        System.out.println();
        System.out.println("The area of the second object is: " + o.getArea());
    }
}