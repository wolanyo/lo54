package fr.utbm.lo5.courssmanage.core.Test;

import java.util.Set;

import javax.swing.table.AbstractTableModel;

import fr.utbm.lo54.coursesmanager.core.entity.Course;
import fr.utbm.lo54.coursesmanager.core.service.CourseService;

public class NotesModele extends AbstractTableModel {

    private final String[] entetes = { "Code", "Titre " };

    // private List<Course> notes;
    private Set<Course>    notes;

    // private NoteService noteService;
    private CourseService  courseService;

    // private List<NoteEleve> notes;

    public NotesModele() {
        super();
        // noteService = NoteService.getInstance();
        courseService = new CourseService();
        notes = courseService.getListCOurse();

    }

    public Set<Course> getCourse() {
        return notes;
    }

    public int getColumnCount() {
        return entetes.length;
    }

    public String getColumnName( int columnIndex ) {
        return entetes[columnIndex];
    }

    public int getRowCount() {
        return notes.size();
    }

    public Object getValueAt( int rowIndex, int columnIndex ) {
        switch ( columnIndex ) {

        case 0:
            // return notes.get( rowIndex ).getEleve().getNom();
        case 1:
            // return notes.get( rowIndex ).getEleve().getPrenom();

        default:
            throw new IllegalArgumentException();
        }
    }

    public Class<?> getColumnClass( int columnIndex ) {
        switch ( columnIndex ) {
        case 0:
        case 1:
            return String.class;

        default:
            return Object.class;
        }
    }

}
