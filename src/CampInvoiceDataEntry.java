
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class CampInvoiceDataEntry extends JFrame
{

    JPanel mainPnl;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    int quantity;

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    double unitPrice;

    public double getItemTotal() {
        return itemTotal;
    }

    public void setItemTotal(double itemTotal) {
        this.itemTotal = itemTotal;
    }

    double itemTotal;

    public double getFinalTotal() {
        return finalTotal;
    }

    public void setFinalTotal(double finalTotal) {
        this.finalTotal = finalTotal;
    }
    private String productName;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public JPanel getMainPnl() {
        return mainPnl;
    }

    public void setMainPnl(JPanel mainPnl) {
        this.mainPnl = mainPnl;
    }

    double finalTotal;
    String divider;
    JPanel titlePnl;
    JPanel bodyPnl;

    JPanel footerPnl;


    public CampInvoiceDataEntry()
    {

        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());
        setTitle("Invoice");

        createTitlePnl();
        mainPnl.add(titlePnl,BorderLayout.NORTH);
        createBodyPnl();
        mainPnl.add(bodyPnl,BorderLayout.CENTER);
        createFooterPnl();
        mainPnl.add(footerPnl,BorderLayout.SOUTH);
        add(mainPnl);

        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void createTitlePnl()
    {

        titlePnl = new JPanel();

        String titleS = new String("Invoice");
        JLabel titleLbl = new JLabel(titleS);
        titleLbl.setFont(new Font("Roboto" , Font.BOLD, 48));
        setLayout(new BorderLayout());
        titleLbl.setBorder(new CompoundBorder(new EmptyBorder(4, 4, 4, 4), new MatteBorder(0, 0, 1, 0, Color.BLACK)));


        titlePnl.add(titleLbl);

    }

    private void createBodyPnl() {

        bodyPnl = new JPanel();
        divider = new String("===========================================================================================================================================\n");

        String header = new String("              Item                                                                                                                                                                                                    Qty                               Price                          Total   \n");
        String listItem;

        TextArea bodyTA = new TextArea();

        bodyTA.setPreferredSize(new Dimension(1000, 750));
        bodyTA.append(divider);
        bodyTA.append(header);
        int option;
        do {


            setProductName(JOptionPane.showInputDialog("Enter product name"));
            setQuantity(Integer.parseInt(JOptionPane.showInputDialog("Enter product quantity", 1)));
            setUnitPrice(Double.parseDouble(JOptionPane.showInputDialog("Enter product price", 1)));
            setItemTotal(quantity * unitPrice);
            setFinalTotal(getFinalTotal()+getItemTotal());
            listItem = new String("              " + productName + "                                                                                                                                                                                                    " + quantity + "                                " + unitPrice + "                          " + itemTotal + "   \n");
            bodyTA.append(listItem);
            option = JOptionPane.showConfirmDialog(null, "Do you want to enter another item?");

        } while (option == JOptionPane.YES_OPTION);

        bodyTA.append(divider);
        bodyTA.setEditable(false);
        bodyPnl.add(bodyTA);

    }

    private void createFooterPnl()
    {

        footerPnl = new JPanel();

        String total = new String("Amount Due: " + getFinalTotal());
        JLabel footerLbl = new JLabel(total);
        footerLbl.setFont(new Font("Roboto" , Font.BOLD, 48));
        setLayout(new BorderLayout());
        footerLbl.setBorder(new CompoundBorder(new EmptyBorder(4, 4, 4, 4), new MatteBorder(0, 0, 1, 0, Color.BLACK)));


        footerPnl.add(footerLbl);

    }





}


