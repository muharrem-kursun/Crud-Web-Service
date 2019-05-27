package com.dao;

import com.model.Person;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.sql.*;

public class PersonDaoImpl implements PersonDao {
   public Connection connection;
    private final String INSERT_PERSON = "insert into personel(Pid,Pad,Psoyad) values(?,?,?)";
    private final String UPDATE_PERSON = "update personel set Pad = ?, Psoyad = ? where Pid=?";
    private final String DELETE_PERSON = "delete from personel where Pid = ? " ;
    private final String SELECT_PERSON = "select *from personel";
    private final Logger LOGGER = Logger.getLogger(PersonDaoImpl.class);
    public PersonDaoImpl()  {
        try {
            PropertyConfigurator.configure("write.properties");
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
                System.out.println("id : "+resultSet.getInt("Pid")+"  ad : "+resultSet.getString("Pad")
                +"soyad  : "+resultSet.getString("Psoyad"));

            }
            LOGGER.info("select islemi basarili");
        }
        catch (Exception e)
        {
            LOGGER.error("select islemi basarisiz",e);

        }
    }

    @Override
    public void delete(int id) {


        try {

            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PERSON);
            preparedStatement.setInt(1,id);

            preparedStatement.executeUpdate();
            LOGGER.info("delete islemi basarili");
        }
        catch (Exception e)
        {

            LOGGER.info("delete islemi basarisiz");
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
            LOGGER.info("update islemi basarili");

        }
        catch (Exception e)
        {

            LOGGER.info("update islemi basarisiz");
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
            LOGGER.info("insert islemi basarili");
        }
catch (Exception e)
{
    LOGGER.info("insert islemi basarisiz");

}
    }

    @Override
    public Connection getConnection()  {
        try {

            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/deneme2","root","");
            LOGGER.info("veritabanı bağlantısı  basarili ");
        }
catch (Exception e)
{
    System.out.println(e);
    LOGGER.info("veritabanı bağlantısı başarısız ");
}
        return connection;
    }
}
