package fr.utbm.lo5.coursesmanage.core.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import fr.utbm.lo54.coursesmanager.core.entity.Course;
import fr.utbm.lo54.coursesmanager.core.service.CourseService;

/**
 * 
 * @author Malick - Modèle de JTable
 */
public class CoursesModele extends AbstractTableModel {

    private static final long  serialVersionUID = 3577938988963323655L;

    private final String[]     entetes          = { "Code", "Titre " };

    private CourseService      courseService;
    private final List<Course> courses          = new ArrayList<Course>();

    // private final HashSet<Course> data;

    public CoursesModele() {
        super();
        courseService = new CourseService();
        Iterator<Course> it = courseService.getListCOurse().iterator();
        while ( it.hasNext() ) {
            Course crs = (Course) it.next();
            courses.add( crs );
        }
    }

    // public List<Course> getCourse() {
    // return courses;
    // }

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
    // Get row Values here;
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
