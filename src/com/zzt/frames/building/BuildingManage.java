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

import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import com.zzt.entity.build.Bed;
import com.zzt.entity.build.BuildFloor;
import com.zzt.entity.build.Building;
import com.zzt.entity.build.Room;
import com.zzt.tool.GetDataClass;
import com.zzt.tool.WriteDataClass;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class BuildingManage extends javax.swing.JPanel {
	private JScrollPane jScrollPane1;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JButton delete;
	private JComboBox specialType;
	private JTree buildTree;
	private JTextField explain;
	private JComboBox isSpecial;
	private JTextField maxHold;
	private JComboBox roomNumber;
	private JComboBox buildingFloorNumber;
	private JButton jButton1;
	private JComboBox buildingNumber;
	private JTextField name;
	private JLabel jLabel8;
	private JLabel jLabel7;
	private JLabel jLabel6;
	private JLabel jLabel3;
	private JLabel jLabel2;
	private JLabel jLabel1;

	// 建立楼的临时对象用来数据之间的传输
	private List<Building> buildings = GetDataClass.getDataBuildingClass();

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new BuildingManage());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	public BuildingManage() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			this.setPreferredSize(new java.awt.Dimension(649, 690));
			this.setLayout(null);
			{
				jScrollPane1 = new JScrollPane();
				this.add(jScrollPane1);
				jScrollPane1.setBounds(-2, 0, 242, 695);
				{
					buildTree = new JTree();
					viewTree();
					jScrollPane1.setViewportView(buildTree);
				}
			}
			{
				jLabel1 = new JLabel();
				this.add(jLabel1);
				jLabel1.setText("\u540d\u79f0");
				jLabel1.setBounds(375, 24, 46, 32);
			}
			{
				jLabel2 = new JLabel();
				this.add(jLabel2);
				jLabel2.setText("\u697c\u53f7");
				jLabel2.setBounds(375, 82, 37, 28);
			}
			{
				jLabel3 = new JLabel();
				this.add(jLabel3);
				jLabel3.setText("\u697c\u5c42");
				jLabel3.setBounds(375, 149, 43, 28);
			}
			{
				jLabel4 = new JLabel();
				this.add(jLabel4);
				jLabel4.setText("\u623f\u95f4");
				jLabel4.setBounds(377, 213, 41, 33);
			}
			{
				jLabel5 = new JLabel();
				this.add(jLabel5);
				jLabel5.setText("\u6700\u5927\u5bb9\u7eb3");
				jLabel5.setBounds(375, 280, 91, 50);
			}
			{
				jLabel6 = new JLabel();
				this.add(jLabel6);
				jLabel6.setText("\u7a00\u6709\u623f\u95f4");
				jLabel6.setBounds(375, 358, 99, 45);
			}
			{
				jLabel7 = new JLabel();
				this.add(jLabel7);
				jLabel7.setText("\u7a00\u6709\u7c7b\u578b");
				jLabel7.setBounds(375, 427, 73, 39);
			}
			{
				jLabel8 = new JLabel();
				this.add(jLabel8);
				jLabel8.setText("\u5907\u6ce8");
				jLabel8.setBounds(375, 491, 58, 58);
			}
			{
				jButton1 = new JButton();
				this.add(jButton1);
				jButton1.setText("\u65b0\u5efa");
				jButton1.setBounds(454, 600, 99, 52);
				jButton1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jButton1ActionPerformed(evt);
					}
				});
			}
			{
				name = new JTextField();
				this.add(name);
				name.setBounds(448, 27, 139, 27);
			}
			{

				ComboBoxModel buildingNumberModel = new DefaultComboBoxModel(
						new String[] { " ", "1号楼", "2号楼", "3号楼" });
				buildingNumber = new JComboBox();
				this.add(buildingNumber);
				buildingNumber.setModel(buildingNumberModel);
				buildingNumber.setBounds(448, 83, 139, 27);
				viewFlush1();
				buildingNumber.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						buildingNumberActionPerformed(evt);
					}
				});
			}
			{
				ComboBoxModel buildingFloorNumberModel = new DefaultComboBoxModel(
						new String[] { " ", "1层", "2层" });
				buildingFloorNumber = new JComboBox();
				this.add(buildingFloorNumber);
				buildingFloorNumber.setModel(buildingFloorNumberModel);
				buildingFloorNumber.setBounds(448, 149, 139, 27);
				buildingFloorNumber.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						buildingFloorNumberActionPerformed(evt);
					}
				});
			}
			{
				ComboBoxModel roomNumberModel = new DefaultComboBoxModel(
						new String[] { " ", "1号房", "2号房", "3号房" });
				roomNumber = new JComboBox();
				this.add(roomNumber);
				roomNumber.setModel(roomNumberModel);
				roomNumber.setBounds(448, 216, 139, 27);
			}
			{
				maxHold = new JTextField();
				this.add(maxHold);
				maxHold.setBounds(450, 292, 134, 27);
			}
			{
				ComboBoxModel isSpecialModel = new DefaultComboBoxModel(
						new String[] { "否", "是" });
				isSpecial = new JComboBox();
				this.add(isSpecial);
				isSpecial.setModel(isSpecialModel);
				isSpecial.setBounds(454, 367, 131, 27);
			}
			{
				explain = new JTextField();
				this.add(explain);
				explain.setBounds(457, 501, 128, 82);
			}
			{
				ComboBoxModel specialTypeModel = new DefaultComboBoxModel(
						new String[] { " ", "浴室", "棋牌室", "娱乐室" });
				specialType = new JComboBox();
				this.add(specialType);
				specialType.setModel(specialTypeModel);
				specialType.setBounds(454, 433, 131, 27);
			}
			{
				delete = new JButton();
				this.add(delete);
				delete.setText("\u5220\u9664");
				delete.setBounds(273, 600, 89, 59);
				delete.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						deleteActionPerformed(evt);
					}
				});
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void viewFlush1() {
		buildings = GetDataClass.getDataBuildingClass();
		if (buildings != null && !buildings.isEmpty()) {
			// 显示楼号
			int size1 = buildings.size();
			String[] builds = new String[size1 + 1];
			builds[0] = " ";
			int i = 1;
			for (Building t : buildings) {
				builds[i++] = t.getName();
			}

			ComboBoxModel buildingNumberModel = new DefaultComboBoxModel(builds);
			buildingNumber.setModel(buildingNumberModel);

		} else {
			ComboBoxModel buildingNumberModel = new DefaultComboBoxModel(
					new String[] { " " });
			buildingNumber.setModel(buildingNumberModel);
		}
	}

	private void viewFlush2() {
		buildings = GetDataClass.getDataBuildingClass();
		String namex = buildingNumber.getSelectedItem().toString();
		if (namex.equals(" ")) {
			ComboBoxModel buildingFloorNumberModel = new DefaultComboBoxModel(
					new String[] { " " });
			buildingFloorNumber.setModel(buildingFloorNumberModel);
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
					buildingFloorNumber.setModel(buildingFloorNumberModel);
				} else {
					ComboBoxModel buildingFloorNumberModel = new DefaultComboBoxModel(
							new String[] { " " });
					buildingFloorNumber.setModel(buildingFloorNumberModel);
				}
				break;
			}
		}
	}

	private void viewFlush3() {
		buildings = GetDataClass.getDataBuildingClass();
		String namex1 = buildingNumber.getSelectedItem().toString();
		String namex2 = buildingFloorNumber.getSelectedItem().toString();

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
										new String[] { " " });
								roomNumber.setModel(roomNumberModel);
							}
							break;
						}
					}
				} else {
					ComboBoxModel roomNumberModel = new DefaultComboBoxModel(
							new String[] { " " });
					roomNumber.setModel(roomNumberModel);
				}
				break;
			}
		}
	}

	private void jButton1ActionPerformed(ActionEvent evt) {
		Building building = Building.getBuilding();
		buildings = GetDataClass.getDataBuildingClass();
		// 获取输入的数据
		String name1 = name.getText();

		String buildingNumber1 = buildingNumber.getSelectedItem().toString();
		String buildindFloor1 = buildingFloorNumber.getSelectedItem()
				.toString();
		String buildingRoom1 = roomNumber.getSelectedItem().toString();
		String maxHold1 = maxHold.getText();
		String isSpecial1 = isSpecial.getSelectedItem().toString();
		String specialType1 = specialType.getSelectedItem().toString();
		String explain1 = explain.getText();

		if(maxHold1 == null || "".equals(maxHold1))
		{
			if(isSpecial1.equals("是"))
			{
				JOptionPane.showMessageDialog(null, "请输入稀有设备的最大容纳人数！");
				return;
			}
		}
		if(specialType1.equals(" ") || "".equals(maxHold1))
		{
			if(isSpecial1.equals("是"))
			{
				JOptionPane.showMessageDialog(null, "请输入稀有设备的最大容纳人数！");
				return;
			}
		}
		
		if(name1 == null || "".equals(name1))
		{
			JOptionPane.showMessageDialog(null, "请输入名称！");
			return;
		}
		
		if (buildingNumber1.equals(" ")) {
			building.setName(name1);
			building.setExplain(explain1);
			buildings.add(building);
		} else if (buildindFloor1.equals(" ")) {
			List<BuildFloor> buildingfloors = new ArrayList<BuildFloor>();
			BuildFloor buildingFloor = BuildFloor.getBuildFloor();
			buildingFloor.setName(name1);
			buildingFloor.setExplain(explain1);
			// 寻找楼层相应的楼号
			int i = 0;
			for (Building t : buildings) {
				if (!"".equals(t.getName())
						&& buildingNumber1.equals(t.getName())) {
					buildingfloors = t.getBuildFloors();
					if (buildingfloors == null || buildings.isEmpty()) {
						buildingfloors = new ArrayList<BuildFloor>();
					}
					buildingfloors.add(buildingFloor);
					building.setBuildFloors(buildingfloors);
					building.setName(t.getName());
					buildings.set(i, building);
				}
				i++;
			}
		} else if (buildingRoom1.equals(" ")) {
			List<Room> rooms = null;
			Room m = Room.getRoom();
			List<BuildFloor> buildingfloors = null;
			// 寻找原来该层的房间：
			int i1 = 0;
			for (Building t1 : buildings) {
				if (buildingNumber1.equals(t1.getName())) {
					buildingfloors = t1.getBuildFloors();
					int i2 = 0;
					for (BuildFloor t2 : buildingfloors) {
						if (buildindFloor1.equals(t2.getName())) {
							rooms = t2.getRooms();
							if (rooms == null || rooms.isEmpty()) {
								rooms = new ArrayList<Room>();
							}
							// 判断是否是稀有房间
							if (isSpecial1.equals("否")) {
								
								m.setSpecial(false);
							} else {
								m.setSpecial(true);
								m.setSpecialType(specialType1);
								
								
							}
							m.setName(name1);
							m.setMaxHold(maxHold1);
							m.setVaildHold(maxHold1);
							m.setExplain(explain1);
							m.setPosition(t1.getName() + "->" + t2.getName() + "->" + name1);
							rooms.add(m);
							t2.setRooms(rooms);
							buildingfloors.set(i2, t2);
							break;
						}
						i2++;
					}
					t1.setBuildFloors(buildingfloors);
					buildings.set(i1, t1);
				}
				i1++;
			}
		} else {
			List<Room> rooms = null;
			Room m;
			List<BuildFloor> buildingfloors = null;
			List<Bed> beds = null;
			Bed bed = Bed.getBed();
			bed.setExpalin(explain1);
			bed.setName(name1);
			// 寻找原来该层的房间：
			int i1 = 0;
			for (Building t1 : buildings) {
				if (buildingNumber1.equals(t1.getName())) {
					buildingfloors = t1.getBuildFloors();
					int i2 = 0;
					for (BuildFloor t2 : buildingfloors) {
						if (buildindFloor1.equals(t2.getName())) {
							rooms = t2.getRooms();
							int i4 = 0;
							for (Room t3 : rooms) {
								if (buildingRoom1.equals(t3.getName())) {
									beds = t3.getBeds();
									if (beds == null || beds.isEmpty()) {
										beds = new ArrayList<Bed>();
									}
									bed.setPosition(t1.getName()+"->" + t2.getName() + "->" + t3.getName() + "->" + name1);
									beds.add(bed);
									t3.setBeds(beds);
									rooms.set(i4, t3);
									break;
								}
								i4++;
							}
							t2.setRooms(rooms);
							buildingfloors.set(i2, t2);
							break;
						}
						i2++;
					}
					t1.setBuildFloors(buildingfloors);
					buildings.set(i1, t1);
					break;
				}
				i1++;
			}
		}
		WriteDataClass.writeDataBuilding(buildings);
		viewFlush1();
		viewFlush2();
		viewFlush3();
		JOptionPane.showMessageDialog(null, "添加成功！");
		name.setText("");
		viewTree();
	}

	private void buildingNumberActionPerformed(ActionEvent evt) {
		String a = buildingNumber.getSelectedItem().toString();
		// 根据楼号事件来判断
		if (!a.equals(" ")) {
			// 显示楼层
			viewFlush2();
			viewFlush3();
		}
		viewTree();
	}

	private void buildingFloorNumberActionPerformed(ActionEvent evt) {
		String b = buildingFloorNumber.getSelectedItem().toString();
		if (!b.equals(" ")) {
			viewFlush3();
		}
		viewTree();
	}

	@SuppressWarnings("serial")
	
	
	private void viewTree() {
		buildings = GetDataClass.getDataBuildingClass();//从文件中得到已有的数据
		buildTree.setModel(new DefaultTreeModel(new DefaultMutableTreeNode(
				"东软颐养中心") {
			{
				//设置四层结点以显示树
				DefaultMutableTreeNode node1;//结点1
				DefaultMutableTreeNode node2;//结点2
				DefaultMutableTreeNode node3;//结点3
				DefaultMutableTreeNode node4;//结点4
				//通过循环已有的数据进行显示
				if (buildings != null && !buildings.isEmpty()) {//判断是否为空，防止空指针异常
					for (Building t : buildings) {//循环第一层
						node1 = new DefaultMutableTreeNode(t.getName());//实例化节点
						List<BuildFloor> buildingfloors = t.getBuildFloors();//得到楼层list
						if (buildingfloors != null && !buildingfloors.isEmpty()) {//判断是否为空，防止空指针异常
							for (BuildFloor t1 : buildingfloors) {//循环第二层
								node2 = new DefaultMutableTreeNode(t1.getName());//实例化节点
								List<Room> rooms = t1.getRooms();//循环第三层
								if (rooms != null && !rooms.isEmpty()) {//判断是否为空，防止空指针异常
									for (Room t2 : rooms) {//循环第四层
										node3 = new DefaultMutableTreeNode(t2
												.getName());//实例化节点
										List<Bed> beds = t2.getBeds();//
										if (beds != null && !beds.isEmpty()) {//判断是否为空，防止空指针异常
											for (Bed t3 : beds) {//
												node4 = new DefaultMutableTreeNode(
														t3.getName());//实例化节点
												node3.add(node4);//将第四层结点加入到第三层
											}
										}
										node2.add(node3);//将第三层结点加入到第二层
									}
								}
								node1.add(node2);//将第二层结点加入到第一层
							}
						}
						add(node1);//将第一层结点加入到总树根
					}
				}
			}
		}));
	}
	
	private void deleteActionPerformed(ActionEvent evt) {
		Building building = Building.getBuilding();
		buildings = GetDataClass.getDataBuildingClass();
		// 获取输入的数据
		String name1 = name.getText();

		String buildingNumber1 = buildingNumber.getSelectedItem().toString();
		String buildindFloor1 = buildingFloorNumber.getSelectedItem()
				.toString();
		String buildingRoom1 = roomNumber.getSelectedItem().toString();
		String maxHold1 = maxHold.getText();
		String isSpecial1 = isSpecial.getSelectedItem().toString();
		String specialType1 = specialType.getSelectedItem().toString();
		String explain1 = explain.getText();

		if (buildingNumber1.equals(" ")) {
			JOptionPane.showMessageDialog(null, "请先选择想要删除的楼号！");
			return;
		} else if (buildindFloor1.equals(" ")) {
			List<BuildFloor> buildingfloors = new ArrayList<BuildFloor>();
			BuildFloor buildingFloor = BuildFloor.getBuildFloor();
			// 寻找楼层相应的楼号
			int i1 = 0 ;
			for (Building t : buildings) {
				if (!"".equals(t.getName())
						&& buildingNumber1.equals(t.getName())) {
					buildingfloors = t.getBuildFloors();
					if (buildingfloors == null || buildingfloors.isEmpty()) {
						buildings.remove(i1);
						buildingfloors = new ArrayList<BuildFloor>();
					}else
					{
						JOptionPane.showMessageDialog(null, "该号楼还有楼层单位，请先删除楼层单位！");
						return;
					}
					break;
				}
				i1 ++ ;
			}
		} else if (buildingRoom1.equals(" ")) {
			List<Room> rooms = null;
			Room m;
			List<BuildFloor> buildingfloors = null;
			// 寻找原来该层的房间：
			int i1 = 0;
			for (Building t1 : buildings) {
				if (buildingNumber1.equals(t1.getName())) {
					buildingfloors = t1.getBuildFloors();
					int i2 = 0;
					for (BuildFloor t2 : buildingfloors) {
						if (buildindFloor1.equals(t2.getName())) {
							rooms = t2.getRooms();
							if (rooms == null || rooms.isEmpty()) {
								buildingfloors.remove(i2);
								rooms = new ArrayList<Room>();
							}else
							{
								JOptionPane.showMessageDialog(null, "该层还有房间单位，请先删除房间单位后再删除楼层");
								return;
							}
							break;
						}
						i2++;
					}
					t1.setBuildFloors(buildingfloors);
					buildings.set(i1, t1);
				}
				i1++;
			}
		} else {
			List<Room> rooms = null;
			Room m;
			List<BuildFloor> buildingfloors = null;
			List<Bed> beds = null;
			Bed bed = Bed.getBed();
			bed.setExpalin(explain1);
			bed.setName(name1);
			bed.setRegister(false);
			// 寻找原来该层的房间：
			int i1 = 0;
			for (Building t1 : buildings) {
				if (buildingNumber1.equals(t1.getName())) {
					buildingfloors = t1.getBuildFloors();
					int i2 = 0;
					for (BuildFloor t2 : buildingfloors) {
						if (buildindFloor1.equals(t2.getName())) {
							rooms = t2.getRooms();
							int i4 = 0;
							for (Room t3 : rooms) {
								if (buildingRoom1.equals(t3.getName())) {
									beds = t3.getBeds();
										rooms.remove(i4);
										beds = new ArrayList<Bed>();
									
									break;
								}
								i4++;
							}
							t2.setRooms(rooms);
							buildingfloors.set(i2, t2);
							break;
						}
						i2++;
					}
					t1.setBuildFloors(buildingfloors);
					buildings.set(i1, t1);
					break;
				}
				i1++;
			}

		}
		WriteDataClass.writeDataBuilding(buildings);
		viewFlush1();
		viewFlush2();
		viewFlush3();
		JOptionPane.showMessageDialog(null, "删除成功！");
		
		viewTree();//调用函数更新树的内容

	}

}
