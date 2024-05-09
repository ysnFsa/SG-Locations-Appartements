/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nezukoRent.managment;

import com.nezukoRent.database.AppartementData;
import com.nezukoRent.database.PhotosData;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.NodeList;

/**
 *
 * @author yassin
 */
public class XMLHandler {
    
   public static void generateAndSaveXml(AppartementData appartement, List<PhotosData> photosList) {

       
        String xmlContent = generateXmlContent(appartement, photosList);
   
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Save XML File");
        fileChooser.setFileFilter(new FileNameExtensionFilter("XML files (*.xml)", "xml"));
        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            if (!fileToSave.getName().toLowerCase().endsWith(".xml")) {
                fileToSave = new File(fileToSave.getAbsolutePath() + ".xml");
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileToSave))) {
                writer.write(xmlContent);
              
            } catch (IOException e) {
                e.printStackTrace();
           
            }
        }
    }
private static String generateXmlContent(AppartementData appartement, List<PhotosData> photosList) {
    StringBuilder xmlBuilder = new StringBuilder();
    xmlBuilder.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n");
    xmlBuilder.append("<appartement>\n");

    // Append AppartementData fields
    xmlBuilder.append("\t<appartementData>\n");
    xmlBuilder.append("\t\t<id>").append(appartement.getId()).append("</id>\n");
    xmlBuilder.append("\t\t<type>").append(appartement.getType()).append("</type>\n");
    xmlBuilder.append("\t\t<surface>").append(appartement.getSurface()).append("</surface>\n");
    xmlBuilder.append("\t\t<chambres>").append(appartement.getChambres()).append("</chambres>\n");
    xmlBuilder.append("\t\t<disponibilite>").append(appartement.isDisponibilite()).append("</disponibilite>\n");
    xmlBuilder.append("\t\t<prix>").append(appartement.getPrix()).append("</prix>\n");
    xmlBuilder.append("\t\t<ville_id>").append(appartement.getVilleId()).append("</ville_id>\n");
    xmlBuilder.append("\t\t<quartier_id>").append(appartement.getQuartierId()).append("</quartier_id>\n");
    xmlBuilder.append("\t\t<description>").append(appartement.getDescription()).append("</description>\n");
    xmlBuilder.append("\t</appartementData>\n");

  
    xmlBuilder.append("\t<photos>\n");
    for (PhotosData photo : photosList) {
        xmlBuilder.append("\t\t<photoData>\n");
        xmlBuilder.append("\t\t\t<id>").append(photo.getId()).append("</id>\n");
        xmlBuilder.append("\t\t\t<path>").append(photo.getPath()).append("</path>\n");
        xmlBuilder.append("\t\t\t<appartement_id>").append(photo.getAppartementId()).append("</appartement_id>\n");
        xmlBuilder.append("\t\t</photoData>\n");
    }
    xmlBuilder.append("\t</photos>\n");

    xmlBuilder.append("</appartement>\n");
    return xmlBuilder.toString();
}
  public static AppartementData readXMLFile() throws Exception {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Choose XML File");
        fileChooser.setFileFilter(new FileNameExtensionFilter("XML files", "xml"));
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            return parseXML(selectedFile);
        }
        throw new IllegalArgumentException("No file selected");
    }
public static AppartementData parseXML(File xmlFile) throws Exception {
    List<PhotosData> photos = new ArrayList<>();

    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    org.w3c.dom.Document doc = dBuilder.parse(xmlFile);
    org.w3c.dom.Element appartementDataElement = (org.w3c.dom.Element) doc.getElementsByTagName("appartementData").item(0);

    int id = Integer.parseInt(appartementDataElement.getElementsByTagName("id").item(0).getTextContent());
    String type = appartementDataElement.getElementsByTagName("type").item(0).getTextContent();
    double surface = Double.parseDouble(appartementDataElement.getElementsByTagName("surface").item(0).getTextContent());
    int chambres = Integer.parseInt(appartementDataElement.getElementsByTagName("chambres").item(0).getTextContent());
    boolean disponibilite = Boolean.parseBoolean(appartementDataElement.getElementsByTagName("disponibilite").item(0).getTextContent());
    double prix = Double.parseDouble(appartementDataElement.getElementsByTagName("prix").item(0).getTextContent());
    int ville_id = Integer.parseInt(appartementDataElement.getElementsByTagName("ville_id").item(0).getTextContent());
    int quartier_id = Integer.parseInt(appartementDataElement.getElementsByTagName("quartier_id").item(0).getTextContent());
    String description = appartementDataElement.getElementsByTagName("description").item(0).getTextContent();

    AppartementData appartementData = new AppartementData(id, type, surface, chambres, disponibilite, prix, ville_id, quartier_id, description);

NodeList photosDataList = doc.getElementsByTagName("photoData");
for (int i = 0; i < photosDataList.getLength(); i++) {
    org.w3c.dom.Element photoDataElement = (org.w3c.dom.Element) photosDataList.item(i);
    int photoId = Integer.parseInt(photoDataElement.getElementsByTagName("id").item(0).getTextContent());
    String path = photoDataElement.getElementsByTagName("path").item(0).getTextContent();
    int appartementId = Integer.parseInt(photoDataElement.getElementsByTagName("appartement_id").item(0).getTextContent());
    PhotosData photosData = new PhotosData(photoId, path, appartementId);
   photos.add(photosData);
}
    appartementData.setPhotosDataList(photos);
    return appartementData;
}
}
