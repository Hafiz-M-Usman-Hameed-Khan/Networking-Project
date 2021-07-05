
package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Gui {
    public static void main(String[] args) {
        main_frame();
    }
   public static void main_frame(){
      JFrame frame = new JFrame("**Welcome to Sports Club**");
    //  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
      JPanel panel = new JPanel();
      //creating buttons.
      JButton member = new JButton("Member Information");
      JButton ground = new JButton("Ground Information");
      JButton booking = new JButton("Booking Information");
      JButton exit = new JButton("Exit");
      //setting button size
      member.setPreferredSize(new Dimension(700, 50));
      ground.setPreferredSize(new Dimension(700, 50));
      booking.setPreferredSize(new Dimension(700, 50));
      exit.setPreferredSize(new Dimension(700, 50));
      //setting font size of the button text.
      Font newButtonFont = new Font(member.getFont().getName(),member.getFont().getStyle(),20);
      member.setFont(newButtonFont);
      ground.setFont(newButtonFont);
      booking.setFont(newButtonFont);
      exit.setFont(newButtonFont);
      //add buttons to the panel.
      panel.add(member);
      panel.add(ground);
      panel.add(booking);
      panel.add(exit);
   
      panel.setAlignmentX(Component.CENTER_ALIGNMENT);
      panel.setPreferredSize(new Dimension(250, 700));
      panel.setMaximumSize(new Dimension(250, 700));
      //add panel to the frame.
      frame.getContentPane().add(panel);
      frame.setSize(700, 600);
      frame.setVisible(true);
        
         class AddInterestListener implements ActionListener
            {
                public void actionPerformed(ActionEvent event)
                {
                    another_frame("ground");
                }
            }
            class OtherButtonListener implements ActionListener
            {
                public void actionPerformed(ActionEvent event)
                {
                   another_frame("member");
                }
            }
            class OtherButton2Listener implements ActionListener
            {
                public void actionPerformed(ActionEvent event)
                {
                   booking_frame();
                }
            }
            class OtherButton3Listener implements ActionListener
            {
                public void actionPerformed(ActionEvent event)
                {
                    System.exit(0);
                }
            }
            ActionListener listener = new AddInterestListener();
            ground.addActionListener(listener);
            ActionListener listener1 = new OtherButtonListener();
            member.addActionListener(listener1);
            ActionListener listener2 = new OtherButton2Listener();
            booking.addActionListener(listener2);
            ActionListener listener3 = new OtherButton3Listener();
            exit.addActionListener(listener3);
   }
   public static void another_frame(String s ){
       JFrame frame = new JFrame();
    
      if (s.equals("ground")){
           frame = new JFrame("Ground Section");
      }
      else if (s.equals("member")){
          frame = new JFrame("Member Section");
      }
      
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
      JPanel panel = new JPanel();
      //creating buttons.
      JButton add = new JButton("Add Information");
      JButton view = new JButton("View Information");
      JButton edit = new JButton("Edit Information");
      JButton search = new JButton("Search Information");
      JButton delete = new JButton("Delete Information");
      
      
      //setting button size
      add.setPreferredSize(new Dimension(700, 50));
      view.setPreferredSize(new Dimension(700, 50));
      edit.setPreferredSize(new Dimension(700, 50));
      search.setPreferredSize(new Dimension(700, 50));
      delete.setPreferredSize(new Dimension(700, 50));
     
      //setting font size of the button text.
      Font newButtonFont = new Font(add.getFont().getName(),add.getFont().getStyle(),20);
      add.setFont(newButtonFont);
      view.setFont(newButtonFont);
      edit.setFont(newButtonFont);
      search.setFont(newButtonFont);
      delete.setFont(newButtonFont);
     
      //add buttons to the panel.
      panel.add(add);
      panel.add(view);
      panel.add(edit);
      panel.add(search);
      panel.add(delete);
       
      panel.setAlignmentX(Component.CENTER_ALIGNMENT);
      panel.setPreferredSize(new Dimension(250, 700));
      panel.setMaximumSize(new Dimension(250, 700));
      //add panel to the frame.
      frame.getContentPane().add(panel);
      frame.setSize(700, 600);
      frame.setVisible(true);
      
        class AddInterestListener implements ActionListener
            {
                public void actionPerformed(ActionEvent event)
                {
                    member_frame();
                }
            }
        class AddInterestListener2 implements ActionListener
            {
                public void actionPerformed(ActionEvent event)
                {
                    ground_frame();
                }
            }
         ActionListener listener = new AddInterestListener();
          ActionListener listener2 = new AddInterestListener2();
         if (s.equals("member")){
         add.addActionListener(listener);}
         else {
             add.addActionListener(listener2);
         }
        
   }
 public static void booking_frame(){
    
     JFrame frame = new JFrame("Booking Section");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
      JPanel panel = new JPanel();
      //creating buttons.
      JButton add = new JButton("Add Information");
      JButton view = new JButton("View Information");
      JButton delete = new JButton("Delete Information");
      
      //setting button size
      add.setPreferredSize(new Dimension(700, 50));
      view.setPreferredSize(new Dimension(700, 50));
      delete.setPreferredSize(new Dimension(700, 50));
      //setting font size of the button text.
      Font newButtonFont = new Font(add.getFont().getName(),add.getFont().getStyle(),20);
      add.setFont(newButtonFont);
      view.setFont(newButtonFont);
      delete.setFont(newButtonFont);
      //add buttons to the panel.
      panel.add(add);
      panel.add(view);
      panel.add(delete);
   
      panel.setAlignmentX(Component.CENTER_ALIGNMENT);
      panel.setPreferredSize(new Dimension(250, 700));
      panel.setMaximumSize(new Dimension(250, 700));
      //add panel to the frame.
      frame.getContentPane().add(panel);
      frame.setSize(700, 600);
      frame.setVisible(true);
      
       class OtherButton3Listener implements ActionListener
            {
                public void actionPerformed(ActionEvent event)
                {
                   add_booking();
                }
            }
            ActionListener listener = new OtherButton3Listener();
            add.addActionListener(listener);
 }
 public static void member_frame(){
     JFrame frame = new JFrame("member section");
      frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     JTextField id = new JTextField(15);
     JTextField name = new JTextField(15);
     JTextField age = new JTextField(15);
     JTextField city = new JTextField(15);
    
     JPanel panel = new JPanel();
     panel.setBorder(BorderFactory.createTitledBorder("Member Information: "));
     
     panel.add(new JLabel("  ID: "));
     id.setPreferredSize( new Dimension( 200,35 ) );
    
      panel.add(id);
      
      panel.add(new JLabel("  Name: "));
      name.setPreferredSize( new Dimension( 200,35 ) );
     
      panel.add(name);
      panel.add(new JLabel("  Age: "));
      age.setPreferredSize( new Dimension( 200,35 ) );
      panel.add(age);
      panel.add(new JLabel("  City: "));
      city.setPreferredSize( new Dimension( 200,35 ) );
   
      panel.add(city);
      
      
       panel.setAlignmentX(Component.CENTER_ALIGNMENT);
      panel.setPreferredSize(new Dimension(180, 800));
      panel.setMaximumSize(new Dimension(180, 800));
      
      frame.add(panel);
      frame.getContentPane().add(panel);
      frame.setSize(700, 600);
      frame.setVisible(true);
    }
 public static void ground_frame(){
     JFrame frame = new JFrame("ground section");
      frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     JTextField ground_id = new JTextField(15);
     JTextField ground_name = new JTextField(15);
     JTextField slots = new JTextField(15);
     JTextField price = new JTextField(15);
    
     JPanel panel = new JPanel();
     panel.setBorder(BorderFactory.createTitledBorder("Ground Information: "));
     
     panel.add(new JLabel("  Ground ID: "));
     ground_id.setPreferredSize( new Dimension( 200,35 ) );
    
      panel.add(ground_id);
      
      panel.add(new JLabel("  Ground Name: "));
      ground_name.setPreferredSize( new Dimension( 200,35 ) );
     
      panel.add(ground_name);
      panel.add(new JLabel("  Slots: "));
      slots.setPreferredSize( new Dimension( 200,35 ) );
      panel.add(slots);
      panel.add(new JLabel("  Price: "));
      price.setPreferredSize( new Dimension( 200,35 ) );
   
      panel.add(price);
      
      
       panel.setAlignmentX(Component.CENTER_ALIGNMENT);
      panel.setPreferredSize(new Dimension(180, 800));
      panel.setMaximumSize(new Dimension(180, 800));
      
      frame.add(panel);
      frame.getContentPane().add(panel);
      frame.setSize(700, 600);
      frame.setVisible(true);
    }
  public static void add_booking(){
     JFrame frame = new JFrame("Booking section");
      frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     JTextField member_id = new JTextField(15);
     JTextField ground_id = new JTextField(15);
     JTextField slots = new JTextField(15);
     
    
     JPanel panel = new JPanel();
     panel.setBorder(BorderFactory.createTitledBorder("Ground Information: "));
     
     panel.add(new JLabel("  Ground ID: "));
     ground_id.setPreferredSize( new Dimension( 200,35 ) );
    
      panel.add(ground_id);
      
      panel.add(new JLabel("  member ID: "));
      member_id.setPreferredSize( new Dimension( 200,35 ) );
     
      panel.add(member_id);
      panel.add(new JLabel("  Enter Slots to book: "));
      slots.setPreferredSize( new Dimension( 200,35 ) );
      panel.add(slots);
      
      
       panel.setAlignmentX(Component.CENTER_ALIGNMENT);
      panel.setPreferredSize(new Dimension(180, 800));
      panel.setMaximumSize(new Dimension(180, 800));
      
      frame.add(panel);
      frame.getContentPane().add(panel);
      frame.setSize(700, 600);
      frame.setVisible(true);
    }
}
