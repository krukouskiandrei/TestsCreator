package by.krukouski.testscreator.dao;

import by.krukouski.testscreator.exception.ResourceSQLExeption;
import by.krukouski.testscreator.exception.ResourceUnsupportedOperationExeption;
import by.krukouski.testscreator.subject.Answer;
import by.krukouski.testscreator.subject.Question;
import by.krukouski.testscreator.subject.Test;

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

    public static final String SQL_SELECT_ALL_TESTS = "SELECT id, subject, topic, time FROM test";//выбор всех тестов
    public static final String SQL_SELECT_IDTEST_BY_TOPIC_AND_SUBJECT = "SELECT id FROM test WHERE topic = ? AND subject = ?";//выбор тестов по теме и предмету
    public static final String SQL_SELECT_IDQUESTION_BY_VALUEQUESTION = "SELECT id FROM question WHERE value_question = ?";//выбор id вопроса по значению вопроса
    public static final String SQL_SELECT_TEST = "SELECT id, subject, topic, time FROM test WHERE id = ?";//выбор теста по id
    public static final String SQL_SELECR_ALL_QUESTIONS_BY_TEST = "SELECT id, value_question FROM question WHERE id_test = ?";//выбор вопросов по id теста
    public static final String SQL_SELECT_ALL_ANSWERS_BY_QUESTION = "SELECT id, value_answer, correct_answer FROM answer WHERE id_question = ?";//выбор ответов по id вопроса
    public static final String SQL_INSERT_TEST_BY_USER = "INSERT INTO test(id_user, topic, subject, time) VALUES(?, ?, ?, ?)";//вставка теста в БД
    public static final String SQL_INSERT_QUESTION_BY_TEST = "INSERT INTO question(id_test, value_question) VALUES(?, ?)";//вставка вопроса в БД
    public static final String SQL_INSERT_ANSWER_BY_QUESTION = "INSERT INTO answer(id_question, value_answer, correct_answer) VALUES(?, ?, ?)";//вставка ответа в БД

    public TestDAO(){
        this.connector = new WrapperConnector();
    }
    @Override
    public List<Test> findAll() {//получение списка всех тестов

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
            new ResourceSQLExeption();
        }finally {
            this.closeStatement(statement);


        }

        return tests;
    }
    @Override
    public Test findEntityById(Integer id){//нахожение теста по id
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
            new ResourceSQLExeption(e);
        }finally {
            this.closeStatement(statement);
        }
        return test;
    }
    public boolean createTest(Test test, Integer id_user){//создание теста
        PreparedStatement statement = null;
        try {
            statement = connector.getPreparedStatement(SQL_INSERT_TEST_BY_USER);
            statement.setInt(1, id_user);
            statement.setString(2, test.getTopic());
            statement.setString(3, test.getSubject());
            statement.setInt(4, test.getTime());
            statement.executeUpdate();
            statement = connector.getPreparedStatement(SQL_SELECT_IDTEST_BY_TOPIC_AND_SUBJECT);
            statement.setString(1, test.getTopic());
            statement.setString(2, test.getSubject());
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            Integer id_test = resultSet.getInt("id");
            List<Question> listQuestions = test.getQuestions();
            Iterator<Question> iteratorQuestions = listQuestions.iterator();
            while (iteratorQuestions.hasNext()){
                Question question = iteratorQuestions.next();
                statement = connector.getPreparedStatement(SQL_INSERT_QUESTION_BY_TEST);
                statement.setInt(1, id_test);
                statement.setString(2, question.getValueQuestion());
                statement.executeUpdate();
                statement = connector.getPreparedStatement(SQL_SELECT_IDQUESTION_BY_VALUEQUESTION);
                statement.setString(1, question.getValueQuestion());
                resultSet = statement.executeQuery();
                resultSet.next();
                Integer id_question = resultSet.getInt("id");
                List<Answer> listAnswers = question.getAnswers();
                Iterator<Answer> iteratorAnswers = listAnswers.iterator();
                while (iteratorAnswers.hasNext()){
                    Answer answer = iteratorAnswers.next();
                    statement = connector.getPreparedStatement(SQL_INSERT_ANSWER_BY_QUESTION);
                    statement.setInt(1, id_question);
                    statement.setString(2, answer.getValueAnswer());
                    statement.setBoolean(3, answer.getCorrectAnswer());
                    statement.executeUpdate();
                }
            }
        }catch (SQLException e){
            new ResourceSQLExeption(e);
            return false;
        }finally {
            this.closeStatement(statement);
        }


        return true;
    }
    @Override
    public boolean delete(Integer id){
        throw new ResourceUnsupportedOperationExeption();
    }
    @Override
    public boolean delete(Test test){
        throw new ResourceUnsupportedOperationExeption();
    }
    @Override
    public boolean create(Test test){
        throw new ResourceUnsupportedOperationExeption();
    }
    @Override
    public Test update(Test test){
        throw new ResourceUnsupportedOperationExeption();
    }


}
