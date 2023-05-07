package tests;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.google.gson.Gson;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.Heroes;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipFilesTest {
    private ClassLoader cl = ZipFilesTest.class.getClassLoader();

    @Test
    @DisplayName("Чтение файла pdf в zip")
    void zipTestPdf() throws Exception {
        try (InputStream is = cl.getResourceAsStream("Pdf.zip");
             ZipInputStream zs = new ZipInputStream(is)) {
            ZipEntry entry;
            while ((entry = zs.getNextEntry()) != null) {
                Assertions.assertTrue(entry.getName().contains("Pdf.pdf"));
                PDF pdf = new PDF(zs);
                Assertions.assertEquals(
                        "dandi",
                        pdf.author
                );
            }
        }
    }

    @Test
    @DisplayName("Чтение файла Xlsx в zip")
    void zipTestXlsx() throws Exception {
        try (InputStream is = cl.getResourceAsStream("Xlsx.zip");
             ZipInputStream zs = new ZipInputStream(is)) {
            ZipEntry entry;
            while ((entry = zs.getNextEntry()) != null) {
                Assertions.assertTrue(entry.getName().contains("Xlsx.xlsx"));
                XLS xls = new XLS(zs);
                Assertions.assertFalse(
                        xls.excel.getSheetAt(0).getRow(1).getCell(1).getStringCellValue()
                                .startsWith("fuck")
                );
            }
        }
    }


    @Test
    @DisplayName("Парсинг json")
    void jsonHeroesTest() throws Exception {
        Gson gson = new Gson();
        try (InputStream is = cl.getResourceAsStream("Heroes.json");
             InputStreamReader isr = new InputStreamReader(is)) {
            Heroes heroes = gson.fromJson(isr, Heroes.class);

            Assertions.assertTrue(heroes.active);
            Assertions.assertEquals(29, heroes.age);
        }
    }

    @Test
    void zipTestArchive() throws Exception {
        try (InputStream is = cl.getResourceAsStream("Archive.zip");
             ZipInputStream zs = new ZipInputStream(is)) {
            ZipEntry entry = zs.getNextEntry();
            while (entry != null) {
                String fileName = entry.getName();
                if (fileName.endsWith(".xlsx")) {
                    XLS xls = new XLS(zs);
                    Assertions.assertTrue(
                            xls.excel.getSheetAt(0).getRow(1).getCell(1).getStringCellValue()
                                    .startsWith("Second")
                    );
                    return;
                }
                entry = zs.getNextEntry();
            }
        }
    }

    @Test
    @DisplayName("Чтение файла Csv в zip")
    void zipTestCvs() throws Exception {
        try (InputStream is = cl.getResourceAsStream("CVS1.zip");
             ZipInputStream zs = new ZipInputStream(is)) {
            ZipEntry entry = zs.getNextEntry();
            while (entry != null) {
                String fileName = entry.getName();
                if (fileName.endsWith(".csv")) {
                    InputStreamReader isr = new InputStreamReader(zs);
                    CSVReader csvReader = new CSVReader(isr);
                    List<String[]> content = csvReader.readAll();
                    Assertions.assertArrayEquals(new String[] {"test.Hub"}, content.get(1));
                    return;
                }
                entry = zs.getNextEntry();
            }
        }
    }

    @Test
    void zipTestPDF() throws Exception {
        try (InputStream is = cl.getResourceAsStream("Archive.zip");
             ZipInputStream zs = new ZipInputStream(is)) {
            ZipEntry entry = zs.getNextEntry();
            while (entry != null) {
                String fileName = entry.getName();
                if (fileName.endsWith(".pdf")) {
                    PDF pdf = new PDF(zs);
                    Assertions.assertEquals(
                            "dandi",
                            pdf.author
                    );
                    return;
                }
            }
        }
    }
}
