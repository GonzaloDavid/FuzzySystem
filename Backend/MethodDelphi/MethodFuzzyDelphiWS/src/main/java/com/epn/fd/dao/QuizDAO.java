/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.fd.dao;

import com.epn.dtos.EmailContainer;
import com.epn.dtos.ListAndCountContainer;

import com.epn.dtos.QuizContainer;
import com.epn.dtos.QuizContainerList;
import com.epn.dtos.QuizSave;
import com.epn.entities.FilterTypes;
import com.epn.entities.Quiz;
import com.epn.entities.SearchObject;
import com.epn.exception.AppException;
import com.epn.mapper.QuizMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author david
 */
@Stateless
public class QuizDAO extends GenericDAO<Quiz> {

    @Inject()
    QuestionDAO questionDAO;
    @Inject()
    ItemQuestionDAO itemQuestionDAO;
    @Inject
    Mail mail;

    private final QuizMapper quizMapper = Mappers.getMapper(QuizMapper.class);

    public QuizDAO() {
        super(Quiz.class);
    }

    public List<QuizContainer> getQuizbycode(Long codeQuiz) {
        SearchObject search = new SearchObject("codeQuiz");
        search.addParameter("codeQuiz", FilterTypes.EQUAL, codeQuiz);

        List<Quiz> resultList = search(search);
        List<QuizContainer> containers = quizMapper.sourceListToDestination(resultList);
        return containers;
    }

    public Quiz saveQuiz(QuizSave quizcontainer) {
        Quiz quiz = new Quiz();
        if (quizcontainer.getCodeQuiz() != null) {
            quiz.setCodeQuiz(quizcontainer.getCodeQuiz());
        } else {
            quiz.setCodeQuiz(new Long(0));
        }
        quiz.setNameQuiz(quizcontainer.getNameQuiz());
        quiz.setDescription(quizcontainer.getDescription());
        quiz.setShortNameQuiz(quizcontainer.getShortNameQuiz());
        quiz.setStatusCat(quizcontainer.getStatusCat());
        quiz.setStatus(quizcontainer.getStatus());
        //quiz.setUserCreate(quizcontainer.getUserCreate());
        //quiz.setUserLastModify(quizcontainer.getUserLastModify());
        update(quiz);
        //flush();
        questionDAO.deleteQuestion(quizcontainer);
        itemQuestionDAO.deleteItem(quizcontainer);
        questionDAO.saveQuestion(quizcontainer, quiz);
        return quiz;
    }

    public String getSurveys(Integer from, Integer to) throws JsonProcessingException {

        SearchObject searchObject = new SearchObject("codeQuiz");
        // search.addParameter("codeQuiz", FilterTypes.EQUAL, codeQuiz); para filtrar u ordenar con like,order,equal

        long count = search(searchObject).size();

        searchObject.setFrom(from);
        searchObject.setTo(to);

        List<Quiz> resultList = search(searchObject);
        List<QuizContainerList> containers = quizMapper.sourceListToDestinationList(resultList);

        ListAndCountContainer surveysListAndCount = new ListAndCountContainer(count, containers);

        ObjectMapper mapper = new ObjectMapper();
        String response = mapper.writeValueAsString(surveysListAndCount);

        return response;
    }

    public void deletequiz(Quiz quiz) {

        Quiz foundelement = new Quiz();
        foundelement = find(quiz.getCodeQuiz());
        try {
            if (foundelement != null) {
                remove(foundelement);
            }
        } catch (Exception e) {
            throw new AppException(e.toString(), "NO SE ELIMINO CORRECTAMENTE");
        }

    }

    public void sendquiz(EmailContainer emailcontainer) {
        List<QuizContainer> quiz = getQuizbycode(emailcontainer.getQuiz().getCodeQuiz());
        emailcontainer.getPersons().forEach(person -> {
            try {
                String link = "http://localhost:4200/admin/surveys/client/" + person.getCodePerson() + "/" + quiz.get(0).getCodeQuiz();
                String msg = "<span>Saludos Estimad@ " + person.getName() + "</span><br><span> Usted ha sido seleccionado para participar en una encuesta acerca de " + quiz.get(0).getDescription() + "</span>";
                String footer = "<br><span>Por favor de click en el siguiente enlace para continuar ...</span><br>";
                String body = msg + footer + "<div style=\"text-align:center\">\n"
                        + "        <p style=\"color: aquamarine\">hola mundo</p>\n"
                        + "        <input type=\"button\" value=\"Click me\" onclick=\"msg()\">\n"
                        + "</div>"
                        + "<br><span>" + link + "</span>";
                String s = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n"
                        + "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n"
                        + "  <head>\n"
                        + "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n"
                        + "    <title>Fuzzy System</title>\n"
                        + "  </head>\n"
                        + "\n"
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
                        + "                                        FUZZY SYSTEM\n"
                        + "                                      </strong>\n"
                        + "                                    </span>\n"
                        + "                                  </td>\n"
                        + "                                </tr>\n"
                        + "                                <tr>\n"
                        + "                                  <td\n"
                        + "                                    class=\"h1\"\n"
                        + "                                    style=\"padding: 5px 0 0 0;color: #ffffff; font-family: sans-serif;font-size: 33px; line-height: 38px; font-weight: bold;\"\n"
                        + "                                  >\n"
                        + "                                    ENCUESTA PREGRADO\n"
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
                        + "                          >\n"
                        + "                            Sr. Edison Loza\n"
                        + "                          </td>\n"
                        + "                        </tr>\n"
                        + "                        <tr>\n"
                        + "                          <td\n"
                        + "                            class=\"bodycopy\"\n"
                        + "                            style=\"padding: 5px 0 0 0;color: #153643; font-family: sans-serif;font-size: 16px; line-height: 22px;text-align:justify\"\n"
                        + "                          >\n"
                        + "                            Usted a sido seleccionado para participar en el programa de selección de POSTGRADO de la\n"
                        + "                            Facultad de Ingeniería en Sistemas.\n"
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
                        + "                                  >\n"
                        + "                                    Para continuar con la encuesta por favor dar click en el siguiente enlace.\n"
                        + "                                  </td>\n"
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
                        + "                                              href=\"https://www.youtube.com/watch?v=x6e4kDh6vao\"\n"
                        + "                                              target=\"_blank\"\n"
                        + "                                              style=\"padding: 8px 40px 8px 40px; border: 1px solid #1E88E5; border-radius: 2px;font-family: Helvetica, Arial, sans-serif;font-size: 14px; color: #ffffff;text-decoration: none;font-weight:bold;display: inline-block;\"\n"
                        + "                                            >\n"
                        + "                                              Ir a la Encuesta\n"
                        + "                                            </a>\n"
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
                mail.sendEmail(person.getEmail(), quiz.get(0).getNameQuiz(), s);
            } catch (Exception e) {
                throw new AppException(e.toString(), "NO SE ENVIO EMAIL");
            }

        });

    }
}
