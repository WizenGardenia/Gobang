package 小小五子棋;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.net.InetAddress;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class DBMFrame extends javax.swing.JFrame{

	private static final long serialVersionUID = 1L;
	private javax.swing.JButton queryButton;// 查询按钮
	private javax.swing.JButton clearButton;// 关闭按钮
	private javax.swing.JButton closeButton;// 关闭按钮
	private javax.swing.JTable table;
	private static DefaultTableModel model;
	private ResultSet rs;
	private Object[] data = null;
	public DBManager dbm=new DBManager();
	
	public DBMFrame() {
		initComponents(); // 调用初始化界面的方法
		
	}
	
	private void initComponents() {
		setBounds(100,100,700,550);
		setResizable(false);
		java.awt.GridBagConstraints gridBagConstraints;
		queryButton = new javax.swing.JButton();// 初始化按钮
		clearButton = new javax.swing.JButton();
		closeButton = new javax.swing.JButton();
		table=new javax.swing.JTable();
		setForeground(java.awt.Color.gray);// 前景色为灰色
		setTitle("战绩");
		setLayout(new FlowLayout(FlowLayout.LEFT,10,5));// 使用网格包布局
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.insets = new Insets(0, 0, 0, 40);
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		add(queryButton, gridBagConstraints);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.insets = new Insets(0, 0, 0, 40);
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		add(clearButton, gridBagConstraints);
		
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.insets = new Insets(0, 0, 0, 55);
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 2;
		add(closeButton, gridBagConstraints);
		
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.insets = new Insets(0, 0, 0, 95);
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 2;
		add(new JScrollPane(table), gridBagConstraints);
		table.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][]{}, new Object[] { "UserName","Time", "Result" }) {
			// 重写表格编辑方法
			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return false;// 表格不可编辑
			}
		});
		model = (DefaultTableModel) table.getModel();
		//model.setRowCount( 10000 );
		table.setBounds(200, 300, 200, 600);
	    table.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		
		queryButton.setText("查询");
		queryButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				queryButtonActionPerformed(evt);
			}
		});
		
		
		clearButton.setText("清除");
		clearButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				clearButtonActionPerformed(evt);
			}
		});
		
		closeButton.setText("关闭");
		closeButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				closeButtonActionPerformed(evt);// 关闭按钮触发程序关闭
			}
		});
		
		
		
	}
	
	private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {
		setVisible(false);
	}
	
	private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {
		String sql="delete from result";
		dbm.update(sql);
		model.setRowCount( 0 );
	}
	
	private void queryButtonActionPerformed(java.awt.event.ActionEvent evt) {
		rs=dbm.query();
		try {
            while (rs.next()) {
                data = null;
                String username = rs.getString(1);
                String time = rs.getString(2);
                String result = rs.getString(3);
                data = new Object[] {username,time, result};
                model.addRow(data);
            }
        } catch (SQLException e) { 
        	JOptionPane.showMessageDialog(this,"失败计入"); 
        }
	}
}
