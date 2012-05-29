package bd6.gui.manager;

import bd6.Main;
import bd6.data.Item;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class TopSellsFrame extends javax.swing.JFrame {
    /**
     * Creates new form TopSellsFrame
     */
    public TopSellsFrame() {
        try {
            String[] tops = Item.getTopSells();

            initComponents();
            top1Label.setText(tops[0]);
            top2Label.setText(tops[1]);
            top3Label.setText(tops[2]);
            top4Label.setText(tops[3]);
            top5Label.setText(tops[4]);
            top6Label.setText(tops[5]);
            top7Label.setText(tops[6]);
            top8Label.setText(tops[7]);
            top9Label.setText(tops[8]);
            top10Label.setText(tops[9]);
        } catch (SQLException exception) {
            String message = "Error while fetching the top sells.";

            System.err.println("Fatal Error:");
            exception.printStackTrace();
            JOptionPane.showMessageDialog(null, message, "Database Error",
                                          JOptionPane.ERROR_MESSAGE);
            System.exit(1);
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

        top1Label = new javax.swing.JLabel();
        top2Label = new javax.swing.JLabel();
        top6Label = new javax.swing.JLabel();
        top3Label = new javax.swing.JLabel();
        top4Label = new javax.swing.JLabel();
        top7Label = new javax.swing.JLabel();
        top5Label = new javax.swing.JLabel();
        top8Label = new javax.swing.JLabel();
        top10Label = new javax.swing.JLabel();
        top9Label = new javax.swing.JLabel();
        closeButton = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Top Sells");
        setResizable(false);

        top1Label.setText("jLabel1");

        top2Label.setText("jLabel1");

        top6Label.setText("jLabel1");

        top3Label.setText("jLabel1");

        top4Label.setText("jLabel1");

        top7Label.setText("jLabel1");

        top5Label.setText("jLabel1");

        top8Label.setText("jLabel1");

        top10Label.setText("jLabel1");

        top9Label.setText("jLabel1");

        closeButton.setText("Close");
        closeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeButtonMouseClicked(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        jLabel11.setText("Top Sells");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(top10Label, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                    .addComponent(top9Label, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
                    .addComponent(top8Label, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
                    .addComponent(top2Label, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
                    .addComponent(top3Label, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
                    .addComponent(top4Label, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
                    .addComponent(top5Label, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
                    .addComponent(top6Label, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
                    .addComponent(top7Label, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(top1Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(top1Label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(top2Label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(top3Label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(top4Label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(top5Label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(top6Label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(top7Label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(top8Label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(top9Label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(top10Label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(closeButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeButtonMouseClicked
        PeopleFrame peopleFrame = new PeopleFrame();

        Main.centerFrame(peopleFrame);
        peopleFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_closeButtonMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeButton;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel top10Label;
    private javax.swing.JLabel top1Label;
    private javax.swing.JLabel top2Label;
    private javax.swing.JLabel top3Label;
    private javax.swing.JLabel top4Label;
    private javax.swing.JLabel top5Label;
    private javax.swing.JLabel top6Label;
    private javax.swing.JLabel top7Label;
    private javax.swing.JLabel top8Label;
    private javax.swing.JLabel top9Label;
    // End of variables declaration//GEN-END:variables
}