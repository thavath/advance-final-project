package AdvanceProject.HotelReservation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.awt.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

/**
 * Hello world!
 *
 */
public class App extends JFrame implements ActionListener
{
	JMenuBar menuBar;
	JMenu mFile, mTable, mFood, mReservation, mOrder, mHelp;
	// For Menu File
	JMenuItem mItemNew, mItemSave, mItemExit, mItemEdit;
	// For Menu Table Mgt
	JMenuItem mItemNewTable, mItemListTable;
	// For Menu Food
	JMenuItem mItemNewFood, mItemListFood;
	// For Menu Order
	JMenuItem mItemListOrder, mItemTakeOrder;
	// For Menu Reservation;
	JMenuItem mItemTakeReservation, mItemReservationList;
	// For Menu Help;
	JMenuItem mItemWelcome, mItemHelpContents, mItemCheckUpdate, mItemAbout;
	// JTree
	JTree jTreeRestaurant;
	
	JTabbedPane jTab;
	
	// Table Item
	JButton btnTableSave, btnTableClear, btnTableEdit, btnTableDelete, btnTableUpdate;
	JTextField txtTableID, txtTableSeats, txtTableStatus;
	// Food Button
	JButton btnFoodSave, btnFoodClear, btnFoodEdit, btnFoodDelete, btnFoodUpdate;
	
	// Order Button
	JButton btnOrderSave, btnOrderClear, btnOrderEdit, btnOrderDelete, btnOrderUpdate;
	
	// Reservation Button
	JButton btnReservationSave, btnReservationClear, btnReservationEdit, btnReservationDelete, btnReservationUpdate;
	
	public App() {
		
		mItemNew = new JMenuItem("New");
		mItemExit = new JMenuItem("Exit");
		mItemSave = new JMenuItem("Save");
		mItemEdit = new JMenuItem("Edit");
		//Create object Menu File and add its items
		mFile = new JMenu("File");
		mFile.add(mItemNew);
		mFile.add(mItemEdit);

		mFile.add(new JSeparator());
		mFile.add(mItemSave);
		mFile.add(mItemExit);
		//==========================END MENU FILE =====================/
		
		//Create Object Menu Item of Table Mgt
		mItemNewTable = new JMenuItem("New Table");
		mItemNewTable.addActionListener(this);
		mItemListTable = new JMenuItem("List Table");
		mItemListTable.addActionListener(this);
		
		//Create Object Menu Table Mgt and add its items
		mTable = new JMenu("Table Info");
		mTable.add(mItemNewTable);
		mTable.add(mItemListTable);
		//==========================END MENU Table ==================/
		
		//Create Object Menu Item of Food
		mItemNewFood = new JMenuItem("New Food");
		mItemNewFood.addActionListener(this);

		mItemListFood = new JMenuItem("List Food");
		mItemListFood.addActionListener(this);
		
		
		//Create Object Menu Report add add its items
		mFood = new JMenu("Food Info");
		mFood.add(mItemNewFood);
		mFood.add(mItemListFood);
		
		// ==========================================================
		mItemTakeOrder = new JMenuItem("Take Order");
		mItemTakeOrder.addActionListener(this);
		mItemListOrder = new JMenuItem("List Order");
		mItemListOrder.addActionListener(this);
		mOrder = new JMenu("Order");
		mOrder.add(mItemTakeOrder);
		mOrder.add(mItemListOrder);
		
		//=========================END MENU Food ======================/
		//Create Object Menu item of Order Rule
		mItemTakeReservation = new JMenuItem("Take Reservation");
		mItemTakeReservation.addActionListener(this);
		mItemReservationList = new JMenuItem("List Reservation");
		mItemReservationList.addActionListener(this);
		//Create Object menu reservation list and add its items
		mReservation = new JMenu("Reservation");
		mReservation.add(mItemTakeReservation);
		mReservation.add(mItemReservationList);
		//==========================END MENU Reservation===================/
		//Create Object Menu Item of Help
		mItemWelcome = new JMenuItem("Welcome");
		mItemHelpContents = new JMenuItem("Help Contents");		
		mItemCheckUpdate = new JMenuItem("Check Update");
		mItemAbout = new JMenuItem("About Restaurant Reservation");
		//Create Object Menu Help and add its items
		mHelp = new JMenu("Help");
		mHelp.add(mItemWelcome);
		mHelp.add(mItemHelpContents);
		mHelp.add(new JSeparator());
		mHelp.add(mItemCheckUpdate);
		mHelp.add(mItemAbout);
		//==========================END MENU HELP======================/
		//Create object menu bar and add its menus
		menuBar = new JMenuBar();
		menuBar.add(mFile); //Add File
		menuBar.add(mTable); //Add Table
		menuBar.add(mFood); //Add Food
		menuBar.add(mOrder); //Add Order
		menuBar.add(mReservation); //Add Reservation
		menuBar.add(mHelp); // Add Help
		//=========================END MENU BAR======================/

		//Left Section as Tree
		JTree leftJTree = createJTree();
		//Right Section as Tab Panel
		jTab = new JTabbedPane();
		
		JSplitPane jsp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, leftJTree, jTab);
		jsp.setDividerLocation(180);
		add(menuBar);
		add(jsp);
		setTitle("Restaurant Reservation Management");
		setJMenuBar(menuBar);
		setExtendedState(MAXIMIZED_BOTH);
		setVisible(true);
		
	}
	
	private JPanel openTableSection_NewTable(JPanel tableNew) {
		// Create Group Box - New Employee
		TitledBorder tBorderNewTable = BorderFactory.createTitledBorder("CREATE NEW TABLE");
		tBorderNewTable.setTitleJustification(TitledBorder.CENTER);
		tableNew.setBorder(tBorderNewTable);
		//Create Block All Info
		JPanel blockTableInfo = new JPanel(new GridLayout(4,2));
//		JPanel blockEmpInfo = new JPanel(new GridLayout(6,2,10,10));
		blockTableInfo.add(new JLabel("Table ID :"));
		blockTableInfo.add(txtTableID = new JTextField(12));

		blockTableInfo.add(new JLabel());
		blockTableInfo.add(new JLabel());
		
		blockTableInfo.add(new JLabel("Total Seats:"));
		blockTableInfo.add(txtTableSeats = new JTextField(12));

		blockTableInfo.add(new JLabel());
		blockTableInfo.add(new JLabel());
		// Create Block Employee Info - FINAL
		JPanel blockAllInfo = new JPanel(new GridLayout(3,1));
		blockAllInfo.add(new JLabel("Create New Table"));
		blockAllInfo.add(new JSeparator());
		blockAllInfo.add(blockTableInfo);
		//Create Block All Info - FINAL
		JPanel blockAllInfo_FINAL = new JPanel(new GridLayout(3,1));
		blockAllInfo_FINAL.add(blockAllInfo);
		blockAllInfo_FINAL.add(new JSeparator());
		// Button FlowLayout
		//=============================================
		JPanel actionBtnPanel = new JPanel(new FlowLayout());
		actionBtnPanel.add(btnTableSave = new JButton("SAVE"));
		btnTableSave.addActionListener(this);
		actionBtnPanel.add(btnTableClear = new JButton("CLEAR"));
		//=============================================
		blockAllInfo_FINAL.add(actionBtnPanel);
		return blockAllInfo_FINAL;
	}
	
	
	private void openTableSection() {
		JPanel tablePanel = new JPanel(new GridLayout(1,2));
		JPanel tableList = new JPanel(new BorderLayout(10,10));
		JPanel tableNew = new JPanel(new CardLayout(10,10));

		tableNew.add(openTableSection_NewTable(tableNew));
		tableList.add(new JLabel("Hello List "));
//		tableList.add(openTableSection_ListTable(tableList));

		tablePanel.add(new JScrollPane(tableNew));
		tablePanel.add(new JScrollPane(tableList));
		
		jTab.addTab("Table Information", tablePanel);
		jTab.setSelectedComponent(tablePanel);
	}
	
	private JTree createJTree() {
		//JPanel leftPanel = new JPanel();
		// Create Tree Root Node
		DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("Root Node");
		// Create Tree Node Employee Mgt
		DefaultMutableTreeNode nodeTable = new DefaultMutableTreeNode("Table Info");
		// Create Tree Node Add Employee
		DefaultMutableTreeNode nodeNewTable = new DefaultMutableTreeNode("New Table");
		// Create Tree Node List Employee
		DefaultMutableTreeNode nodeListTable = new DefaultMutableTreeNode("List Table");
		nodeTable.add(nodeNewTable);
		nodeTable.add(nodeListTable);
		// ============= End of Table Section ===============================//
		
		// Create Tree Node Food
		DefaultMutableTreeNode nodeFood = new DefaultMutableTreeNode("Food Info");
		// Create Tree Node New Food
		DefaultMutableTreeNode nodeNewFood = new DefaultMutableTreeNode("New Food");
		// Create Tree Node List Food
		DefaultMutableTreeNode nodeListFood = new DefaultMutableTreeNode("List Food");
		
		//================================END TREE NODE of Food Info=========//
		nodeFood.add(nodeNewFood);
		nodeFood.add(nodeListFood);
		
		// Create Tree Node Order
		DefaultMutableTreeNode nodeOrder = new DefaultMutableTreeNode("Order Info");
		// Create Tree Node New Food
		DefaultMutableTreeNode nodeNewOrder = new DefaultMutableTreeNode("Take Order");
		// Create Tree Node List Food
		DefaultMutableTreeNode nodeListOrder = new DefaultMutableTreeNode("List Order");
		nodeOrder.add(nodeNewOrder);
		nodeOrder.add(nodeListOrder);
		
		//================================ END TREE NODE of Order =========//
		
		// Create Tree Node Reservation
		DefaultMutableTreeNode nodeReservation = new DefaultMutableTreeNode("Reservation");
		// Create Tree Node Take Reservation
		DefaultMutableTreeNode nodeTakeReservation = new DefaultMutableTreeNode("Take Reservation");
		// Create Tree Node List Reservation
		DefaultMutableTreeNode nodeReservationList = new DefaultMutableTreeNode("List Reservation");
		nodeReservation.add(nodeTakeReservation);
		nodeReservation.add(nodeReservationList);
		//================================ END TREE NODE of Reservation =========//
		
		rootNode.add(nodeTable);
		rootNode.add(nodeFood);
		rootNode.add(nodeOrder);
		rootNode.add(nodeReservation);
		
		// Create object of JTree Restaurant Management
		jTreeRestaurant = new JTree(rootNode);
		jTreeRestaurant.setRowHeight(25);
		jTreeRestaurant.setRootVisible(false);
		jTreeRestaurant.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		// Add mouse listener to tree
		jTreeRestaurant.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				// Find selected node of tree
				int selectedNode = jTreeRestaurant.getRowForLocation(e.getX(), e.getY());
				// Condition when mouse pressed on a specific node
				if(selectedNode != -1) {
					// When mouse pressed is double clicked
					if(e.getClickCount() == 2) {
						//Get for whole tree path
						TreePath treePath = jTreeRestaurant.getPathForLocation(e.getX(), e.getY());
						//Get last selected tree path
						String lastSelectedPath = treePath.getLastPathComponent().toString();
						if(lastSelectedPath.equals("New Table")) {
							openTableSection();
						}else if (lastSelectedPath.equals("List Table")) {
							openTableSection();
						}else if (lastSelectedPath.equals("New Food")) {
//							performOpenTaxReport();
						}else if (lastSelectedPath.equals("List Food")) {
//							performOpenTaxRule2018();
						}else if (lastSelectedPath.equals("Take Order")) {
//							performOpenTaxCalculator();
						}else if (lastSelectedPath.equals("List Order")) {
//							performOpenTaxCalculator();
						}else if (lastSelectedPath.equals("Take Reservation")) {
//							performOpenTaxCalculator();
						}else if (lastSelectedPath.equals("List Reservation")) {
//							performOpenTaxCalculator();
						}
						
					}
				}
			}
		});
		// Expand all tree nodes
		for(int i =0; i<=jTreeRestaurant.getRowCount(); i++)
			jTreeRestaurant.expandRow(i);
		// Add tree to panel
		//leftPanel.add(jTreeEmp);
		return jTreeRestaurant;
	}
	// ActionPerformed for JMENUBar
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == mItemNewTable) {
			openTableSection();
		}else if (e.getSource() == mItemListTable) {
			openTableSection();
		}else if (e.getSource() == mItemNewFood) {
//			performOpenTaxReport();
		}else if(e.getSource() == mItemListFood) {
//			performOpenTaxRule2018();
		}else if(e.getSource() == mItemTakeOrder) {
//			performOpenTaxCalculator();
		}else if(e.getSource() == mItemListOrder) {
//			performOpenTaxCalculator();
		}else if(e.getSource() == mItemTakeReservation) {
//			performOpenTaxCalculator();
		}else if(e.getSource() == mItemReservationList) {
//			performOpenTaxCalculator();
		}
	}
	
    public static void main( String[] args )
    {
    	new App();
    }
}
