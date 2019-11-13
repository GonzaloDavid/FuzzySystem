/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.fd.dao;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.ejb.Singleton;
import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author david
 */
@Singleton()
public class FileService {
    /*
     private final String INSTANCE = "instance";
     private final String REPOSITORY = "repository";
     private final String RESOURCES = "resources";
     private final String FILEPATHCAT = "FILEPATHCAT";

     @Inject
     private JorupeProperties jorupeProperties;

     @Inject
     private CatalogueitemDAO catalogueitemDAO;

     @Inject
     private CatalogueitemvalueadicDAO catalogueitemvalueadicDAO;

     @Inject
     private CompanyDAO companyDAO;*/

    public FileService() {
    }

    public String saveFileB64(Long id, String dataB64,String pathsave) throws IOException {

        return saveFileAsBase64String(id, dataB64,pathsave);

    }

    private String saveFileAsBase64String(Long id, String dataB64,String pathsave) throws IOException {

        String path = searchOrCreateFullPath(pathsave);

        String fullPath = path + File.separator + id+".png";

        byte[] data = Base64.decodeBase64(dataB64);

        try (
            OutputStream stream = new FileOutputStream(fullPath)) {
            stream.write(data);
        }
        return fullPath;
    }

    private String searchOrCreateFullPath(String pathsave) {
        String fullPath = searchPath(pathsave);
        createFolderIfNotExists(fullPath);
        return fullPath;
    }

    private void createFolderIfNotExists(String path) {
        File f = new File(path);
        if (!f.exists()) {
            f.mkdirs();
        }
    }

    private String searchPath(String pathsave) {
        String basePath = pathsave;
        String totalPath = basePath;
        return totalPath;
    }
    /*
     private String searchPath(Long id, String codeItem) {
     return catalogueitemDAO.findCatalogueItem(codeInstance, FILEPATHCAT, codeItem).map(cat -> {
     List<Catalogueitemvalueadic> catalogueItemsAdic = catalogueitemvalueadicDAO.findByCatalogueitem(cat);
     String type = catalogueItemsAdic.stream().filter(
     i -> i.getCataloguenamevalueadic().getCataloguenamevalueadicPK().getNameValueAdic().equals("TYPE"))
     .findFirst().get().getValueAdic();
     String path = catalogueItemsAdic.stream().filter(
     i -> i.getCataloguenamevalueadic().getCataloguenamevalueadicPK().getNameValueAdic().equals("PATH"))
     .findFirst().get().getValueAdic();

     String basePath = getPath(id, type);
     String totalPath = basePath + File.separator + path;
     return totalPath;
     }).orElseThrow(AppException::new);
     }*/


    /*  public String saveFileB64(Long codeCompany, Long codeInstance, String resource, String dataB64, String name)
     throws IOException {

     return saveFileAsBase64String(codeCompany, codeInstance, resource, dataB64, name);

     }*/
    /* public String saveFile(Company company, String resource, InputStream stream, String name) throws IOException {

     return saveFileWithInputStream(company.getCompanyPK().getCode(), company.getCompanyPK().getCodeInstance(),
     resource, stream, name);

     }

     public String saveFile(Long codeCompany, Long codeInstance, String resource, InputStream stream, String name)
     throws IOException {

     return saveFileWithInputStream(codeCompany, codeInstance, resource, stream, name);

     }

     public String saveFile(Company company, String resource, String stringData, String name) throws IOException {

     return saveFileWithString(company.getCompanyPK().getCode(), company.getCompanyPK().getCodeInstance(), resource,
     stringData, name);
     }

     public String saveFile(Long codeCompany, Long codeInstance, String resource, String stringData, String name)
     throws IOException {

     return saveFileWithString(codeCompany, codeInstance, resource, stringData, name);
     }

     public String saveFile(Company company, String resource, BufferedImage image, String name) throws IOException {

     return saveFileWithBufferedImage(company.getCompanyPK().getCode(), company.getCompanyPK().getCodeInstance(),
     resource, image, name);

     }

     public String saveFile(Long codeCompany, Long codeInstance, String resource, BufferedImage image, String name)
     throws IOException {

     return saveFileWithBufferedImage(codeCompany, codeInstance, resource, image, name);

     }

     public String getFullPath(Company company, String resource) {
     return searchOrCreateFullPath(company.getCompanyPK().getCode(), company.getCompanyPK().getCodeInstance(),
     resource);
     }

     public String getFullPath(Long codeCompany, Long codeInstance, String resource) {
     return searchOrCreateFullPath(codeCompany, codeInstance, resource);
     }

     public String getCompanyResourcePath(Company company) {

     return getResourcePath(company);

     }

     public String getCompanyRepositoryPath(Company company) {

     return getRepositoryPath(company);

     }

     public String getCompanyResourcePath(Long codeCompany, Long codeInstance) {

     String companyResourcePath = getRepositoryPath(codeCompany, codeInstance);

     createFolderIfNotExists(companyResourcePath);

     return companyResourcePath;
     }

     public String getCompanyRepositoryPath(Long codeCompany, Long codeInstance) {

     String companyRepositoryPath = getResourcePath(codeCompany, codeInstance);

     createFolderIfNotExists(companyRepositoryPath);

     return companyRepositoryPath;
     }

     private String saveFileWithBufferedImage(Long codeCompany, Long codeInstance, String resource, BufferedImage image,
     String name) throws IOException {

     String pathString = searchOrCreateFullPath(codeCompany, codeInstance, resource);

     String fullPath = pathString + File.separator + name;

     String[] nameSplit = name.split("\\.");

     ImageIO.write(image, nameSplit[1], new File(fullPath));

     return fullPath;
     }

     private String saveFileWithString(Long codeCompany, Long codeInstance, String resource, String stringData,
     String name) throws IOException {

     String pathString = searchOrCreateFullPath(codeCompany, codeInstance, resource);

     String fullPath = pathString + File.separator + name;

     Path path = Paths.get(fullPath);

     BufferedWriter writer = Files.newBufferedWriter(path, Charset.forName("UTF-8"));

     writer.write(stringData);

     return fullPath;
     }

     private String saveFileWithInputStream(Long codeCompany, Long codeInstance, String resource, InputStream stream,
     String name) throws IOException {

     String path = searchOrCreateFullPath(codeCompany, codeInstance, resource);

     String fullPath = path + File.separator + name;

     File file = new File(fullPath);

     Files.copy(stream, file.toPath(), StandardCopyOption.REPLACE_EXISTING);

     IOUtils.closeQuietly(stream);

     return fullPath;
     }

     private String getResourcePath(Long codeCompany, Long codeInstance) {

     Company company = companyDAO.findByCode(codeCompany, codeInstance);

     return getResourcePath(company);
     }

     private String getRepositoryPath(Long codeCompany, Long codeInstance) {

     Company company = companyDAO.findByCode(codeCompany, codeInstance);

     return getRepositoryPath(company);
     }

     private String getResourcePath(Company company) {
     return getCompanyPath(company) + File.separator + RESOURCES;
     }

     private String getRepositoryPath(Company company) {
     return getCompanyPath(company) + File.separator + REPOSITORY;
     }

     private String getPath(Long id, String type) {
     switch (type) {
     case "RESOURCE":
     return getResourcePath(id);
     case "REPOSITORY":
     return getRepositoryPath(id);
     default:
     throw new AppException();
     }

     }

    

     private String getCompanyPath(Company company) {

     String companyNameNoWhiteSpaces = company.getName().replaceAll("\\s+", "");
     String companyNameNoSpecialCharacters = companyNameNoWhiteSpaces.replaceAll("[^a-zA-Z]+", "");

     String path = company.getBasePath() + File.separator + INSTANCE
     + company.getCompanyPK().getCodeInstance() + File.separator + companyNameNoSpecialCharacters;

     return path;

     }*/
}
