using System;
using System.Windows.Forms;



namespace Calc
{
    public partial class Calculator : Form
    {
        double resVal = 0;
        string opPerformed;
        bool isOper = false;
        bool symbol = true;

        public Calculator()
        {
            InitializeComponent();
            tBox.Text = "0";
            tBox.TextAlign = HorizontalAlignment.Right;
        }

        private void button_Click(object sender, EventArgs e)
        {
            Button button = (Button)sender;
            

            if ((tBox.Text == "0" && button.Text != ",") || (isOper))
            {
                tBox.Clear();

            }

            if (button.Text == ",")
            {
                if (!tBox.Text.Contains(","))
                {
                    tBox.Text = tBox.Text + button.Text;
                }

            }
            else
            {
                tBox.Text = tBox.Text + button.Text;
            }

            isOper = false;
            label.Focus();
        }

        private void op_Click(object sender, EventArgs e)
        {
            Button button = (Button)sender;
            symbol = true;
            if (resVal != 0)
            {
                if (isOper)
                {
                    opPerformed = button.Text;
                    label.Text = resVal + " " + opPerformed;
                }
                else
                {
                    buttonEquals.PerformClick();
                    opPerformed = button.Text;
                    isOper = true;
                    label.Text = resVal + " " + opPerformed;
                }

            }
            else
            {
                opPerformed = button.Text;
                resVal = double.Parse(tBox.Text);
                isOper = true;
                label.Text = resVal + " " + opPerformed;
            }
        }

        private void buttonClear_Click(object sender, EventArgs e)
        {
            tBox.Text = "0";
            label.Text = "";
            resVal = 0;
            isOper = false;
        }

        private void buttonDel_Click(object sender, EventArgs e)
        {

            if (tBox.Text.Length > 1)
            {
                tBox.Text = tBox.Text.Substring(0, tBox.Text.Length - 1);
            }
            else
            {
                tBox.Text = "0";
            }
        }

        private void buttonEquals_Click(object sender, EventArgs e)
        {
            label.Text = "";
            double res;

            switch (opPerformed)
            {
                case "+":
                    res = resVal + double.Parse(tBox.Text);
                    tBox.Text = res.ToString();
                    break;
                case "—":
                    res = resVal - double.Parse(tBox.Text);
                    tBox.Text = res.ToString();
                    break;
                case "×":
                    res = resVal * double.Parse(tBox.Text);
                    tBox.Text = res.ToString();
                    break;
                case "÷":
                    if (double.Parse(tBox.Text) != 0)
                    {
                        res = resVal / double.Parse(tBox.Text);
                        tBox.Text = res.ToString();
                    }
                    else
                    {
                        label.Text = "Div by zero ";
                    }

                    break;
            }
            resVal = double.Parse(tBox.Text);
            opPerformed = "";
        }

        private void buttonSign_Click(object sender, EventArgs e)
        {
            if (isOper)
            {
                tBox.Text = "0";
            }
            if (symbol == true)
            {
                if (tBox.Text == "0")
                {
                    tBox.Clear();
                }
                tBox.Text = "-" + tBox.Text;
                symbol = false;
            }
            else
            {
                tBox.Text = tBox.Text.Replace("-", "");
                if (tBox.Text == "")
                {
                    tBox.Text = "0";
                }
                symbol = true;
            }
            isOper = false;
        }

        private void tBox_TextChanged(object sender, EventArgs e)
        {
            if (tBox.TextLength > 25)
            {
                tBox.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            }
            else if (tBox.TextLength > 18)
            {
                tBox.Font = new System.Drawing.Font("Microsoft Sans Serif", 15F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            }
            else
            {
                tBox.Font = new System.Drawing.Font("Microsoft Sans Serif", 20F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            }
        }

        private void Calculator_KeyDown(object sender, KeyEventArgs e)
        {
            switch (e.KeyCode)
            {
                case Keys.D0:
                    button0.PerformClick();
                    break;
                case Keys.D1:
                    button1.PerformClick();
                    break;
                case Keys.D2:
                    button2.PerformClick();
                    break;
                case Keys.D3:
                    button3.PerformClick();
                    break;
                case Keys.D4:
                    button4.PerformClick();
                    break;
                case Keys.D5:
                    button5.PerformClick();
                    break;
                case Keys.D6:
                    button6.PerformClick();
                    break;
                case Keys.D7:
                    button7.PerformClick();
                    break;
                case Keys.D8:
                    button8.PerformClick();
                    break;
                case Keys.D9:
                    button9.PerformClick();
                    break;

                case Keys.NumPad0:
                    button0.PerformClick();
                    break;
                case Keys.NumPad1:
                    button1.PerformClick();
                    break;
                case Keys.NumPad2:
                    button2.PerformClick();
                    break;
                case Keys.NumPad3:
                    button3.PerformClick();
                    break;
                case Keys.NumPad4:
                    button4.PerformClick();
                    break;
                case Keys.NumPad5:
                    button5.PerformClick();
                    break;
                case Keys.NumPad6:
                    button6.PerformClick();
                    break;
                case Keys.NumPad7:
                    button7.PerformClick();
                    break;
                case Keys.NumPad8:
                    button8.PerformClick();
                    break;
                case Keys.NumPad9:
                    button9.PerformClick();
                    break;

                case Keys.Decimal:
                    buttonDot.PerformClick();
                    break;
                case Keys.Multiply:
                    buttonMult.PerformClick();
                    break;
                case Keys.Divide:
                    buttonDiv.PerformClick();
                    break;
                case Keys.Add:
                    buttonPlus.PerformClick();
                    break;
                case Keys.Subtract:
                    buttonMinus.PerformClick();
                    break;

                case Keys.Delete:
                    buttonClear.PerformClick();
                    break;
                case Keys.Back:
                    buttonDel.PerformClick();
                    break;
                case Keys.Enter:
                    buttonEquals.PerformClick();
                    break;
                case Keys.Tab:
                    buttonSign.PerformClick();
                    break;

            }
        }
    }
}
