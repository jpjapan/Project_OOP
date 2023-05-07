
import java.awt.event.*;
import javax.swing.JOptionPane;
import java.io.*;
import java.util.ArrayList;

public class WareHouseHandler implements ActionListener, WindowListener, MouseListener {

    private ProductTableModel model;
    private WareHouseGUI view;
    private Product obj_p1;
    private File logs;

    public WareHouseHandler() {
        model = new ProductTableModel();
        view = new WareHouseGUI();
        logs = new File("Products.dat");
        try {
            logs.createNewFile();
        } catch (IOException ev) {
            ev.printStackTrace();
        }
        init();
    }

    public void init() {
        view.getBn1().addActionListener(this);
        view.getBn2().addActionListener(this);
        view.getBn3().addActionListener(this);
        view.getBn4().addActionListener(this);
        view.getFr().addWindowListener(this);
        view.getTable().addMouseListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(view.getBn1())) {
            if (view.gettxtAmount().getText().equals("") || view.gettxtPrice().getText().equals("") || view.gettxtName().getText().equals("") || view.gettxtCode().getText().equals("")) {
                JOptionPane.showMessageDialog(view.getFr(), "Please Enter All Data!");
            } else {
                try {
                    int price = Integer.parseInt(view.gettxtPrice().getText());
                    int amount = Integer.parseInt(view.gettxtAmount().getText());
                    obj_p1 = new Product(view.getTablemodel().getRowCount() + 1, view.gettxtCode().getText(), view.gettxtName().getText(), price, amount);
                    view.getTablemodel().products.add(obj_p1);
                    view.getTablemodel().fireTableDataChanged();
                    JOptionPane.showMessageDialog(view.getFr(), "Success !");
                } catch (NumberFormatException ev) {
                    JOptionPane.showMessageDialog(view.getFr(), "Price and Amount can input only number!");
                }
                try (FileOutputStream stream = new FileOutputStream(logs); ObjectOutputStream ops = new ObjectOutputStream(stream);) {
                    ops.writeObject(view.getTablemodel().products);
                } catch (IOException ex) {
                    System.out.println("Error");
                    ex.printStackTrace();
                }
                view.gettxtName().setText("");
                view.gettxtAmount().setText("");
                view.gettxtPrice().setText("");
                view.gettxtCode().setText("");
                view.getTablemodel().printArray();
                System.out.println("out of data");
            }
        }
        if (ae.getSource().equals(view.getBn2())) {
            if (view.getTable().getSelectedRowCount() == 1) {
                int num1 = view.getTable().getSelectedRow();
                view.getTablemodel().products.remove(num1);
                view.getTablemodel().fireTableDataChanged();
                for (int i = num1; i < view.getTablemodel().getRowCount(); i++) {
                    view.getTablemodel().products.get(i).setNo(view.getTablemodel().products.get(i).getNo() - 1);
                    System.out.println(i);
                }
                JOptionPane.showMessageDialog(view.getFr(), "Deleted.");
            } else {
                if (view.getTable().getRowCount() == 0) {
                    JOptionPane.showMessageDialog(view.getFr(), "Table is Empty.");
                } else {
                    JOptionPane.showMessageDialog(view.getFr(), "Please select Single Row For Delete.");
                }
            }
        }
        if (ae.getSource().equals(view.getBn3())) {
            if (view.gettxtAmount().getText().equals("") || view.gettxtPrice().getText().equals("") || view.gettxtName().getText().equals("") || view.gettxtCode().getText().equals("")) {
                JOptionPane.showMessageDialog(view.getFr(), "Please Enter All Data!");
            } else if (view.getTable().getSelectedRowCount() == 1) {
                try {
                    int Ino = view.getTable().getSelectedRow();
                    String Scode = view.gettxtCode().getText();
                    String Sname = view.gettxtName().getText();
                    String Sprice = view.gettxtPrice().getText();
                    String Samount = view.gettxtAmount().getText();
                    Product Pproduct = view.getTablemodel().products.get(Ino);
                    Pproduct.setCode(Scode);
                    Pproduct.setName(Sname);
                    Pproduct.setPrice(Integer.parseInt(Sprice));
                    Pproduct.setAmount(Integer.parseInt(Samount));
                    JOptionPane.showMessageDialog(view.getFr(), "Success !");
                    view.getTablemodel().fireTableDataChanged();
                } catch (NumberFormatException ev) {
                    JOptionPane.showMessageDialog(view.getFr(), "Price and Amount can input only number!");
                }
            } else if (view.getTable().getRowCount() == 0) {
                JOptionPane.showMessageDialog(view.getFr(), "Table is Empty.");
            } else {
                JOptionPane.showMessageDialog(view.getFr(), "Please select Single Row For Update.");
            }

            if (ae.getSource().equals(view.getBn4())) {
                if (view.getTable().getRowCount() == 0) {
                    JOptionPane.showMessageDialog(view.getFr(), "Table is Empty.");
                } else {
                    int response = JOptionPane.showConfirmDialog(view.getFr(), "Do you want to continue action ?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (response == JOptionPane.YES_OPTION) {
                        view.getTablemodel().products.clear();
                        view.getTablemodel().fireTableDataChanged();
                    }
                }
            }
        }
    }

    @Override
    public void windowClosing(WindowEvent e) {
        try (FileOutputStream stream = new FileOutputStream(logs); ObjectOutputStream ops = new ObjectOutputStream(stream);) {
            ops.writeObject(view.getTablemodel().products);
        } catch (IOException ex) {
            System.out.println("Error");
            ex.printStackTrace();
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        if (logs.exists()) {
            try (FileInputStream stream = new FileInputStream(logs); ObjectInputStream ips = new ObjectInputStream(stream);) {
                view.getTablemodel().products = (ArrayList<Product>) ips.readObject();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        view.getTablemodel().fireTableDataChanged();
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent m) {
        String tblCode = (String) view.getTablemodel().getValueAt(view.getTable().getSelectedRow(), 1);
        String tblName = (String) view.getTablemodel().getValueAt(view.getTable().getSelectedRow(), 2);
        String tblPrice = "" + view.getTablemodel().getValueAt(view.getTable().getSelectedRow(), 3);
        String tblAmount = "" + view.getTablemodel().getValueAt(view.getTable().getSelectedRow(), 4);
        view.gettxtCode().setText(tblCode);
        view.gettxtName().setText(tblName);
        view.gettxtPrice().setText(tblPrice);
        view.gettxtAmount().setText(tblAmount);
    }

    @Override
    public void mouseEntered(MouseEvent m) {

    }

    @Override
    public void mouseExited(MouseEvent m) {

    }

    @Override
    public void mousePressed(MouseEvent m) {

    }

    @Override
    public void mouseReleased(MouseEvent m) {

    }

    public static void main(String[] args) {
        new WareHouseHandler();
    }
}
