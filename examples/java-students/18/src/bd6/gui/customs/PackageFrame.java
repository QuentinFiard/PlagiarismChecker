package bd6.gui.customs;

import bd6.Main;
import bd6.data.ControlStatus;
import bd6.data.Customs;
import bd6.data.Package;
import java.sql.Date;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

/**
 *
 * @author Grégoire Duchêne
 */
public class PackageFrame extends javax.swing.JFrame {
    protected Package pkg;
    protected TableModel packageContentsTableModel;

    /**
     * Creates new form PackageFrame
     */
    public PackageFrame(Package pkg) {
        if (pkg == null)
            throw new IllegalArgumentException(new NullPointerException());

        this.pkg = pkg;
        packageContentsTableModel = new PackageContentsTableModel(pkg.getContents());
        initComponents();

        if (!((Customs) Main.currentUser).getCountry().equals(pkg.getCountry())
            || pkg.getControlStatus() != ControlStatus.UNDETERMINED) {
            controlCommentTextArea.setEditable(false);
            acceptPackageButton.setEnabled(false);
            rejectPackageButton.setEnabled(false);
        }
    }

    public TableModel getPackageContentsTableModel() {
        return packageContentsTableModel;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        controlCommentTextArea = new javax.swing.JTextArea();
        closeButton = new javax.swing.JButton();
        acceptPackageButton = new javax.swing.JButton();
        rejectPackageButton = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        packageIdLabel = new javax.swing.JLabel();
        packageKindLabel = new javax.swing.JLabel();
        addressLabel = new javax.swing.JLabel();
        countryLabel = new javax.swing.JLabel();
        sentDateLabel = new javax.swing.JLabel();
        packerFullNameLabel = new javax.swing.JLabel();
        packerErrorRateLabel = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        packageValueLabel = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        controlStatusLabel = new javax.swing.JLabel();
        controlDateLabel = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Package Viewer");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        jLabel1.setText("General Information");

        jLabel2.setText("Package ID:");

        jLabel3.setText("Kind of package:");

        jLabel4.setText("Destination Address:");

        jLabel5.setText("Destination Country:");

        jLabel6.setText("Sent Date:");

        jLabel7.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        jLabel7.setText("Package Contents");

        jTable1.setModel(getPackageContentsTableModel());
        jScrollPane1.setViewportView(jTable1);

        jLabel8.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        jLabel8.setText("Control Information");

        jLabel9.setText("Control Date:");

        jLabel10.setText("Control Comment:");

        controlCommentTextArea.setColumns(20);
        controlCommentTextArea.setRows(5);
        controlCommentTextArea.setText(pkg.getControlComment());
        jScrollPane2.setViewportView(controlCommentTextArea);

        closeButton.setText("Close");
        closeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeButtonMouseClicked(evt);
            }
        });

        acceptPackageButton.setText("Accept Package");
        acceptPackageButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                acceptPackageButtonMouseClicked(evt);
            }
        });

        rejectPackageButton.setText("Reject Package");
        rejectPackageButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rejectPackageButtonMouseClicked(evt);
            }
        });

        jLabel11.setText("Packer's Name:");

        jLabel12.setText("Packer's Error Rate:");

        packageIdLabel.setText(Integer.toString(pkg.getId()));

        packageKindLabel.setText(pkg.getKind().toString());

        addressLabel.setText(pkg.getAddress());

        countryLabel.setText(pkg.getCountry());

        sentDateLabel.setText(pkg.getSentDate() == null ? "Not sent yet" : pkg.getSentDate().toString());

        packerFullNameLabel.setText(pkg.getPacker().getFullName());

        packerErrorRateLabel.setText(Integer.toString(pkg.getPacker().getErrorRate()) + '%');

        jLabel14.setText("Package Value:");

        packageValueLabel.setText("EUR " + Integer.toString(pkg.getValue()));

        jLabel13.setText("Control Status:");

        controlStatusLabel.setText(pkg.getControlStatus().toString());
        controlStatusLabel.setToolTipText("");

        controlDateLabel.setText(pkg.getControlDate() == null ? "Not controlled yet" : pkg.getControlDate().toString());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addComponent(jSeparator2)
                            .addComponent(packageIdLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(packageKindLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addressLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(countryLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sentDateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(packerFullNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(packerErrorRateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(packageValueLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(controlStatusLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(controlDateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(acceptPackageButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rejectPackageButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(closeButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(packageIdLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(packageKindLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(addressLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(countryLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(sentDateLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(packerFullNameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(packerErrorRateLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(packageValueLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(controlStatusLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(controlDateLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(closeButton)
                    .addComponent(rejectPackageButton)
                    .addComponent(acceptPackageButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeButtonMouseClicked
        PackageListFrame packageListFrame = new PackageListFrame();

        Main.centerFrame(packageListFrame);
        packageListFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_closeButtonMouseClicked

    private void acceptPackageButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_acceptPackageButtonMouseClicked
        if (!acceptPackageButton.isEnabled())
            return;

        String message = "Please confirm that this package is valid.";
        int confirmation = JOptionPane.showConfirmDialog(this, message,
                                                         "Confirmation",
                                                         JOptionPane.YES_NO_OPTION);

        if (confirmation != JOptionPane.OK_OPTION)
            return;

        pkg.setControlComment(controlCommentTextArea.getText());
        pkg.setControlDate(new Date(new java.util.Date().getTime()));
        pkg.setControlStatus(ControlStatus.OK);

        try {
            pkg.commit();
            pkg.getPacker().decrementErrorRate();
            pkg.getPacker().commit();
            message = "The package has been successfully updated!";
            JOptionPane.showMessageDialog(this, message, "Package Updated",
                                          JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException exception) {
            message = "A database error occurred.";
            System.err.println("Fatal Error:");
            exception.printStackTrace();
            JOptionPane.showMessageDialog(this, message, "Database Error",
                                          JOptionPane.ERROR_MESSAGE);

        } finally {
            closeButtonMouseClicked(null);
        }
    }//GEN-LAST:event_acceptPackageButtonMouseClicked

    private void rejectPackageButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rejectPackageButtonMouseClicked
        if (!rejectPackageButton.isEnabled())
            return;

        String message = "Please confirm that this package is invalid.";
        int confirmation = JOptionPane.showConfirmDialog(this, message,
                                                         "Confirmation",
                                                         JOptionPane.YES_NO_OPTION);

        if (confirmation != JOptionPane.OK_OPTION)
            return;

        pkg.setControlComment(controlCommentTextArea.getText());
        pkg.setControlDate(new Date(new java.util.Date().getTime()));
        pkg.setControlStatus(ControlStatus.KO);

        try {
            pkg.commit();
            pkg.getPacker().incrementErrorRate();
            pkg.getPacker().commit();
            message = "The package has been successfully updated!";
            JOptionPane.showMessageDialog(this, message, "Package Updated",
                                          JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException exception) {
            message = "A database error occurred.";
            System.err.println("Fatal Error:");
            exception.printStackTrace();
            JOptionPane.showMessageDialog(this, message, "Database Error",
                                          JOptionPane.ERROR_MESSAGE);

        } finally {
            closeButtonMouseClicked(null);
        }
    }//GEN-LAST:event_rejectPackageButtonMouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton acceptPackageButton;
    private javax.swing.JLabel addressLabel;
    private javax.swing.JButton closeButton;
    private javax.swing.JTextArea controlCommentTextArea;
    private javax.swing.JLabel controlDateLabel;
    private javax.swing.JLabel controlStatusLabel;
    private javax.swing.JLabel countryLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel packageIdLabel;
    private javax.swing.JLabel packageKindLabel;
    private javax.swing.JLabel packageValueLabel;
    private javax.swing.JLabel packerErrorRateLabel;
    private javax.swing.JLabel packerFullNameLabel;
    private javax.swing.JButton rejectPackageButton;
    private javax.swing.JLabel sentDateLabel;
    // End of variables declaration//GEN-END:variables
}
