package com.sample.itext.examples;

import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

public class ReadModifyPdfExample {
	public static void main(String[] args) {
		  try
		  {
			//Read file using PdfReader
			PdfReader pdfReader = new PdfReader("HelloWorld.pdf");

			//Modify file using PdfReader
			PdfStamper addpdfStamper = new PdfStamper(pdfReader, new FileOutputStream("HelloWorld-modified.pdf"));

			Image image = Image.getInstance("temp.png");
			image.scaleAbsolute(100, 50);
			image.setAbsolutePosition(100f, 700f);

			System.out.println("pdfReader.getFileLength() :"+pdfReader.getFileLength());
			System.out.println("pdfReader.getNumberOfPages() :"+pdfReader.getNumberOfPages());
			System.out.println("pdfReader.getEofPos() :"+pdfReader.getEofPos());
			System.out.println("pdfReader.getPageContent(1) :"+pdfReader.getPageContent(1));
			for(int i=1; i<= pdfReader.getNumberOfPages(); i++)
			{
				PdfContentByte content = addpdfStamper.getUnderContent(i);
				System.out.println("PDF content :"+content);
				content.addImage(image);
			}

			addpdfStamper.close();

		  } catch (IOException e) {
			e.printStackTrace();
		  } catch (DocumentException e) {
			e.printStackTrace();
		  }
		}
}
