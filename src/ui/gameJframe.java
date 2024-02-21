package ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class gameJframe extends JFrame implements KeyListener, ActionListener {
    int[][] data = new int[4][4];

    public gameJframe() {
        //初始化界面
        initJFrame();


        //初始化菜单
        initJMenubar();

        //初始化数据
        initDate();

        //初始化图片
        initImage();


        this.setVisible(true);
    }

    int x = 0;
    int y = 0;
    String path = "C:\\Users\\12586\\Desktop\\puzzleGame\\image\\animal\\animal3\\";
    //定义一个二维数组，用来存储正确的图片顺序
    int[][] win = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 0}
    };

    //步数
    int step = 0;

    //创建重新开始菜单项
    JMenuItem replayItem = new JMenuItem("重新开始");
    //创建重新登录菜单项
    JMenuItem reLoginItem = new JMenuItem("重新登录");
    //创建退出游戏菜单项
    JMenuItem closeItem = new JMenuItem("退出游戏");


    //创建公众号信息菜单项
    JMenuItem accoutItem = new JMenuItem("信息");

    JMenuItem changeImage = new JMenuItem("更换图片");
    JMenuItem girl = new JMenuItem("美女");
    JMenuItem animal = new JMenuItem("动物");
    JMenuItem sport = new JMenuItem("运动");



    private void initDate() {
        int[] tempArr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0};
        Random random = new Random();
        for (int i = 0; i < tempArr.length; i++) {
            int index = random.nextInt(tempArr.length);
            int temp = tempArr[i];
            tempArr[i] = tempArr[index];
            tempArr[index] = temp;
        }

        for (int i = 0; i < tempArr.length; i++) {
            System.out.println(tempArr[i]);
        }


        int index = 0;
//遍历一维数组，将数据存入二维数组
//        for(int i =0 ;i<tempArr.length;i++){
//            data[i/4][i%4] = tempArr[i];
//        }
//遍历二维数组
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                //找到0的位置
                if (tempArr[index] == 0) {
                    x = i;
                    y = j;
                }
                    data[i][j] = tempArr[index];



                index++;
            }
            System.out.println();
        }

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }


    }

    private void initImage() {
        //清空界面
        this.getContentPane().removeAll();
        if (victory()) {
            //显示胜利图片
            JLabel win = new JLabel(new ImageIcon("C:\\Users\\12586\\Desktop\\puzzleGame\\image\\win.png"));
            win.setBounds(203, 283, 197, 73);
            this.getContentPane().add(win);
        }

        //显示步数
        JLabel stepLabel = new JLabel("步数：" + step);
        stepLabel.setBounds(50, 30, 100, 20);
        this.getContentPane().add(stepLabel);


        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                //获取图片编号
                int number = data[i][j];

                //创建一个图片ImageIcon的对象
                ImageIcon icon = new ImageIcon(path + number + ".jpg");
                //创建一个JLabel的对象（管理容器）
                JLabel jLabel1 = new JLabel(icon);
                //指定图片位置
                jLabel1.setBounds(105 * j + 83, 105 * i + 134, 105, 105);
                //给图片添加边框
                jLabel1.setBorder(new BevelBorder(0));

                //把管理容器添加到界面中
                // this.add(jLabel1);
                this.getContentPane().add(jLabel1);
                //每次循环，图片编号+1


            }
        }

        //添加背景图片
        ImageIcon bg = new ImageIcon("C:\\Users\\12586\\Desktop\\puzzleGame\\image\\background.png");
        JLabel background = new JLabel(bg);
        background.setBounds(40, 40, 508, 560);
        this.getContentPane().add(background);

        //刷新界面
        this.getContentPane().repaint();

    }

    private void initJMenubar() {
//创建菜单栏
        JMenuBar jMenuBar = new JMenuBar();

//创建功能菜单
        JMenu functionJMenu = new JMenu("功能");
//创建关于我们菜单
        JMenu aboutJMenu = new JMenu("关于我们");






// 添加功能菜单项
        functionJMenu.add(changeImage);
        functionJMenu.add(replayItem);
        functionJMenu.add(reLoginItem);
        functionJMenu.add(closeItem);

//        changeImage.add(girl);
//        changeImage.add(animal);
//        changeImage.add(sport);


        //添加监听
        replayItem.addActionListener(this);
        reLoginItem.addActionListener(this);
        closeItem.addActionListener(this);
        accoutItem.addActionListener(this);


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

        //添加键盘监听
        this.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }


    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == 65) {
            //把界面清除
            this.getContentPane().removeAll();
            //加载完整图片
            JLabel all = new JLabel(new ImageIcon(path + "all.jpg"));
            all.setBounds(83, 134, 420, 420);
            this.getContentPane().add(all);
            //加载背景图片
            ImageIcon bg = new ImageIcon("C:\\Users\\12586\\Desktop\\puzzleGame\\image\\background.png");
            JLabel background = new JLabel(bg);
            this.getContentPane().add(background);
            //刷新界面
            this.getContentPane().repaint();

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (victory()) {
            return;
        }


        //左：37 上：38 右：39 下：40
        int code = e.getKeyCode();

        if (code == 37) {
            System.out.println("左");
            if (y == 3) {
                return;
            }
            data[x][y] = data[x][y + 1];
            data[x][y + 1] = 0;
            y++;
            step++;
            initImage();


        } else if (code == 38) {
            System.out.println("上");
            if (x == 3) {
                return;
            }
            data[x][y] = data[x + 1][y];
            data[x + 1][y] = 0;
            x++;
            step++;
            initImage();

        } else if (code == 39) {
            System.out.println("右");
            if (y == 0) {
                return;
            }
            data[x][y] = data[x][y - 1];
            data[x][y - 1] = 0;
            y--;
            step++;
            initImage();

        } else if (code == 40) {
            System.out.println("下");
            if (x == 0) {
                return;
            }
            data[x][y] = data[x - 1][y];
            data[x - 1][y] = 0;
            x--;
            step++;
            initImage();

        } else if (code == 65) {
            initImage();
        } else if (code == 87) {
            data = new int[][]{
                    {1, 2, 3, 4},
                    {5, 6, 7, 8},
                    {9, 10, 11, 12},
                    {13, 14, 15, 0}
            };
            initImage();
        }

    }

    public boolean victory() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (data[i][j] != win[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //获取事件源
        Object obj = e.getSource();
        //判断事件源
        if (obj == replayItem) {
            step = 0;
            initDate();
            initImage();
        } else if (obj == reLoginItem) {
            new loginJframe();
            this.dispose();
        } else if (obj == closeItem) {
            System.exit(0);
        } else if (obj == accoutItem) {
            JOptionPane.showMessageDialog(this, "LXY");

        }
    }
}
