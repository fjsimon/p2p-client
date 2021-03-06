/*
 *  JMule - Java file sharing client
 *  Copyright (C) 2007-2008 JMule team ( jmule@jmule.org / http://jmule.org )
 *
 *  Any parts of this program derived from other projects, or contributed
 *  by third-party developers are copyrighted by their respective authors.
 *
 *  This program is free software; you can redistribute it and/or
 *  modify it under the terms of the GNU General Public License
 *  as published by the Free Software Foundation; either version 2
 *  of the License, or (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program; if not, write to the Free Software
 *  Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 *
 */
package org.jmule.ui.swt.tables;

import org.eclipse.swt.graphics.*;
import org.eclipse.swt.widgets.Table;


/**
 * @author Olivier
 * @author binary256
 * @version $$Revision: 1.2 $$
 * Last changed by $$Author: binary256_ $$ on $$Date: 2008/10/16 18:20:02 $$
 */
public abstract class BufferedTableItemImpl implements BufferedTableItem
{
	protected BufferedTableRow row;

	private int position;

	private Color ourFGColor = null;

	public BufferedTableItemImpl(BufferedTableRow row, int position) {
		this.row = row;
		this.position = position;
	}

	public String getText() {
//		if (Utils.SWT32_TABLEPAINT) {
//			return text;
//		}

		if (position != -1)
			return row.getText(position);
		return "";
	}

	public boolean setText(String text) {
//		if (Utils.SWT32_TABLEPAINT) {
//			if (this.text.equals(text)) {
//				return false;
//			}
//	
//			this.text = (text == null) ? "" : text;
//			
//			Rectangle bounds = getBounds();
//			if (bounds != null) {
//				Table table = row.getTable();
//				Rectangle dirty = table.getClientArea().intersection(bounds);
//				table.redraw(dirty.x, dirty.y, dirty.width, dirty.height, false);
//			}
//			
//			return true;
//		}

		if (position != -1)
			return row.setText(position, text);
		return false;
	}

	public void setImage(Image img) {
		if (position != -1)
			row.setImage(position, img);
	}

	public void setRowForeground(Color color) {
		row.setForeground(color);
	}

	public boolean setForeground(Color color) {
		if (position == -1)
			return false;

		boolean ok;
		if (ourFGColor != null) {
			ok = row.setForeground(position, color);
			if (ok) {
				if (!color.isDisposed())
					color.dispose();
				ourFGColor = null;
			}
		} else {
			ok = row.setForeground(position, color);
		}
		return ok;
	}
	
	public Color getForeground() {
		if (position == -1)
			return null;

		return row.getForeground(position);
	}

	public boolean setForeground(int red, int green, int blue) {
		if (position == -1)
			return false;

		Color oldColor = row.getForeground(position);

		RGB newRGB = new RGB(red, green, blue);

		if (oldColor != null && oldColor.getRGB().equals(newRGB)) {
			return false;
		}

		Color newColor = new Color(row.getTable().getDisplay(), newRGB);
		boolean ok = row.setForeground(position, newColor);
		if (ok) {
			if (ourFGColor != null && !ourFGColor.isDisposed())
				ourFGColor.dispose();
			ourFGColor = newColor;
		} else {
			if (!newColor.isDisposed())
				newColor.dispose();
		}

		return ok;
	}

	public Color getBackground() {
		return row.getBackground();
	}

	public Rectangle getBounds() {
		if (position != -1)
			return row.getBounds(position);
		return null;
	}

	public Table getTable() {
		return row.getTable();
	}

	public void dispose() {
		if (ourFGColor != null && !ourFGColor.isDisposed())
			ourFGColor.dispose();
	}

	public boolean isShown() {
		return true;
// XXX Bounds check is almost always slower than any changes we
//     are going to do to the column
//		if (position < 0) {
//			return false;
//		}
//		
//		Rectangle bounds = row.getBounds(position);
//		if (bounds == null) {
//			return false;
//		}
//
//		return row.getTable().getClientArea().intersects(bounds);
	}

	public boolean needsPainting() {
		return false;
	}

	public void doPaint(GC gc) {
	}

	public void locationChanged() {
	}

	public int getPosition() {
		return position;
	}

	public Image getBackgroundImage() {
		Table table = row.getTable();
		
		Rectangle bounds = getBounds();
		
		if (bounds.isEmpty()) {
			return null;
		}
		
		Image image = new Image(table.getDisplay(), bounds.width, bounds.height);
		
		GC gc = new GC(table);
		gc.copyArea(image, bounds.x, bounds.y);
		gc.dispose();
		
		return image;
	}
}
