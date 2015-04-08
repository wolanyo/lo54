package fr.utbm.lo5.coursesmanage.core.Test;

//import static java.awt.BorderLayout.CENTER;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import fr.utbm.lo54.coursesmanager.core.controller.CourseController;

public class CoursesJFrame extends JFrame {

    private static final long serialVersionUID = -6188817508920623384L;

    private JTable            table;
    private CoursesModele     modele;

    public CoursesJFrame() {
        super();
        setTitle( "Liste des Cours" );
        setPreferredSize( new Dimension( 500, 400 ) );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        modele = new CoursesModele();
        table = new JTable( modele );

        // table.setAutoCreateRowSorter( true ); // trier le tableau

        // getContentPane().add( table.getTableHeader(), BorderLayout.NORTH );
        getContentPane().add( new JScrollPane( table ), BorderLayout.CENTER );

        JPanel boutons = new JPanel();
        JButton addbouton = new JButton( new AddAction() );
        JButton deletebouton = new JButton( "delete" );
        boutons.add( addbouton );
        boutons.add( deletebouton );
        getContentPane().add( boutons, BorderLayout.SOUTH );

        JPanel panel = new JPanel();
        // panel.setLayout( new FlowLayout() );
        JTextField textField = new JTextField();
        panel.add( textField );
        JLabel label = new JLabel( "Rien pour le moment" );
        panel.add( label );
        // getContentPane().add( textField, BorderLayout.SOUTH );
        getContentPane().add( textField );

        pack();
    }

    private class AddAction extends AbstractAction {

        private static final long serialVersionUID = -2395542670670746658L;

        private AddAction() {
            super( "Ajouter" );
        }

        public void actionPerformed( ActionEvent e ) {
            CourseController courseController = new CourseController();
            courseController.registerCoursefromConsoleInput();
            modele.addCourse( courseController.registerCoursefromConsoleInput() );
        }
    }

    // private class RemoveAction extends AbstractAction {
    // private RemoveAction() {
    // super( "Supprimmer" );
    // }
    //
    // public void actionPerformed( ActionEvent e ) {
    // int[] selection = tableau.getSelectedRows();
    //
    // for ( int i = selection.length - 1; i >= 0; i-- ) {
    // modele.removeAmi( selection[i] );
    // }
    // }
    // }

}
