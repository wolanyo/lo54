package fr.utbm.lo54.coursesmanager.core.Test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.utbm.lo54.coursesmanager.core.controller.CourseController;
import fr.utbm.lo54.coursesmanager.core.entity.Course;

public class CourseForm extends JFrame {

    private JPanel              container   = new JPanel();
    private JLabel              label       = new JLabel( "Une ComboBox" );

    private JLabel              labelCode   = new JLabel( "Code : " );
    private JFormattedTextField jtfCode     = new JFormattedTextField();

    private JLabel              labelTitle  = new JLabel( "Title : " );
    private JFormattedTextField jtfTitle    = new JFormattedTextField();

    private JButton             saveBoutton = new JButton( "OK" );

    public CourseForm() {
        this.setTitle( "Create a course" );
        this.setSize( 200, 500 );
        // this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        this.setLocationRelativeTo( null );
        container.setBackground( Color.white );
        container.setLayout( new BorderLayout() );

        Font police = new Font( "Arial", Font.BOLD, 14 );
        // jtf.setFont( police );
        jtfTitle.setPreferredSize( new Dimension( 150, 30 ) );
        jtfTitle.setForeground( Color.BLUE );
        jtfCode.setPreferredSize( new Dimension( 150, 30 ) );

        saveBoutton.addActionListener( new SaveBouttonListener() );

        JPanel top = new JPanel();

        top.add( labelCode );
        top.add( jtfCode );

        top.add( labelTitle );
        top.add( jtfTitle );

        top.add( saveBoutton );
        // container.add( top, BorderLayout.NORTH );
        this.setContentPane( top );
        // this.setContentPane( container );
        this.setVisible( true );
    }

    class SaveBouttonListener implements ActionListener {
        public void actionPerformed( ActionEvent e ) {
            Course course = new Course();
            course.setCode( jtfCode.getText() );
            course.setTitle( jtfTitle.getText() );
            CourseController courseController = new CourseController();
            courseController.saveCourse( course );
        }
    }

}
