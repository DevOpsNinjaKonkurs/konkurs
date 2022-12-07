package pl.creditagricole.devopsninja.offercalculator.web.tools;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import io.vavr.CheckedConsumer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.ByteArrayOutputStream;

public class PdfTools {
	public static ResponseEntity<byte[]> asResponse(byte[] pdf) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_PDF);
		headers.set("content-disposition", "inline; filename=harmonogram.pdf");

		return new ResponseEntity<>(pdf, headers, HttpStatus.OK);
	}

	public static byte[] write(CheckedConsumer<Document> consumer) {
		try {
			Document document = new Document();
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			PdfWriter.getInstance(document, out);

			document.open();
			consumer.accept(document);
			document.close();

			return out.toByteArray();
		} catch (Throwable ex) {
			throw new RuntimeException(ex);
		}
	}
}
