package main.java.Lambda;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingTest {

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("My JFrame");
        JButton jButton = new JButton("My Jbutton");

//        匿名内部类的写法。需要为执行的代码块定义一个类。
//        jButton.addActionListener(
//                new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent e) {
//                        System.out.println("Button Pressed!");
//                    }
//                }
//        );
//      Lambda写法。不需要定义单独的类，只需要编写处理逻辑
        jButton.addActionListener(e -> System.out.println("Button Pressed!"));

        jFrame.add(jButton);
        jFrame.pack();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
