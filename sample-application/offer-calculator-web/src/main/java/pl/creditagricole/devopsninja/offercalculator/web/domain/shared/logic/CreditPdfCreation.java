package pl.creditagricole.devopsninja.offercalculator.web.domain.shared.logic;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import io.vavr.collection.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.creditagricole.devopsninja.offercalculator.web.domain.schedule.model.CreditSchedule;
import pl.creditagricole.devopsninja.offercalculator.web.domain.shared.database.CreditDataEntity;
import pl.creditagricole.devopsninja.offercalculator.web.domain.shared.database.PersonalDataEntity;
import pl.creditagricole.devopsninja.offercalculator.web.tools.PdfTools;

@Service
@RequiredArgsConstructor
public class CreditPdfCreation {
	public byte[] toPdf(String name, CreditDataEntity credit, PersonalDataEntity personal, CreditSchedule schedule) {
		return PdfTools.write(document -> {
			Font baseFont = FontFactory.getFont(BaseFont.HELVETICA, BaseFont.CP1250, BaseFont.EMBEDDED, 16, Font.NORMAL, BaseColor.BLACK);
			Font redFont = FontFactory.getFont(BaseFont.HELVETICA, BaseFont.CP1250, BaseFont.EMBEDDED, 16, Font.BOLD, BaseColor.RED);

			document.addTitle(name);

			document.add(new Phrase(name, redFont));
			document.add(Chunk.NEWLINE);
			document.add(Chunk.NEWLINE);
			personalData(personal, document, baseFont);
			document.add(Chunk.NEWLINE);
			creditData(credit, document, redFont);
			document.add(Chunk.NEWLINE);
			schedule(schedule, document);
		});
	}

	private void personalData(PersonalDataEntity personal, Document document, Font baseFont) throws DocumentException {
		List<Chunk> personalData = List.of(
				new Chunk("Imię i nazwisko: " + personal.getFullName(), baseFont),
				new Chunk("Email: " + personal.getEmail(), baseFont),
				new Chunk("Adres: " + personal.getAddress(), baseFont),
				new Chunk("Data urodzenia: " + personal.getBirthDate(), baseFont)
		).intersperse(Chunk.NEWLINE);

		Paragraph personalDataParagraph = new Paragraph();
		personalData.forEach(personalDataParagraph::add);
		document.add(personalDataParagraph);
	}

	private void creditData(CreditDataEntity credit, Document document, Font redFont) throws DocumentException {
		List<Chunk> creditData = List.of(
				new Chunk("Kwota kredytu: " + credit.getCreditAmount(), redFont),
				new Chunk("Ilość rat: " + credit.getInstallmentCount(), redFont)
		).intersperse(Chunk.NEWLINE);

		Paragraph creditDataParagraph = new Paragraph();
		creditData.forEach(creditDataParagraph::add);
		document.add(creditDataParagraph);
	}

	private void schedule(CreditSchedule schedule, Document document) throws DocumentException {
		final Font headerFont = FontFactory.getFont(BaseFont.HELVETICA, BaseFont.CP1250, BaseFont.EMBEDDED, 12, Font.BOLD, BaseColor.RED);
		final Font normalFont = FontFactory.getFont(BaseFont.HELVETICA, BaseFont.CP1250, BaseFont.EMBEDDED, 10, Font.NORMAL, BaseColor.BLACK);

		final PdfPTable table = new PdfPTable(6);

		table.addCell(new PdfPCell(new Phrase("Lp.", headerFont)));
		table.addCell(new PdfPCell(new Phrase("Data spłaty", headerFont)));
		table.addCell(new PdfPCell(new Phrase("Cześć kapitałowa", headerFont)));
		table.addCell(new PdfPCell(new Phrase("Część odsetkowa", headerFont)));
		table.addCell(new PdfPCell(new Phrase("Kwota całej raty", headerFont)));
		table.addCell(new PdfPCell(new Phrase("Pozostało do spłaty", headerFont)));

		schedule.getEntries().forEachWithIndex((entry, index) -> {
			table.addCell(new PdfPCell(new Phrase(String.valueOf(index + 1), normalFont)));
			table.addCell(new PdfPCell(new Phrase(String.valueOf(entry.getPaymentDate()), normalFont)));
			table.addCell(new PdfPCell(new Phrase(String.valueOf(entry.getCapital()), normalFont)));
			table.addCell(new PdfPCell(new Phrase(String.valueOf(entry.getInterest()), normalFont)));
			table.addCell(new PdfPCell(new Phrase(String.valueOf(entry.getInstallment()), normalFont)));
			table.addCell(new PdfPCell(new Phrase(String.valueOf(entry.getLeftCapital()), normalFont)));
		});

		document.add(table);
	}
}
