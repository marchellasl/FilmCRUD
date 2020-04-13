package film;

import java.util.Random;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ModelFilm 
{
    ViewFilm viewFilm;
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/filmpraktikum";
    static final String USER = "root";
    static final String PASS = "";
    
    Connection koneksi;
    Statement statement;
    
    public ModelFilm()
    {
        try
        {
            Class.forName(JDBC_DRIVER);
            koneksi = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected");
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Connection Failed");
        }
    }
    
    public void insertFilm(String judul, String tipe, String episode, String genre, String status, String rating)
    {
        try
        {
            String id;
            Random r = new Random();
            int idf = r.nextInt(10000-1)+1;
            id = Integer.toString(idf);
            String query = "INSERT INTO `film` (`ID`, `Judul`,`Tipe`,`Episode`, `Genre`, `Status`, `Rating`)"
                    + "VALUES ('"+id+"','"+judul+"', '"+tipe+"', '"+episode+"','"+genre+"', '"+status+"', '"+rating+"')";
            statement = (Statement) koneksi.createStatement();
            statement.executeUpdate(query);
            System.out.println("Added");
            JOptionPane.showMessageDialog(null, "Data Added");
        }
        catch(Exception sql)
        {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    
    public String[][] readFilm()
    {
        try
        {
            int jmlData = 0;
            int no = 0;
            String data[][] = new String[getBanyakData()][8];
            String query = "SELECT * FROM `Film`;";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next())
            {
                no++;
                String str = Integer.toString(no);
                data[jmlData][0] = str;
                data[jmlData][1] = resultSet.getString("ID");
                data[jmlData][2] = resultSet.getString("Judul");
                data[jmlData][3] = resultSet.getString("Tipe");
                data[jmlData][4] = resultSet.getString("Episode");
                data[jmlData][5] = resultSet.getString("Genre");
                data[jmlData][6] = resultSet.getString("Status");
                data[jmlData][7] = resultSet.getString("Rating");
                jmlData++;
                
            }
            return data;
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    
    public int getBanyakData()
    {
        int jmlData = 0;
        try
        {
            statement = koneksi.createStatement();
            String query = "Select * from `Film`";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next())
            {
                jmlData++;
            }
            return jmlData;
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }
    
    public void deleteFilm(String id)
    {
        try{
            String query = "DELETE FROM `Film` WHERE `ID` = '"+id+"'";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Deleted");
        }catch(SQLException sql){
            System.out.println(sql.getMessage());
        }
    }
    
    public int getSearchedData(String search)
    {
        int jmlData = 0;
        try
        {
            statement = koneksi.createStatement();
            String query = "SELECT *  FROM `Film` WHERE `Judul` LIKE '%"+search+"%'";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next())
            {
                jmlData++;
            }
            return jmlData;
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }
        
    public String[][] readsearchedFilm(String search)
    {
        try
        {
            int jmlData = 0;
            int no = 0;
            String data[][] = new String[getSearchedData(search)][8];
            String query = "SELECT *  FROM `Film` WHERE `Judul` LIKE '%"+search+"%'";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next())
            {
                no++;
                String str = Integer.toString(no);
                data[jmlData][0] = str;
                data[jmlData][1] = resultSet.getString("ID");
                data[jmlData][2] = resultSet.getString("Judul");
                data[jmlData][3] = resultSet.getString("Tipe");
                data[jmlData][4] = resultSet.getString("Episode");
                data[jmlData][5] = resultSet.getString("Genre");
                data[jmlData][6] = resultSet.getString("Status");
                data[jmlData][7] = resultSet.getString("Rating");
                jmlData++;
            }
            return data;
            
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    
    public void updateFilm(String id, String judul, String tipe, String episode, String genre, String status, String rating)
    {
        try
        {
            String query = "UPDATE `Film` SET `Judul` = '"+judul+"', `Tipe` = '"+tipe+"', `Episode` = '"+episode+"',"
                    + " `Genre` = '"+genre+"', `Status` = '"+status+"', `Rating` = '"+rating+"' WHERE `ID` = '"+id+"'";
            statement = (Statement) koneksi.createStatement();
            statement.executeUpdate(query);
            System.out.println("Updated");
            JOptionPane.showMessageDialog(null, "Data Updated");
        }
        catch(Exception sql)
        {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }


}