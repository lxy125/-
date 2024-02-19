package ui;

import javax.swing.*;

public class gameJframe extends JFrame {

    public gameJframe() {
        //初始化界面
        initJFrame();


        //初始化菜单
        initJMenubar();


        this.setVisible(true);
    }

    private void initJMenubar() {
        JMenuBar jMenuBar = new JMenuBar();

        JMenu functionJMenu = new JMenu("功能");
        JMenu aboutJMenu = new JMenu("关于我们");

        JMenuItem replayItem = new JMenu("重新开始");
        JMenuItem reLoginItem = new JMenuItem("重新登录");
        JMenuItem closeItem = new JMenuItem("退出游戏");


        JMenuItem accoutItem = new JMenuItem("公众号信息");


        functionJMenu.add(replayItem);
        functionJMenu.add(reLoginItem);
        functionJMenu.add(closeItem);

        aboutJMenu.add(accoutItem);

        jMenuBar.add(functionJMenu);
        jMenuBar.add(aboutJMenu);

        this.setJMenuBar(jMenuBar);
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
    }

}
