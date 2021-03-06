package by.krukouski.testscreator.dao;

import by.krukouski.testscreator.exception.DAOException;
import by.krukouski.testscreator.exception.ResourceUnsupportedOperationException;
import by.krukouski.testscreator.exception.TestDAOException;
import by.krukouski.testscreator.subject.Answer;
import by.krukouski.testscreator.subject.Question;
import by.krukouski.testscreator.subject.Test;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Krukouski Andrei on 27.12.2015.
 */
public class TestDAO extends AbstractDAO<Integer, Test> {

    static Logger logger = Logger.getLogger(TestDAO.class);

    public static final String SQL_SELECT_ALL_TESTS = "SELECT id, subject, topic, time FROM test";//select all tests
    public static final String SQL_SELECT_IDTEST_BY_TOPIC_AND_SUBJECT = "SELECT id FROM test WHERE topic = ? AND subject = ?";//select tests by topic and subject
    public static final String SQL_SELECT_IDQUESTION_BY_VALUEQUESTION = "SELECT id FROM question WHERE value_question = ?";//select question id by value question
    public static final String SQL_SELECT_TEST = "SELECT id, subject, topic, time FROM test WHERE id = ?";//select test by id
    public static final String SQL_SELECR_ALL_QUESTIONS_BY_TEST = "SELECT id, value_question FROM question WHERE id_test = ?";//select questions by test id
    public static final String SQL_SELECT_ALL_ANSWERS_BY_QUESTION = "SELECT id, value_answer, correct_answer FROM answer WHERE id_question = ?";//select answer by questio id
    public static final String SQL_INSERT_TEST_BY_USER = "INSERT INTO test(id_user, topic, subject, time) VALUES(?, ?, ?, ?)";//insert test in database
    public static final String SQL_INSERT_QUESTION_BY_TEST = "INSERT INTO question(id_test, value_question) VALUES(?, ?)";//insert questio in database
    public static final String SQL_INSERT_ANSWER_BY_QUESTION = "INSERT INTO answer(id_question, value_answer, correct_answer) VALUES(?, ?, ?)";//insert answer in database
    public static final String SQL_SELECT_TEST_BY_USER = "SELECT id, subject, topic, time FROM test WHERE id_user = ?";//select tests by user_id
    public static final String SQL_DELETE_TEST_BY_ID = "DELETE FROM test WHERE id = ?";//delete test by id
    public static final String SQL_DELETE_TESTS_BY_USERID = "DELETE FROM test WHERE id_user = ?";//delete tests by user id
    public static final String SQL_DELETE_QUESTION_BY_ID = "DELETE FROM question WHERE id = ?";//delete question by id
    public static final String SQL_DELETE_QUESTIONS_BY_TESTID = "DELETE FROM question WHERE id_test = ?";//delete questions by test id
    public static final String SQL_DELETE_ANSWER_BY_ID = "DELETE FROM answer WHERE id = ?";//delete answer by id
    public static final String SQL_DELETE_ANSWERS_BY_QUESTIONID = "DELETE FROM answer WHERE id_question = ?";//delete answers by question id
    public static final String SQL_UPDATE_TEST = "UPDATE test SET subject = ?, topic = ?, time = ? WHERE id = ?";//update test by id
    public TestDAO(){
        this.connector = ConnectionExtract.getConnection();
    }
    @Override
    public List<Test> findAll(){//get list all tests

        List<Test> tests = new ArrayList<>();
        Statement statement = null;
        try{
            statement = connector.getStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_TESTS);
            while (resultSet.next()){
                Test test = new Test();
                test.setId(resultSet.getInt("id"));
                test.setSubject(resultSet.getString("subject"));
                test.setTopic(resultSet.getString("topic"));
                test.setTime(resultSet.getInt("time"));
                tests.add(test);
            }
        }catch (SQLException e){
            logger.error(e.getMessage());
        }finally {
            this.closeStatement(statement);
        }

        return tests;
    }
    @Override
    public Test findEntityById(Integer id){//searching test by id
        Test test = new Test();
        PreparedStatement statement = null;
        try{
            statement = connector.getPreparedStatement(SQL_SELECT_TEST);
            statement.setString(1, id.toString());
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            test.setId(resultSet.getInt("id"));
            test.setTopic(resultSet.getString("topic"));
            test.setSubject(resultSet.getString("subject"));
            test.setTime(resultSet.getInt("time"));
            System.out.println(test.getId());
            statement = connector.getPreparedStatement(SQL_SELECR_ALL_QUESTIONS_BY_TEST);
            statement.setString(1, test.getId().toString());
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                Question question = new Question();
                question.setId(resultSet.getInt("id"));
                question.setValueQuestion(resultSet.getString("value_question"));
                statement = connector.getPreparedStatement(SQL_SELECT_ALL_ANSWERS_BY_QUESTION);
                statement.setString(1, question.getId().toString());
                ResultSet resultSet1 = statement.executeQuery();
                while (resultSet1.next()){
                    Answer answer = new Answer();
                    answer.setValueAnswer(resultSet1.getString("value_answer"));
                    answer.setId(resultSet1.getInt("id"));
                    answer.setCorrectAnswer(resultSet1.getBoolean("correct_answer"));
                    question.setAnswer(answer);
                }
                test.setQuestion(question);
            }
        }catch (SQLException e){
            logger.error(e.getMessage());
        }finally {
            this.closeStatement(statement);
        }
        return test;
    }
    public List<Test> findTestByUserId(Integer userId){
        List<Test> tests = new ArrayList<>();
        PreparedStatement statement = null;
        try{
            statement = connector.getPreparedStatement(SQL_SELECT_TEST_BY_USER);
            statement.setString(1, userId.toString());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Test test = new Test();
                test.setId(resultSet.getInt("id"));
                test.setSubject(resultSet.getString("subject"));
                test.setTopic(resultSet.getString("topic"));
                test.setTime(resultSet.getInt("time"));
                tests.add(test);
            }
        }catch (SQLException e){
            logger.error(e.getMessage());
        }finally {
            this.closeStatement(statement);
        }
        return tests;
    }

    public boolean createTest(Test test, Integer idUser){//creating test
        PreparedStatement statement = null;
        try {
            statement = connector.getPreparedStatement(SQL_INSERT_TEST_BY_USER);
            statement.setInt(1, idUser);
            statement.setString(2, test.getTopic());
            statement.setString(3, test.getSubject());
            statement.setInt(4, test.getTime());
            statement.executeUpdate();
            statement = connector.getPreparedStatement(SQL_SELECT_IDTEST_BY_TOPIC_AND_SUBJECT);
            statement.setString(1, test.getTopic());
            statement.setString(2, test.getSubject());
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            Integer idTest = resultSet.getInt("id");
            List<Question> listQuestions = test.getQuestions();
            Iterator<Question> iteratorQuestions = listQuestions.iterator();
            while (iteratorQuestions.hasNext()){
                Question question = iteratorQuestions.next();
                statement = connector.getPreparedStatement(SQL_INSERT_QUESTION_BY_TEST);
                statement.setInt(1, idTest);
                statement.setString(2, question.getValueQuestion());
                statement.executeUpdate();
                statement = connector.getPreparedStatement(SQL_SELECT_IDQUESTION_BY_VALUEQUESTION);
                statement.setString(1, question.getValueQuestion());
                resultSet = statement.executeQuery();
                resultSet.next();
                Integer idQuestion = resultSet.getInt("id");
                List<Answer> listAnswers = question.getAnswers();
                Iterator<Answer> iteratorAnswers = listAnswers.iterator();
                while (iteratorAnswers.hasNext()){
                    Answer answer = iteratorAnswers.next();
                    statement = connector.getPreparedStatement(SQL_INSERT_ANSWER_BY_QUESTION);
                    statement.setInt(1, idQuestion);
                    statement.setString(2, answer.getValueAnswer());
                    statement.setBoolean(3, answer.getCorrectAnswer());
                    statement.executeUpdate();
                }
            }
        }catch (SQLException e){
            logger.error(e.getMessage());
        }finally {
            this.closeStatement(statement);
        }
        return true;
    }
    public boolean deleteTestsByUserId(Integer idUser){

            List<Test> tests = findTestByUserId(idUser);
            Iterator<Test> iterator = tests.iterator();
            while (iterator.hasNext()){
                delete(iterator.next().getId());
            }

        return true;
    }
    @Override
    public boolean delete(Integer idTest){
        PreparedStatement statement = null;
        try{
            deleteQuestionsByTestId(idTest);
            statement = connector.getPreparedStatement(SQL_DELETE_TEST_BY_ID);
            statement.setInt(1, idTest);
            statement.executeUpdate();
        }catch (SQLException e){
            logger.error(e.getMessage());
        }finally {
            this.closeStatement(statement);
        }
        return true;
    }
    @Override
    public boolean delete(Test test) throws TestDAOException{
        throw new TestDAOException();
    }
    @Override
    public boolean create(Test test) throws TestDAOException{
        throw new TestDAOException();
    }
    @Override
    public boolean update(Test test){
        PreparedStatement statement = null;
        deleteQuestionsByTestId(test.getId());
        try {
            List<Question> listQuestions = test.getQuestions();
            Iterator<Question> iteratorQuestions = listQuestions.iterator();
            while (iteratorQuestions.hasNext()){
                Question question = iteratorQuestions.next();
                statement = connector.getPreparedStatement(SQL_INSERT_QUESTION_BY_TEST);
                statement.setInt(1, test.getId());
                statement.setString(2, question.getValueQuestion());
                statement.executeUpdate();
                statement = connector.getPreparedStatement(SQL_SELECT_IDQUESTION_BY_VALUEQUESTION);
                statement.setString(1, question.getValueQuestion());
                ResultSet resultSet = statement.executeQuery();
                resultSet.next();
                Integer idQuestion = resultSet.getInt("id");
                List<Answer> listAnswers = question.getAnswers();
                Iterator<Answer> iteratorAnswers = listAnswers.iterator();
                while (iteratorAnswers.hasNext()){
                    Answer answer = iteratorAnswers.next();
                    statement = connector.getPreparedStatement(SQL_INSERT_ANSWER_BY_QUESTION);
                    statement.setInt(1, idQuestion);
                    statement.setString(2, answer.getValueAnswer());
                    statement.setBoolean(3, answer.getCorrectAnswer());
                    statement.executeUpdate();
                }
                statement = connector.getPreparedStatement(SQL_UPDATE_TEST);
                statement.setString(1, test.getSubject());
                statement.setString(2, test.getTopic());
                statement.setInt(3, test.getTime());
                statement.setInt(4, test.getId());
                statement.executeUpdate();
            }
        }catch (SQLException e){
            logger.error(e.getMessage());
        }finally {
            this.closeStatement(statement);
        }
        return true;
    }

    public boolean deleteAnswerById(Integer id){
        PreparedStatement statement = null;
        try{
            statement = connector.getPreparedStatement(SQL_DELETE_ANSWER_BY_ID);
            statement.setInt(1, id);
            statement.executeUpdate();
        }catch (SQLException e){
            logger.error(e.getMessage());
        }finally {
            this.closeStatement(statement);
        }
        return true;
    }
    public boolean deleteAnswersByQuestionId(Integer id){
        PreparedStatement statement = null;
        try{
            statement = connector.getPreparedStatement(SQL_DELETE_ANSWERS_BY_QUESTIONID);
            statement.setInt(1, id);
            statement.executeUpdate();
        }catch (SQLException e){
            logger.error(e.getMessage());
        }finally {
            this.closeStatement(statement);
        }
        return true;
    }
    public boolean deleteQuestionById(Integer id){
        PreparedStatement statement = null;
        try{
            deleteAnswersByQuestionId(id);
            statement = connector.getPreparedStatement(SQL_DELETE_QUESTION_BY_ID);
            statement.setInt(1, id);
            statement.executeUpdate();
        }catch (SQLException e){
            logger.error(e.getMessage());
        }finally {
            this.closeStatement(statement);
        }
        return true;
    }
    public boolean deleteQuestionsByTestId(Integer id){

            Test test = findEntityById(id);
            List<Question> questions = test.getQuestions();
            Iterator<Question> iterator = questions.iterator();
            while (iterator.hasNext()){
                deleteQuestionById(iterator.next().getId());
            }
        return true;
    }

}
