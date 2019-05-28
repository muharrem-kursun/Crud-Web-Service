package com.dao;

import com.model.Person;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class PersonDaoImpl implements PersonDao {
   public Connection connection;
    private final String INSERT_PERSON = "insert into personel(Pid,Pad,Psoyad) values(?,?,?)";
    private final String UPDATE_PERSON = "update personel set Pad = ?, Psoyad = ? where Pid=?";
    private final String DELETE_PERSON = "delete from personel where Pid = ? " ;
    private final String SELECT_PERSON = "select *from personel";
    private final Logger LOGGER = Logger.getLogger(PersonDaoImpl.class);
    public PersonDaoImpl()  {
        try {
            InputStream inputStream= getClass().getResourceAsStream("/write.properties");
            PropertyConfigurator.configure(inputStream);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        connection=getConnection();
    }
    @Override
    public void select() {

        try {

            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PERSON);
             ResultSet resultSet= preparedStatement.executeQuery();

            while (resultSet.next()){
                System.out.println("id : "+resultSet.getInt("Pid")+"  name : "+resultSet.getString("Pad")
                +"soyad  : "+resultSet.getString("Psoyad"));

            }
            LOGGER.info("select islemi basarili.");
        }
        catch (Exception e)
        {
            LOGGER.error("select islemi basarisiz.");

        }
    }

    @Override
    public void delete(int id) {

        try {

            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PERSON);
            preparedStatement.setInt(1,id);

            preparedStatement.executeUpdate();
            LOGGER.info("delete islemi basarili.");
        }
        catch (Exception e)
        {

            LOGGER.info("delete islemi basarisiz.");
        }
    }

    @Override
    public void update(Person person) {



        try {

            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PERSON);
            preparedStatement.setString(1,person.getName());
            preparedStatement.setString(2,person.getSurName());
            preparedStatement.setInt(3,person.getId());
            preparedStatement.executeUpdate();
            LOGGER.info("update islemi basarili.");

        }
        catch (Exception e)
        {

            LOGGER.info("update islemi basarisiz.");
        }
    }

    @Override
        public  void insert(Person person)  {


        try {

            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PERSON);
            preparedStatement.setInt(1,person.getId());
            preparedStatement.setString(2,person.getName());
            preparedStatement.setString(3,person.getSurName());
            preparedStatement.executeUpdate();
            LOGGER.info("insert islemi basarili.");
        }
catch (Exception e)
{
    LOGGER.info("insert islemi basarisiz.");

}
    }

    @Override
    public Connection getConnection()  {
        Properties properties = new Properties();
        InputStream input = null;
        try {
            input = getClass().getResourceAsStream("/db.properties");
            properties.load(input);
            LOGGER.info("db.properties load edilmistir.");
        } catch (IOException e) {
            LOGGER.error("db.properties bulununamadi." );

        }

        String URL = (String)properties.get("URL");
        String USERNAME = (String) properties.get("Username");
        String PASSWORD =(String) properties.get("password");

        properties.setProperty("user", USERNAME);
        properties.setProperty("password", PASSWORD);
        properties.setProperty("useUnicode", "yes");
        properties.setProperty("characterEncoding", "UTF-8");
        properties.setProperty("serverTimezone", "UTC");
        properties.setProperty("autoReconnect", "true");
        properties.setProperty("useSSL", "false");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            LOGGER.info("veritabanı baglantisi kurulmustur.");
            connection = DriverManager.getConnection(URL,properties);
            return connection;
        } catch (Exception e) {
            LOGGER.error("Drive manager bulunamadi. ");

        }
        return connection;
    }
}
