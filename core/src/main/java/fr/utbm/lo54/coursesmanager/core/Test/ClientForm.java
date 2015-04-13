package fr.utbm.lo54.coursesmanager.core.Test;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu.Separator;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import net.miginfocom.layout.AC;
import net.miginfocom.layout.CC;
import net.miginfocom.layout.LC;
import net.miginfocom.swing.MigLayout;
import fr.utbm.lo54.coursesmanager.core.controller.ClientController;
import fr.utbm.lo54.coursesmanager.core.controller.CourseSessionController;
import fr.utbm.lo54.coursesmanager.core.entity.Client;
import fr.utbm.lo54.coursesmanager.core.entity.CourseSession;

public class ClientForm extends JFrame {

    CourseSession      courseSession  = new CourseSession();

    private JLabel     labelLastname  = new JLabel( "Last Name" );
    private JTextField jtfLastname    = new JTextField( 15 );
    private JLabel     labelFirstname = new JLabel( "First Name" );
    private JTextField jtfFirstname   = new JTextField( 15 );

    private JLabel     labelAdress    = new JLabel( "Adress" );
    private JTextField jtfAdress      = new JTextField( 25 );

    private JLabel     labelEmail     = new JLabel( "Email" );
    private JTextField jtfEmail       = new JTextField( 10 );

    private JLabel     labelPhone     = new JLabel( "Phone" );
    // private JFormattedTextField jtfPhone = new JFormattedTextField();
    private JTextField jtfPhone       = new JTextField( 10 );

    private Separator  sep            = new Separator();

    JButton            ButtonSave     = new JButton( "Save" );

    LC                 layC           = new LC().fill().wrap();
    AC                 colC           = new AC().align( "right", 0 ).fill( 1, 3 ).grow( 100, 1, 3 )
                                              .align( "right", 2 ).gap( "15", 1 );
    AC                 rowC           = new AC().index( 6 ).gap( "15!" ).align( "top" ).grow( 100, 8 );
    MigLayout          myLayout       = new MigLayout( layC, colC, rowC );
    JPanel             p              = new JPanel( myLayout );

    public ClientForm( Long SessionId ) {

        CourseSessionController courseSessionController = new CourseSessionController();
        courseSession = courseSessionController.showCourseSessionsByid( SessionId );

        this.setTitle( "Register Client in a session course" );
        this.setSize( 600, 300 );
        // this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        this.setVisible( true );

        // p.add( labelLastname, "gap para" );
        // p.add( jtfLastname, "span, growx, wrap" );
        // p.add( labelFirstnam, "gap para" );
        // p.add( jtfFirstnam, "span, growx, wrap para" );

        JLabel labelClient = new JLabel( "User info" );
        labelClient.setFont( new Font( "Tahoma", Font.BOLD, 11 ) );
        // labelClient.setBackground( Color.red );
        labelClient.setForeground( Color.blue );
        JSeparator separatorClient = new JSeparator();
        separatorClient.setBackground( Color.blue );
        p.add( labelClient );
        p.add( separatorClient, "growx, wrap" );

        p.add( labelLastname );
        p.add( jtfLastname );
        p.add( labelFirstname );
        p.add( jtfFirstname, new CC().wrap() );
        p.add( labelPhone );
        p.add( jtfPhone );
        p.add( labelEmail );
        p.add( jtfEmail );
        p.add( labelAdress );
        p.add( jtfAdress, new CC().spanX().growX() );

        // p.add( labelAdress, "gap para" );
        // p.add( jtfAdress, "span, growx, wrap para" );
        // p.add( labelEmail, "gap para" );
        // p.add( jtfEmail, "span,growx, wrap para" );
        // p.add( labelPhone, "gap para" );
        // p.add( jtfPhone, "span, wrap para" );

        JLabel labelSession = new JLabel( "Course Session" );
        labelSession.setFont( new Font( "Tahoma", Font.BOLD, 11 ) );
        labelSession.setForeground( Color.blue );
        JSeparator separatorSession = new JSeparator();
        separatorSession.setBackground( Color.blue );
        p.add( labelSession );
        p.add( separatorSession, "growx, wrap" );

        DateFormat df = new SimpleDateFormat( "MM/dd/yyyy HH:mm:ss" );
        String Startdate = df.format( courseSession.getStartdate() );
        String Enddate = df.format( courseSession.getEnddate() );
        JLabel labelStartDate = new JLabel( "Start date" );
        JTextField jtfStartDate = new JTextField( Startdate );
        JLabel labelEndDate = new JLabel( "End date" );
        JTextField jtfEndDate = new JTextField( Enddate );

        JLabel labelCourseCode = new JLabel( "Course code" );
        JTextField jtfCourseCode = new JTextField( courseSession.getCourse().getCode() );
        JLabel labelCourseLocation = new JLabel( "Course Location" );
        // JTextField jtfCourseLocation = new JTextField(
        // courseSession.getLocation().getCity() );
        // System.out.println( courseSession.getLocation().getCity() );
        JTextField jtfCourseLocation = new JTextField();

        // JFormattedTextField jtfEndDate = new JFormattedTextField(
        // DateFormat.getDateInstance() );

        jtfStartDate.setEnabled( false );
        jtfEndDate.setEnabled( false );
        jtfCourseCode.setEnabled( false );
        jtfCourseLocation.setEnabled( false );

        p.add( labelStartDate, "gap para" );
        p.add( jtfStartDate );
        p.add( labelEndDate, "gap para" );
        p.add( jtfEndDate, "wrap" );

        labelCourseCode.setFont( new Font( "Tahoma", Font.BOLD, 11 ) );
        p.add( labelCourseCode, "gap para" );
        p.add( jtfCourseCode );
        p.add( labelCourseLocation, "gap para" );
        p.add( jtfCourseLocation, "wrap" );

        JSeparator sep = new JSeparator();
        sep.setForeground( Color.green ); // top line color
        sep.setBackground( Color.green.brighter() ); // bottom line color
        p.add( sep, "growx, wrap" );

        ButtonSave.addActionListener( new SaveBouttonListener() );
        // p.add( ButtonSave, "gap para" );
        p.add( ButtonSave, new CC().spanX( 5 ).split( 5 ).tag( "other" ) );
        p.add( new JButton( "Cancel" ), new CC().tag( "other" ) );

        // tabbedPane.addTab( "Client Form", p );
        this.add( p );
    }

    // Classe interne implémentant l'interface ItemListener

    // public static void main( String[] args ) {
    // ClientForm c = new ClientForm(courseSession crs);
    // c.setVisible( true );

    // }

    class SaveBouttonListener implements ActionListener {
        public void actionPerformed( ActionEvent e ) {
            Client client = new Client();
            client.setFirstName( jtfFirstname.getText() );
            client.setLastName( jtfLastname.getText() );
            client.setAddress( jtfAdress.getText() );
            client.setPhone( jtfPhone.getText() );
            client.setEmail( jtfEmail.getText() );
            client.setCoursesession( courseSession );

            ClientController clientController = new ClientController();
            ClientController.saveClient( client );
        }
    }

}
