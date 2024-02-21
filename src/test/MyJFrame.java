package test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyJFrame extends JFrame implements ActionListener{

    JButton jtb1 = new JButton("按钮1");
    JButton jtb2 = new JButton("按钮2");

    public MyJFrame(){
        //设置界面的宽高
        this.setSize(603,680);
        //设置界面的标题
        this.setTitle("拼图游戏");
        //设置界面的位置
        this.setLocationRelativeTo(null);
        //设置界面置顶
        this.setAlwaysOnTop(true);
        //设置界面的关闭方式
        this.setDefaultCloseOperation(3);
        //取消默认的居中放置
        this.setLayout(null);

        jtb1.setBounds(0,0,100,50);
        jtb1.addActionListener(this);

        jtb2.setBounds(100,0,100,50);
        jtb2.addActionListener(this);

        this.getContentPane().add(jtb1);
        this.getContentPane().add(jtb2);

        this.setVisible(true);




    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == jtb1){
            System.out.println("按钮1被点击");
        }

        if(e.getSource() == jtb2){
            System.out.println("按钮2被点击");
        }
    }
}
