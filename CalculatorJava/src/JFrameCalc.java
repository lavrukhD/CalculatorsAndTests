import javax.swing.*;

public class JFrameCalc extends JFrame{
    public JFrameCalc(){
        setBounds(150,150,355,350);
        setTitle("Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //setUndecorated(true);
        setResizable(false);
        add( new JPanelCalc());
        setVisible(true);
    }
}
