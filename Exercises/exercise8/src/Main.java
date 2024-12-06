import org.json.JSONArray;
import org.json.JSONObject;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws Exception {
        String xmlFilePath = "bookshelf.xml";
        String jsonFilePath = "bookshelf.json";

        // parse & print XML file
        Document xmlDoc = parseXMLFile(xmlFilePath);
        printXMLFile(xmlDoc);

        // add an additional book for XML object
        addBookToXML(
                xmlDoc,
                "Dream of the Red Chamber",
                1791,
                2339,
                new String[]{"Xueqin Cao", "E Gao"}
        );
        System.out.print("After Adding a new book, ");
        printXMLFile(xmlDoc);

        // parse & print JSON file
        JSONObject jsonObject = parseJSONFile(jsonFilePath);
        printJSONFile(jsonObject);

        // add an additional book for JSON object
        addBookToJSON(
                jsonObject,
                "Dream of the Red Chamber",
                1791,
                2339,
                new String[]{"Xueqin Cao", "E Gao"}
        );
        System.out.print("After Adding a new book, ");
        printJSONFile(jsonObject);
    }

    private static Document parseXMLFile(String filePath) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        try (FileInputStream fis = new FileInputStream(filePath)) {
            return builder.parse(fis);
        }
    }

    private static JSONObject parseJSONFile(String filePath) throws Exception {
        byte[] jsonData = Files.readAllBytes(Paths.get(filePath));
        String jsonString = new String(jsonData, StandardCharsets.UTF_8);
        return new JSONObject(jsonString);
    }

    private static void printXMLFile(Document doc) throws TransformerException {
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        transformer.transform(new DOMSource(doc), new StreamResult(output));
        String xmlString = output.toString(StandardCharsets.UTF_8);

        System.out.printf("XML file:\n%s\n\n", xmlString);
    }

    private static void printJSONFile(JSONObject obj) throws TransformerException {
        System.out.printf("JSON file:\n%s\n\n", obj.toString(2));
    }

    private static void addBookToXML(Document doc, String title, int publishedYear, int numberOfPages, String[] authors) {
        // sub-elements of book
        Element titleElement = doc.createElement("title");
        titleElement.setTextContent(title);
        Element yearElement = doc.createElement("publishedYear");
        yearElement.setTextContent(String.valueOf(publishedYear));
        Element pagesElement = doc.createElement("numberOfPages");
        pagesElement.setTextContent(String.valueOf(numberOfPages));
        Element authorsElement = doc.createElement("authors");
        for (String author : authors) {
            Element authorElement = doc.createElement("author");
            authorElement.setTextContent(author);
            authorsElement.appendChild(authorElement);
        }

        // book element
        Element bookElement = doc.createElement("Book");
        bookElement.appendChild(titleElement);
        bookElement.appendChild(yearElement);
        bookElement.appendChild(pagesElement);
        bookElement.appendChild(authorsElement);

        // bookshelf element
        Element bookshelf = doc.getDocumentElement();
        bookshelf.appendChild(bookElement);
    }

    private static void addBookToJSON(JSONObject jsonObj, String title, int publishedYear, int numberOfPages, String[] authors) {
        // add sub-elements to a new book
        JSONObject newBook = new JSONObject();
        newBook.put("title", title);
        newBook.put("publishedYear", publishedYear);
        newBook.put("numberOfPages", numberOfPages);
        JSONArray authorsArray = new JSONArray();
        for (String author : authors) {
            authorsArray.put(author);
        }
        newBook.put("authors", authorsArray);

        // add the new book to bookshelf
        JSONObject bookShelf = jsonObj.getJSONObject("BookShelf");
        JSONArray books = bookShelf.getJSONArray("Book");
        books.put(newBook);
    }
}
