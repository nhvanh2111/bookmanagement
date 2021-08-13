package ui;

import dao.TblBookDAO;
import dto.Book;
import java.awt.event.ItemEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class ManagementUI extends javax.swing.JFrame {

    TblBookDAO modelBook;

    final int SUCCESS = 1;
    boolean addNewBook = true;
    boolean deleteBook = true;

    public ManagementUI() throws Exception {
        initComponents();
        setLocationRelativeTo(null);

        modelBook = new TblBookDAO();
        tblBook.setModel(modelBook.getModelBook());

        loadPublishedYearIntoComboBox();

        cbxPublishedYear.setSelectedIndex(-1);
        cbxSortByName.setSelectedIndex(-1);

    }

    public void loadPublishedYearIntoComboBox() {
        for (int i = 1985; i < 2021; i++) {
            cbxPublishedYear.addItem(String.valueOf(i));
        }
    }

    public void loadSortByName() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.addElement("Ascending");
        model.addElement("Descending");

        cbxSortByName.setModel(model);
        cbxSortByName.setSelectedIndex(-1);
    }

    void clearInformationBookOnTable() {
        txtBookID.setText("");
        txtBookName.setText("");
        txtBookName.setEnabled(true);
        txtAuthor.setText("");
        txtAuthor.setEnabled(true);
        txtPublisher.setText("");
        txtPublisher.setEnabled(true);
        cbxPublishedYear.setSelectedIndex(-1);
        cbxPublishedYear.setEnabled(true);
        chkForRent.setSelected(false);
        chkForRent.setEnabled(true);
        cbxSortByName.setSelectedIndex(-1);
    }

    private void clearAllBook() {
        txtBookID.setText("");
        txtBookName.setText("");
        txtBookName.setEnabled(false);
        txtAuthor.setText("");
        txtAuthor.setEnabled(false);
        txtPublisher.setText("");
        txtPublisher.setEnabled(false);
        cbxPublishedYear.setSelectedIndex(-1);
        cbxPublishedYear.setEnabled(false);
        chkForRent.setSelected(false);
        chkForRent.setEnabled(false);

        cbxSortByName.setSelectedIndex(-1);
        cbxSortByName.setEnabled(true);
        txtSearchByName.setText("");

    }

    private void clearMouseClickedBook() {
        txtBookName.setEnabled(true);
        txtAuthor.setEnabled(true);
        txtPublisher.setEnabled(true);
        cbxPublishedYear.setEnabled(true);
        chkForRent.setEnabled(true);

    }

    private void clearBookSort() {
        txtBookID.setText("");
        txtBookName.setText("");
        txtBookName.setEnabled(false);
        txtAuthor.setText("");
        txtAuthor.setEnabled(false);
        txtPublisher.setText("");
        txtPublisher.setEnabled(false);
        cbxPublishedYear.setSelectedIndex(-1);
        cbxPublishedYear.setEnabled(false);
        chkForRent.setSelected(false);
        chkForRent.setEnabled(false);

        cbxSortByName.setEnabled(true);
        txtSearchByName.setText("");
    }

    public void displayDetailBook(Book book) {
        txtBookID.setText(book.getId());
        txtBookName.setText(book.getName());
        txtAuthor.setText(book.getAuthor());
        txtPublisher.setText(book.getPublisher());
        cbxPublishedYear.setSelectedIndex(book.getPublishedYear() - 1985);
        if (book.isForRent() == true) {
            chkForRent.setSelected(true);
        } else {
            chkForRent.setSelected(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBook = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        cbxSortByName = new javax.swing.JComboBox<>();
        btnSearchByName = new javax.swing.JButton();
        txtSearchByName = new javax.swing.JTextField();
        btnGetAllBook = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtBookID = new javax.swing.JTextField();
        btnFindByID = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtBookName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtAuthor = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtPublisher = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cbxPublishedYear = new javax.swing.JComboBox<>();
        chkForRent = new javax.swing.JCheckBox();
        btnAddNew = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Book Management");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Main part:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 15))); // NOI18N

        tblBook.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        tblBook.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBookMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblBook);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Sort by name:");

        cbxSortByName.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        cbxSortByName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Descending", "Ascending" }));
        cbxSortByName.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxSortByNameItemStateChanged(evt);
            }
        });

        btnSearchByName.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnSearchByName.setText("Search by name");
        btnSearchByName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchByNameActionPerformed(evt);
            }
        });

        txtSearchByName.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        btnGetAllBook.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnGetAllBook.setText("Get all Book");
        btnGetAllBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetAllBookActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbxSortByName, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSearchByName)
                .addGap(18, 18, 18)
                .addComponent(txtSearchByName))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(183, 183, 183)
                .addComponent(btnGetAllBook, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSearchByName)
                        .addComponent(txtSearchByName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(cbxSortByName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGetAllBook)
                .addGap(0, 7, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detailed part:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 15))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("Book ID:");

        txtBookID.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        btnFindByID.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnFindByID.setText("Find by ID");
        btnFindByID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindByIDActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("Book Name:");

        txtBookName.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setText("Author:");

        txtAuthor.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setText("Publisher:");

        txtPublisher.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel7.setText("Published Year:");

        cbxPublishedYear.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        chkForRent.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        chkForRent.setText("For rent");

        btnAddNew.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnAddNew.setText("Add New");
        btnAddNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNewActionPerformed(evt);
            }
        });

        btnSave.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnRemove.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnRemove.setText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtBookID, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFindByID))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtAuthor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                            .addComponent(txtBookName)
                            .addComponent(txtPublisher))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(btnAddNew)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSave))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(chkForRent)
                                    .addComponent(cbxPublishedYear, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(btnRemove)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtBookID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFindByID))
                .addGap(42, 42, 42)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtBookName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(txtAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtPublisher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbxPublishedYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(chkForRent)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddNew)
                    .addComponent(btnSave)
                    .addComponent(btnRemove))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBookMouseClicked
        int selectedRow = tblBook.getSelectedRow();
        Book b = modelBook.getModelBook().getList().get(selectedRow);
        txtBookID.setText(b.getId());
        txtBookName.setText(b.getName());
        txtAuthor.setText(b.getAuthor());
        txtPublisher.setText(b.getPublisher());
        cbxPublishedYear.setSelectedIndex(b.getPublishedYear() - 1985);
        chkForRent.setSelected(b.isForRent());
        cbxSortByName.setSelectedIndex(-1);
        addNewBook = false;
        deleteBook = true;
    }//GEN-LAST:event_tblBookMouseClicked

    private void btnAddNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNewActionPerformed
        clearInformationBookOnTable();
        addNewBook = true;
        deleteBook = false;
    }//GEN-LAST:event_btnAddNewActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (!modelBook.validData(txtBookID.getText().trim(), txtBookName.getText().trim(), txtAuthor.getText().trim(),
                txtPublisher.getText().trim())) {
            return;
        }
        if (addNewBook) {
            try {
                if (!modelBook.validDatabookID(txtBookID.getText().trim())) {
                    JOptionPane.showMessageDialog(this, "DUPLICATED BOOKID at " + txtBookID.getText().trim());
                    return;
                }
                Book b = new Book(txtBookID.getText().toUpperCase().trim(),
                        txtBookName.getText().trim(),
                        txtAuthor.getText().trim(),
                        txtPublisher.getText().trim(),
                        Integer.parseInt(cbxPublishedYear.getSelectedItem().toString()),
                        chkForRent.isSelected());
                if (modelBook.Insert(b) == SUCCESS) {
                    modelBook.getModelBook().getList().add(b);
                }
                addNewBook = false;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                int selectedRow = tblBook.getSelectedRow();
                if (selectedRow < 0) {
                    JOptionPane.showMessageDialog(this, "Please Choose Row to Edit");
                }

                Book bOld = modelBook.getModelBook().getList().get(selectedRow);
                Book bNew = new Book(txtBookID.getText().trim().toUpperCase(),
                        txtBookName.getText().trim(),
                        txtAuthor.getText().trim(),
                        txtPublisher.getText().trim(),
                        Integer.parseInt(cbxPublishedYear.getSelectedItem().toString()),
                        chkForRent.isSelected());
                if (modelBook.Save(bNew) == SUCCESS) {
                    bOld.setName(bNew.getName());
                    bOld.setAuthor(bNew.getAuthor());
                    bOld.setPublisher(bNew.getPublisher());
                    bOld.setPublishedYear(bNew.getPublishedYear());
                    bOld.setForRent(bNew.isForRent());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        tblBook.updateUI();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        try {
            int selectedRow = tblBook.getSelectedRow();
            if (selectedRow < 0 || deleteBook == false) {
                JOptionPane.showMessageDialog(this, "Choose the Row to Delete");
                return;
            }
            int r = JOptionPane.showConfirmDialog(this, "Do you want to Delete this Book?");
            if (r == JOptionPane.YES_OPTION) {
                Book b = modelBook.getModelBook().getList().get(selectedRow);
                if (modelBook.Delete(b) == SUCCESS) {
                    deleteBook = false;
                    modelBook.getModelBook().getList().remove(b);
                    JOptionPane.showMessageDialog(this, "Deleted");
                    clearInformationBookOnTable();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        tblBook.updateUI();
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnFindByIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindByIDActionPerformed
        addNewBook = false;
        String bookID = txtBookID.getText();
        try {
            modelBook.loadData();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(ManagementUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 0; i < modelBook.getModelBook().getList().size(); i++) {
            if (bookID.equals(modelBook.getModelBook().getList().get(i).getId())) {
                clearMouseClickedBook();
                
                modelBook = new TblBookDAO();
                tblBook.setModel(modelBook.getModelBook());
                
                Book book = modelBook.getModelBook().getList().get(i);
                displayDetailBook(book);
                tblBook.setRowSelectionInterval(i, i); //focus dong dc chon
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Không tìm thấy ID này!");
    }//GEN-LAST:event_btnFindByIDActionPerformed

    private void btnSearchByNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchByNameActionPerformed
        String bookName = txtSearchByName.getText();
        if (bookName.length() == 0) {
            JOptionPane.showMessageDialog(null, "Search by name phải khác rỗng!");
            return;
        }
        for (int i = 0; i < modelBook.getModelBook().getList().size(); i++) {
            if (modelBook.getModelBook().getList().get(i).getName().contains(bookName) == true) {
                try {
                    modelBook = new TblBookDAO();
                    modelBook.loadTableBookSearchByName(bookName);
                    tblBook.setModel(modelBook.getModelBook());
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Không tìm thấy tên sách này!");
    }//GEN-LAST:event_btnSearchByNameActionPerformed

    private void btnGetAllBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetAllBookActionPerformed
        clearAllBook();
        try {            
            modelBook = new TblBookDAO();
            tblBook.setModel(modelBook.getModelBook());
        } catch (Exception ex) {
            Logger.getLogger(ManagementUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGetAllBookActionPerformed

    private void cbxSortByNameItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxSortByNameItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            if (cbxSortByName.getSelectedIndex() == 0) {
                clearBookSort();
                try {
                    modelBook = new TblBookDAO();
                    modelBook.loadBookDescending();
                } catch (SQLException ex) {
                    Logger.getLogger(ManagementUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                tblBook.setModel(modelBook.getModelBook());
            }
            if (cbxSortByName.getSelectedIndex() == 1) {
                clearBookSort();
                try {
                    modelBook = new TblBookDAO();
                    modelBook.loadBookAscending();
                } catch (SQLException ex) {
                    Logger.getLogger(ManagementUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                tblBook.setModel(modelBook.getModelBook());
            }
        }
    }//GEN-LAST:event_cbxSortByNameItemStateChanged

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManagementUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManagementUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManagementUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManagementUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ManagementUI().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(ManagementUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddNew;
    private javax.swing.JButton btnFindByID;
    private javax.swing.JButton btnGetAllBook;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearchByName;
    private javax.swing.JComboBox<String> cbxPublishedYear;
    private javax.swing.JComboBox<String> cbxSortByName;
    private javax.swing.JCheckBox chkForRent;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblBook;
    private javax.swing.JTextField txtAuthor;
    private javax.swing.JTextField txtBookID;
    private javax.swing.JTextField txtBookName;
    private javax.swing.JTextField txtPublisher;
    private javax.swing.JTextField txtSearchByName;
    // End of variables declaration//GEN-END:variables
}
