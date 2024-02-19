package ui;

import javax.swing.*;

public class gameJframe extends JFrame {

    public gameJframe() {
        //初始化界面
        initJFrame();


        //初始化菜单
        initJMenubar();


        //初始化图片
        initImage();


        this.setVisible(true);
    }

    private void initImage() {
        int number = 1;

        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                //创建一个图片ImageIcon的对象
                ImageIcon icon = new ImageIcon("C:\\Users\\12586\\Desktop\\puzzleGame\\image\\animal\\animal1\\"+number+".jpg");
                //创建一个JLabel的对象（管理容器）
                JLabel jLabel1 = new JLabel(icon);
                //指定图片位置
                jLabel1.setBounds(105*j,105*i,105,105);

                //把管理容器添加到界面中
                // this.add(jLabel1);
                this.getContentPane().add(jLabel1);
                //每次循环，图片编号+1
                number++;
            }
        }



    }

    private void initJMenubar() {
//创建菜单栏
        JMenuBar jMenuBar = new JMenuBar();

//创建功能菜单
        JMenu functionJMenu = new JMenu("功能");
//创建关于我们菜单
        JMenu aboutJMenu = new JMenu("关于我们");

//创建重新开始菜单项
        JMenuItem replayItem = new JMenuItem("重新开始");
//创建重新登录菜单项
        JMenuItem reLoginItem = new JMenuItem("重新登录");
//创建退出游戏菜单项
        JMenuItem closeItem = new JMenuItem("退出游戏");


//创建公众号信息菜单项
        JMenuItem accoutItem = new JMenuItem("公众号信息");


// 添加功能菜单项
        functionJMenu.add(replayItem);
        functionJMenu.add(reLoginItem);
        functionJMenu.add(closeItem);

// 添加关于菜单项
        aboutJMenu.add(accoutItem);

// 添加菜单项到菜单栏
        jMenuBar.add(functionJMenu);
        jMenuBar.add(aboutJMenu);

        this.setJMenuBar(jMenuBar);//设置菜单栏
    }

    private void initJFrame() {
        this.setSize(603, 680);

        this.setTitle("拼图单机版1.0");

        //设置窗口总是处于最前端
        this.setAlwaysOnTop(true);
        //设置窗口位置为相对位置
        this.setLocationRelativeTo(null);
        //设置窗口的关闭操作
        this.setDefaultCloseOperation(3);

        //取消默认的居中放置
        this.setLayout(null);
    }

}
