package com.codecool.common;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.Date;

public class SensorParser {

    private Document sampleDocument() {
        Document document;
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            document = dBuilder.newDocument();
            return document;
        } catch (Exception e) {
            System.out.println(e + "Cannot create DocumentBuilderFactory!");
        }
        return null;
    }

    public Document createDocument(int id, String name, Date time, double value, String type) {
        Document document = sampleDocument();
        if (document == null) {
            System.exit(1);
        }

        Element root = document.createElement("measurement");
        root.setAttribute("id", Integer.toString(id));
        root.setAttribute("name", name);
        root.setAttribute("time", String.valueOf(time));
        root.setAttribute("value", String.valueOf(value));
        root.setAttribute("type", type);

        document.appendChild(root);
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File("test.xml"));
            transformer.transform(source, result);
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
        return document;
    }
}
