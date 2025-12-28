package leetcode.jpgTopdfConverter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.io.IOException;

public class ImageToPDF {

    public static void main(String[] args) {
        String imagePath = "D:\\2025\\PERSONAL\\PUSHPLATA\\registration_renewal.jpg";   // Path to JPG
        String pdfPath = "D:\\2025\\PERSONAL\\PUSHPLATA\\registration_renewal.pdf";    // Output PDF

        try {
            convertJpgToPdf(imagePath, pdfPath);
            System.out.println("PDF created successfully: " + pdfPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void convertJpgToPdf(String imagePath, String pdfPath) throws IOException {
        // Load image
        PDDocument document = new PDDocument();
        PDImageXObject image = PDImageXObject.createFromFile(imagePath, document);

        // Create page with same size as image
        PDPage page = new PDPage(new PDRectangle(image.getWidth(), image.getHeight()));
        document.addPage(page);

        // Draw image on page
        PDPageContentStream contentStream = new PDPageContentStream(document, page);
        contentStream.drawImage(image, 0, 0, image.getWidth(), image.getHeight());
        contentStream.close();

        // Save PDF
        document.save(pdfPath);
        document.close();
    }
}