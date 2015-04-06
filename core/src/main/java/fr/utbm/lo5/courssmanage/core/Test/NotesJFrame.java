package fr.utbm.lo5.courssmanage.core.Test;

import static java.awt.BorderLayout.CENTER;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class NotesJFrame extends JFrame {

    /**
     * 
     */
    private static final long serialVersionUID = -6188817508920623384L;

    private NotesModele       modele;
    private JTable            table;

    public NotesJFrame() {
        super();
        setTitle( "Notes des élèves" );
        setPreferredSize( new Dimension( 500, 400 ) );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        modele = new NotesModele();

        table = new JTable( modele );
        table.setAutoCreateRowSorter( true );
        // table.setDefaultRenderer(Sexe.class, new SexeCellRenderer());
        // table.getColumnModel().getColumn( 4 ).setCellRenderer( new
        // NoteCellRenderer() );

        getContentPane().add( new JScrollPane( table ), CENTER );

        pack();
    }
}
