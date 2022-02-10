package utilities;

import java.util.Comparator;
import domain.Shape;

/**
 * This class provides a comparison of the volume.
 * 
 * @author Dongyeon Kim
 * @author Seungjin Moon
 * @author Yoonju Baek
 * 
 * @version Feb 07 2022
 *
 */
public class VolumeCompare implements Comparator<Shape> {

	/**
	 * Compare the volume of Shape
	 * @return -1 if s1 is less s2, 0 if s1 is equal to s2 , 1 s1 is greater than s2.
	 */
	@Override
	public int compare(Shape s1, Shape s2) {	
		if(s1.calcVolume() > s2.calcVolume()) {			
			return 1;
		}
		else if(s1.calcVolume() < s2.calcVolume()) {
			return -1;
		}
		else {
			return 0;
		}
	}

}
