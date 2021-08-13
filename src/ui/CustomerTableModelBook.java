
package ui;

import dto.Book;
import java.util.Locale.Category;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

public class CustomerTableModelBook extends AbstractTableModel{
    private String[] headeres;
    private int[] indexes;
    private Vector<Book> data;
    
    public Vector<Book> getList(){
        return data;
    }
    
    public CustomerTableModelBook(String[] headeres, int[] indexes){
        this.headeres= new String[headeres.length];
        for(int i=0; i<headeres.length; i++){
            this.headeres[i]= headeres[i];
        }
        this.indexes= new int[indexes.length];
        for(int i=0; i<indexes.length; i++){
            this.indexes[i]= indexes[i];
        }
        data= new Vector<>();
    }

    @Override
    public String getColumnName(int column) {
        if(column>=0 || column<headeres.length){
            return headeres[column];
        }
        else return "";
    }
    
    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return headeres.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(rowIndex<0 || rowIndex>=data.size() || columnIndex<0|| columnIndex>=headeres.length){
            return null;
        }
        Book b= data.get(rowIndex);
        switch(indexes[columnIndex]){
            case 0: return b.getId();
            case 1: return b.getName();
            case 2: return b.getAuthor();
            case 3: return b.getPublisher();
            case 4: return b.getPublishedYear();
            case 5: return b.isForRent();
        }
        return null;
    }
}
