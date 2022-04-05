package com.zzt.frames;

import java.awt.Component;

import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class IDColumnRender extends JCheckBox implements TableCellRenderer// 实现TableCellRenderer
{
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		this.setSelected(isSelected); // 将复选框是否选中与单元格是否选中同时设置同时设置
		if (value != null)
			this.setText(value.toString()); // 将原来的类的String值显示出来

		// 背景设置：
		this.setOpaque(true); // 设置背景透明度
		if (isSelected) { // 判断是否选中
			this.setBackground(table.getSelectionBackground());//设置背景
			this.setForeground(table.getSelectionForeground());//设置前景
		} else {
			this.setBackground(table.getBackground());//设置背景
			this.setForeground(table.getForeground());//设置前景
		}
		return this;// 返回该类
	}
}
