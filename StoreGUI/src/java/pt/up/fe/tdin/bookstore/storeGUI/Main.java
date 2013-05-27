/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.up.fe.tdin.bookstore.storeGUI;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.xml.ws.WebServiceRef;
import pt.up.fe.tdin.bookstore.store.*;
/**
 *
 * @author Joao
 */
public class Main extends java.awt.Frame {
    @WebServiceRef(wsdlLocation = "META-INF/wsdl/localhost_8080/myWebService/myWebService.wsdl")
    private static MyWebService_Service service;
    private List<Book> bookList;
    
    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();  
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        bookList = new ArrayList();
        bookList = getBookList();

        Vector columnNames = new Vector();
        columnNames.add("Title");
        columnNames.add("Unit price");
        columnNames.add("Stock");

        Vector data = new Vector();
        for (Book b: bookList) {
            Vector myRow = new Vector();
            myRow.add(b.getTitle());
            myRow.add(b.getPrice());
            myRow.add(b.getAvailability());
            data.add(myRow);
        }
        jTable1 = new javax.swing.JTable(data, columnNames);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Exit the Application
     */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        System.exit(0);
    }//GEN-LAST:event_exitForm

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    private List<Book> getBookList() {
        MyWebService port = service.getMyWebServicePort();
        return port.getBookList();
    }
}
