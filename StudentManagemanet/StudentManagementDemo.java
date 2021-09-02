
package StudentManagemanet;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class StudentManagementDemo extends JFrame implements ActionListener{
    private Container c;
    private JLabel lbl1,lbl2,lbl3,lbl4,lbl5;
    private JTextField tf1,tf2,tf3,tf4;
    private Font f,f1;
    private JButton btn1,btn2,btn3,btn4;
    private JTable tbl;
    private JScrollPane sc;
    
    private DefaultTableModel mdl;
    private String [] col = {"Name","ID","Phone","GPA"};
    private String [] row = new String [4];
    
    
    StudentManagementDemo()
    {
        initComponents();
    }
    
    public void initComponents()
    {
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.CYAN);
        
        f = new Font("Callibri",Font.BOLD,18);
        f1 = new Font("Callibri",Font.BOLD,22);
        
        lbl1 = new JLabel("Student Name :");
        lbl1.setFont(f);
        lbl1.setBounds(100,50,150,50);
        lbl1.setBackground(Color.CYAN);
        c.add(lbl1);
        
        tf1 = new JTextField();
        tf1.setFont(f);
        tf1.setBounds(260,50,250,50);
        c.add(tf1);
        
        btn1 = new JButton("Apply");
        btn1.setBounds(600,50,100,50);
        btn1.setFont(f);
        c.add(btn1);
        
        lbl2 = new JLabel("Student ID :");
        lbl2.setFont(f);
        lbl2.setBounds(100,110,150,50);
        lbl2.setBackground(Color.CYAN);
        c.add(lbl2);
        
        tf2 = new JTextField();
        tf2.setFont(f);
        tf2.setBounds(260,110,250,50);
        c.add(tf2);
        
        btn2 = new JButton("Update");
        btn2.setBounds(600,110,100,50);
        btn2.setFont(f);
        c.add(btn2);
        
        lbl3 = new JLabel("Student Phone :");
        lbl3.setFont(f);
        lbl3.setBounds(100,170,150,50);
        lbl3.setBackground(Color.CYAN);
        c.add(lbl3);
        
        tf3 = new JTextField();
        tf3.setFont(f);
        tf3.setBounds(260,170,250,50);
        c.add(tf3);
        
        btn3 = new JButton("Delete");
        btn3.setBounds(600,170,100,50);
        btn3.setFont(f);
        c.add(btn3);
        
        lbl4 = new JLabel("Student GPA :");
        lbl4.setFont(f);
        lbl4.setBounds(100,230,150,50);
        lbl4.setBackground(Color.CYAN);
        c.add(lbl4);
        
        tf4 = new JTextField();
        tf4.setFont(f);
        tf4.setBounds(260,230,250,50);
        c.add(tf4);
        
        btn4 = new JButton("Cancel");
        btn4.setBounds(600,230,100,50);
        btn4.setForeground(Color.RED);
        btn4.setFont(f);
        c.add(btn4);
        
        lbl5 = new JLabel("Student Data Registration Table");
        lbl5.setBounds(310,400,350,50);
        lbl5.setFont(f1);
        c.add(lbl5);
        
        tbl = new JTable();
        
        mdl = new DefaultTableModel();
        mdl.setColumnIdentifiers(col);
        tbl.setModel(mdl);
        tbl.setFont(f);
        tbl.setSelectionBackground(Color.RED);
        tbl.setBackground(Color.PINK);
        tbl.setRowHeight(30);
        
        sc = new JScrollPane(tbl);
        sc.setBounds(50,500,900,350);
        c.add(sc);
        
        btn1.addActionListener(this);
        btn4.addActionListener(this);
        btn3.addActionListener(this);
        btn2.addActionListener(this);
        
        tbl.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent me){
                int numrow = tbl.getSelectedRow();
                
                String name = mdl.getValueAt(numrow, 0).toString();
                String ID = mdl.getValueAt(numrow, 1).toString();
                String phone = mdl.getValueAt(numrow, 2).toString();
                String gpa = mdl.getValueAt(numrow, 3).toString();
                
                tf1.setText(name);
                tf2.setText(ID);
                tf3.setText(phone);
                tf4.setText(gpa);
                
            }
        
        
        });
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==btn1){
            
            row[0] = tf1.getText();
            row[1] = tf2.getText();
            row[2] = tf3.getText();
            row[3] = tf4.getText();
            mdl.addRow(row);
            
        }
        else if(e.getSource()==btn4){
            tf1.setText("");
            tf2.setText("");
            tf3.setText("");
            tf4.setText("");
        }
        else if(e.getSource()==btn3){
            int num = tbl.getSelectedRow();
            
            if(num>=0)
            {
                mdl.removeRow(num);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "No row has been selected or no row exist!!!");
            }
        }
        else if(e.getSource()==btn2)
        {
            int numrow = tbl.getSelectedRow();
            
            if(numrow>=0){
                String n= tf1.getText();
                String i= tf2.getText();
                String p= tf3.getText();
                String g= tf4.getText();

                mdl.setValueAt(n ,numrow, 0);
                mdl.setValueAt(i ,numrow, 1);
                mdl.setValueAt(p ,numrow, 2);
                mdl.setValueAt(g ,numrow, 3);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "No row has been selected or no row exist!!!");
            }
        }
        
    }
    
    
    
    
    public static void main(String[] args) {
        StudentManagementDemo sm = new StudentManagementDemo();
        sm.setVisible(true);
        sm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sm.setBounds(300,20,1000,1000);
        sm.setTitle("Student Management");
    }

    
    
}
