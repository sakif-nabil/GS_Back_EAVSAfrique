package com.hamzaTech.gestionstock.services;

import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.hamzaTech.gestionstock.entities.Bon;
import com.hamzaTech.gestionstock.entities.Materiel;
import com.itextpdf.awt.geom.Rectangle;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

@Service
public class GenerateBonWord {
	
	
	public void generatePdf(Bon bon) throws Exception {
		
		

		String client= bon.getClient().getNom()+" "+bon.getClient().getPrenom();
		
		String adresseClient= bon.getClient().getAdresse();
		
		String telephoneClient=bon.getClient().getTelephone();
		
		String listMateriels="- ";
		String listMaterielsSerie="- ";
		
		for(Materiel materiel:bon.getListMateriel()) {
			
			listMateriels=listMateriels+materiel.getLibelle()+" / ";
			
			listMaterielsSerie=listMaterielsSerie+ String.valueOf(materiel.getNumeroSerie()) +" / ";
		}

		 DateTimeFormatter dateFormatter
         = DateTimeFormatter.ofPattern("d MMM u", Locale.FRENCH);
 LocalDate ld = LocalDate.now();
 System.out.println(ld.format(dateFormatter));
		
		
		Document document = new Document();
		
		
		PdfWriter.getInstance(document, new FileOutputStream("blank.pdf"));
			
			//File resource = new ClassPathResource("templateExcel/ENOGRIP_CENTRAL.xlsx").getFile();

			document.open();
			Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
			
			
			Paragraph paragraph00 = new Paragraph();
			 Image csbImage = Image.getInstance("logo.png");
			            
			 csbImage.setAlignment(Element.ALIGN_CENTER);
			 csbImage.setSpacingBefore(32f);
			// csbImage.setRight(1f);
			 //csbImage.setAlignment(Element.ALIGN_TOP);
			// csbImage.setAbsolutePosition(0, PageSize.A4.getHeight() - csbImage.getScaledHeight() );
			 document.add(csbImage);
			 
			Paragraph paragraph0 = new Paragraph();
		      paragraph0.add("BON DE PRET\n");
		      paragraph0.setAlignment(Element.ALIGN_CENTER);
		      paragraph0.setSpacingBefore(32f);
		      paragraph0.setSpacingAfter(32f);
		     
		      //paragraph0.setFont(font);
		      document.add(paragraph0);
		     
		      Paragraph paragraph1 = new Paragraph(); 
		   
		      
		      paragraph1.add("EAVS Afrique a le plaisir de vous prêter des enceintes actives et micro HF de la marque AMATE AUDIO et");
		      paragraph1.add("MAJORCOM. Durant cette période de prêt, vous aurez toute l’opportunité de profiter de ce produit en");
		      paragraph1.add("profondeur et d’en apprécier toutes ses qualités. N’hésitez pas à demander si besoin, une Fiche Produit et");
		      paragraph1.add("un Guide Utilisateur à votre commercial qui vous aidera à mieux connaitre le produit.\n");
		      
		      paragraph1.setSpacingAfter(32f);
		      document.add(paragraph1);   

		      //adding Image
		     
              Paragraph paragraph2 = new Paragraph(); 
              paragraph2.add("CLIENT : "+client);
              paragraph2.setFont(font);
              Font fontParagraph = FontFactory.getFont(FontFactory.HELVETICA);
              fontParagraph.setSize(12);
              paragraph2.setFont(fontParagraph);
              
              document.add(paragraph2);
              
              
              Paragraph paragraph3 = new Paragraph(); 
              paragraph3.add("ADRESSE CLIENT : "+adresseClient);
              paragraph3.setFont(font);
             
              paragraph3.setFont(fontParagraph);
              
              document.add(paragraph3);
              
              
              
              Paragraph paragraph4 = new Paragraph(); 
              paragraph4.add("TELEPHONE : "+telephoneClient);
              paragraph4.setFont(font);
             
              paragraph4.setFont(fontParagraph);
              
              document.add(paragraph4);
              
              
              Paragraph paragraph5 = new Paragraph(); 
              paragraph5.add("DATE DE PRET : 06/04/2022");
              paragraph5.setFont(font);
         
              paragraph5.setFont(fontParagraph);
              
              document.add(paragraph5);
              
              
              Paragraph paragraph6 = new Paragraph(); 
              paragraph6.add("PRODUITS : "+listMateriels);
              paragraph6.setFont(font);
            
              paragraph6.setFont(fontParagraph);
              
              document.add(paragraph6);
              
              
              Paragraph paragraph7 = new Paragraph(); 
              paragraph7.add("NUMERO DE SERIE : "+listMaterielsSerie);
              paragraph7.setFont(font);
            
              paragraph7.setFont(fontParagraph);
              paragraph7.setSpacingAfter(32f);
              document.add(paragraph7);
              
              
              Paragraph paragraph8 = new Paragraph(); 
              paragraph8.add("Afin de concrétiser ce prêt, nous vous remercions de bien vouloir nous retourner ce contrat signé.");
              paragraph8.setFont(font);
            
              paragraph8.setFont(fontParagraph);
              paragraph8.setSpacingAfter(32f);
              document.add(paragraph8);
              
              Paragraph paragraph9 = new Paragraph(); 
              paragraph9.add("Pour information, nous vous rappelons que le produit devra être rendu dans son emballage d’origine,"
              		+ " au complet et en état de marche. En cas de détérioration du matériel, vous serez dans l’obligation de le rembourser."
              		+ " D’autre part, les dates de prêts devront être strictement respectées, dans le cas où le produit ne serait pas rendu "
              		+ "dans les 7 jours ouvrés, le prix total du produit mentionné ci-dessus sera facturé. Le signataire de ce document"
              		+ " est dûment autorisé à représenter la société requérante, qui sera responsable d’honorer ce contrat dans sa totalité et"
              		+ " sans aucune exception.");
              paragraph9.setFont(font);
              paragraph9.setSpacingAfter(32f);
              paragraph9.setFont(fontParagraph);
              
              document.add(paragraph9);
              
              
              Paragraph paragraph10 = new Paragraph(); 
              paragraph10.add("Nous vous en souhaitons très bonne utilisation.");
              paragraph10.setSpacingAfter(32f);
              paragraph10.setFont(font);
            
              paragraph10.setFont(fontParagraph);
              
              document.add(paragraph10);
              
              
              Paragraph paragraph11 = new Paragraph(); 
              paragraph11.add("Signature avec la mention Lu et Approuvé");
              paragraph11.setFont(font);
              paragraph11.setSpacingAfter(16f);
              paragraph11.setFont(fontParagraph);
              
              document.add(paragraph11);
              
              
              Paragraph paragraph12 = new Paragraph(); 
              paragraph12.add("Rabat, le "+ld.format(dateFormatter));
              paragraph12.setFont(font);
              paragraph12.setAlignment(Element.ALIGN_RIGHT);
              paragraph12.setFont(fontParagraph);
              
              document.add(paragraph12);
              
              
              Paragraph paragraph13 = new Paragraph(); 
              paragraph13.add("Nom et Fonction du signataire");
              paragraph13.setFont(font);
            
              paragraph13.setFont(fontParagraph);
              
              document.add(paragraph13);
              
              
             
             
		      
		    //  paragraph1.add()
		     
		     
		
		      
		      
		  
			document.close();
		
		
	}
	
	

}








