import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class calculator implements ActionListener {
     
    JFrame frame;
    JTextField textField;
    JButton[] numButtons = new JButton[10] ;
    JButton[] functionButtons =  new JButton[9];  
    JButton addButton,subButton,mulButton,divButton;
    JButton decButton,equButton,clrButton,delButton;
    JButton negButton;
    JPanel panel;
     
    Font myFont = new Font("Arial Black",Font.BOLD,20);
    
    double num1=0,num2=0,result=0;
    char operator;

    calculator(){

        frame =new JFrame("calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);
        //textfield
        textField = new JTextField();
        textField.setBounds(35,25,340, 50);
        textField.setFont(myFont);
        textField.setEditable(false);
        //functionbuttons
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("x");
        divButton = new JButton("/");
        equButton = new JButton("=");
        decButton = new JButton(".");
        delButton = new JButton("Delete");
        clrButton = new JButton("clr");
        negButton = new JButton("+/-");
        //add these buttons to the array functionbuttons
        functionButtons[0]= addButton;
        functionButtons[1]= subButton;
        functionButtons[2]= mulButton;
        functionButtons[3]= divButton;
        functionButtons[4]= equButton;
        functionButtons[5]= decButton;
        functionButtons[6]= delButton;
        functionButtons[7]= clrButton;
        functionButtons[8]= negButton;

        for(int i=0;i<9;i++){
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }
        //numbuttons
         for(int i=0;i<10;i++){
            numButtons[i]=new JButton(String.valueOf(i));
            numButtons[i].addActionListener(this);
            numButtons[i].setFont(myFont);
            numButtons[i].setFocusable(false);
        }

        negButton.setBounds(50, 430, 90, 50);
        delButton.setBounds(150, 430, 90, 50);
        clrButton.setBounds(250, 430, 90, 50);

        frame.add(delButton);
        frame.add(clrButton);
        frame.add(negButton);

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        //panel.setBackground(Color.GRAY);
        panel.add(numButtons[7]);
        panel.add(numButtons[8]);
        panel.add(numButtons[9]);
        panel.add(addButton);
        panel.add(numButtons[4]);
        panel.add(numButtons[5]);
        panel.add(numButtons[6]);
        panel.add(subButton);
        panel.add(numButtons[1]);
        panel.add(numButtons[2]);
        panel.add(numButtons[3]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numButtons[0]);
        panel.add(divButton);
        panel.add(equButton);

        frame.add(panel);
        frame.add(textField);
        frame.setVisible(true);

    }
     public static void main(String[] args) {
    
        calculator calc = new calculator();

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
       for(int i=0;i<10;i++){

            if(e.getSource()==numButtons[i]){

                textField.setText(textField.getText().concat(String.valueOf(i)));

            }

       }

       if(e.getSource()==decButton){

            textField.setText(textField.getText().concat("."));

       }

        if(e.getSource()==addButton){

          num1 = Double.parseDouble(textField.getText());
          operator = '+';
          textField.setText(null);

       }

       if(e.getSource()==subButton){

          num1 = Double.parseDouble(textField.getText());
          operator = '-';
          textField.setText(null);

       }

        if(e.getSource()==divButton){

          num1 = Double.parseDouble(textField.getText());
          operator = '/';
          textField.setText(null);

       }

        if(e.getSource()==mulButton){

          num1 = Double.parseDouble(textField.getText());
          operator = 'x';
          textField.setText(null);

       }

       if(e.getSource()==equButton){

            num2 = Double.parseDouble(textField.getText());
            switch(operator){
                case '+' :
                            result=num1 + num2;
                            break;
                case '-' :
                            result=num1-num2;
                            break;
                case 'x' :
                            result=num1 * num2;
                            break;
                case '/' :
                            result=num1/num2;
                            break;                            
                                                      
            }

            textField.setText(String.valueOf(result));
            num1=result;

       }
       
        if(e.getSource()==clrButton){

          num1=0;
          num2=0;
          textField.setText(null);

       }

       if(e.getSource()==delButton){

            String string = textField.getText();
            textField.setText(null);
            for(int i=0;i<string.length()-1;i++){
                textField.setText(textField.getText()+string.charAt(i));
            }
       }

       if(e.getSource()==negButton){

            Double temp = Double.parseDouble(textField.getText());
            temp*=-1;
            textField.setText(String.valueOf(temp));
       }

    }
}
