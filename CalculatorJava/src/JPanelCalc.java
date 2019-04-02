
import javax.swing.*;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class JPanelCalc extends JPanel {

    int bWidth = 55, bHeight = 40;


    Font numberFont = new Font("serif", Font.BOLD, 25);



    public JPanelCalc() {

        setLayout(null);
        setBackground(Color.DARK_GRAY);

        JLabel label = new JLabel();
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        label.setFont(new Font("serif", Font.PLAIN, 21));
        label.setBounds(20, 30, 300, 30);
        label.setForeground(Color.LIGHT_GRAY);

        JTextField textField = new JTextField();
        textField.setBounds(20, 70, 305, 35);           //+30(Y)
        textField.setEditable(false);
        textField.setBackground(Color.white);
        textField.setFont(new Font("serif", Font.LAYOUT_RIGHT_TO_LEFT, 25));
        textField.setHorizontalAlignment(SwingConstants.RIGHT);
        textField.setText("0");
        //Buttons

        JButton bDot = new JButton(".");
        bDot.setBounds(20, 255, bWidth, bHeight);
        setButtonStyle(bDot);

        JButton b0 = new JButton("0");
        b0.setBounds(80, 255, bWidth, bHeight);
        setButtonStyle(b0);

        JButton bSign = new JButton("±");
        bSign.setBounds(140, 255, bWidth, bHeight);
        setButtonStyle(bSign);

        JButton b1 = new JButton("1");
        b1.setBounds(20, 210, bWidth, bHeight);
        setButtonStyle(b1);

        JButton b2 = new JButton("2");
        b2.setBounds(80, 210, bWidth, bHeight);
        setButtonStyle(b2);

        JButton b3 = new JButton("3");
        b3.setBounds(140, 210, bWidth, bHeight);
        setButtonStyle(b3);

        JButton b4 = new JButton("4");
        b4.setBounds(20, 165, bWidth, bHeight);
        setButtonStyle(b4);

        JButton b5 = new JButton("5");
        b5.setBounds(80, 165, bWidth, bHeight);
        setButtonStyle(b5);

        JButton b6 = new JButton("6");
        b6.setBounds(140, 165, bWidth, bHeight);
        setButtonStyle(b6);

        JButton b7 = new JButton("7");
        b7.setBounds(20, 120, bWidth, bHeight);
        setButtonStyle(b7);

        JButton b8 = new JButton("8");
        b8.setBounds(80, 120, bWidth, bHeight);
        setButtonStyle(b8);

        JButton b9 = new JButton("9");
        b9.setBounds(140, 120, bWidth, bHeight);
        setButtonStyle(b9);

        JButton bPlus = new JButton("+");
        bPlus.setBounds(210, 120, bWidth, bHeight);
        setButtonStyle(bPlus);

        JButton bMinus = new JButton("–");
        bMinus.setBounds(210, 165, bWidth, bHeight);
        setButtonStyle(bMinus);

        JButton bMulti = new JButton("×");
        bMulti.setBounds(210, 210, bWidth, bHeight);
        setButtonStyle(bMulti);

        JButton bDiv = new JButton("÷");
        bDiv.setBounds(210, 255, bWidth, bHeight);
        setButtonStyle(bDiv);

        JButton bEqual = new JButton("=");
        bEqual.setBounds(270, 210, bWidth, bHeight * 2 + 5);
        setButtonStyle(bEqual);

        JButton bClearAll = new JButton("CE");
        bClearAll.setBounds(270, 120, bWidth, bHeight);
        setButtonStyle(bClearAll);
        bClearAll.setFont(new Font("serif", Font.BOLD, 16));
        b1.setFocusable(false);

        JButton bDelSymb = new JButton("←");
        bDelSymb.setBounds(270, 165, bWidth, bHeight);
        setButtonStyle(bDelSymb);
        bDelSymb.setFont(new Font("serif", Font.BOLD, 22));
        b1.setFocusable(false);


        add(label);
        add(textField);
        add(bDot);
        add(b0);
        add(bSign);
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        add(b6);
        add(b7);
        add(b8);
        add(b9);
        add(bEqual);
        add(bPlus);
        add(bMinus);
        add(bMulti);
        add(bDiv);
        add(bClearAll);
        add(bDelSymb);


        b0.addActionListener(e -> Processing.numClicked(b0, textField));
        b1.addActionListener(e -> Processing.numClicked(b1, textField));
        b2.addActionListener(e -> Processing.numClicked(b2, textField));
        b3.addActionListener(e -> Processing.numClicked(b3, textField));
        b4.addActionListener(e -> Processing.numClicked(b4, textField));
        b5.addActionListener(e -> Processing.numClicked(b5, textField));
        b6.addActionListener(e -> Processing.numClicked(b6, textField));
        b7.addActionListener(e -> Processing.numClicked(b7, textField));
        b8.addActionListener(e -> Processing.numClicked(b8, textField));
        b9.addActionListener(e -> Processing.numClicked(b9, textField));
        bDot.addActionListener(e -> Processing.numClicked(bDot, textField));

        bSign.addActionListener(e -> Processing.numSignClicked(textField));

        bPlus.addActionListener(e -> Processing.opClicked(bPlus, textField, label));
        bMinus.addActionListener(e -> Processing.opClicked(bMinus, textField, label));
        bMulti.addActionListener(e -> Processing.opClicked(bMulti, textField, label));
        bDiv.addActionListener(e -> Processing.opClicked(bDiv, textField, label));

        bEqual.addActionListener(e -> Processing.bEqualsClicked(textField, label));

        bClearAll.addActionListener(e -> Processing.clearAllClicked(textField, label));
        bDelSymb.addActionListener(e -> Processing.delSymbClicked(textField));


        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                switch (key) {
                    case KeyEvent.VK_NUMPAD0:
                    case KeyEvent.VK_0:
                        b0.doClick();
                        break;
                    case KeyEvent.VK_NUMPAD1:
                    case KeyEvent.VK_1:
                        b1.doClick();
                        break;
                    case KeyEvent.VK_NUMPAD2:
                    case KeyEvent.VK_2:
                        b2.doClick();
                        break;
                    case KeyEvent.VK_NUMPAD3:
                    case KeyEvent.VK_3:
                        b3.doClick();
                        break;
                    case KeyEvent.VK_NUMPAD4:
                    case KeyEvent.VK_4:
                        b4.doClick();
                        break;
                    case KeyEvent.VK_NUMPAD5:
                    case KeyEvent.VK_5:
                        b5.doClick();
                        break;
                    case KeyEvent.VK_NUMPAD6:
                    case KeyEvent.VK_6:
                        b6.doClick();
                        break;
                    case KeyEvent.VK_NUMPAD7:
                    case KeyEvent.VK_7:
                        b7.doClick();
                        break;
                    case KeyEvent.VK_NUMPAD8:
                    case KeyEvent.VK_8:
                        b8.doClick();
                        break;
                    case KeyEvent.VK_NUMPAD9:
                    case KeyEvent.VK_9:
                        b9.doClick();
                        break;
                    case KeyEvent.VK_BACK_SPACE:
                        bDelSymb.doClick();
                        break;
                    case KeyEvent.VK_DELETE:
                        bClearAll.doClick();
                        break;
                    case KeyEvent.VK_ALT:
                        bSign.doClick();
                        break;
                    case KeyEvent.VK_DECIMAL:
                        bDot.doClick();
                        break;
                    case KeyEvent.VK_ADD:
                        bPlus.doClick();
                        break;
                    case KeyEvent.VK_SUBTRACT:
                        bMinus.doClick();
                        break;
                    case KeyEvent.VK_MULTIPLY:
                        bMulti.doClick();
                        break;
                    case KeyEvent.VK_DIVIDE:
                        bDiv.doClick();
                        break;
                    case KeyEvent.VK_ENTER:
                        bEqual.doClick();
                        break;
                    default:
                        break;
                }
            }
        });
    }


    private void setButtonStyle(JButton b) {
        b.setBackground(Color.LIGHT_GRAY);
        b.setFont(numberFont);
        b.setContentAreaFilled(false);
        b.setOpaque(true);
        b.setFocusable(false);
    }
}


