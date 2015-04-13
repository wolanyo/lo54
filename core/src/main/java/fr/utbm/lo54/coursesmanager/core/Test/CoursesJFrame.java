package fr.utbm.lo54.coursesmanager.core.Test;

//import static java.awt.BorderLayout.CENTER;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CoursesJFrame extends JFrame {

    private static final long serialVersionUID = -6188817508920623384L;

    // private CoursesModele modele;

    // private FormulaireClient pan = new FormulaireClient();

    public CoursesJFrame() {
        super();
        setTitle( "Private Training courses manager" );
        setPreferredSize( new Dimension( 600, 100 ) );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        JPanel boutons = new JPanel();
        JButton addCoursebouton = new JButton( new AddCourseAction() );

        // JButton deletebouton = new JButton( "delete" );
        // deletebouton.setEnabled( false ); // Le bouton n'est plus cliquable
        // deletebouton.setPreferredSize( new Dimension( 150, 120 ) );

        JButton showlistbouton = new JButton( new ShowAction() );
        JButton showLocationbouton = new JButton( new ShowLocationAction() );
        JButton showClientbouton = new JButton( new ShowClientAction() );
        JButton showSessionbouton = new JButton( new ShowSessionAction() );
        // JButton addClientbouton = new JButton( new AddClientAction() );

        boutons.add( addCoursebouton );
        // boutons.add( deletebouton );
        boutons.add( showlistbouton );
        boutons.add( showLocationbouton );
        boutons.add( showSessionbouton );
        boutons.add( showClientbouton );
        // boutons.add( addClientbouton );

        getContentPane().add( boutons, BorderLayout.SOUTH );
        // getContentPane().add( pan, BorderLayout.CENTER );

        JPanel panel = new JPanel();
        // panel.setLayout( new FlowLayout() );
        JTextField textField = new JTextField();
        panel.add( textField );
        JLabel label = new JLabel( "Rien pour le moment" );
        panel.add( label );
        // getContentPane().add( textField, BorderLayout.SOUTH );
        // getContentPane().add( textField, BorderLayout.NORTH );

        pack();
    }

    // classe écoutant le bouton Ajouter Cours
    private class AddCourseAction extends AbstractAction {

        private static final long serialVersionUID = -2395542670670746658L;

        private AddCourseAction() {
            super( "add Course" );
        }

        public void actionPerformed( ActionEvent e ) {
            CourseForm form = new CourseForm();
            // CourseController courseController = new CourseController();
            // courseController.registerCoursefromConsoleInput();
            // modele.addCourse(
            // courseController.registerCoursefromConsoleInput() );
        }
    }

    // classe écoutant le bouton Ajouter Client
    // private class AddClientAction extends AbstractAction {
    //
    // private static final long serialVersionUID = 1L;
    //
    // private AddClientAction() {
    // super( "Add Client" );
    // }
    //
    // public void actionPerformed( ActionEvent e ) {
    // FormulaireClient form = new FormulaireClient();
    // // getContentPane().add( pan, BorderLayout.CENTER );
    // }
    // }

    // classe écoutant le bouton lister Cours
    private class ShowAction extends AbstractAction {

        private static final long serialVersionUID = 1L;

        private ShowAction() {
            super( "Course List" );
        }

        public void actionPerformed( ActionEvent e ) {
            ListeCours fenCourses = new ListeCours();
        }
    }

    // classe écoutant le bouton lister SEssion
    private class ShowSessionAction extends AbstractAction {

        private static final long serialVersionUID = 1L;

        private ShowSessionAction() {
            super( "Session List " );
        }

        public void actionPerformed( ActionEvent e ) {
            ListeCourseSession fenSessions = new ListeCourseSession();
            // ListeCourseSession fenSessions = new ListeCourseSession( "BD40"
            // );
        }
    }

    private class ShowClientAction extends AbstractAction {

        private static final long serialVersionUID = 1L;

        private ShowClientAction() {
            super( "Client List " );
        }

        public void actionPerformed( ActionEvent e ) {
            ListeClient fenClient = new ListeClient();
            // ListeCourseSession fenSessions = new ListeCourseSession( "BD40"
            // );
        }
    }

    private class ShowLocationAction extends AbstractAction {
        private static final long serialVersionUID = 1L;

        private ShowLocationAction() {
            super( "Location List" );
        }

        public void actionPerformed( ActionEvent e ) {
            ListeLocation fen = new ListeLocation();
        }
    }

    // classe écoutant le bouton lister Session d'un Cours
    // private class ShowSessionsAction extends AbstractAction {
    //
    // private ShowSessionsAction() {
    // super( "Lister" );
    // }
    //
    // public void actionPerformed( ActionEvent e ) {
    // Fenetre fen = new Fenetre();
    // }
    // }

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
