package СС������;

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
	private javax.swing.JButton queryButton;// ��ѯ��ť
	private javax.swing.JButton clearButton;// �رհ�ť
	private javax.swing.JButton closeButton;// �رհ�ť
	private javax.swing.JTable table;
	private static DefaultTableModel model;
	private ResultSet rs;
	private Object[] data = null;
	public DBManager dbm=new DBManager();
	
	public DBMFrame() {
		initComponents(); // ���ó�ʼ������ķ���
		
	}
	
	private void initComponents() {
		setBounds(100,100,700,550);
		setResizable(false);
		java.awt.GridBagConstraints gridBagConstraints;
		queryButton = new javax.swing.JButton();// ��ʼ����ť
		clearButton = new javax.swing.JButton();
		closeButton = new javax.swing.JButton();
		table=new javax.swing.JTable();
		setForeground(java.awt.Color.gray);// ǰ��ɫΪ��ɫ
		setTitle("ս��");
		setLayout(new FlowLayout(FlowLayout.LEFT,10,5));// ʹ�����������
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
			// ��д���༭����
			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return false;// ��񲻿ɱ༭
			}
		});
		model = (DefaultTableModel) table.getModel();
		//model.setRowCount( 10000 );
		table.setBounds(200, 300, 200, 600);
	    table.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		
		queryButton.setText("��ѯ");
		queryButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				queryButtonActionPerformed(evt);
			}
		});
		
		
		clearButton.setText("���");
		clearButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				clearButtonActionPerformed(evt);
			}
		});
		
		closeButton.setText("�ر�");
		closeButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				closeButtonActionPerformed(evt);// �رհ�ť��������ر�
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
        	JOptionPane.showMessageDialog(this,"ʧ�ܼ���"); 
        }
	}
}
