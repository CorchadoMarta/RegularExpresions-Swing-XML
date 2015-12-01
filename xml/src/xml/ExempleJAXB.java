package xml;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class ExempleJAXB {
	
	private static final String NOM_FITXER = "ememple.xml";
	private static final String FITXER_ENTRADA = "ememple_invers.xml";

	public static void main(String[] args) {
		Empleat currito = new Empleat(133 ,"Xavi", "home", 40, "Big Boss", "P@ssw0rd");
		Empleat currito2 = new Empleat();
		Empleat currito3 = new Empleat(134 ,"Chema", "home", 32, "Delegat", "123");
		Empleat currito4 = new Empleat(126 ,"Marta", "dona", 23, "Designer", "456");
		Empleat currito5 = new Empleat(127 ,"Gerard", "home", 22, "Aries", "565");
		Empleat currito6 = new Empleat(128 ,"Cagi", "home", 26, "Super Developer", "858");
		Empleat currito7 = new Empleat(126 ,"Juan", "home", 35, "Backend", "639");
		Staff currito0 = new Staff();
		
		try {
			//objecteAXml(currito);
			//currito2 = xmlAObjecte();
			//System.out.println(currito2);
			//Staff myStaff = new Staff();
			//myStaff.add(currito3);
			//myStaff.add(currito4);
			//myStaff.add(currito5);
			//myStaff.add(currito6);
			//myStaff.add(currito7);
			
			//marshallLlista(myStaff, new File("llista_empleats.xml"));
			
			currito0 = unmarshallLlista(new File("llista_empleats.xml"));
			for (Empleat x : currito0.getCurrantes()) {
				System.out.println(x.toString());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

	private static void objecteAXml(Empleat currante) {
		try {
			//Clase CONTEXT: clase que acaba de fer la traducció al xml
			JAXBContext contexte = JAXBContext.newInstance(Empleat.class);
			//Transformador
			Marshaller m = contexte.createMarshaller();
			//Posar-ho bonic
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			//A on es guarda
			m.marshal(currante, new File(NOM_FITXER));
			//Sortida estandard
			m.marshal(currante, System.out);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	private static Empleat xmlAObjecte() {
		try {
			//Clase CONTEXT: clase que acaba de fer la traducció al xml
			JAXBContext contexte = JAXBContext.newInstance(Empleat.class);
			//Destransformador
			Unmarshaller um = contexte.createUnmarshaller();
			
			Empleat temporal = (Empleat) um.unmarshal(new File(FITXER_ENTRADA));
		
			return temporal;
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	private static void marshallLlista(Staff myStaff, File file) {
		try {
			//Clase CONTEXT: clase que acaba de fer la traducció al xml
			JAXBContext contexte = JAXBContext.newInstance(Staff.class);
			BufferedWriter writer = null;
			writer = new BufferedWriter(new FileWriter(file));
			
			//Transformador
			Marshaller m = contexte.createMarshaller();
			//Posar-ho bonic
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.marshal(myStaff, writer);
			
			writer.close();
		} catch (JAXBException | IOException e) {
			e.printStackTrace();
		}
	}
	private static Staff unmarshallLlista(File fitxer_entrada) throws IOException {
		try {
			//Clase CONTEXT: clase que acaba de fer la traducció al xml
			JAXBContext contexte = JAXBContext.newInstance(Staff.class);
			//Destransformador
			Unmarshaller um = contexte.createUnmarshaller();
			//creem el reader
			BufferedReader reader = null;
			reader = new BufferedReader(new FileReader(fitxer_entrada));
			
			Staff temporal = (Staff) um.unmarshal(fitxer_entrada);
		
			reader.close();
			
			return temporal;
		} catch (JAXBException | FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
