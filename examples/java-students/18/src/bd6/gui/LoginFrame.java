/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bd6.gui;

import bd6.Main;
import bd6.data.Client;
import bd6.data.Customs;
import bd6.data.Manager;
import bd6.data.User;
import bd6.data.UserKind;
import bd6.gui.client.OrdersFrame;
import bd6.gui.customs.PackageListFrame;
import bd6.gui.manager.PeopleFrame;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Grégoire Duchêne
 */
public class LoginFrame extends javax.swing.JFrame {
    /**
     * Creates new form LoginFrame
     */
    public LoginFrame() {
        initComponents();

        if (Main.userName != null && Main.password != null) {
            userNameField.setText(Main.userName);
            passwordField.setText(Main.password);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        okButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        userNameField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Login");
        setResizable(false);

        okButton.setText("OK");
        okButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                okButtonMouseClicked(evt);
            }
        });

        exitButton.setText("Exit");
        exitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitButtonMouseClicked(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("User name:");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Password:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(userNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exitButton)
                    .addComponent(okButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitButtonMouseClicked
        System.exit(0);
    }//GEN-LAST:event_exitButtonMouseClicked

    private void okButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_okButtonMouseClicked
        String userName = userNameField.getText();
        String password = new String(passwordField.getPassword());

        try {
            UserKind kind = User.getKind(userName);

            if (kind == null) {
                String message = "This user does not exist!";
                JOptionPane.showMessageDialog(this, message, "Error",
                                              JOptionPane.WARNING_MESSAGE);
                return;
            }

            switch (kind) {
            case MANAGER:
                Manager manager = Manager.get(userName, password);

                if (manager == null) {
                    String message = "User name or password invalid.";
                    JOptionPane.showMessageDialog(this, message, "Error",
                                                  JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Main.currentUser = manager;

                PeopleFrame peopleFrame = new PeopleFrame();

                Main.centerFrame(peopleFrame);
                peopleFrame.setVisible(true);
                dispose();
                break;
            case CUSTOMS:
                Customs customs = Customs.get(userName, password);

                if (customs == null) {
                    String message = "User name or password invalid.";
                    JOptionPane.showMessageDialog(this, message, "Error",
                                                  JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Main.currentUser = customs;

                PackageListFrame packageListFrame = new PackageListFrame();

                Main.centerFrame(packageListFrame);
                packageListFrame.setVisible(true);
                dispose();
                break;

            case CLIENT:
                Client client = Client.get(userName, password);

                if (client == null) {
                    String message = "User name or password invalid";
                                        JOptionPane.showMessageDialog(this, message, "Error",
                                                  JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Main.currentUser = client;

                OrdersFrame ordersFrame = new OrdersFrame();

                Main.centerFrame(ordersFrame);
                ordersFrame.setVisible(true);
                dispose();
                break;
            case FIRED:
                String message = "You have been fired from the company,\n"
                                 + "and therefore cannot log in anymore.";

                JOptionPane.showMessageDialog(this, message, "Error",
                                              JOptionPane.ERROR_MESSAGE);
                break;
            }
        } catch (SQLException exception) {
            System.err.println("Fatal Error:");
            exception.printStackTrace();
            JOptionPane.showMessageDialog(this, "A database error occurred.",
                                          "Database Error",
                                          JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }//GEN-LAST:event_okButtonMouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton okButton;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JTextField userNameField;
    // End of variables declaration//GEN-END:variables
}
