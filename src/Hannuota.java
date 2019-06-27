
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Hannuota {
    public static void main(String[]args){
        //创建开始界面
        Sbtn s=new Sbtn();
    }
}
/**
 * 创建类HNT
 * 重写绘制方法
 * */
class HNT extends JPanel implements Runnable{
    int n;//汉诺塔的总层数
    ArrayList<Dish> d;//创建了盘子对象集合
    int I;
    HNT(int getn){
        n=getn;
        I=0;
        d=new ArrayList<Dish>();
        int j=getn;int ii=0;
        for(int i=1;i<getn+1;i++){
            d.add(ii,new Dish(500/getn,i*20,500-i*10,500-j*500/getn));
            ii++;
            j--;
        }
    }
    public void paint(Graphics g){
        super.paint(g);
        //地平线
        g.setColor(Color.green);
        g.drawLine(0,500,1920,500);
        //柱子A B C
        g.setColor(Color.white);
        g.drawLine(500,500,500,10);
        g.drawLine(1000,500,1000,10);
        g.drawLine(1500,500,1500,10);

        g.drawString("此汉诺塔总层数为："+n,10,10);

        //盘子,定义盘子对象
        g.setColor(Color.gray);
        //用对象变量来定位盘子
        for(int i=0;i<n;i++){
            g.fillRect(d.get(i).Dx,d.get(i).Dy,d.get(i).with,d.get(i).heigh);
        }
    }
    @Override
    public void run() {
//        move(n,500-d.get(I).with/2,1000-d.get(I).with/2,1500-d.get(I).with/2);
        JOptionPane.showMessageDialog(this, "动画完成！！！");
    }
    void move(int n,int x1,int x2,int x3){//这里的三个参数我想用得是三个盘子到三个柱子上的x坐标
//        if(n==1){
//             if(d.get(I).Dx==x1){
//                 d.get(I).Dx=x3;
//             }
//             I++;
//            try{
//                Thread.sleep(1000);
//            }catch (Exception e){
//                JOptionPane.showMessageDialog(this, "程序被外星人干扰崩溃！！");
//            }
//            repaint();
//        }
//        else{
//            move(n-1,x1,x3,x2);
//            d.get(n-1).Dx=x3;
//            move(n-1,x2,x1,x3);
//        }
    }



}
/**
 * 开始窗口
 * */
class Sbtn extends JFrame implements ActionListener {
    JTextField txtN;
    //用户输入的汉诺塔层数
    Sbtn() {
        /*布局界面*/
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(1920 / 2, 1080 / 2, 300, 150);
        JButton btnStart = new JButton("开始");
        //监听按钮.....
        btnStart.addActionListener(this);
        JLabel labTxt = new JLabel("请输入汉诺塔层数：");
        txtN = new JTextField();
        JPanel panTxt = new JPanel();
        panTxt.setLayout(new GridLayout(1, 2));
        panTxt.add(labTxt);
        panTxt.add(txtN);
        this.setLayout(new GridLayout(2, 1));
        this.add(panTxt);
        this.add(btnStart);
        this.setVisible(true);
    }

    //判断字符串是否为纯整数是返回true，否返回false；
    boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("开始")) {
            String s = txtN.getText();//取字符串
            if (!s.equals("")&&isInteger(s)) {
                //将字符串转化成数字，从而获得塔的总层数
                int num = Integer.parseInt(s);
                this.setVisible(false);
                //汉诺塔窗口
                JFrame win=new JFrame();
                win.setSize(1920,1080);
                win.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                //创建画面对象
                HNT hnt=new HNT(num);
                hnt.setBackground(Color.BLACK);

                win.add(hnt);

                Thread t=new Thread(hnt);
                t.start();
                win.setVisible(true);
            }
            else {
                JOptionPane.showMessageDialog(this, "输入有误，必须为整数！！");
            }
        }
    }
}
//创建盘子对象
class Dish{
    public int heigh;
    public int with;
    public int Dx;
    public int Dy;
    Dish(int h,int w,int x,int y){
        heigh=h;
        with=w;
        Dx=x;
        Dy=y;
    }
}