/*
   Alumno: Juan Manuel Pascual Navarro
   Semestre y grupo: 4-A
   Fecha de entrega: 15/Feb/2021
*/

import javax.swing.*;
import java.awt.event.*;

public class Calculadora_Grafica extends JFrame{
   JTextField texto1, texto2, r;
   JButton btnMas, btnMenos, btnPor, btnEntre;
   JPanel panel;
   JLabel num1, num2, res;
   
   public Calculadora_Grafica(){
      initComponents();
   }
   
   private void initComponents(){
      setSize(400, 200);
      setTitle("Calculadora");
      texto1 = new JTextField(10);
      texto1.setEditable(true);
      texto2 = new JTextField(10);
      texto2.setEditable(true);
      r = new JTextField(10);
      r.setEditable(false);
      num1 = new JLabel("Numero 1: ");
      num2 = new JLabel("Numero 2: ");
      res = new JLabel("Resultado: ");
      btnMas = new JButton("+");
      btnMenos = new JButton("-");
      btnPor = new JButton("*");
      btnEntre = new JButton("/");
      btnMas.addMouseListener(new MyClickListener1());
      btnMenos.addMouseListener(new MyClickListener2());
      btnPor.addMouseListener(new MyClickListener3());
      btnEntre.addMouseListener(new MyClickListener4());
      
      panel = new JPanel();
      
      panel.add(num1);
      panel.add(texto1);
      panel.add(num2);
      panel.add(texto2);
      panel.add(btnMas);
      panel.add(btnMenos);
      panel.add(btnPor);
      panel.add(btnEntre);
      panel.add(res);
      panel.add(r);
      setContentPane(panel);
      setVisible(true);
   }
   
   private class MyClickListener1 extends MouseAdapter{
      double n1 = 0.0, n2 = 0.0;
      public void mouseClicked(MouseEvent event){
         try{
            n1 = Double.parseDouble(texto1.getText());
            n2 = Double.parseDouble(texto2.getText());
            r.setText(String.valueOf(n1+n2));
         }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "valores no numericos");
            texto1.setText("");;
            texto1.requestFocus();
            texto2.setText("");
            r.setText("");
         }
      }
   }
   
   private class MyClickListener2 extends MouseAdapter{
      double n1 = 0.0, n2 = 0.0;
      public void mouseClicked(MouseEvent event){
         try{
            n1 = Double.parseDouble(texto1.getText());
            n2 = Double.parseDouble(texto2.getText());
            r.setText(String.valueOf(n1-n2));
         }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "valores no numericos");
            texto1.setText("");;
            texto1.requestFocus();
            texto2.setText("");
            r.setText("");
         }
      }
   }
   
   private class MyClickListener3 extends MouseAdapter{
      double n1 = 0.0, n2 = 0.0;
      public void mouseClicked(MouseEvent event){
         try{
            n1 = Double.parseDouble(texto1.getText());
            n2 = Double.parseDouble(texto2.getText());
            r.setText(String.valueOf(n1*n2));
         }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "valores no numericos");
            texto1.setText("");;
            texto1.requestFocus();
            texto2.setText("");
            r.setText("");
         }
      }
   }
   
   private class MyClickListener4 extends MouseAdapter{
      double n1 = 0.0, n2 = 0.0;
      public void mouseClicked(MouseEvent event){
         try{
            n1 = Double.parseDouble(texto1.getText());
            n2 = Double.parseDouble(texto2.getText());
            validarDivisor(n2);
            r.setText(String.valueOf(n1/n2));
         }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "valores no numericos");
            texto1.setText("");;
            texto1.requestFocus();
            texto2.setText("");
            r.setText("");
         }catch(MyException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            texto1.setText("");;
            texto1.requestFocus();
            texto2.setText("");
            r.setText("");
         }
      }
      
      public void validarDivisor(double n2) throws MyException{
         if(n2 == 0)
            throw new MyException("No se puede dividir entre 0");
      }
   }
   
   private class MyException extends Exception{
      public MyException(String mensaje){
         super(mensaje);
      }
   }
}