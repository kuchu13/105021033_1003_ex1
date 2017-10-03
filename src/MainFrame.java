import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {
    private Container cp;
    private JButton jbtn1 = new JButton("範例");
    private JButton jbtn2 = new JButton("加密");
    private JLabel jlb = new JLabel("Key");
    private JButton jbtn3 = new JButton("清除");
    private JButton jbtn4 = new JButton("Exit");

    private JPanel jpnc = new JPanel(new GridLayout(6,1,3,3));
    private JTextArea jtaL = new JTextArea();
    private JTextArea jtaR = new JTextArea();
    private JScrollPane jspL=new JScrollPane(jtaL);
    private JScrollPane jspR=new JScrollPane(jtaR);
    private JTextField jtfKey = new JTextField("3");

    public MainFrame() {
        initComp();
    }

    private void initComp() {
    this.setBounds(100,100,500,400);
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    cp=this.getContentPane();
//    cp.setLayout(new GridLayout(5,1,3,3));
    cp.setLayout(new BorderLayout(3,3));

    jpnc.add(jbtn1);
    jpnc.add(jbtn2);
    jpnc.add(jlb);
    jlb.setHorizontalAlignment(JLabel.CENTER);
    jpnc.add(jtfKey);
    jpnc.add(jbtn3);
    jpnc.add(jbtn4);

    cp.add(jpnc,BorderLayout.CENTER);
    cp.add(jspL,BorderLayout.WEST);
    cp.add(jspR,BorderLayout.EAST);

    jtaL.setPreferredSize(new Dimension( 200,400));
    jtaR.setPreferredSize(new Dimension( 200,400));
    jtaL.setLineWrap(true);
    jtaR.setLineWrap(true);

    jbtn1.addActionListener(new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
        jtaL.setText("Hello, I'm Ray! \n" +
                "Today I'm going to share my tips for public speaking! \n" +
                "It's been a while since we've done an English Corner video, \n" +
                "so in a moment we'll start with the English portion of the video. \n" +
                "Remember, if you want to watch this video with English subtitles, ");
        }
    });

        jbtn2.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
            char data[] =jtaL.getText().toCharArray();
            int len =data.length,Key =Integer.parseInt(jtfKey.getText());
            for(int i = 0;i<len; i++){
                data[i] += Key;
            }
            jtaR.setText(new String(data));
            }
        });

        jbtn3.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jtaL.setText(null);
                jtaR.setText(null);
            }
        });

        jbtn4.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
    }
}