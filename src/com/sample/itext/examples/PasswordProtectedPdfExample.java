package com.sample.itext.examples;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Date;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class PasswordProtectedPdfExample {
	private static String USER_PASSWORD = "tamal";
	private static String OWNER_PASSWORD = "dipanwita";

	public static void main(String[] args) {
		try 
		{
			OutputStream file = new FileOutputStream(new File("PasswordProtected.pdf"));
			Document document = new Document();
			PdfWriter writer = PdfWriter.getInstance(document, file);

			writer.setEncryption(USER_PASSWORD.getBytes(),
					OWNER_PASSWORD.getBytes(), PdfWriter.ALLOW_PRINTING,
					PdfWriter.ENCRYPTION_AES_128);

			document.open();
			document.add(new Paragraph("It's a start of my journey to play with PDF documents !!"));
			document.add(new Paragraph("Owner Name :"+OWNER_PASSWORD));
			document.add(new Paragraph("Only for user :"+USER_PASSWORD));
			document.close();
			file.close();

		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
