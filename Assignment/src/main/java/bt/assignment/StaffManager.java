package bt.assignment;

import java.awt.Color;
import java.util.List;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import library.Extensions;
import library.Validation;

public class StaffManager extends javax.swing.JFrame {
//    Tạo list và thông tin cần thiết
    List<Employee> list = new ArrayList<>();
    String path = "F:\\Java Lab2\\Data\\asmData.dat";
    
    
    Employee a = new Employee("1", "a", 18, "a123@gmail.com",18.0);
    Employee b = new Employee("2", "b", 18, "a123@gmail.com",18.0);
    Employee c = new Employee("3", "c", 18, "a123@gmail.com",18.0);
    Employee d = new Employee("4", "d", 18, "a123@gmail.com",18.0);
    
    
    public void addStaff(){
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
    }
    
    /**
     * Creates new form StafffManager
     */
    public StaffManager() {
        initComponents();
        setLocationRelativeTo(null);
        
        //Đồng hồ Y1.11
        new Thread()
        {
            public void run() {
                while(true) {
                    try {
                        Date now = new Date();
                        SimpleDateFormat formater = new SimpleDateFormat();
                        formater.applyPattern("hh:mm aa");
                        String time = formater.format(now);
                        txtTime.setText(time);
                    }
                    catch (Exception e) {
                        break;
                    }
                }
            }        
        }.start();
    }

//  Chức năng
    public void fillToTable(){
        DefaultTableModel model = (DefaultTableModel) tblThongTin.getModel();
        model.setRowCount(0);
        for (Employee nv : list) {
            Object[] row = new Object[] {nv.getStaffId(), nv.getName(), nv.getTuoi(), nv.getEmail(), nv.getSalary()};
            model.addRow(row);
        }
    }
    
    public void xuatConsole(){
        addStaff();
        for(Employee i : list) {
            System.out.println(i.getName());
        }
    }

    
    //Mở file
    public void Read(String path) throws IOException {
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            list = (List<Employee>) ois.readObject();
            System.out.println("Thành công");
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    //Lưu file và thoát
    public void Write(String path) throws IOException {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(path);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(StaffManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(fos);
            System.out.println("Thành Công");
        } catch (IOException ex) {
            Logger.getLogger(StaffManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        oos.writeObject(list);
        oos.close();
        fos.close();
    }
    
    //Xóa trắng ô nhập
    public void ClearForm() {
        txtStaffName.setText(null);
        txtStaffId.setText(null);
        txtTuoi.setText(null);
        txtStaffEmail.setText(null);
        txtSalary.setText(null);
    }
    
    //Tìm nv theo mã
    public void Find(String id) {
        for(int i = 0; i <= list.size(); i++) {
            if (i < list.size()) {
                if (list.get(i).getStaffId().equalsIgnoreCase(id)) {
                    txtStaffName.setText(list.get(i).getName());
                    txtTuoi.setText(String.valueOf(list.get(i).getTuoi()));
                    txtStaffEmail.setText(list.get(i).getEmail());
                    txtSalary.setText(String.valueOf(list.get(i).getSalary()));
                    break;
                } 
            } else {
                JOptionPane.showMessageDialog(this,"NV không tồn tại");
            }
        }
    }
    
    //Hiện thông tin khi click
    public void showDetail() {
        int index = tblThongTin.getSelectedRow();
        Employee nv = list.get(index);
        txtStaffName.setText(nv.getName());
        txtStaffId.setText(nv.getStaffId());
        txtTuoi.setText(String.valueOf(nv.getTuoi()));
        txtStaffEmail.setText(nv.getEmail());
        txtSalary.setText(String.valueOf(nv.getSalary()));
    }
    
    private void Check() {
        //Check Rỗng
        if(Validation.isEmpty(txtStaffId, "Mã nhân viên không tồn tại")) {
            return;
        }
        if(Validation.isEmpty(txtStaffName, "Tên nhân viên không tồn tại")) {
            return;
        }
        if(Validation.isEmpty(txtTuoi, "Nhập tuổi nhân viên")) {
            return;
        }
        if(Validation.isEmpty(txtStaffEmail, "Nhập Email")) {
            return;
        }
        //Check Tuổi
        if(!Validation.checkAge(txtTuoi)) {
            return;
        }
        //Check Email
        if(!Validation.isEmail(txtStaffEmail)) {
            return;
        }        
        //Check Lương
        if(!Validation.checkSalary(txtSalary)) {
            return;
        }
        
    }
    int clickbtnNew = 0;
    public void Save() {
        Check();
        String staffId = txtStaffId.getText();
        String name = txtStaffName.getText();
        int tuoi = Integer.parseInt(txtTuoi.getText());
        String email = txtStaffEmail.getText();
        Double salary = Double.valueOf(txtSalary.getText());
        if (clickbtnNew == 0) {
            int index = Extensions.getLocate(txtStaffId, list);
            if (index != -1) {
                Employee nv = new Employee(staffId, name, tuoi, email, salary);
                list.set(index, nv);
            } else {
                Employee nv = new Employee(staffId, name, tuoi, email, salary);
                list.add(nv);
            }
        } else {
            System.out.println(Validation.isExist(txtStaffId, list));
            if(Validation.isExist(txtStaffId, list)){
                JOptionPane.showMessageDialog(null, "Đã tồn tại trên hệ thống!");
            } else {
                Employee nv = new Employee(staffId, name, tuoi, email, salary);
                list.add(nv);
                clickbtnNew = 0;
            }
        }
    }
    
    //Nút Delete xóa nhân viên 
    public void Delete() {
        try {
        String idDelele = txtStaffId.getText();
        for (Employee i : list) {
            if (i.getStaffId().equalsIgnoreCase(idDelele)) {
                list.remove(i);
                break;
            }
        }
        }
        catch (Exception e){
            e.getMessage();
        }
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtStaffId = new javax.swing.JTextField();
        txtStaffName = new javax.swing.JTextField();
        txtTuoi = new javax.swing.JTextField();
        txtStaffEmail = new javax.swing.JTextField();
        txtSalary = new javax.swing.JTextField();
        btnNew = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnFind = new javax.swing.JButton();
        btnOpen = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblThongTin = new javax.swing.JTable();
        btnLastLeft = new javax.swing.JButton();
        btnLeft = new javax.swing.JButton();
        btnRight = new javax.swing.JButton();
        btnLastRight = new javax.swing.JButton();
        txtTime = new javax.swing.JLabel();
        txtSilde = new javax.swing.JLabel();
        txtIndex = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtRecordSum = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("QUẢN LÝ NHÂN VIÊN");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("QUẢN LÝ NHÂN VIÊN");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("MÃ NHÂN VIÊN");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("HỌ VÀ TÊN");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("TUỔI");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("EMAIL");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("LƯƠNG");

        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnFind.setText("Find");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        btnOpen.setText("Open");
        btnOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenActionPerformed(evt);
            }
        });

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        tblThongTin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "MÃ", "HỌ VÀ TÊN", "TUỔI", "EMAIL", "LƯƠNG"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblThongTin.setAutoscrolls(false);
        tblThongTin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblThongTinMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblThongTin);

        btnLastLeft.setText("|<");
        btnLastLeft.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastLeftActionPerformed(evt);
            }
        });

        btnLeft.setText("<<");
        btnLeft.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLeftActionPerformed(evt);
            }
        });

        btnRight.setText(">>");
        btnRight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRightActionPerformed(evt);
            }
        });

        btnLastRight.setText(">|");
        btnLastRight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastRightActionPerformed(evt);
            }
        });

        txtTime.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTime.setForeground(new java.awt.Color(255, 0, 0));
        txtTime.setText("10:22 AM");

        txtSilde.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSilde.setForeground(new java.awt.Color(255, 0, 0));
        txtSilde.setText("Record: ");

        txtIndex.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtIndex.setForeground(new java.awt.Color(255, 0, 51));
        txtIndex.setText("0");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("of");

        txtRecordSum.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtRecordSum.setForeground(new java.awt.Color(255, 0, 0));
        txtRecordSum.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtStaffId, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTuoi, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtStaffEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                                        .addComponent(txtStaffName, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnLastLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnRight, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnLastRight, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtSilde)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtIndex)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtRecordSum)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnNew, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSave, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnFind, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnOpen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(txtTime)
                        .addGap(18, 18, 18)
                        .addComponent(btnNew)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFind)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOpen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExit))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtStaffId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtStaffName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtTuoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtStaffEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnLastLeft)
                            .addComponent(btnLeft)
                            .addComponent(btnRight)
                            .addComponent(btnLastRight)
                            .addComponent(txtSilde)
                            .addComponent(txtIndex)
                            .addComponent(jLabel8)
                            .addComponent(txtRecordSum))))
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenActionPerformed
        try {
            Read(path);
            fillToTable();
            txtRecordSum.setText(String.valueOf(getRecord()));
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnOpenActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        try {
            Write(path);
            System.exit(0);
        } catch (IOException ex) {
            Logger.getLogger(StaffManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        ClearForm();
        addStaff();
        clickbtnNew++;
        System.out.println(clickbtnNew);
        txtRecordSum.setText(String.valueOf(getRecord()));
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        String id = txtStaffId.getText();
        Find(id);
    }//GEN-LAST:event_btnFindActionPerformed

    private void tblThongTinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblThongTinMouseClicked
        this.showDetail();
        getIndex();
    }//GEN-LAST:event_tblThongTinMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        Delete();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getName());
        }
        
        System.out.println("");
        fillToTable();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        Save();
        fillToTable();
    }//GEN-LAST:event_btnSaveActionPerformed

    
    public void getIndex() {
        int index = tblThongTin.getSelectedRow() + 1;
        txtIndex.setText(String.valueOf(index));
    }
    public int getRecord() {
        return list.size();
    }
    private void btnLastLeftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastLeftActionPerformed
        tblThongTin.setRowSelectionInterval(0, 0);
        showDetail();
        getIndex();
    }//GEN-LAST:event_btnLastLeftActionPerformed

    private void btnLastRightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastRightActionPerformed
        tblThongTin.setRowSelectionInterval(getRecord() -1, getRecord()-1);
        showDetail();
        getIndex();
    }//GEN-LAST:event_btnLastRightActionPerformed

    private void btnLeftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLeftActionPerformed
        if (tblThongTin.getSelectedRow() > 0) {
        int index = tblThongTin.getSelectedRow() - 1;
        tblThongTin.setRowSelectionInterval(index, index);
        showDetail();
        getIndex(); 
        }
    }//GEN-LAST:event_btnLeftActionPerformed

    private void btnRightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRightActionPerformed
        if (tblThongTin.getSelectedRow() < list.size()) {
            int index = tblThongTin.getSelectedRow() + 1;
            tblThongTin.setRowSelectionInterval(index, index);
            showDetail();
            getIndex();
        }
    }//GEN-LAST:event_btnRightActionPerformed

    
    
    
    
    
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StaffManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StaffManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StaffManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StaffManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StaffManager().setVisible(true);
            }
        });
        
       
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnLastLeft;
    private javax.swing.JButton btnLastRight;
    private javax.swing.JButton btnLeft;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnOpen;
    private javax.swing.JButton btnRight;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblThongTin;
    private javax.swing.JLabel txtIndex;
    private javax.swing.JLabel txtRecordSum;
    private javax.swing.JTextField txtSalary;
    private javax.swing.JLabel txtSilde;
    private javax.swing.JTextField txtStaffEmail;
    private javax.swing.JTextField txtStaffId;
    private javax.swing.JTextField txtStaffName;
    public javax.swing.JLabel txtTime;
    private javax.swing.JTextField txtTuoi;
    // End of variables declaration//GEN-END:variables
}
