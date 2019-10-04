/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.fd.dao;

import com.epn.dtos.SentemailbycodefahpContainer;
import com.epn.entities.Fahp;
import com.epn.entities.FahpPK;
import com.epn.entities.FilterTypes;
import com.epn.entities.Person;
import com.epn.entities.SearchObject;
import com.epn.entities.Sentemailbycodefahp;
import com.epn.entities.SentemailbycodefahpPK;
import com.epn.exception.AppException;
import com.epn.mapper.SentemailbycodefahpMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author david
 */
@Stateless
public class SentemailbycodefahpDAO extends GenericDAO<Sentemailbycodefahp> {

    @Inject()
    FahpDAO fahpDAO;

    @Inject()
    Mail mail;

    @Inject()
    EnvironmentDAO environmentDAO;

    @Inject()
    SurveybycodefahpDAO surveybycodefahpDAO;

    @Inject()
    PersonDAO personDAO;

    private final SentemailbycodefahpMapper mapper = Mappers.getMapper(SentemailbycodefahpMapper.class);

    public SentemailbycodefahpDAO() {
        super(Sentemailbycodefahp.class);
    }

    public List<SentemailbycodefahpContainer> searchbycodefahp(Long codefahp) {
        SearchObject search = new SearchObject("sentemailbycodefahpPK");
        search.addParameter("sentemailbycodefahpPK.codefahp", FilterTypes.EQUAL, codefahp);

        List<Sentemailbycodefahp> resultList = search(search);
        List<SentemailbycodefahpContainer> containers = mapper.sourceListToDestination(resultList);
        return containers;
    }

    public void updatestatus(SentemailbycodefahpPK sentemailbycodefahppk) {
        Sentemailbycodefahp exist = find(sentemailbycodefahppk);
        if (exist != null) {
            exist.setStatussentfahp("answered");
            update(exist);
        }
    }

    public void savelist(List<Sentemailbycodefahp> personsselectedlist) {
        personsselectedlist.forEach(person -> {
            Sentemailbycodefahp foundelement = find(person.getSentemailbycodefahpPK());
            if (foundelement != null && !person.getStatussentfahp().equals("answered")) {
                person.setStatussentfahp("forwarded");
            }
            update(person);
        });
    }

    public void save(Sentemailbycodefahp sentemailbycodefahp) {
        update(sentemailbycodefahp);
    }

    public void forwardemail(Sentemailbycodefahp sentemailbycodefahp, String descriptionMail) {
        String uribase = environmentDAO.getenvironmentbyuseplace(
                "fahpclient", "frontend").get(0).getEnvironmentPK().getUri();

        String key = "FAHP";
        String subject = "FuzzyAnalyticHierarchyProcess";
        long expirationTime = System.currentTimeMillis() + 604800000;

        JsonObject jwt = generateJWT(key, subject,
                sentemailbycodefahp.getSentemailbycodefahpPK().getCodePerson(),
                sentemailbycodefahp.getSentemailbycodefahpPK().getCodefahp(),
                expirationTime);

        String namesurvey = surveybycodefahpDAO.getnamequizbycodefahp(sentemailbycodefahp.getSentemailbycodefahpPK().getCodefahp());
        Person persons = personDAO.getpersonbycodeperson(sentemailbycodefahp.getSentemailbycodefahpPK().getCodePerson());

        sendquizbyfahp(namesurvey, persons,
                sentemailbycodefahp.getSentemailbycodefahpPK().getCodefahp(),
                uribase, jwt.getString("JWT"), descriptionMail);

    }

    public void sendprocess(List<Sentemailbycodefahp> personsselectedlist, String descriptionMail) {

        if (personsselectedlist.size() > 0) {

            FahpPK fahpPK = new FahpPK();
            fahpPK.setCodefahp(personsselectedlist.get(0).getSentemailbycodefahpPK().getCodefahp());
            Fahp fahp = new Fahp(fahpPK);
            fahp.setStatusfahpCatt("STATUSFAHPCAT");
            fahp.setStatusfahp("sent");
            fahpDAO.savefahp(fahp);
            savelist(personsselectedlist);

            String uribase = environmentDAO.getenvironmentbyuseplace(
                    "fahpclient", "frontend").get(0).getEnvironmentPK().getUri();

            String key = "FAHP";
            String subject = "FuzzyAnalyticHierarchyProcess";
            long expirationTime = System.currentTimeMillis() + 604800000;

            personsselectedlist.forEach(sentemailbycodeobject -> {
                JsonObject jwt = generateJWT(key, subject,
                        sentemailbycodeobject.getSentemailbycodefahpPK().getCodePerson(),
                        sentemailbycodeobject.getSentemailbycodefahpPK().getCodefahp(),
                        expirationTime);

                String namesurvey = surveybycodefahpDAO.getnamequizbycodefahp(sentemailbycodeobject.getSentemailbycodefahpPK().getCodefahp());
                Person persons = personDAO.getpersonbycodeperson(sentemailbycodeobject.getSentemailbycodefahpPK().getCodePerson());

                sendquizbyfahp(namesurvey, persons,
                        sentemailbycodeobject.getSentemailbycodefahpPK().getCodefahp(),
                        uribase, jwt.getString("JWT"), descriptionMail);
            });
        }
    }

    public JsonObject generateJWT(String key, String subject, Long codeperson,
            Long codefahp, long expirationTime) {

        long time = System.currentTimeMillis();
        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, key)
                .setSubject(subject)
                .setIssuedAt(new Date(time))
                .setExpiration(new Date(time + expirationTime))
                .claim("codeperson", codeperson)
                .claim("codefahp", codefahp)
                .compact();

        JsonObject json = Json.createObjectBuilder().
                add("JWT", jwt).build();
        return json;
    }

    public void sendquizbyfahp(String namesurvey, Person person,
            Long codefahp, String uribase, String token, String descriptionMail) {
        try {
            String message = "";
            if (descriptionMail != null) {
                message = "<div style='text-align: justify;'><span> " + descriptionMail + "</span></div>";
            } else {
                message = "<div style='text-align: justify;'><span> Por favor, dedica un momento completando la informacion solicitada, dicha información que proporcione será utilizada con fines academicos e investigación </span></div>";
            }
            String link = uribase + "/" + person.getCodePerson() + "/" + codefahp + "/" + token;
            String nameQuiz = namesurvey;
            String name = "<span>Saludos Estimad@ " + person.getName() + "</span><br>";
            String footer = "<span>La información transmitida a través del sistema debe ser tratada con confidencialidad , al entrar usted al sistema acepta el compromiso de no divulgar la información que se presente a continuación.</span><br>";
            String html = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n"
                    + "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n"
                    + "  <head>\n"
                    + "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n"
                    + "    <title>";
            String title = "Fuzzy System";
            html += title;
            html += "</title>\n"
                    + "  </head>\n"
                    + "  <body yahoo=\"\" bgcolor=\"#f6f8f1\" style=\"margin: 0;padding: 0; min-width: 100% !important;\">\n"
                    + "    <table width=\"100%\" bgcolor=\"#f6f8f1\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n"
                    + "      <tbody>\n"
                    + "        <tr>\n"
                    + "          <td>\n"
                    + "            <table\n"
                    + "              bgcolor=\"#ffffff\"\n"
                    + "              class=\"content\"\n"
                    + "              style=\"width: 100%; max-width: 600px;\"\n"
                    + "              align=\"center\"\n"
                    + "              cellpadding=\"0\"\n"
                    + "              cellspacing=\"0\"\n"
                    + "              border=\"0\"\n"
                    + "            >\n"
                    + "              <tbody>\n"
                    + "                <tr>\n"
                    + "                  <td bgcolor=\"#2E86C1\" class=\"header\" style=\"padding: 30px 30px 10px 30px\">\n"
                    + "                    <table width=\"70\" align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n"
                    + "                      <tbody>\n"
                    + "                        <tr>\n"
                    + "                          <td height=\"70\" style=\"padding: 0 20px 20px 0;\">\n"
                    + "                            <img\n"
                    + "                              class=\"fix\"\n"
                    + "                              align=\"middle\"\n"
                    + "                              src=\"https://upload.wikimedia.org/wikipedia/commons/8/8c/Escudo_de_la_Escuela_Polit%C3%A9cnica_Nacional.png\"\n"
                    + "                              width=\"75\"\n"
                    + "                              height=\"75\"\n"
                    + "                              border=\"0\"\n"
                    + "                              alt=\"Logo Fuzzy System\"\n"
                    + "                            />\n"
                    + "                          </td>\n"
                    + "                        </tr>\n"
                    + "                      </tbody>\n"
                    + "                    </table>\n"
                    + "                    <table\n"
                    + "                      class=\"col425\"\n"
                    + "                      align=\"left\"\n"
                    + "                      border=\"0\"\n"
                    + "                      cellpadding=\"0\"\n"
                    + "                      cellspacing=\"0\"\n"
                    + "                      style=\"width: 100%; max-width: 425px;\"\n"
                    + "                    >\n"
                    + "                      <tbody>\n"
                    + "                        <tr>\n"
                    + "                          <td height=\"70\">\n"
                    + "                            <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n"
                    + "                              <tbody>\n"
                    + "                                <tr>\n"
                    + "                                  <td\n"
                    + "                                    class=\"subhead\"\n"
                    + "                                    style=\"padding: 0 0 0 3px; font-size: 15px;color: #153643; font-family: sans-serif; letter-spacing: 10px;\"\n"
                    + "                                  >\n"
                    + "                                    <span>\n"
                    + "                                      <strong>\n"
                    + "                       ";
            html += "FUZZY SYSTEM";
            html += "  </strong>\n"
                    + "                                    </span>\n"
                    + "                                  </td>\n"
                    + "                                </tr>\n"
                    + "                                <tr>\n"
                    + "                                  <td\n"
                    + "                                    class=\"h1\"\n"
                    + "                                    style=\"padding: 5px 0 0 0;color: #ffffff; font-family: sans-serif;font-size: 33px; line-height: 38px; font-weight: bold;\"\n"
                    + "                                  >";
            html += nameQuiz;
            html += " </td>\n"
                    + "                                </tr>\n"
                    + "                              </tbody>\n"
                    + "                            </table>\n"
                    + "                          </td>\n"
                    + "                        </tr>\n"
                    + "                      </tbody>\n"
                    + "                    </table>\n"
                    + "                  </td>\n"
                    + "                </tr>\n"
                    + "                <tr>\n"
                    + "                  <td\n"
                    + "                    class=\"innerpadding borderbottom\"\n"
                    + "                    style=\"padding: 30px 30px 30px 30px;border-bottom: 1px solid #f2eeed;\"\n"
                    + "                  >\n"
                    + "                    <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n"
                    + "                      <tbody>\n"
                    + "                        <tr>\n"
                    + "                          <td\n"
                    + "                            class=\"h2\"\n"
                    + "                            style=\"color: #153643; font-family: sans-serif;padding: 0 0 15px 0; font-size: 24px; line-height: 28px; font-weight: bold;\"\n"
                    + "                          >";
            html += name;
            html += " </td>\n"
                    + "                        </tr>\n"
                    + "                        <tr>\n"
                    + "                          <td\n"
                    + "                            class=\"bodycopy\"\n"
                    + "                            style=\"padding: 5px 0 0 0;color: #153643; font-family: sans-serif;font-size: 10px; line-height: 22px;text-align:justify;background: antiquewhite\"\n"
                    + "                          >";
            html += footer;
            html += "  </td>\n"
                    + "                        </tr>\n"
                    + "                      </tbody>\n"
                    + "                    </table>\n"
                    + "                  </td>\n"
                    + "                </tr>\n"
                    + "                <tr>\n"
                    + "                  <td\n"
                    + "                    class=\"innerpadding borderbottom\"\n"
                    + "                    style=\"padding: 30px 30px 30px 30px;border-bottom: 1px solid #f2eeed;\"\n"
                    + "                  >\n"
                    + "                    <table width=\"115\" align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n"
                    + "                      <tbody>\n"
                    + "                        <tr>\n"
                    + "                          <td height=\"115\" style=\"padding: 0 20px 20px 0;\">\n"
                    + "                            <img\n"
                    + "                              class=\"fix\"\n"
                    + "                              style=\"color: black\"\n"
                    + "                              src=\"https://upload.wikimedia.org/wikipedia/commons/8/8c/Escudo_de_la_Escuela_Polit%C3%A9cnica_Nacional.png\"\n"
                    + "                              width=\"115\"\n"
                    + "                              height=\"auto\"\n"
                    + "                              border=\"0\"\n"
                    + "                              alt=\"\"\n"
                    + "                            />\n"
                    + "                          </td>\n"
                    + "                        </tr>\n"
                    + "                      </tbody>\n"
                    + "                    </table>\n"
                    + "                    <table\n"
                    + "                      class=\"col380\"\n"
                    + "                      align=\"left\"\n"
                    + "                      border=\"0\"\n"
                    + "                      cellpadding=\"0\"\n"
                    + "                      cellspacing=\"0\"\n"
                    + "                      style=\"width: 100%; max-width: 380px;\"\n"
                    + "                    >\n"
                    + "                      <tbody>\n"
                    + "                        <tr>\n"
                    + "                          <td>\n"
                    + "                            <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n"
                    + "                              <tbody>\n"
                    + "                                <tr>\n"
                    + "                                  <td\n"
                    + "                                    class=\"bodycopy\"\n"
                    + "                                    style=\"padding: 5px 0 0 0;color: #153643; font-family: sans-serif;font-size: 16px; line-height: 22px;\"\n"
                    + "                                  >";
            html += message;
            html += "  </td>\n"
                    + "                                </tr>\n"
                    + "                                <tr>\n"
                    + "                                  <td style=\"padding: 20px 0 0 0;\">\n"
                    + "                                    <table\n"
                    + "                                      class=\"buttonwrapper\"\n"
                    + "                                      bgcolor=\"#1E88E5\"\n"
                    + "                                      border=\"0\"\n"
                    + "                                      cellspacing=\"0\"\n"
                    + "                                      cellpadding=\"0\"\n"
                    + "                                      style=\"border-radius: 2px\"\n"
                    + "                                    >\n"
                    + "                                      <tbody>\n"
                    + "                                        <tr>\n"
                    + "                                          <td class=\"button\" height=\"45\">\n"
                    + "                                            <a\n"
                    + "                                              href=\"";
            html += link;
            html += "\"\n"
                    + "                                              target=\"_blank\"\n"
                    + "                                              style=\"padding: 8px 40px 8px 40px; border: 1px solid #1E88E5; border-radius: 2px;font-family: Helvetica, Arial, sans-serif;font-size: 14px; color: #ffffff;text-decoration: none;font-weight:bold;display: inline-block;\"\n"
                    + "                                            >";
            html += "Ir a la Encuesta";
            html += "   </a>\n"
                    + "                                          </td>\n"
                    + "                                        </tr>\n"
                    + "                                      </tbody>\n"
                    + "                                    </table>\n"
                    + "                                  </td>\n"
                    + "                                </tr>\n"
                    + "                              </tbody>\n"
                    + "                            </table>\n"
                    + "                          </td>\n"
                    + "                        </tr>\n"
                    + "                      </tbody>\n"
                    + "                    </table>\n"
                    + "                  </td>\n"
                    + "                </tr>\n"
                    + "\n"
                    + "                <tr>\n"
                    + "                  <td class=\"footer\" bgcolor=\"#44525f\" style=\"padding: 20px 30px 15px 30px;\">\n"
                    + "                    <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n"
                    + "                      <tbody>\n"
                    + "                        <tr>\n"
                    + "                          <td\n"
                    + "                            align=\"center\"\n"
                    + "                            class=\"footercopy\"\n"
                    + "                            style=\"font-family: sans-serif; font-size: 14px; color: #ffffff;\"\n"
                    + "                          >\n"
                    + "                            ® Escuela Politécnica Nacional<br />\n"
                    + "                            <span class=\"hide\">Facultad de Ingeniería en Sistemas</span>\n"
                    + "                          </td>\n"
                    + "                        </tr>\n"
                    + "                        <tr>\n"
                    + "                          <td align=\"center\" style=\"padding: 20px 0 0 0;\">\n"
                    + "                            <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n"
                    + "                              <tbody>\n"
                    + "                                <tr>\n"
                    + "                                  <td width=\"37\" style=\"text-align: center; padding: 0 10px 0 10px;\">\n"
                    + "                                    <a href=\"\">\n"
                    + "                                      <img\n"
                    + "                                        src=\"https://upload.wikimedia.org/wikipedia/commons/8/8c/Escudo_de_la_Escuela_Polit%C3%A9cnica_Nacional.png\"\n"
                    + "                                        width=\"37\"\n"
                    + "                                        height=\"37\"\n"
                    + "                                        alt=\"EPN\"\n"
                    + "                                        border=\"0\"\n"
                    + "                                      />\n"
                    + "                                    </a>\n"
                    + "                                  </td>\n"
                    + "                                  <td width=\"37\" style=\"text-align: center; padding: 0 10px 0 10px;\">\n"
                    + "                                    <a href=\"\">\n"
                    + "                                      <img\n"
                    + "                                        src=\"https://fis.epn.edu.ec/images/FISlogo.jpg\"\n"
                    + "                                        width=\"37\"\n"
                    + "                                        height=\"37\"\n"
                    + "                                        alt=\"FIS\"\n"
                    + "                                        border=\"0\"\n"
                    + "                                      />\n"
                    + "                                    </a>\n"
                    + "                                  </td>\n"
                    + "                                </tr>\n"
                    + "                              </tbody>\n"
                    + "                            </table>\n"
                    + "                          </td>\n"
                    + "                        </tr>\n"
                    + "                      </tbody>\n"
                    + "                    </table>\n"
                    + "                  </td>\n"
                    + "                </tr>\n"
                    + "              </tbody>\n"
                    + "            </table>\n"
                    + "          </td>\n"
                    + "        </tr>\n"
                    + "      </tbody>\n"
                    + "    </table>\n"
                    + "  </body>\n"
                    + "</html>";
            mail.sendEmail(person.getEmail(), nameQuiz, html);
        } catch (Exception e) {
            throw new AppException(e.toString(), "NO SE ENVIO EMAIL");
        }
    }
}
