package com.hamzaTech.gestionstock.services;

import java.io.File;
import java.io.FileOutputStream;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.hamzaTech.gestionstock.entities.Bon;
import com.hamzaTech.gestionstock.entities.Materiel;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

@Service
public class GenerateBonWord {
	
	
	public void generatePdf(Bon bon) throws Exception {
		
		Document document = new Document();
		
		
		PdfWriter.getInstance(document, new FileOutputStream("blank.pdf"));
		
		//File resource = new ClassPathResource("templateExcel/ENOGRIP_CENTRAL.xlsx").getFile();

		document.open();
		Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
		Chunk chunk = new Chunk("Bon de commande numéro: "+bon.getId(), font);
		
		Chunk chunk1 = new Chunk("Nom du client : "+bon.getClient().getNom(), font);
		Chunk chunk2 = new Chunk("Prenom du client : "+bon.getClient().getPrenom(), font);
		Chunk chunk3 = new Chunk("Adresse du client : "+bon.getClient().getAdresse(), font);
		//document.add(chunk);
		document.add(chunk1);
		//document.
		//document.add(chunk2);
		//document.add(chunk2.NEWLINE);
		
//		Paragraph p = new Paragraph();
//		p.add(new Text("this will be in bold").setFont(boldFont));
		//document.
//		document.add(chunk2);
//		document.add(chunk3);
		String listMateriels="- ";
		String listMaterielsSerie="- ";
		for(Materiel materiel:bon.getListMateriel()) {
			listMateriels=listMateriels+materiel.getLibelle()+" / ";
			
			listMaterielsSerie=listMaterielsSerie+ String.valueOf(materiel.getNumeroSerie()) +" / ";
		}
		Chunk chunk4 = new Chunk("Liste des materiels : "+listMateriels, font);
		Chunk chunk5 = new Chunk("serie des materiels : "+listMaterielsSerie, font);

//		document.add(chunk4);
//		document.add(chunk5);
		document.close();
	}
	
	

}








