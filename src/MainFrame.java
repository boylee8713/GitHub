import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    public MainFrame() {
        initComp();
    }
    private Container cp;
    private JButton jbtnA = new JButton("範例");
    private JButton jbtnB = new JButton("加密");
    private JButton jbtnC = new JButton("清除");
    private JButton jbtnD = new JButton("解密");
    private JButton jbtnE = new JButton("離開");
    private JLabel Jla = new JLabel("KEY");
    private JTextField Jtf = new JTextField("1");
    private JPanel Jpa = new JPanel(new GridLayout(7,1,3,3));
    private JTextArea JtaL = new JTextArea();
    private JTextArea JtaR = new JTextArea();
    private JScrollPane JspL = new JScrollPane(JtaL);
    private JScrollPane JspR = new JScrollPane(JtaR);
    private void initComp(){
        this.setBounds(450,200,500,300);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Jla.setHorizontalAlignment(JLabel.CENTER);
        Jtf.setHorizontalAlignment(JLabel.CENTER);
        JspL.setPreferredSize(new Dimension(200,300));
        JspR.setPreferredSize(new Dimension(200,300));
        JtaL.setLineWrap(true);
        JtaR.setLineWrap(true);
        cp = this.getContentPane();
        cp.setLayout(new BorderLayout(3,3));
        Jpa.add(jbtnA);
        Jpa.add(jbtnB);
        Jpa.add(jbtnD);
        Jpa.add(Jla);
        Jpa.add(Jtf);
        Jpa.add(jbtnC);
        Jpa.add(jbtnE);
        cp.add(JspL,BorderLayout.WEST);
        cp.add(JspR,BorderLayout.EAST);
        cp.add(Jpa,BorderLayout.CENTER);

        jbtnA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JtaL.setText("ABC123321OAO");
            }
        });



        jbtnB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char data[] = JtaL.getText().toCharArray();
                int len = data.length , key = Integer.parseInt(Jtf.getText());
                for(int x = 0 ; x < len ; x ++){data[x] +=key;}
                JtaR.setText(new String(data));

            }
        });

        jbtnD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char data[] = JtaL.getText().toCharArray();
                int len = data.length , key = Integer.parseInt(Jtf.getText());
                for(int x = 0 ; x < len ; x ++){data[x] -=key;}
                JtaR.setText(new String(data));

            }
        });

        jbtnC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JtaL.setText("");
                JtaR.setText("");

            }
        });

        jbtnE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });












    }






}