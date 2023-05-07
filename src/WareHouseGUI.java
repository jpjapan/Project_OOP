import javax.swing.*;
import java.awt.*;
public class WareHouseGUI {
    //Declare an attribute
    private JFrame fr;
    private JPanel p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17;
    private JButton bn1, bn2, bn3, bn4;
    private JTextField txtName, txtAmount, txtPrice, txtCode, txtDateOfTime;
    private JLabel la1, la2, la3, la4, title1, la_DateOfTime;
    private static JTable table;
    private JScrollPane scrollPane;
    private ProductTableModel tablemodel; 
    
    public WareHouseGUI(){
        fr = new JFrame();
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set size of JFrame
        fr.setBounds(580, 250, 750, 500);
        //Set Layout for JPanel
        p1 = new JPanel();
        p1.setLayout(new BorderLayout());
        p2 = new JPanel();
        p2.setLayout(new GridLayout(9, 1));
        p3 = new JPanel();
        p3.setLayout(new FlowLayout());
        p4 = new JPanel();
        p4.setLayout(new FlowLayout());
        p5 = new JPanel();
        p5.setLayout(new FlowLayout());
        p6 = new JPanel();
        p6.setLayout(new FlowLayout());
        p7 = new JPanel();
        p7.setLayout(new FlowLayout());
        p8 = new JPanel();
        p8.setLayout(new FlowLayout());
        p9 = new JPanel();
        p9.setLayout(new GridLayout(1, 4));
        p10 = new JPanel();
        p10.setLayout(new FlowLayout());
        p11 = new JPanel();
        p11.setLayout(new FlowLayout());
        p12 = new JPanel();
        p12.setLayout(new FlowLayout());
        p13 = new JPanel();
        p13.setLayout(new FlowLayout());
        p14 = new JPanel();
        p14.setLayout(new FlowLayout());
        p15 = new JPanel();
        p15.setLayout(new FlowLayout());
        p16 = new JPanel();
        p16.setLayout(new FlowLayout());
        p17 = new JPanel();
        p17.setLayout(new FlowLayout());
        
        //set textfield on JPanel
        txtName = new JTextField(15); //Name
        txtName.setFont(new Font("Angsana New", Font.BOLD, 18));
        
        txtAmount = new JTextField(13); //Amount
        txtAmount.setFont(new Font("Angsana New", Font.BOLD, 18));
        
        txtPrice = new JTextField(15); //Price
        txtPrice.setFont(new Font("Angsana New", Font.BOLD, 18));
        
        txtCode = new JTextField(15); //Code
        txtCode.setFont(new Font("Angsana New", Font.BOLD, 18));
        
        txtDateOfTime = new JTextField(7);
        txtDateOfTime.setFont(new Font("Angsana New", Font.BOLD, 18));
        txtDateOfTime.setEditable(false);
        
        //Set JLabel
        title1 = new JLabel("WareHouse");
        title1.setFont(new Font("Angsana New", Font.BOLD, 70));
        
        la_DateOfTime = new JLabel("Date");
        la_DateOfTime.setFont(new Font("Angsana New", Font.BOLD, 25));
        
        la1 = new JLabel("Name");
        la1.setFont(new Font("Angsana New", Font.BOLD, 25));
        
        la2 = new JLabel("Amount");
        la2.setFont(new Font("Angsana New", Font.BOLD, 25));
        
        la3 = new JLabel("Price");
        la3.setFont(new Font("Angsana New", Font.BOLD, 25));
        
        la4 = new JLabel("Code");
        la4.setFont(new Font("Angsana New", Font.BOLD, 25));
        
        //Set JButton on JFrame
        bn1 = new JButton("RECORD");
        bn1.setFont(new Font("Arial", Font.PLAIN, 15));
        bn1.setPreferredSize(new Dimension(150, 30));
        
        bn2 = new JButton("DELETE");
        bn2.setFont(new Font("Arial", Font.PLAIN, 15));
        bn2.setPreferredSize(new Dimension(150, 30));
        
        bn3 = new JButton("UPDATE");
        bn3.setFont(new Font("Arial", Font.PLAIN, 15));
        bn3.setPreferredSize(new Dimension(150, 30));
        
        bn4 = new JButton("RESET");
        bn4.setFont(new Font("Arial", Font.PLAIN, 15));
        bn4.setPreferredSize(new Dimension(150, 30));
        
        fr.add(p1);
        p7.add(title1);
        p3.add(la1);
        p3.add(txtName);
        p4.add(la2);
        p4.add(txtAmount);
        p5.add(la3);
        p5.add(txtPrice);
        p6.add(la4);
        p6.add(txtCode);
        p2.add(p6);
        p2.add(p3);
        p2.add(p5);
        p2.add(p4);
        p17.add(la_DateOfTime);
        p17.add(txtDateOfTime);
        p9.add(p14);
        p9.add(p15);
        p9.add(p16);
        p10.add(bn1);
        p11.add(bn2);
        p12.add(bn3);
        p13.add(bn4);
        p2.add(p10);
        p2.add(p8);
        p2.add(p11);
        p2.add(p12);
        p2.add(p13);
        p9.add(p17);
        
        //Add components on the JFrame
        p1.add(p2, BorderLayout.WEST);
        p1.add(p7, BorderLayout.NORTH);
        p1.add(p9, BorderLayout.SOUTH);
        
        //Set scrollPane for JTable
        scrollPane = new JScrollPane();
        scrollPane.setBounds(245, 80, 390, 300);
        p1.add(scrollPane, BorderLayout.CENTER);
        table = new JTable();
        
        //Set Model for Jtable(ProductTableModel)
        tablemodel = new ProductTableModel();
        table.setModel(tablemodel);
        scrollPane.setViewportView(table);
        fr.setVisible(true);
    }

    public JButton getBn1() {
        return bn1;
    }

    public JButton getBn2() {
        return bn2;
    }

    public JButton getBn3() {
        return bn3;
    }

    public JButton getBn4() {
        return bn4;
    }

    public JTextField gettxtDateOfTime() {
        return txtDateOfTime;
    }

    public void settxtDateOfTime(JTextField txtDateOfTime) {
        this.txtDateOfTime = txtDateOfTime;
    }

    public JTextField gettxtName() {
        return txtName;
    }

    public void settxtName(JTextField txtName) {
        this.txtName = txtName;
    }

    public JTextField gettxtAmount() {
        return txtAmount;
    }

    public void settxtAmount(JTextField txtAmount) {
        this.txtAmount = txtAmount;
    }

    public JTextField gettxtPrice() {
        return txtPrice;
    }

    public void settxtPrice(JTextField txtPrice) {
        this.txtPrice = txtPrice;
    }

    public JTextField gettxtCode() {
        return txtCode;
    }

    public void settxtCode(JTextField txtCode) {
        this.txtCode = txtCode;
    }

    public static JTable getTable() {
        return table;
    }

    public static void setTable(JTable table) {
        WareHouseGUI.table = table;
    }

    public ProductTableModel getTablemodel() {
        return tablemodel;
    }
    public static void main(String[] args) {
        new WareHouseGUI();
    }

    public JFrame getFr() {
        return fr;
    }
    
    
}
