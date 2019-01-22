import java.lang.*;
import java.awt.*;
  import java.awt.datatransfer.*;
  import java.awt.event.*;
import javax.swing.*;
  import javax.swing.JComponent;
  import javax.swing.JFrame.*;
  import javax.swing.JTextField.*;

public class Calculator extends JFrame{
  //value of Calculator
    private double tempFirst=0.0;
    private double tempSaved=0.0;
    private int operation=0;
  //display
    private JTextArea main_display;//for the writing
  //Menus---
    private JMenuBar menu_bar;
      private JMenu file;
        private JMenuItem close;
      private JMenu edit;
        private JMenuItem copy;
      private JMenu help;
        private JMenuItem view_help, about;
  //Buttons---------
    private JButton zero,one,two,three,four,five,six,seven,eight,nine;
    private JButton decimal,plus,minus,multiply,divide,simetric,module_divide,equals,clear,clear_all;
  //Constructor
    public Calculator(){
      super("Calculator");
      createMenuBar();
      createMainDisplay();
      createButtons();
      createCalculator(this);
    }

  public double gettempFirst(){return tempFirst;}
  public void settempFirst(double tempFirst){this.tempFirst=tempFirst;}

  public double gettempSaved(){return tempSaved;}
  public void settempSaved(double tempSaved){this.tempSaved=tempSaved;}

  public int getOperation(){return operation;}
  public void setOperation(int operation){
    this.operation=operation;
    //0->null  1->+  2->-  3->*  4->/  5->%
  }

  private void createMenuBar(){
    menu_bar = new JMenuBar();
    //SubMenus
      file = new JMenu(" File ");
        close = new JMenuItem(" Close ");
      edit = new JMenu(" Edit ");
        copy = new JMenuItem(" Copy ");
      help = new JMenu(" Help ");
        view_help = new JMenuItem(" View Help ");
        about = new JMenuItem(" About Calculator ");
    setJMenuBar(menu_bar);
    //addSubMenus+Action listeners
      menu_bar.add(file);
        //File-closeAction
          close.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
              System.exit(0);
            }
          });
        file.add(close);
      menu_bar.add(edit);
        //copy-Action
          copy.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
              String display=main_display.getText();//copy value in text display
              StringSelection string = new StringSelection(display);
              Clipboard system = Toolkit.getDefaultToolkit().getSystemClipboard();
              system.setContents(string,string);
            }
          });
        edit.add(copy);
      menu_bar.add(help);
        //View-Action
          view_help.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
              JOptionPane.showMessageDialog(null,"There are currently no help topics to view","Calculator",JOptionPane.OK_OPTION);
            }
          });
        //About-Action
          about.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
              JOptionPane.showMessageDialog(null,"JavaCalculator (c) 2018","Calculator",JOptionPane.OK_OPTION);
            }
          });
        help.add(view_help);
        help.add(about);
  }
  private void createMainDisplay(){
    //|-------------------0-|
    //|___________________0_|
    main_display = new JTextArea("0");
    main_display.setBounds(10,10,324,50);
    main_display.setEditable(false);//no resize
    /*//Location of letters (L<-R)
      main_display.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
    main_display.setText("0");*/
    main_display.setFont(new Font("Arial",Font.PLAIN,30));
    add(main_display);
  }
  private void createButtons(){
    //DECIMAL BUTTONS
      seven = new JButton("7");
        seven.setBounds(10,70,65,55);
        seven.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
            //if size of text is greater than 13 do not append
            if(main_display.getText().length()>13) return;
            //if it only has a 0 ==> Beginning
            if(main_display.getText().equalsIgnoreCase("0")){
              main_display.setText("7");
              settempFirst(Double.parseDouble(main_display.getText()));
              return;
            }
            main_display.append("7");
            settempFirst(Double.parseDouble(main_display.getText()));
          }
        });
      add(seven);

      eight = new JButton("8");
        eight.setBounds(80,70,65,55);
        eight.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
            //if size of text is greater than 13 do not append
            if(main_display.getText().length()>13) return;
            //if it only has a 0 ==> Beginning
            if(main_display.getText().equalsIgnoreCase("0")){
              main_display.setText("8");
              settempFirst(Double.parseDouble(main_display.getText()));
              return;
            }
            main_display.append("8");
            settempFirst(Double.parseDouble(main_display.getText()));
          }
        });
      add(eight);

      nine = new JButton("9");
        nine.setBounds(150,70,65,55);
        nine.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
            //if size of text is greater than 13 do not append
            if(main_display.getText().length()>13) return;
            //if it only has a 0 ==> Beginning
            if(main_display.getText().equalsIgnoreCase("0")){
              main_display.setText("9");
              settempFirst(Double.parseDouble(main_display.getText()));
              return;
            }
            main_display.append("9");
            settempFirst(Double.parseDouble(main_display.getText()));
          }
        });
      add(nine);

      six = new JButton("6");
        six.setBounds(10,130,65,55);
        six.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
            //if size of text is greater than 13 do not append
            if(main_display.getText().length()>13) return;
            //if it only has a 0 ==> Beginning
            if(main_display.getText().equalsIgnoreCase("0")){
              main_display.setText("6");
              settempFirst(Double.parseDouble(main_display.getText()));
              return;
            }
            main_display.append("6");
            settempFirst(Double.parseDouble(main_display.getText()));
          }
        });
      add(six);

      five = new JButton("5");
        five.setBounds(80,130,65,55);
        five.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
            //if size of text is greater than 13 do not append
            if(main_display.getText().length()>13) return;
            //if it only has a 0 ==> Beginning
            if(main_display.getText().equalsIgnoreCase("0")){
              main_display.setText("5");
              settempFirst(Double.parseDouble(main_display.getText()));
              return;
            }
            main_display.append("5");
            settempFirst(Double.parseDouble(main_display.getText()));
          }
        });
      add(five);

      four = new JButton("4");
        four.setBounds(150,130,65,55);
        four.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
            //if size of text is greater than 13 do not append
            if(main_display.getText().length()>13) return;
            //if it only has a 0 ==> Beginning
            if(main_display.getText().equalsIgnoreCase("0")){
              main_display.setText("4");
              settempFirst(Double.parseDouble(main_display.getText()));
              return;
            }
            main_display.append("4");
            settempFirst(Double.parseDouble(main_display.getText()));
          }
        });
      add(four);

      three = new JButton("3");
        three.setBounds(10,190,65,55);
        three.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
            //if size of text is greater than 13 do not append
            if(main_display.getText().length()>13) return;
            //if it only has a 0 ==> Beginning
            if(main_display.getText().equalsIgnoreCase("0")){
              main_display.setText("3");
              settempFirst(Double.parseDouble(main_display.getText()));
              return;
            }
            main_display.append("3");
            settempFirst(Double.parseDouble(main_display.getText()));
          }
        });
      add(three);

      two = new JButton("2");
        two.setBounds(80,190,65,55);
        two.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
            //if size of text is greater than 13 do not append
            if(main_display.getText().length()>13) return;
            //if it only has a 0 ==> Beginning
            if(main_display.getText().equalsIgnoreCase("0")){
              main_display.setText("2");
              settempFirst(Double.parseDouble(main_display.getText()));
              return;
            }
            main_display.append("2");
            settempFirst(Double.parseDouble(main_display.getText()));
          }
        });
      add(two);

      one = new JButton("1");
        one.setBounds(150,190,65,55);
        one.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
            //if size of text is greater than 13 do not append
            if(main_display.getText().length()>13) return;
            //if it only has a 0 ==> Beginning
            if(main_display.getText().equalsIgnoreCase("0")){
              main_display.setText("1");
              settempFirst(Double.parseDouble(main_display.getText()));
              return;
            }
            main_display.append("1");
            settempFirst(Double.parseDouble(main_display.getText()));
          }
        });
      add(one);

      zero = new JButton("0");
        zero.setBounds(10,250,65,55);
        zero.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
            //if size of text is greater than 13 or is only zero do nothing
            if(main_display.getText().length()>13 || main_display.getText().equalsIgnoreCase("0")) return;
            main_display.append("0");
            settempFirst(Double.parseDouble(main_display.getText()));
          }
        });
      add(zero);

    //OPERATOR/FUNCTION Buttons
      decimal = new JButton(".");
        decimal.setBounds(80,250,65,55);
        decimal.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
            if(main_display.getText().contains(".")) return;
            main_display.append(".");
            settempFirst(Double.parseDouble(main_display.getText()));
          }
        });
      add(decimal);

      simetric = new JButton("+/-");
        simetric.setBounds(150,250,65,55);
        simetric.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
            if(main_display.getText().equalsIgnoreCase("0")) return;
            main_display.setText(Double.toString(Double.parseDouble(main_display.getText())*(-1)));
            settempFirst(Double.parseDouble(main_display.getText()));
            if(main_display.getText().endsWith("0")){
              main_display.setText(main_display.getText().replace(".0",""));
              settempFirst(Double.parseDouble(main_display.getText()));
            }
          }
        });
      add(simetric);

      clear = new JButton("CE");
        clear.setBounds(220,70,60,55);
        clear.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
            main_display.setText("0");
            settempFirst(0.0);
          }
        });
      add(clear);

      clear_all = new JButton("CA");
        clear_all.setBounds(280,70,60,55);
        clear_all.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
            settempFirst(0.0); settempSaved(0.0); setOperation(0);
            main_display.setText("0");
          }
        });
      add(clear_all);

      equals = new JButton("=");
        equals.setBounds(220,250,60,55);
        equals.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
            double result=0.0;
            switch(getOperation()){
              case 1: //plus
                result = gettempSaved() + gettempFirst();
                settempSaved(result); settempFirst(result);
                main_display.setText(result+"");
              break;
              case 2: //minus
                result = gettempSaved() - gettempFirst();
                settempSaved(result); settempFirst(result);
                main_display.setText(result+"");
              break;
              case 3: // multiply
                result = gettempSaved() * gettempFirst();
                settempSaved(result); settempFirst(result);
                main_display.setText(result+"");
              break;
              case 4: // divide
                if(gettempSaved()==0.0||gettempFirst()==0.0){
                  setOperation(0); settempFirst(0.0); settempSaved(0.0);
                  main_display.setText("0");
                  break;
                }
                result = gettempSaved() / gettempFirst();
                settempSaved(result); settempFirst(result);
                main_display.setText(result+"");
              break;
              case 5: //modulus
                if(gettempSaved()==0.0||gettempFirst()==0.0){
                  setOperation(0); settempFirst(0.0); settempSaved(0.0);
                  main_display.setText("0");
                  break;
                }
                result = (double)((int)gettempSaved() % (int)gettempFirst());
                settempSaved(result); settempFirst(result);
                main_display.setText(result+"");
              break;
              default:
                setOperation(0); settempFirst(0.0); settempSaved(0.0);
                main_display.setText("0");
              break;//operation==0==>NULL
            }
          }
        });
      add(equals);

      plus = new JButton("+");
        plus.setBounds(220,130,60,55);
        plus.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
            setOperation(1);
            settempSaved(gettempFirst());
            main_display.setText("0");
            settempFirst(Double.parseDouble(main_display.getText()));
          }
        });
      add(plus);

      minus = new JButton("-");
        minus.setBounds(220,190,60,55);
        minus.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
            setOperation(2);
            settempSaved(gettempFirst());
            main_display.setText("0");
            settempFirst(Double.parseDouble(main_display.getText()));
          }
        });
      add(minus);

      multiply = new JButton("x");
        multiply.setBounds(280,130,60,55);
        multiply.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
            setOperation(3);
            settempSaved(gettempFirst());
            main_display.setText("0");
            settempFirst(Double.parseDouble(main_display.getText()));
          }
        });
      add(multiply);

      divide = new JButton("/");
        divide.setBounds(280,190,60,55);
        divide.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
            if(gettempFirst()==0.0){
              setOperation(0); settempFirst(0.0); settempSaved(0.0);
              return;
            }
            setOperation(4);
            settempSaved(gettempFirst());
            main_display.setText("0");
            settempFirst(Double.parseDouble(main_display.getText()));
          }
        });
      add(divide);

      module_divide = new JButton("%");
        module_divide.setBounds(280,250,60,55);
        module_divide.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
            if(gettempFirst()==0.0){
              setOperation(0); settempFirst(0.0); settempSaved(0.0);
              return;
            }
            setOperation(5);
            settempSaved(gettempFirst());
            main_display.setText("0");
            settempFirst(Double.parseDouble(main_display.getText()));
          }
        });
      add(module_divide);

  }
  private static void createCalculator(Calculator app){
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    app.setResizable(false);
    app.setLocationRelativeTo(null);//goes to center
    app.setSize(350,400);
    app.setLayout(null);
    app.setVisible(true);
  }

  public static void main(String[] args) {
    try {//Set UI to computer theme
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch(Exception e) {
      System.out.println("Not load");
    }
    new Calculator();
  }
}
