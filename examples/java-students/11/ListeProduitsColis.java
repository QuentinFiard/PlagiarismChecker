package Douane;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import javax.swing.*;

import General.Connexion;


public class ListeProduitsColis extends JFrame implements ActionListener{

	protected JTable table;
	protected JScrollPane scroll;
	private JPanel jp;
	private JButton fermer = new JButton("fermer");
	
	protected static final long serialVersionUID = 1L;

	
	
	public ListeProduitsColis(int id){
		//super();
		
		this.setTitle("Liste des produits colis");
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		
		ListeProduitColis(id);
	}

	public void ListeProduitColis(int id){


		try {

			Connexion connec = new Connexion(Connexion.log,Connexion.password);
			ResultSet rs = connec.listerProduitColis(id);


			if(rs.next()){	

				rs.previous();

		

				String[] nomColonnes = { "num_produit"};

				LinkedList<Object[]> liste = new LinkedList<Object[]>();
				Object[][] donnees;


				while(rs.next()){
					Object[] data = new Object[8];

					data[0] = rs.getString(1);

					liste.add(data);
				}

				donnees = new Object[liste.size()][];


				for(int i=0; i<donnees.length; i++){
					donnees[i] = liste.get(i);
				}

				table = new JTable(donnees, nomColonnes);


				jp = new JPanel();
				
				jp.setLayout(new BorderLayout());
				jp.add(table.getTableHeader(), BorderLayout.PAGE_START);
				scroll = new JScrollPane(table);
				
				jp.add(scroll, BorderLayout.CENTER);

				jp.setVisible(true);
				jp.setSize(800, 700);

				
				fermer.addActionListener(this);
				JPanel panel = new JPanel(new BorderLayout());
				panel.add(jp, BorderLayout.CENTER);
				panel.add(fermer, BorderLayout.SOUTH);
				this.setContentPane(panel);
				this.setVisible(true);
			}
			
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public JTable getTable(){
		return table;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() ==  fermer){
			this.dispose();
		}
		
	}
	

	
}
