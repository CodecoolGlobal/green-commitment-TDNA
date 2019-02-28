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

    public Document createDocument(int id, long time, int value, String type) {
        Document document = sampleDocument();
        if (document == null) {
            System.exit(1);
        }

        Element root = document.createElement("measurements");
        root.setAttribute("id", Integer.toString(id));
        document.appendChild(root);

        Element measurement = document.createElement("measurement");
        root.appendChild(measurement);

        Element timeNode = document.createElement("time");
        timeNode.setTextContent(String.valueOf(time));
        measurement.appendChild(timeNode);

        Element valueNode = document.createElement("value");
        valueNode.setTextContent(String.valueOf(value));
        measurement.appendChild(valueNode);

        Element typeNode = document.createElement("type");
        typeNode.setTextContent(type);
        measurement.appendChild(typeNode);

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

    public void parseDocument(Document document){
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File("test.xml"));
            transformer.transform(source, result);
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }
}
