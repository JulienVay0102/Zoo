/**
 * 
 */
package zoo.pfleger;

import java.util.ArrayList;

/**
 * @author Konstantin.Mende
 *
 */
public abstract class Test {

	public static void main(String[] args) {

		PflegerModel pflegermodel = new PflegerModel();
		ArrayList<PflegerModel> pflegerModelList = new ArrayList<PflegerModel>();
		
		PflegerDao.createPfleger("Hans", "Dampf");
		PflegerDao.updatePfleger(1, "Hanso", "Dampfo");
		PflegerDao.createPfleger("Fred","Feuerstein");
		pflegerModelList = PflegerDao.getAllPfleger();
		
		for (PflegerModel p : pflegerModelList) {
			System.out.println(p);
		}
		
	}

}
