package admin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

public class Persistencia {

	private XStream xstream = new XStream (new DomDriver());
	
	private File arquivo = new File("central.xml");
	
	public Persistencia() {
		xstream.addPermission(AnyTypePermission.ANY);
	}
	
	public void salvarCentral (CentralDeInformacoes central) {
		
			String xml = xstream.toXML(central);
		
			try {
				arquivo.createNewFile();
				PrintWriter pw = new PrintWriter(arquivo);
				pw.print(xml);
				pw.close();
			} catch (IOException e) {
			  }
			
		
		}
	public CentralDeInformacoes recuperarCentral() {
		
				try {
					if(arquivo.exists()) {
						FileInputStream fis = new FileInputStream(arquivo);
						return (CentralDeInformacoes) xstream.fromXML(fis);
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
					
				}
				return new CentralDeInformacoes();
				
			}
	}
	
	
	
	

