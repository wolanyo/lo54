package fr.utbm.lo54.coursesmanager.core.Test;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import fr.utbm.lo54.coursesmanager.core.controller.LocationController;
import fr.utbm.lo54.coursesmanager.core.entity.Location;

public class ListeLocation extends JFrame {

    private JTable         table;
    private ModeleLocation modele;

    public ListeLocation() {
        super();
        this.setTitle( "Location List" );
        this.setSize( 300, 300 );
        this.setLocationRelativeTo( null );

        modele = new ModeleLocation();
        table = new JTable( modele );
        this.table.setRowHeight( 30 );

        this.getContentPane().add( new JScrollPane( table ), BorderLayout.CENTER );

        this.setVisible( true );
    }

    class ModeleLocation extends AbstractTableModel {
        private static final long serialVersionUID = 1L;
        private final String[]    entetes          = { "ID ", "CITY" };
        LocationController        locationController;
        List<Location>            Locations;

        public ModeleLocation() {
            super();
            locationController = new LocationController();
            Locations = locationController.showListLocations();
        }

        public List<Location> getCourse() {
            return Locations;
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
            return Locations.size();
        }

        // retourner la valeur du tableau à la colonne et la ligne spécifiées
        public Object getValueAt( int rowIndex, int columnIndex ) {
            switch ( columnIndex ) {
            case 0:
                return Locations.get( rowIndex ).getId();
            case 1:
                return Locations.get( rowIndex ).getCity();
            default:
                throw new IllegalArgumentException();
            }
        }

        public Class<?> getColumnClass( int columnIndex ) {
            // Depending on the type of the column. Return data type;
            switch ( columnIndex ) {
            case 0:
                return Long.class;
            case 1:
                return String.class;

            default:
                return Object.class;
            }
        }

    }

}
