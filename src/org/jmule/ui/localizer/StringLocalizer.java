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
package org.jmule.ui.localizer;

/**
 *
 * Created on Aug 15, 2008
 * @author javajox
 * @version $Revision: 1.2 $
 * Last changed by $Author: binary256_ $ on $Date: 2008/10/09 10:12:11 $
 */
public class StringLocalizer {

	public static String StringLocalizer(String key) {
		
		return Localizer.getString(key);
		
	}
	
	public static String StringLocalizer(String key, String... params) {
		
		return Localizer.getString(key, params);
		
	}
	
}
