package com.zzt.frames.building;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.zzt.controller.impl.PatientControllerImpl;
import com.zzt.entity.Patient;
import com.zzt.entity.build.Bed;
import com.zzt.entity.build.BuildFloor;
import com.zzt.entity.build.Building;
import com.zzt.entity.build.Room;
import com.zzt.tool.GetDataClass;
import com.zzt.tool.WriteDataClass;



public class SpecialFacilityManage extends javax.swing.JPanel {
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JComboBox applyPatient;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JButton flush;
	private JTable table;
	private JButton find;
	private JTextField facilityName;
	private JLabel jLabel6;
	private JScrollPane jScrollPane1;
	private JComboBox facilityType;
	private JTextField dayUse;
	private JButton Apply;
	private TableModel tableModel;

	private List<Building> buildings;
	private List<Room> specialRooms;
	private List<Patient> patients;
	
	private ComboBoxModel applyPatientModel;
	

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new SpecialFacilityManage());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	public SpecialFacilityManage() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			this.setPreferredSize(new java.awt.Dimension(860, 669));
			this.setLayout(null);
			{
				jLabel1 = new JLabel();
				this.add(jLabel1);
				jLabel1.setText("\u7a00\u6709\u8bbe\u5907\u7ba1\u7406\u754c\u9762");
				jLabel1.setBounds(12, 26, 138, 59);
			}
			{
				Apply = new JButton();
				this.add(Apply);
				Apply.setText("\u7533\u8bf7");
				Apply.setBounds(709, 564, 90, 63);
				Apply.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						ApplyActionPerformed(evt);
					}
				});
			}
			{
				jLabel2 = new JLabel();
				this.add(jLabel2);
				jLabel2.setText("\u7533\u8bf7\u4eba\uff1a");
				jLabel2.setBounds(24, 578, 82, 44);
			}
			{
				dataInit();
				//更新可申请人列表
				int size1 = 0 ;
				String[] content = new String[0];
				if(patients != null && !patients.isEmpty())
				{
					size1 = patients.size();
					content = new String[size1];
					int i = 0 ;
					for(Patient t : patients)
					{
						content[i ++ ] = t.getName();
					}
				}
				
				applyPatientModel = new DefaultComboBoxModel(
						content);
				applyPatient = new JComboBox();
				this.add(applyPatient);
				applyPatient.setModel(applyPatientModel);
				applyPatient.setBounds(85, 587, 101, 40);
			}
			{
				jLabel3 = new JLabel();
				this.add(jLabel3);
				jLabel3.setText("\u4f7f\u7528\u65f6\u957f\uff1a");
				jLabel3.setBounds(209, 589, 84, 37);
			}
			{
				dayUse = new JTextField();
				this.add(dayUse);
				dayUse.setBounds(283, 594, 41, 27);
			}
			{
				jLabel4 = new JLabel();
				this.add(jLabel4);
				jLabel4.setText("\u5929");
				jLabel4.setBounds(329, 593, 35, 29);
			}
			{
				jLabel5 = new JLabel();
				this.add(jLabel5);
				jLabel5.setText("\u8bbe\u5907\u7c7b\u578b\uff1a");
				jLabel5.setBounds(376, 589, 80, 36);
			}
			{
				ComboBoxModel facilityTypeModel = new DefaultComboBoxModel(
						new String[] { "浴室", "娱乐室","棋牌室" });
				facilityType = new JComboBox();
				this.add(facilityType);
				facilityType.setModel(facilityTypeModel);
				facilityType.setBounds(468, 594, 92, 27);
			}
			{
				jScrollPane1 = new JScrollPane();
				this.add(jScrollPane1);
				jScrollPane1.setBounds(0, 103, 860, 446);
				{
					viewTable();
					
				}
			}
			{
				jLabel6 = new JLabel();
				this.add(jLabel6);
				jLabel6.setText("\u540d\u79f0\uff1a");
				jLabel6.setBounds(408, 45, 47, 40);
			}
			{
				facilityName = new JTextField();
				this.add(facilityName);
				facilityName.setBounds(461, 52, 126, 27);
			}
			{
				find = new JButton();
				this.add(find);
				find.setText("\u67e5\u8be2");
				find.setBounds(617, 44, 71, 43);
				find.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						findActionPerformed(evt);
					}
				});
			}
			{
				flush = new JButton();
				this.add(flush);
				flush.setText("\u5237\u65b0");
				flush.setBounds(735, 42, 64, 45);
				flush.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						flushActionPerformed(evt);
					}
				});
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void dataInit() {
		buildings = GetDataClass.getDataBuildingClass();
		specialRooms = new ArrayList<Room>();
		if (buildings != null && !buildings.isEmpty()) {
			for (Building t1 : buildings) {
				List<BuildFloor> buildFloors = t1.getBuildFloors();
				if (buildFloors != null && !buildFloors.isEmpty()) {
					for (BuildFloor t2 : buildFloors) {
						List<Room> rooms = t2.getRooms();
						if (rooms != null && !rooms.isEmpty()) {
							for (Room t3 : rooms) {
								if(t3.isSpecial())
								{
									specialRooms.add(t3);
								}
							}

						}

					}

				}
			}
		}
		patients = GetDataClass.getDataPatientClass();
	}

	private void viewTable() {
		dataInit();
		//更新可申请人列表
		int size1 = 0 ;
		String[] content1 = new String[0];
		if(patients != null && !patients.isEmpty())
		{
			size1 = patients.size();
			content1 = new String[size1];
			int i = 0 ;
			for(Patient t : patients)
			{
				content1[i ++ ] = t.getName();
			}
		}
		
		applyPatientModel = new DefaultComboBoxModel(
				content1);
		applyPatient.setModel(applyPatientModel);
		
		
		String[] colNames = new String[] { "房间名称", "房间类型", "位置", "最大容纳人数" ,"可用人数"};
		int size = 0 ;
		String[][] content = null;
		if(specialRooms != null && !specialRooms.isEmpty())
		{
			for(Room sr : specialRooms)
			{
				size ++ ;
			}
			 content = new String[size][5];
			int i = 0 ;
			for(Room sr : specialRooms)
			{
				content[i ++ ] = new String[]{sr.getName(),sr.getSpecialType(),sr.getPosition(),sr.getMaxHold(),sr.getVaildHold()};
			}
		}else
		{
			 content = new String[0][0];
		}
		
		tableModel = new DefaultTableModel(
				content, colNames);
		table = new JTable();
		table.setModel(tableModel);
		jScrollPane1.setViewportView(table);
		table.setModel(tableModel);
		repaint();	
	}
	
	private void viewOther()
	{
		dataInit();
		//更新可申请人列表
		int size1 = 0 ;
		String[] content = new String[0];
		if(patients != null && !patients.isEmpty())
		{
			size1 = patients.size();
			content = new String[size1];
			int i = 0 ;
			for(Patient t : patients)
			{
				content[i ++ ] = t.getName();
			}
		}
		
		applyPatientModel = new DefaultComboBoxModel(
				content);
		applyPatient = new JComboBox();
		this.add(applyPatient);
		applyPatient.setModel(applyPatientModel);
		applyPatient.setBounds(85, 587, 101, 40);
		
		
	}
	
	private void findActionPerformed(ActionEvent evt) {
		dataInit();
		String name1 = facilityName.getText();
		String[] colNames = new String[] { "房间名称", "房间类型", "位置", "最大容纳人数" ,"可用人数"};
		String[][] content = null;
		int i = 0 ;
		if(name1 == null || "".equals(name1))
		{
			JOptionPane.showMessageDialog(null, "请输入所要查找的名称！");
			return;
		}
		
		for(Room sr : specialRooms)
		{
			if(name1.equals(sr.getName()))
			{
				
				i ++ ;
			}
		}
		if(i == 0)
		{
			JOptionPane.showMessageDialog(null, "找不到您所要查找的内容");
			return ;
		}
		
		content = new String[i][4];
		i = 0 ;
		for(Room sr : specialRooms)
		{
			if(name1.equals(sr.getName()))
			{
				
				content[i ++ ] = new String[]{sr.getName(),sr.getSpecialType(),sr.getPosition(),sr.getMaxHold(),sr.getVaildHold()};
			}
		}
		
		tableModel = new DefaultTableModel(
				content, colNames);
		table = new JTable();
		table.setModel(tableModel);
		jScrollPane1.setViewportView(table);
		table.setModel(tableModel);
		repaint();
	}
	
	private void flushActionPerformed(ActionEvent evt) {
		viewTable();
		viewOther();
		facilityName.setText("");
	}
	
	private void ApplyActionPerformed(ActionEvent evt) {
		String dayuse = dayUse.getText();
		String typeApply = facilityType.getSelectedItem().toString();
		if(dayuse == null || dayuse.isEmpty())
		{
			JOptionPane.showMessageDialog(null, "请输入患者所要使用的天数");
			return;
		}
		Integer contime = null;
		
		try{
			contime = Integer.parseInt(dayuse);
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "请输入争取的日期格式！(仅整数)");
			return;
		}
		
		//找到所指定的病人
		String patientName = applyPatient.getSelectedItem().toString();
		
		
		
		
		
		//flag1用来判断是否有空床可行
		boolean flag1 = false;
		for(Room t : specialRooms)
		{
			if(Integer.parseInt(t.getVaildHold()) >= 1 && typeApply.equals(t.getSpecialType()))
			{
				t.setVaildHold(Integer.toString(Integer.parseInt(t.getVaildHold())-1));
				
				//寻找t
				
				List<Building> buildings = GetDataClass.getDataBuildingClass();
				
				if(buildings != null && !buildings.isEmpty())
				{
					int i3 = 0 ;
					for(Building t1 : buildings)
					{
						List<BuildFloor> buildfloors = t1.getBuildFloors();
						if(buildfloors != null && !buildfloors.isEmpty())
						{
							int i2 = 0 ;
							for(BuildFloor t2 : buildfloors)
							{
								List<Room> rooms = t2.getRooms();
								if(rooms != null && !rooms.isEmpty())
								{
									int i1 = 0 ;
									for(Room t3:rooms)
									{
										if(t3.isSpecial() && Integer.parseInt(t3.getVaildHold()) >= 1 )
										{
											t3.setVaildHold(Integer.toString( Integer.parseInt(t3.getVaildHold()) -1 ));
											rooms.set(i1, t3);
											flag1 = true;
											break;
										}
										i1 ++ ;
									}
									t2.setRooms(rooms);
									buildfloors.set(i2, t2);
								}
								i2 ++;
							}
							t1.setBuildFloors(buildfloors);
							buildings.set(i3, t1);
						}
						i3 ++;
					}
				}
				WriteDataClass.writeDataBuilding(buildings);
				
				
				//
				
				flag1 =true;
				break;
			}
		}
		if(flag1)
		{
			JOptionPane.showMessageDialog(null, "申请成功");
			viewTable();
		}else
		{
			JOptionPane.showMessageDialog(null, "申请失败,暂无可用稀有设备！");
		}
		
		
		
	}

}
