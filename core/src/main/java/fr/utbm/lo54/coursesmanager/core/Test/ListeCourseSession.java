package fr.utbm.lo54.coursesmanager.core.Test;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import fr.utbm.lo54.coursesmanager.core.controller.CourseSessionController;
import fr.utbm.lo54.coursesmanager.core.entity.CourseSession;

public class ListeCourseSession extends JFrame {

    private JTable               table;
    private ModeleCoursesSession modele;

    public ListeCourseSession() {
        super();
        this.setTitle( "Courses Session List" );
        this.setSize( 500, 400 );
        this.setLocationRelativeTo( null );
        modele = new ModeleCoursesSession();
        table = new JTable( modele );
        getContentPane().add( new JScrollPane( table ), BorderLayout.CENTER );

        JButton RegisterBoutton = new JButton( "Register in selected Session" );
        RegisterBoutton.addActionListener( new RegisterBouttonListener() );
        this.getContentPane().add( RegisterBoutton, BorderLayout.SOUTH );

        this.setVisible( true );
    }

    public ListeCourseSession( String codeCourse ) {
        super();
        this.setTitle( "List of " + codeCourse + " Session " );
        this.setSize( 500, 400 );
        this.setLocationRelativeTo( null );
        modele = new ModeleCoursesSession( codeCourse );
        table = new JTable( modele );
        getContentPane().add( new JScrollPane( table ), BorderLayout.CENTER );

        JButton RegisterBoutton = new JButton( "Register in selected Session" );
        RegisterBoutton.addActionListener( new RegisterBouttonListener() );
        this.getContentPane().add( RegisterBoutton, BorderLayout.SOUTH );

        this.setVisible( true );
    }

    class RegisterBouttonListener implements ActionListener {
        public void actionPerformed( ActionEvent e ) {
            int selectedLine = table.getSelectedRow();
            Long SessionId = (Long) table.getValueAt( selectedLine, 0 );
            // ListeCourseSession fenSessions = new ListeCourseSession(
            // codeCourse );
            ClientForm fenClient = new ClientForm( SessionId );
        }
    }

    class ModeleCoursesSession extends AbstractTableModel {
        private static final long serialVersionUID = 1L;
        private final String[]    entetes          = { "ID", "CODE COURSE ", "LOCATION", "START DATE", "END DATE", };
        // CourseController courseController;
        // List<Course> courses;
        CourseSessionController   courseSessionController;
        List<CourseSession>       CourseSessions;

        public ModeleCoursesSession() {
            super();
            // courseController = new CourseController();
            // courses = courseController.showListCourses();
            courseSessionController = new CourseSessionController();
            CourseSessions = courseSessionController.showListCourseSessions();
        }

        public ModeleCoursesSession( String CodeCOURSE ) {
            super();
            // courseController = new CourseController();
            // courses = courseController.showListCourses();
            courseSessionController = new CourseSessionController();
            CourseSessions = courseSessionController.showCourseSessionsByCourse( CodeCOURSE );
        }

        public List<CourseSession> getCourse() {
            return CourseSessions;
        }

        // retourner le nombre de colonnes du tableau
        public int getColumnCount() {
            return entetes.length;
        }

        // doit retourner l'en-tête de la colonne spécifiée
        public String getColumnName( int columnIndex ) {
            return entetes[columnIndex];
        }

        // retourner le nombre de lignes du tableau
        public int getRowCount() {
            return CourseSessions.size();
        }

        // retourner la valeur du tableau à la colonne et la ligne spécifiées
        public Object getValueAt( int rowIndex, int columnIndex ) {
            switch ( columnIndex ) {
            case 0:
                return CourseSessions.get( rowIndex ).getId();
            case 1:
                return CourseSessions.get( rowIndex ).getCourse().getCode();
            case 2:
                return CourseSessions.get( rowIndex ).getLocation().getCity();
            case 3:
                return CourseSessions.get( rowIndex ).getStartdate();
            case 4:
                return CourseSessions.get( rowIndex ).getEnddate();
            default:
                throw new IllegalArgumentException();
            }
        }

        // public Class<?> getColumnClass( int columnIndex ) {
        // // Depending on the type of the column. Return data type;
        // switch ( columnIndex ) {
        // case 0:
        // return Date.class;
        // case 1:
        // return Date.class;
        // case 2:
        // return Course.class;
        // case 3:
        // return Location.class;
        // default:
        // return Object.class;
        // }
        // }
        // public Class<?> getColumnClass( int columnIndex ) {
        // On retourne le type de la cellule à la colonne demandée
        // On se moque de la ligne puisque les données sont les mêmes
        // On choisit donc la première ligne
        // return this.CourseSessions.get(0). [columnIndex].getClass();
        // }

    }

}
