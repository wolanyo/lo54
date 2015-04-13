package fr.utbm.lo54.coursesmanager.core.Test;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import fr.utbm.lo54.coursesmanager.core.controller.ClientController;
import fr.utbm.lo54.coursesmanager.core.controller.CourseSessionController;
import fr.utbm.lo54.coursesmanager.core.entity.Client;

public class ListeClient extends JFrame {

    private JTable       table;
    private ModeleClient modele;

    public ListeClient() {
        super();
        this.setTitle( "CLient List" );
        this.setSize( 500, 400 );
        this.setLocationRelativeTo( null );
        modele = new ModeleClient();
        table = new JTable( modele );
        getContentPane().add( new JScrollPane( table ), BorderLayout.CENTER );
        this.setVisible( true );
    }

    class ModeleClient extends AbstractTableModel {
        private static final long serialVersionUID = 1L;
        private final String[]    entetes          = {
                                                           "FIST NAME ", "LAST NAME", "EMAIL", "ID Session"
                                                           , "Code COURSE"
                                                           // ,"Location City",
                                                   };
        // CourseController courseController;
        // List<Course> courses;
        CourseSessionController   courseSessionController;
        ClientController          clientController;
        List<Client>              clients;

        public ModeleClient() {
            super();
            clientController = new ClientController();
            clients = clientController.showListClients();
        }

        public List<Client> getCourse() {
            return clients;
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
            return clients.size();
        }

        // retourner la valeur du tableau à la colonne et la ligne spécifiées
        public Object getValueAt( int rowIndex, int columnIndex ) {
            switch ( columnIndex ) {
            // case 0:
            // return clients.get( rowIndex ).getId();
            case 0:
                return clients.get( rowIndex ).getFirstName();
            case 1:
                return clients.get( rowIndex ).getLastName();
            case 2:
                return clients.get( rowIndex ).getEmail();
                // case 3:
                // return clients.get( rowIndex ).getAddress();
                // case 5:
                // return clients.get( rowIndex ).getPhone();
            case 3:
                return clients.get( rowIndex ).getCoursesession().getId();

            case 4:
                return clients.get( rowIndex ).getCoursesession().getCourse().getCode();

                // case 5: return
                // clients.get( rowIndex
                // ).getCoursesession().getLocation().getCity();

            default:
                throw new IllegalArgumentException();
            }
        }

    }

}
