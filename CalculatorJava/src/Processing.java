import javax.swing.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Processing {

    static BigDecimal resVal = new BigDecimal("0");
    static String opPerformed;
    static boolean isOper = false;
    static boolean symbol = true;

    public static void numClicked(JButton b, JTextField tF) {
        if ((Objects.equals(tF.getText(), "0") & !Objects.equals(b.getText(), ".")) | (isOper)) {
            tF.setText("");
        }

        if (Objects.equals(b.getText(), ".")) {
            if (!tF.getText().contains(".")) {
                tF.setText(tF.getText() + b.getText());
                if(Objects.equals(tF.getText(), ".")){
                    tF.setText("0.");
                }
            }
        } else {
            tF.setText(tF.getText() + b.getText());
        }
        isOper = false;
    }

    public static void numSignClicked(JTextField tF) {
        if (isOper) {
            tF.setText("0");
        }
        if (symbol) {
            if (Objects.equals(tF.getText(), "0")) {
                tF.setText("");
            }
            tF.setText("-" + tF.getText());
            symbol = false;
        } else {
            tF.setText(tF.getText().replace("-", ""));
            if (Objects.equals(tF.getText(), "")) {
                tF.setText("0");
            }
            symbol = true;
        }
        isOper = false;



    }

    public static void opClicked(JButton b, JTextField tF, JLabel label) {
        symbol = true;

        if (resVal.signum() != 0) {
            if (isOper) {
                opPerformed = b.getText();

                    label.setText(resVal.toString() + " " + opPerformed);

            } else {
                bEqualsClicked(tF, label);
                opPerformed = b.getText();
                isOper = true;

                label.setText(resVal.toString() + " " + opPerformed);

            }

        } else {
            opPerformed = b.getText();

            resVal = new BigDecimal(tF.getText());

            isOper = true;

            label.setText(resVal.toString() + " " + opPerformed);

        }
    }

    public static void bEqualsClicked(JTextField tF, JLabel label) {
        label.setText("");
        BigDecimal res;

        switch (opPerformed) {
            case "+":

                res = resVal.add(new BigDecimal(tF.getText()));

                    tF.setText(String.valueOf(res));

                break;
            case "–":
                res = resVal.subtract(new BigDecimal(tF.getText()));

                    tF.setText(String.valueOf(res));

                break;
            case "×":
                res = resVal.multiply(new BigDecimal(tF.getText()));

                    tF.setText(String.valueOf(res));

                break;
            case "÷":
                if (Double.valueOf(tF.getText()) != 0) {
                    res = resVal.divide(new BigDecimal(tF.getText()), RoundingMode.HALF_UP);

                        tF.setText(String.valueOf(res));

                } else {
                    label.setText("Div by zero ");
                }
                break;
            default: break;
        }

        resVal = new BigDecimal(tF.getText());
        opPerformed = "";
    }

    public static void clearAllClicked(JTextField tF, JLabel label) {
        tF.setText("0");
        label.setText("");
        resVal = new BigDecimal("0");
        isOper = false;
    }

    public static void delSymbClicked(JTextField tF){
        if (tF.getText().length() > 1)
        {
            tF.setText(tF.getText().substring(0, tF.getText().length() - 1));
        }
        else
        {
            tF.setText("0");
        }
    }
}
