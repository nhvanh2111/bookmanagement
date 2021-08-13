package dao;

import dto.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Locale.Category;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import ui.CustomerTableModelBook;
import ultis.DBUItis;

public class TblBookDAO {

    private String[] headeres = {"Book ID", "Book Name", "Author", "Publisher", "Published Year", "For Rent"};
    private int[] indexes = {0, 1, 2, 3, 4, 5};
    private CustomerTableModelBook modelBook = new CustomerTableModelBook(headeres, indexes);

    public CustomerTableModelBook getModelBook() {
        return modelBook;
    }

    public TblBookDAO() {
        try {
            loadData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadData() throws Exception {
        modelBook.getList().clear();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBUItis.openConnection();
            if (con != null) {
                String sql = "SELECT bookID, bookName, author, publisher, publishedYear, forRent FROM dbo.Books";
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Book b = new Book(rs.getString("bookID"), rs.getString("bookName"), rs.getString("author"),
                            rs.getString("publisher"), rs.getInt("publishedYear"), rs.getBoolean("forRent"));
                    modelBook.getList().add(b);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public Book getBookById(String bookID) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT bookID, bookName, author, publisher, publishedYear, forRent FROM dbo.Books WHERE bookID=?";
        try {
            con = DBUItis.openConnection();
            if (con != null) {

                ps = con.prepareStatement(sql);
                ps.setString(1, bookID);
                rs = ps.executeQuery();
                if (rs.next()) {
                    String id = rs.getString("bookID");
                    String name = rs.getString("bookName");
                    String author = rs.getString("author");
                    String publisher = rs.getString("publisher");
                    int publishedYear = rs.getInt("publishedYear");
                    boolean forRent = rs.getBoolean("forRent");

                    Book b = new Book(id, name, author, publisher, publishedYear, forRent);

                    return b;
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return null;
    }

    public int Insert(Book b) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBUItis.openConnection();
            if (con != null) {
                String sql = "Insert dbo.Books Values(?,?,?,?,?,?)";

                ps = con.prepareStatement(sql);
                ps.setString(1, b.getId());
                ps.setString(2, b.getName());
                ps.setString(3, b.getAuthor());
                ps.setString(4, b.getPublisher());
                ps.setInt(5, b.getPublishedYear());
                ps.setBoolean(6, b.isForRent());
                return ps.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return -1;
    }
    
    public int Save(Book b) throws Exception{
        Connection con= null;
        PreparedStatement ps= null;
        try {
            con= DBUItis.openConnection();
            if(con!=null){
                String sql= "Update dbo.Books Set bookName=?, author=?, publisher=?, publishedYear=?, forRent=? Where bookID=?";
                ps= con.prepareStatement(sql);
                ps.setString(1, b.getName());
                ps.setString(2, b.getAuthor());
                ps.setString(3, b.getPublisher());
                ps.setInt(4, b.getPublishedYear());
                ps.setBoolean(5, b.isForRent());
                ps.setString(6, b.getId());
                return ps.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(ps != null) {
                ps.close();
            }
            if(con != null) {
                con.close();
            }
            
        }
        return -1;
    }
    
    public int Delete(Book b) throws Exception{
        Connection con= null;
        PreparedStatement ps= null;
        try {
            con= DBUItis.openConnection();
            if(con!=null){
                String sql="DELETE FROM dbo.Books WHERE bookID=?";
                ps= con.prepareStatement(sql);
                ps.setString(1, b.getId());
                return ps.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(ps != null) {
                ps.close();
            }
            if(con != null) {
                con.close();
            }
        }
        return -1;
    }
    
    public void loadBookAscending() throws SQLException{
        Connection con=null;
        PreparedStatement ps= null;
        ResultSet rs= null;
        modelBook.getList().clear();
        try {
            con= DBUItis.openConnection();
            if(con!=null){
                String sql= "SELECT bookID, bookName, author, publisher, publishedYear, forRent FROM dbo.Books ORDER BY bookName ASC;";
                ps=con.prepareStatement(sql);
                rs= ps.executeQuery();
                while(rs.next()){
                    Book b= new Book(rs.getString("bookID"), rs.getString("bookName"), rs.getString("author"),
                            rs.getString("publisher"), rs.getInt("publishedYear"), rs.getBoolean("forRent"));
                    modelBook.getList().add(b);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(rs != null) {
                rs.close();
            }
            if(ps != null) {
                ps.close();
            }
            if(con != null) {
                con.close();
            }
        }
    }

    public void loadBookDescending() throws SQLException {
        Connection con = null;   
        PreparedStatement ps = null;   
        ResultSet rs = null;   
        modelBook.getList().clear();
        try {
            con = DBUItis.openConnection();  
            if (con != null) {   
                String sql = "SELECT bookID, bookName, author, publisher, publishedYear, forRent FROM dbo.Books ORDER BY bookName DESC;";   // Lấy tất cả giá trị tăng dần từ bảng LISTBOOK trong database

                ps = con.prepareStatement(sql); 
                rs = ps.executeQuery();   
                while (rs.next()) {
                    Book b = new Book(rs.getString("bookID"), rs.getString("bookName"), rs.getString("author"),
                            rs.getString("publisher"), rs.getInt("publishedYear"), rs.getBoolean("forRent"));
                    modelBook.getList().add(b);
                }
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();   
            }
            if (ps != null) {
                ps.close();  
            }
            if (con != null) {
                con.close();  
            }
        }

    }

    public void loadTableBookSearchByName(String bookName) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        modelBook.getList().clear();
        try {
            con = DBUItis.openConnection();
            if (con != null) {
                String sql = "SELECT bookID, bookName, author, publisher, publishedYear, forRent FROM dbo.Books WHERE CHARINDEX(N'" + bookName + "', bookName)>0;";

                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Book b = new Book(rs.getString("bookID"), rs.getString("bookName"), rs.getString("author"),
                            rs.getString("publisher"), rs.getInt("publishedYear"), rs.getBoolean("forRent"));
                    modelBook.getList().add(b);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public boolean validDatabookID(String bookID) {//xet trung category
        try {
            for (int i = 0; i < modelBook.getList().size(); i++) {
                if (modelBook.getList().get(i).getId().compareToIgnoreCase(bookID) == 0) {
                    return false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean validData(String bookID, String bookName, String author, String publisher) {
        if (!bookID.toUpperCase().matches("[a-zA-Z]{1}[0-9]{2}")) {
            JOptionPane.showMessageDialog(null, "Invalid Book ID");
            return false;
        }
        if (bookName.isEmpty() || bookName.length() > 50) {
            JOptionPane.showMessageDialog(null, "Invalid Book Name");
            return false;
        }
        if (author.isEmpty() || author.length() > 50) {
            JOptionPane.showMessageDialog(null, "Invalid Author");
            return false;
        }
        if (publisher.isEmpty() || publisher.length() > 50) {
            JOptionPane.showMessageDialog(null, "Invalid Publisher");
            return false;
        }
        return true;
    }
}
