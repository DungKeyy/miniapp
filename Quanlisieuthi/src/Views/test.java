/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controller.NCCModify;
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
import model.loai_hang;
import model.quan_ly_ncc;

/**
 *
 * @author trant
 */
public class test extends javax.swing.JFrame {
     String id_hang; 
     int ma;
    chitietnhaphangDAO da= new chitietnhaphangDAO();
     NCCModify mo= new NCCModify();
    nhaphangDAO a= new nhaphangDAO();
    ProductModify p= new ProductModify();

    private List<nhaphang> nhap_hang;
    private List<Product> sanpham;
    
    //private List<chi_tiet_hd> sanphamct;
   ArrayList<chitietnhaphang> nhaphangct=new ArrayList<>();
    private DefaultTableModel modelnhap;
      private DefaultTableModel modelnhapngay;
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
        modelnhapngay=(DefaultTableModel) tablespsh.getModel();
        showTablenh();
        showTableSPCT();
         tenncc();
         nhapngay();
        //ModelSPCT=(DefaultTableModel) table_chi_tiet_hd.getModel();
      loaisp();
    }
     private void tenncc(){
       for(quan_ly_ncc nc:mo.getAllProducter()){
           jComboBox2.addItem(nc.getTen_ncc());
       }
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
     public void loaisp(){
        ProductModify dai= new ProductModify();
         for (loai_hang pr : dai.getloaihang()){
             System.out.println("1---"+pr.getLoaihang());
             
             jComboBox1.addItem(pr.getLoaihang());
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
                tablectnh.getRowCount()+1 ,s.getTenhang(),p.gettenloai(s.getLoai()),s.getGianhap(),s.getSoluong(),s.getTongtien()
            };
                modelctnh.addRow(row);
                  
            }
          
    }
    public void nhapngay(){
       sanpham=new ProductModify().getProducts();
        
        modelnhapngay.setRowCount(0);
        
        for(Product nh:sanpham){
            System.out.println("---"+nh);
            modelnhapngay.addRow(new Object[]{
                tablespsh.getRowCount()+1, nh.getTen_sp(),p.gettenloai(nh.getMaloai()),nh.getSo_luong(),da.getgianhap(nh.getMa_sp()),mo.gettenncc(da.getmancc(da.getmanhap(nh.getMa_sp())))
                
            });
        }
        
   }
      public void showTableSPCT_themmoi(){
        nhaphangct.clear();
        showTablenh();
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
       
        int k= (int) (nhaphangct.get(i).getGianhap()*0.2);
        Product pr= new Product(nhaphangct.get(i).getTenhang(),nhaphangct.get(i).getGianhap()+k, nhaphangct.get(i).getSoluong(),nhaphangct.get(i).getLoai());
        p.add(pr);
    }
}
      
    public void luu_db_chi_tiet_nh(int k){
    for(int i=0;i<nhaphangct.size();i++)
    {
        int masp= p.getmasp(nhaphangct.get(i).getTenhang());// ???
      //  String ten= nhaphangct.get(i).getTenhang();
        int sl= nhaphangct.get(i).getSoluong();
        int gianhap= nhaphangct.get(i).getGianhap();
        int tong=nhaphangct.get(i).getGianhap();
      //  chitietnhaphang sp= new chitietnhaphang(k,masp,gianhap, sl, tong);
        chitietnhaphang sp= new chitietnhaphang(k, masp, gianhap, sl, tong);
       // chitietnhaphang sp=new chitietnhaphang(gianhap, sl, tong, masp); int ma_nhap, int ma_hang, int gianhap, int soluong, int tongtien
       da.addnh(sp);
       
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
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jtongnhap = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablenhaphang = new javax.swing.JTable();
        jtongnhaps = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablectnh = new javax.swing.JTable();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablespsh = new javax.swing.JTable();

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

        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

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

        tablectnh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Tên hàng", "loai hang", "Giá nhập", "Số lượng", "Tổng tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
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

        jLabel9.setText("loai");

        jButton1.setText("them loai");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tablespsh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Tên SP", "Loại SP", "Số lượng", "Gía nhập", "NCC"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tablespsh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablespshMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tablespsh);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(106, 106, 106)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel6))
                                .addGap(35, 35, 35)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
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
                                    .addComponent(jLabel9))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(56, 56, 56)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jtongnhaps)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(Jtenhang)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(Jgianhap, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(Jsoluong, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGap(0, 139, Short.MAX_VALUE)))
                                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(46, 46, 46)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(55, 55, 55)
                                        .addComponent(jButton1))))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(95, 95, 95))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(151, 151, 151)
                                .addComponent(jtongnhap))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtongnhaps))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(600, 600, 600)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        int soluong=0;
        int gia=0;  
        
        soluong=Integer.parseInt(Jsoluong.getText());
        gia=Integer.parseInt(Jgianhap.getText());
        int tong=soluong*gia;
        int loai=0;
         loai=p.getmaloai((String) jComboBox1.getSelectedItem());//
        chitietnhaphang sp=new chitietnhaphang(gia,soluong,tong,Jtenhang.getText(),loai);
       nhaphangct.add(sp);
        //dao.addSP(sp);
       // dao.Dungtest(GIA);
       
       int tonggia=0;
        showTableSPCT();
         for(int i=0;i<tablectnh.getRowCount();i++)
       { 
            tonggia+=Integer.parseInt(tablectnh.getValueAt(i, 5).toString());
        }
       jtongnhaps.setText(tonggia+"");
    }//GEN-LAST:event_jButton3ActionPerformed

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
         
        int manccne=mo.getmancc((String) jComboBox2.getSelectedItem());
        System.out.println(mo.getmancc((String) jComboBox2.getSelectedItem()));
        nhaphang nh = new nhaphang(manccne, l.returnma(), DateBuy, Integer.parseInt(jtongnhaps.getText()));
           if(a.add(nh)>0){
               //truong hop nhap them
               int mane= p.getmasp(Jtenhang.getText());
            if(p.getmasp1(mane)>0){

                 p.upsl(mane, Integer.parseInt(Jsoluong.getText())+ p.getsl(mane));
                 
            }
            //truong hop nhap moi
            else{
                 luu_hang();
            }
 
            luu_db_chi_tiet_nh(a.getmanh(DateBuy));
         //   showTablenh();
         showTablenh();
          nhapngay();
             JOptionPane.showMessageDialog(this, "Them hoa don thanh cong-----!");
        }
 
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tablenhaphangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablenhaphangMouseClicked
        // TODO add your handling code here:
         int numRow=tablenhaphang.getSelectedRow();
       int ma_nh=Integer.parseInt(tablenhaphang.getValueAt(numRow, 0).toString());   
        System.out.println(ma_nh);
      
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
        loaisp loai= new loaisp();
        loai.show();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tablespshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablespshMouseClicked
        // TODO add your handling code here:
         selectedIndex=tablespsh.getSelectedRow();
        System.out.println(selectedIndex);
        Product sp=sanpham.get(selectedIndex);
       // System.out.println(sp);
        
            Jtenhang.setText(String.valueOf(sp.getTen_sp()));
            Jsoluong.setText(sp.getSo_luong()+"");
            Jgianhap.setText(da.getgianhap(sp.getMa_sp())+"");
            int mane= p.getmasp(String.valueOf(sp.getTen_sp()));
            System.out.println("---------------"+mo.gettenncc(da.getmancc(da.getmanhap(mane))));
             jComboBox2.setSelectedItem(mo.gettenncc(da.getmancc(da.getmanhap(sp.getMa_sp()))));
             jComboBox1.setSelectedItem(p.gettenloai(sp.getMaloai()));
              // ,p.gettenloai(nh.getMaloai()),nh.getSo_luong(),da.getgianhap(nh.getMa_sp()),mo.gettenncc(da.getmancc(da.getmanhap(nh.getMa_sp())))
                

    }//GEN-LAST:event_tablespshMouseClicked

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
    private javax.swing.JTextField Jsoluong;
    private javax.swing.JTextField Jtenhang;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
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
    private javax.swing.JLabel jtongnhap;
    private javax.swing.JLabel jtongnhaps;
    private javax.swing.JTable tablectnh;
    private javax.swing.JTable tablenhaphang;
    private javax.swing.JTable tablespsh;
    // End of variables declaration//GEN-END:variables
}
