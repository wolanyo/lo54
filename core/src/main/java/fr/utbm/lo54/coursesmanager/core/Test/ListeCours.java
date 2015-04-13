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

import fr.utbm.lo54.coursesmanager.core.controller.CourseController;
import fr.utbm.lo54.coursesmanager.core.entity.Course;

public class ListeCours extends JFrame {

    private JTable        table;
    // private CoursesModele modele;
    private ModeleCourses modele;

    // private JPanel container = new JPanel();

    public ListeCours() {
        super();
        this.setTitle( "Courses List" );
        this.setSize( 600, 600 );
        this.setLocationRelativeTo( null );
        // this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        // modele = new CoursesModele();
        modele = new ModeleCourses();
        table = new JTable( modele );
        this.table.setRowHeight( 30 );

        // getContentPane().add( table.getTableHeader(), BorderLayout.NORTH );
        this.getContentPane().add( new JScrollPane( table ), BorderLayout.CENTER );
        // this.add( container );
        JButton DetailBoutton = new JButton( "Show Sessions of selected Course" );
        DetailBoutton.addActionListener( new DetailBouttonListener() );
        this.getContentPane().add( DetailBoutton, BorderLayout.SOUTH );

        // rendre visible
        this.setVisible( true );
    }

    class DetailBouttonListener implements ActionListener {
        public void actionPerformed( ActionEvent e ) {
            int selectedLine = table.getSelectedRow();
            String codeCourse = (String) table.getValueAt( selectedLine, 0 );
            ListeCourseSession fenSessions = new ListeCourseSession( codeCourse );
        }
    }

    class ModeleCourses extends AbstractTableModel {
        private static final long serialVersionUID = 1L;
        private final String[]    entetes          = { "Code", "Titre " };
        CourseController          courseController;
        List<Course>              courses;

        public ModeleCourses() {
            super();
            courseController = new CourseController();
            courses = courseController.showListCourses();
        }

        public List<Course> getCourse() {
            return courses;
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
            return courses.size();
        }

        // retourner la valeur du tableau à la colonne et la ligne spécifiées
        public Object getValueAt( int rowIndex, int columnIndex ) {
            switch ( columnIndex ) {
            case 0:
                return courses.get( rowIndex ).getCode();
            case 1:
                return courses.get( rowIndex ).getTitle();
            default:
                throw new IllegalArgumentException();
            }
        }

        public Class<?> getColumnClass( int columnIndex ) {
            // Depending on the type of the column. Return data type;
            switch ( columnIndex ) {
            case 0:
            case 1:
                return String.class;

            default:
                return Object.class;
            }
        }

        // ajout et suppression de cours dans la liste
        public void addCourse( Course course ) {
            courses.add( course );
            fireTableRowsInserted( courses.size() - 1, courses.size() - 1 );
        }

        public void removeCourse( int rowIndex ) {
            courses.remove( rowIndex );
            fireTableRowsDeleted( rowIndex, rowIndex );
        }
    }

}
