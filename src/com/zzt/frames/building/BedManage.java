package com.zzt.frames.building;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import com.zzt.entity.Patient;
import com.zzt.entity.build.Bed;
import com.zzt.entity.build.BuildFloor;
import com.zzt.entity.build.Building;
import com.zzt.entity.build.Room;
import com.zzt.frames.IDColumnRender;
import com.zzt.tool.GetDataClass;
import com.zzt.tool.WriteDataClass;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class BedManage extends javax.swing.JPanel {
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JComboBox buildNumber;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JButton enter;
	private JTextField leaveTime1;
	private JLabel leaveTime;
	private JTextField loginTime;
	private JTextField typeNumber;
	private JButton flush;
	private JLabel jLabel7;
	private JComboBox patientName;
	private JLabel jLabel6;
	private JTable jTable1;
	private JButton returnHospital;
	private JLabel jLabel8;
	private JButton change;
	private JScrollPane jScrollPane1;
	private JButton find;
	private JComboBox bedNumber;
	private JComboBox roomNumber;
	private JComboBox buildingFloor;
	private TableModel jTable1Model;
	//数据
	private List<Patient> patients;
	private List<Building> buildings;
	private ComboBoxModel patientNameModel;
	

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new BedManage());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public BedManage() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			this.setPreferredSize(new java.awt.Dimension(873, 758));
			this.setLayout(null);
			{
				jLabel1 = new JLabel();
				this.add(jLabel1);
				jLabel1.setText("\u5e8a\u4f4d\u7ba1\u7406\u754c\u9762");
				jLabel1.setBounds(20, 0, 163, 64);
			}
			{
				jLabel2 = new JLabel();
				this.add(jLabel2);
				jLabel2.setText("\u697c\u53f7:");
				jLabel2.setBounds(0, 70, 50, 29);
			}
			{
				buildings = GetDataClass.getDataBuildingClass();
				int size = 0 ;
				if(buildings != null && !buildings.isEmpty())
				{
					for(Building t : buildings)
					{
						size ++ ;
					}
				}
				
				String[] content1 = new String[size+1];
				content1[0] = " ";
				int i = 1 ;
				if(buildings != null && !buildings.isEmpty())
				{
					for(Building t : buildings)
					{
						content1[i ++ ] = t.getName();
					}
				}
				
				ComboBoxModel buildNumberModel = 
					new DefaultComboBoxModel(
							content1);
				buildNumber = new JComboBox();
				this.add(buildNumber);
				buildNumber.setModel(buildNumberModel);
				buildNumber.setBounds(39, 71, 88, 27);
				buildNumber.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						buildNumberActionPerformed(evt);
					}
				});
			}
			{
				jLabel3 = new JLabel();
				this.add(jLabel3);
				jLabel3.setText("\u697c\u5c42\uff1a");
				jLabel3.setBounds(134, 72, 53, 24);
			}
			{
				ComboBoxModel buildingFloorModel = 
					new DefaultComboBoxModel(
							new String[] {" "});
				buildingFloor = new JComboBox();
				this.add(buildingFloor);
				buildingFloor.setModel(buildingFloorModel);
				buildingFloor.setBounds(184, 71, 119, 27);
				buildingFloor.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						buildingFloorActionPerformed(evt);
					}
				});
			}
			{
				jLabel4 = new JLabel();
				this.add(jLabel4);
				jLabel4.setText("\u623f\u95f4\uff1a");
				jLabel4.setBounds(311, 71, 46, 26);
			}
			{
				ComboBoxModel roomNumberModel = 
					new DefaultComboBoxModel(
							new String[] {" "});
				roomNumber = new JComboBox();
				this.add(roomNumber);
				roomNumber.setModel(roomNumberModel);
				roomNumber.setBounds(357, 71, 87, 27);
				roomNumber.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						roomNumberActionPerformed(evt);
					}
				});
			}
			{
				jLabel5 = new JLabel();
				this.add(jLabel5);
				jLabel5.setText("\u5e8a\u4f4d\uff1a");
				jLabel5.setBounds(456, 74, 47, 21);
			}
			{
				ComboBoxModel bedNumberModel = 
					new DefaultComboBoxModel(
							new String[] {" "});
				bedNumber = new JComboBox();
				this.add(bedNumber);
				bedNumber.setModel(bedNumberModel);
				bedNumber.setBounds(508, 71, 87, 27);
			}
			{
				find = new JButton();
				this.add(find);
				find.setText("\u67e5\u8be2");
				find.setBounds(618, 57, 88, 41);
				find.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						findActionPerformed(evt);
					}
				});
			}
			{
				patients = GetDataClass.getDataPatientClass();
				String[] x = new String[0];
				if(patients == null || !patients.isEmpty())
				{
					 x = new String[patients.size()];
					int i = 0 ;
					for(Patient t :patients)
					{
						x[ i ++ ] = t.getName();
					}
				}
				
				ComboBoxModel patientNameModel = 
					new DefaultComboBoxModel(
							x);
				patientName = new JComboBox();
				this.add(patientName);
				patientName.setModel(patientNameModel);
				patientName.setBounds(158, 585, 94, 27);
			}
			
			{
				jScrollPane1 = new JScrollPane();
				this.add(jScrollPane1);
				jScrollPane1.setBounds(0, 172, 873, 393);
				{
					jTable1Model = 
						new DefaultTableModel(
								new String[][] {},
								new String[] {});
					jTable1 = new JTable();
					jScrollPane1.setViewportView(jTable1);
					jTable1.setModel(jTable1Model);
					viewTable();
				}
			}
			{
				returnHospital = new JButton();
				this.add(returnHospital);
				returnHospital.setText("\u9000\u9662");
				returnHospital.setBounds(0, 123, 65, 49);
				returnHospital.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						returnHospitalActionPerformed(evt);
					}
				});
			}
			{
				change = new JButton();
				this.add(change);
				change.setText("\u5e8a\u4f4d\u5bf9\u8c03");
				change.setBounds(65, 123, 107, 49);
				change.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						changeActionPerformed(evt);
					}
				});
			}
			{
				jLabel6 = new JLabel();
				this.add(jLabel6);
				jLabel6.setText("\u5165\u4f4f\u4eba\uff1a");
				jLabel6.setBounds(93, 584, 76, 29);
			}
			
			{
				jLabel7 = new JLabel();
				this.add(jLabel7);
				jLabel7.setText("\u5165\u4f4f\u65f6\u95f4\uff1a");
				jLabel7.setBounds(264, 586, 86, 24);
			}
			{
				loginTime = new JTextField();
				this.add(loginTime);
				loginTime.setBounds(347, 585, 99, 27);
			}
			{
				leaveTime = new JLabel();
				this.add(leaveTime);
				leaveTime.setText("\u79bb\u5f00\u65f6\u95f4\uff1a");
				leaveTime.setBounds(458, 586, 77, 25);
			}
			{
				leaveTime1 = new JTextField();
				this.add(leaveTime1);
				leaveTime1.setBounds(541, 585, 108, 27);
			}
			{
				enter = new JButton();
				this.add(enter);
				this.add(getJLabel8());
				this.add(getTypeNumber());
				this.add(getFlush());
				{
					jTable1 = new JTable(jTable1Model) {
						@Override
						public boolean isCellEditable(int row, int column) {
							return false;
						}
					};
					this.add(jTable1);
					jScrollPane1.setViewportView(jTable1);
					jTable1.setModel(jTable1Model);
					jTable1.setFillsViewportHeight(true);
					jTable1.setRowSelectionAllowed(true); // 整行选择
					jTable1.setRowHeight(30);
					jTable1.getColumnModel().getColumn(0)
					.setCellRenderer(new IDColumnRender());
					jTable1.getColumnModel().getColumn(0).setPreferredWidth(180); // 该列的宽度
					jTable1.setBounds(0, 173, 779, 282);
				}
				enter.setText("\u5165\u4f4f");
				enter.setBounds(680, 585, 93, 55);
				enter.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						enterActionPerformed(evt);
					}
				});
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void viewTable() {
		//更新床位:
		patients = GetDataClass.getDataPatientClass();
		String[] x = new String[0];
		if(patients == null || !patients.isEmpty())
		{
			 x = new String[patients.size()];
			int i = 0 ;
			for(Patient t :patients)
			{
				x[ i ++ ] = t.getName();
			}
		}
		
		ComboBoxModel patientNameModel = 
			new DefaultComboBoxModel(
					x);
		patientName.setModel(patientNameModel);
		
		
		//更新table
		String[] colNames = new String[]{"位置","入住开始时间","入住结束时间","状态","姓名","性别","年龄","档案编号"};
		int size = 0 ;
		List<Bed> beds = GetDataClass.getDataBedClass();
		if(beds != null && !beds.isEmpty())
		{
			for(Bed t : beds)
			{
				if(t.isRegister())
				{
					size ++;
				}
			}
		}
		String[][] content = new String[size][8];
		int i = 0 ;
		if(beds != null && !beds.isEmpty())
		{
			for(Bed t : beds)
			{
				if(t.isRegister())
				{
					content[i ++ ] = new String[]{t.getPosition(),t.getStarttime(),t.getEndtime(),t.getState(),t.getPatient().getName(),t.getPatient().getGender(),t.getPatient().getAge(),t.getNum()};
				}
			}
		}
		
		jTable1Model = 
			new DefaultTableModel(
					content,
					colNames);

		// jTable = new JTable();
		// jTable.setModel(jTableModel);

		jTable1 = new JTable(jTable1Model) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		this.add(jTable1);
		jScrollPane1.setViewportView(jTable1);
		jTable1.setModel(jTable1Model);
		jTable1.setFillsViewportHeight(true);
		jTable1.setRowSelectionAllowed(true); // 整行选择
		jTable1.setRowHeight(30);
		jTable1.getColumnModel().getColumn(0)
		.setCellRenderer(new IDColumnRender());
		jTable1.getColumnModel().getColumn(0).setPreferredWidth(180); // 该列的宽度
		jTable1.setBounds(0, 173, 779, 282);
		
		// 添加到主界面

		// 列设置：自定义绘制
		repaint();
		
	}

	private void enterActionPerformed(ActionEvent evt) {
		storeValue();
		loginTime.setText("");
		leaveTime1.setText("");
		typeNumber.setText("");
		viewTable();
	}
	
	private void storeValue()
	{
		//判断有无可用床位
		boolean flag = false;
		String s1 = patientName.getSelectedItem().toString();
		String startTime = loginTime.getText();
		String endTime = leaveTime1.getText();
		String fileNumber = typeNumber.getText();
		Bed bed = Bed.getBed();
		Patient m = null ;
		
		//判断输入是否为空
		if(startTime == null || startTime.isEmpty())
		{
			JOptionPane.showMessageDialog(null, "请输入入住时间（八位整数）");
			return;
		}
		
		if(endTime == null || endTime.isEmpty())
		{
			JOptionPane.showMessageDialog(null, "请输入出院时间（八位整数）");
		    return;
		}
		
		if(fileNumber == null || fileNumber.isEmpty())
		{
			JOptionPane.showMessageDialog(null, "请输入档案编号");
			return;
		}
		
		
		for(Patient t : patients)
		{
			if(s1.equals(t.getName()))
			{
				m = t ;
				break;
			}
		}
		
		buildings = GetDataClass.getDataBuildingClass();
		if(buildings != null && !buildings.isEmpty())
		{
			int i4 = 0;
			for(Building t : buildings)
			{
				List<BuildFloor> buildfloors = t.getBuildFloors();
				if(buildfloors != null && !buildfloors.isEmpty())
				{
					int i3 = 0 ;
					for(BuildFloor bf : buildfloors)
					{
						List<Room> rooms = bf.getRooms();
						if(rooms != null && !rooms.isEmpty())
						{
							int i2 = 0 ;
							for(Room rm : rooms)
							{
								List<Bed> beds = rm.getBeds();
								if(beds != null && !beds.isEmpty())
								{
									int i1 = 0 ;
									for(Bed bd : beds)
									{
										if(!bd.isRegister())
										{
											bed = bd;
											bed.setPatient(m);
											bed.setStarttime(startTime);
											bed.setEndtime(endTime);
											bed.setState("已入住");
											bed.setNum(fileNumber);
											bed.setRegister(true);
											beds.set(i1, bed);
											flag = true;
											break;
										}
										i1 ++;
									}
									rm.setBeds(beds);
									rooms.set(i2, rm);
									break;
								}
								i2 ++;
								
							}
							bf.setRooms(rooms);
							buildfloors.set(i3, bf);
							break;
						}
						i3 ++;
					}
					t.setBuildFloors(buildfloors);
					buildings.set(i4, t);
					break;
				}
				i4 ++ ;
			}
		}
		
		if(!flag)
		{
			JOptionPane.showMessageDialog(null, "暂无无可用床位！");
			return;
		}
		
		WriteDataClass.writeDataBuilding(buildings);
		return ;
	}
	
	private JLabel getJLabel8() {
		if(jLabel8 == null) {
			jLabel8 = new JLabel();
			jLabel8.setText("\u6863\u6848\u7f16\u53f7\uff1a");
			jLabel8.setBounds(93, 635, 80, 20);
		}
		return jLabel8;
	}
	
	private JTextField getTypeNumber() {
		if(typeNumber == null) {
			typeNumber = new JTextField();
			typeNumber.setBounds(178, 632, 149, 27);
		}
		return typeNumber;
	}
	
	private void returnHospitalActionPerformed(ActionEvent evt) {
		int[] rows = jTable1.getSelectedRows();
		if (rows.length == 0) {
			JOptionPane.showMessageDialog(null, "您尚未选择想要退院的病患！");
			return;
		}

		// 弹出对话框确认
		int select = JOptionPane.showConfirmDialog(this, "是否确认退院?", "确认",
				JOptionPane.YES_NO_OPTION);
		if (select != 0) {
			return;
		} // 0号按钮是'确定'按钮

		boolean flag = false;
		for (int i = rows.length - 1; i >= 0; i--) {
			int row = rows[i];
			
			//首先获取想要退院的病患和相应床位的信息
			
			String bedPosition = jTable1.getValueAt(row, 0).toString();
			Bed bed = Bed.getBed();
			buildings = GetDataClass.getDataBuildingClass();
			if(buildings != null && !buildings.isEmpty())
			{
				int i4 = 0;
				for(Building t : buildings)
				{
					List<BuildFloor> buildfloors = t.getBuildFloors();
					if(buildfloors != null && !buildfloors.isEmpty())
					{
						int i3 = 0 ;
						for(BuildFloor bf : buildfloors)
						{
							List<Room> rooms = bf.getRooms();
							if(rooms != null && !rooms.isEmpty())
							{
								int i2 = 0 ;
								for(Room rm : rooms)
								{
									List<Bed> beds = rm.getBeds();
									if(beds != null && !beds.isEmpty())
									{
										int i1 = 0 ;
										for(Bed bd : beds)
										{
											if(bd.isRegister() && bd.getPosition().equals(bedPosition))
											{
												bed = bd;
												bed.setState("未入住");
												bed.setRegister(false);
												beds.set(i1, bed);
												flag = true;
												break;
											}
											i1 ++;
										}
										rm.setBeds(beds);
										rooms.set(i2, rm);
									}
									i2 ++;
								}
								bf.setRooms(rooms);
								buildfloors.set(i3, bf);
							}
							i3 ++;
						}
						t.setBuildFloors(buildfloors);
						buildings.set(i4, t);
					}
					i4 ++ ;
				}
			}	
		}
		
		if(!flag)
		{
			JOptionPane.showMessageDialog(null, "退院失败！");
		}else
		{
			JOptionPane.showMessageDialog(null, "退院成功！");
		}
		WriteDataClass.writeDataBuilding(buildings);
		viewTable();
		
	}
	
	private void changeActionPerformed(ActionEvent evt) {
		int[] rows = jTable1.getSelectedRows();
		if (rows.length != 2) {
			JOptionPane.showMessageDialog(null, "请选择两个用户进行操作！");
			return;
		}
		
		// 弹出对话框确认
		int select = JOptionPane.showConfirmDialog(this, "是否确认床位调换?", "确认",
				JOptionPane.YES_NO_OPTION);
		if (select != 0) {
			return;
		} // 0号按钮是'确定'按钮
		
		int x1 = rows[0];
		int x2 = rows[1];
		
		String position1 = jTable1.getValueAt(x1, 0).toString();
		String position2 = jTable1.getValueAt(x2, 0).toString();
		
		String patientName1 = jTable1.getValueAt(x1, 4).toString();
		String patientName2 = jTable1.getValueAt(x2, 4).toString();
		
		List<Patient> patients = GetDataClass.getDataPatientClass();
		Patient patient1 = null;
		Patient patient2 = null;
		if( patients != null && !patients.isEmpty())
		{
			for(Patient t : patients)
			{
				if(patientName1.equals(t.getName()))
				{
					patient1 = t;
				}
				
				if(patientName2.equals(t.getName()))
				{
					patient2 = t ;
				}
			}
		}
		
		Bed bed = Bed.getBed();
		buildings = GetDataClass.getDataBuildingClass();
		if(buildings != null && !buildings.isEmpty())
		{
			int i4 = 0;
			for(Building t : buildings)
			{
				List<BuildFloor> buildfloors = t.getBuildFloors();
				if(buildfloors != null && !buildfloors.isEmpty())
				{
					int i3 = 0 ;
					for(BuildFloor bf : buildfloors)
					{
						List<Room> rooms = bf.getRooms();
						if(rooms != null && !rooms.isEmpty())
						{
							int i2 = 0 ;
							for(Room rm : rooms)
							{
								List<Bed> beds = rm.getBeds();
								if(beds != null && !beds.isEmpty())
								{
									int i1 = 0 ;
									for(Bed bd : beds)
									{
										if(bd.isRegister() && bd.getPosition().equals(position1))
										{
											bed = bd;
											bed.setPatient(patient2);
											beds.set(i1, bed);
										}
										
										if(bd.isRegister() && bd.getPosition().equals(position2))
										{
											bed = bd;
											bed.setPatient(patient1);
											beds.set(i1, bed);
										}
										
										i1 ++;
									}
									rm.setBeds(beds);
									rooms.set(i2, rm);
								}
								i2 ++;
							}
							bf.setRooms(rooms);
							buildfloors.set(i3, bf);
						}
						i3 ++;
					}
					t.setBuildFloors(buildfloors);
					buildings.set(i4, t);
				}
				i4 ++ ;
			}
		}	
		
		WriteDataClass.writeDataBuilding(buildings);
		viewTable();
		
	}
	
	private void buildNumberActionPerformed(ActionEvent evt) {
		buildings = GetDataClass.getDataBuildingClass();
		String namex = buildNumber.getSelectedItem().toString();
		if (namex.equals(" ")) {
			ComboBoxModel buildingFloorNumberModel = new DefaultComboBoxModel(
					new String[] { " " });
			buildingFloor.setModel(buildingFloorNumberModel);
			return;
		}

		for (Building t : buildings) {
			if (namex.equals(t.getName())) {
				List<BuildFloor> buildFloors = t.getBuildFloors();

				if (buildFloors != null && !buildFloors.isEmpty()) {
					// 显示楼层
					int size2 = buildFloors.size();
					String[] builds = new String[size2 + 1];
					builds[0] = " ";
					int i = 1;
					for (BuildFloor t1 : buildFloors) {
						builds[i++] = t1.getName();
					}
					ComboBoxModel buildingFloorNumberModel = new DefaultComboBoxModel(
							builds);
					buildingFloor.setModel(buildingFloorNumberModel);
				} else {
					ComboBoxModel buildingFloorNumberModel = new DefaultComboBoxModel(
							new String[] { " " });
					buildingFloor.setModel(buildingFloorNumberModel);
				}
				break;
			}
		}
	}
	
	private void buildingFloorActionPerformed(ActionEvent evt) {
		buildings = GetDataClass.getDataBuildingClass();
		String namex1 = buildNumber.getSelectedItem().toString();
		String namex2 = buildingFloor.getSelectedItem().toString();

		if (namex2.equals(" ")) {
			ComboBoxModel roomNumberModel = new DefaultComboBoxModel(
					new String[] { " " });
			roomNumber.setModel(roomNumberModel);
			return;
		}

		for (Building t : buildings) {
			if (t.getName().equals(namex1)) {
				List<BuildFloor> buildFloors = t.getBuildFloors();

				if (buildFloors != null && !buildFloors.isEmpty()) {
					for (BuildFloor t2 : buildFloors) {
						if (namex2.equals(t2.getName())) {
							List<Room> rooms = t2.getRooms();

							if (rooms != null && !rooms.isEmpty()) {
								int size3 = rooms.size();
								String[] builds = new String[size3 + 1];
								builds[0] = " ";
								int i = 1;
								for (Room t1 : rooms) {
									builds[i++] = t1.getName();
								}
								ComboBoxModel roomNumberModel = new DefaultComboBoxModel(
										builds);
								roomNumber.setModel(roomNumberModel);
							} else {
								ComboBoxModel roomNumberModel = new DefaultComboBoxModel(
										new String[] {""});
								roomNumber.setModel(roomNumberModel);
							}
							break;
						}
					}
				} else {
					ComboBoxModel roomNumberModel = new DefaultComboBoxModel(
							new String[] {""});
					roomNumber.setModel(roomNumberModel);
				}
				break;
			}
		}
	}
	
	private void roomNumberActionPerformed(ActionEvent evt) {
		
		buildings = GetDataClass.getDataBuildingClass();
		String namex1 = buildNumber.getSelectedItem().toString();
		String namex2 = buildingFloor.getSelectedItem().toString();
		String namex3 = roomNumber.getSelectedItem().toString();
		
		if (namex3.equals(" ")) {
			ComboBoxModel roomNumberModel = new DefaultComboBoxModel(
					new String[] {""});
			bedNumber.setModel(roomNumberModel);
			return;
		}

		for (Building t : buildings) {
			if (t.getName().equals(namex1)) {
				List<BuildFloor> buildFloors = t.getBuildFloors();

				if (buildFloors != null && !buildFloors.isEmpty()) {
					for (BuildFloor t2 : buildFloors) {
						if (namex2.equals(t2.getName())) {
							List<Room> rooms = t2.getRooms();

							if (rooms != null && !rooms.isEmpty()) {
								for(Room t3 : rooms)
								{
									if(namex3.equals(t3.getName()))
									{
										List<Bed> beds = t3.getBeds();
										if(beds != null && !beds.isEmpty())
										{
											int size = beds.size();
											String[] bedss = new String[size + 1];
											int i = 1 ;
											bedss[0] = " ";
											for(Bed m : beds)
											{
												bedss[i++] = m.getName();
											}
											
											ComboBoxModel roomNumberModel = new DefaultComboBoxModel(
													bedss);
											bedNumber.setModel(roomNumberModel);
											
										}else {
											ComboBoxModel roomNumberModel = new DefaultComboBoxModel(
													new String[] {" "});
											bedNumber.setModel(roomNumberModel);
										
									}
								}
						}
					}
				} 
				}
				break;
			}
		}
		}
	}
	
	private void findActionPerformed(ActionEvent evt) {
		String buildingName = buildNumber.getSelectedItem().toString();
		String buildingFloorName = buildingFloor.getSelectedItem().toString();
		String roomName = roomNumber.getSelectedItem().toString();
		String bedName = bedNumber.getSelectedItem().toString();
		if(bedName.equals(" "))
		{
			JOptionPane.showMessageDialog(null, "请精确到床位进行查询");
			return;
		}
		String position = buildingName + "->" + buildingFloorName +"->"+ roomName  +"->" +bedName;
		
		List<Bed> beds = GetDataClass.getDataBedClass();
		boolean flag = false;
		Bed t = null;
		if(beds != null && !beds.isEmpty())
		{
			for(Bed bed : beds)
			{
				if(bed.isRegister() && bed.getPosition().equals(position))
				{
					flag = true;
					t = bed;
				}
			}
		}
		
		if(!flag)
		{
			JOptionPane.showMessageDialog(null, "找不到您所要查找的床位！");
			return;
		}
		
		
		String[] colNames = new String[]{"位置","入住开始时间","入住结束时间","状态","姓名","性别","年龄","档案编号"};
		String[][] content = new String[1][8];
		content[0] = new String[]{t.getPosition(),t.getStarttime(),t.getEndtime(),t.getState(),t.getPatient().getName(),t.getPatient().getGender(),t.getPatient().getAge(),t.getNum()};

		
		jTable1Model = 
			new DefaultTableModel(
					content,
					colNames);

		// jTable = new JTable();
		// jTable.setModel(jTableModel);

		jTable1 = new JTable(jTable1Model) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		this.add(jTable1);
		jTable1.setPreferredSize(new java.awt.Dimension(872, 319));
		jScrollPane1.setViewportView(jTable1);
		jTable1.setModel(jTable1Model);
		jTable1.setFillsViewportHeight(true);
		jTable1.setRowSelectionAllowed(true); // 整行选择
		jTable1.setRowHeight(30);
		jTable1.getColumnModel().getColumn(0)
		.setCellRenderer(new IDColumnRender());
		jTable1.getColumnModel().getColumn(0).setPreferredWidth(180); // 该列的宽度
		jTable1.setBounds(0, 173, 779, 282);
		
		// 添加到主界面

		// 列设置：自定义绘制
		repaint();
		
		
		
		
		
	}
	
	private JButton getFlush() {
		if(flush == null) {
			flush = new JButton();
			flush.setText("\u5237\u65b0");
			flush.setBounds(618, 123, 88, 38);
			flush.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					flushActionPerformed(evt);
				}
			});
		}
		return flush;
	}
	
	private void flushActionPerformed(ActionEvent evt) {
		viewTable();
	}

}
