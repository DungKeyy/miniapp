/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Product;
import Controller.ProductModify;
import Controller.chitietnhaphangDAO;
import model.chitietnhaphang;
import model.nhanvien;
import model.nhaphang;
import Controller.nhaphangDAO;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import model.chi_tiet_hd;

/**
 *
 * @author trant
 */
public class test extends javax.swing.JFrame {
     String id_hang; 
     int ma;
    chitietnhaphangDAO da= new chitietnhaphangDAO();
    
    nhaphangDAO a= new nhaphangDAO();
    ProductModify p= new ProductModify();

    private List<nhaphang> nhap_hang;
    private List<Product> sanpham;
    //private List<chi_tiet_hd> sanphamct;
   ArrayList<chitietnhaphang> nhaphangct=new ArrayList<>();
    private DefaultTableModel modelnhap;
     
    private DefaultTableModel modelctnh;
    private DefaultTableModel ModelSPCT;
    int selectedIndex;
    /**
     * Creates new form test
     */
    public test() {
        initComponents();
        modelctnh=(DefaultTableModel) tablectnh.getModel();
        modelnhap= (DefaultTableModel) tablenhaphang.getModel();
        showTablenh();
        showTableSPCT();
        filldata();
        //ModelSPCT=(DefaultTableModel) table_chi_tiet_hd.getModel();
      
    }
    
    private void showTablenh(){
        
        nhap_hang=new nhaphangDAO().getListNH();
        modelnhap.setRowCount(0);
        for(nhaphang nh:nhap_hang){
            modelnhap.addRow(new Object[]{
                nh.getManhap(), nh.getMancc(), nh.getManv(), nh.getNgaynhap(), nh.getThanhtien()
            });
        }
         
    }
    
   public void showTableSPCT(){
       System.out.println(".....");
        modelctnh.setRowCount(0);
        //ArrayList<chi_tiet_hd> sanphamct=new ArrayList<>();
        for(chitietnhaphang s:nhaphangct)
        {
             
            Object[] row=new Object[]
            {  
                tablectnh.getRowCount()+1 ,s.getTenhang(),s.getGianhap(),s.getSoluong(),s.getTongtien()
            };
                modelctnh.addRow(row);
                  
            }
          
    }
      public void showTableSPCT_themmoi(){
        nhaphangct.clear();
        showTablenh();
    }
      public void filldata(){
         DefaultTableModel model2=(DefaultTableModel)TableNhapngay.getModel();
          model2.setRowCount(0);
        for(Product pr: p.getProducts()){
            try {
                model2.addRow(new Object[]{
                pr.getMa_sp(),pr.getTen_sp(),pr.getGia_ban(),pr.getSo_luong()
                     });
            } catch (Exception e) {
                System.out.println(e);
            }
             
        }
    }
      
     /*
    public ArrayList getlinhtinh(){
        ArrayList<String> a = new ArrayList<>();

        // Add elements
        int k= Integer.parseInt(Jgianhap.getText())*Integer.parseInt(Jsoluong.getText());
        a.add(Jmancc.getText());
        a.add(Jtenhang.getText());
        a.add(Jsoluong.getText());
        a.add(Jgianhap.getText());
        a.add(k);
        a.add("Horse");
     //   System.out.println("ArrayList: " + animals);
        return a;
    }
       */
   
     
      public void setModel(Product pr){
    //Jtenhang.setText(String.valueOf(pr.getMa_sp()));
    Jtenhang.setText(pr.getTen_sp());
   int gianhapne=  pr.getMa_sp();
          System.out.println("gia nhap ne: "+gianhapne);
    Jgianhap.setText("");
    ma= pr.getMa_sp();
          System.out.println(a.getgianhap(gianhapne));
    Jmancc.setText("");
    Jsoluong.setText(String.valueOf(pr.getSo_luong()));
    }
      
     public Product getModel_add(){
        Product pr=new Product();
        pr.setTen_sp(Jtenhang.getText());
       pr.setGia_ban(Integer.parseInt(Jgianhap.getText())+11);
        return pr;
    }
    public String getdate(){
     DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss");
    ZonedDateTime now = ZonedDateTime.now();
    String date= dtf.format(now);
    return date;
 }
    public void luu_hang(){
    for(int i=0;i<nhaphangct.size();i++)
    {
        Product pr= new Product(nhaphangct.get(i).getTenhang(),(nhaphangct.get(i).getGianhap()+2), nhaphangct.get(i).getSoluong());
        p.add(pr);
    }
}
      
    public void luu_db_chi_tiet_nh(int k){
    for(int i=0;i<nhaphangct.size();i++)
    {
        int masp= p.getmasp(nhaphangct.get(i).getTenhang());
        int sl= nhaphangct.get(i).getSoluong();
        int gianhap= nhaphangct.get(i).getGianhap();
        int tong=nhaphangct.get(i).getGianhap();
        chitietnhaphang sp=new chitietnhaphang(gianhap, sl, tong, masp);
       da.addnh(sp,k);
        System.out.println(sp);
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

        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Jtenhang = new javax.swing.JTextField();
        Jsoluong = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Jgianhap = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Jmancc = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jtongnhap = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablectnh = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        TableNhapngay = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablenhaphang = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CHI TIẾT NHẬP HÀNG");

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton3.setText("Thêm");
        jButton3.setToolTipText("Thêm vào giỏ");
        jButton3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.blue));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Tên Sản Phẩm");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Số lượng");
        jLabel2.setToolTipText("");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 102));
        jLabel3.setText("CHI TIẾT NHẬP HÀNG");

        Jtenhang.setToolTipText("Nhập Tên sản phẩm");

        Jsoluong.setToolTipText("Nhập số lượng");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Giá nhập");

        Jgianhap.setToolTipText("Nhập giá");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Tổng tiền");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Mã Nhà cung cấp");

        Jmancc.setToolTipText("Nhập mã nhà cung cấp");
        Jmancc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmanccActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton2.setText("Thanh toán");
        jButton2.setToolTipText("Thanh toán");
        jButton2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.blue));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Chi tiết nhập hàng");
        jLabel6.setToolTipText("");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Phiếu Nhập hàng");
        jLabel7.setToolTipText("");

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/home.png"))); // NOI18N
        jButton4.setText("Home");
        jButton4.setToolTipText("Quay về Trang chủ");
        jButton4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        tablectnh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "Tên hàng", "Giá nhập", "Số lượng", "Tổng tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablectnh);
        if (tablectnh.getColumnModel().getColumnCount() > 0) {
            tablectnh.getColumnModel().getColumn(0).setMinWidth(50);
            tablectnh.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        jScrollPane3.setViewportView(jScrollPane1);

        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        TableNhapngay.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã Hàng", "Tên Hàng", "Gía Bán", "Số Lượng"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TableNhapngay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableNhapngayMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(TableNhapngay);

        jLabel9.setText("Sản phẩm sắp hết");

        tablenhaphang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã Nhập", "Mã Nhà cung cấp", "Mã Nhân viên", "Ngày nhập", "Thành tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tablenhaphang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablenhaphangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablenhaphang);
        if (tablenhaphang.getColumnModel().getColumnCount() > 0) {
            tablenhaphang.getColumnModel().getColumn(0).setMinWidth(70);
            tablenhaphang.getColumnModel().getColumn(0).setMaxWidth(70);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addGap(197, 197, 197))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(31, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jtongnhap)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(106, 106, 106)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(35, 35, 35)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(162, 162, 162)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(Jtenhang)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(Jgianhap, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(Jsoluong, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(0, 139, Short.MAX_VALUE)))
                                    .addComponent(Jmancc, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)))
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(151, 151, 151)
                                .addComponent(jtongnhap))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Jmancc, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Jtenhang, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Jsoluong, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Jgianhap, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(35, 35, 35)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel9)
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        int soluong=0;
        int gia=0;  
        
        soluong=Integer.parseInt(Jsoluong.getText());
        gia=Integer.parseInt(Jgianhap.getText());
        int tong=soluong*gia;
        
        chitietnhaphang sp=new chitietnhaphang(gia,soluong,tong,Jtenhang.getText());
       nhaphangct.add(sp);
        //dao.addSP(sp);
       // dao.Dungtest(GIA);
       
       int tonggia=0;
        showTableSPCT();
         for(int i=0;i<tablectnh.getRowCount();i++)
       { 
            tonggia+=Integer.parseInt(tablectnh.getValueAt(i, 4).toString());
        }
       jtongnhap.setText(tonggia+"");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void JmanccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmanccActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JmanccActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Login l= new Login();
        
  //thanh toán 
 
        String DateBuy=getdate();
        
        int tong=0;
        for(int i=0;i<tablectnh.getRowCount();i++)
        {
            tong+=Integer.parseInt(tablectnh.getValueAt(i, 4).toString());
        }
         System.out.println("hhihi");
        nhaphang nh= new nhaphang(Integer.parseInt(Jmancc.getText()),l.returnma(), DateBuy, Integer.parseInt(jtongnhap.getText()));
       System.out.println(nh);
        if(a.add(nh)>0){
            if(p.getmasp1(ma)>0){
                
                 p.upsl(ma, Integer.parseInt(Jsoluong.getText())+ p.getsl(ma));
                 filldata();
                 ma=0;
            }
            else{
                 luu_hang();
            }
 
            luu_db_chi_tiet_nh(a.getmanh(DateBuy));
         //   showTablenh();
         showTablenh();
         filldata();
             JOptionPane.showMessageDialog(this, "Them hoa don thanh cong-----!");
        }
 
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tablenhaphangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablenhaphangMouseClicked
        // TODO add your handling code here:
         int numRow=tablenhaphang.getSelectedRow();
       int ma_nh=Integer.parseInt(tablenhaphang.getValueAt(numRow, 0).toString());   
        System.out.println(ma_nh);
        nhaphangct=new chitietnhaphangDAO().getchi_tiet_nhByMa_nh(ma_nh);
        ModelSPCT.setRowCount(0);
        nhaphangct.forEach((chi_tiet_hd)->{
            ModelSPCT.addRow(new Object[]{tablectnh.getRowCount()+1,chi_tiet_hd.getMa_hang(),chi_tiet_hd.getSoluong(),chi_tiet_hd.getGianhap(),chi_tiet_hd.getTongtien()});
        });
        
        showTableSPCT();
    }//GEN-LAST:event_tablenhaphangMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        dispose();
       Sanpham ah = new  Sanpham();
       ah.show();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void TableNhapngayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableNhapngayMouseClicked
        // TODO add your handling code here:
         int ma_hang=TableNhapngay.rowAtPoint(evt.getPoint());
       id_hang=TableNhapngay.getValueAt(ma_hang, 0).toString();
       Product r=p.getProductById(Integer.parseInt(id_hang));
        setModel(r);
    }//GEN-LAST:event_TableNhapngayMouseClicked

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
            java.util.logging.Logger.getLogger(test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new test().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Jgianhap;
    private javax.swing.JTextField Jmancc;
    private javax.swing.JTextField Jsoluong;
    private javax.swing.JTextField Jtenhang;
    private javax.swing.JTable TableNhapngay;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel jtongnhap;
    private javax.swing.JTable tablectnh;
    private javax.swing.JTable tablenhaphang;
    // End of variables declaration//GEN-END:variables
}
