package utilities;

import java.util.Comparator;
import domain.Shape;

public class VolumeCompare implements Comparator<Shape> {

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
