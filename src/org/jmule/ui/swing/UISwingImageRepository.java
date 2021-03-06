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
package org.jmule.ui.swing;


import java.awt.Image;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import org.jmule.ui.UIImageRepository;

/**
 * @author parg
 * @version $$Revision: 1.1 $$
 * Last changed by $$Author: javajox $$ on $$Date: 2008/07/31 16:43:05 $$
 */
public class
UISwingImageRepository {

    public static Image getImage(String name) {
        try {
            return (ImageIO.read(UIImageRepository.getImageAsStream(name)));
        } catch (Throwable e) {

            // some versions of Opera don't have the imageio stuff available it seems
            // so catch all errors and return null

            //Debug.printStackTrace( e );

            return (null);
        }
    }

    public static InputStream getImageAsStream(String name) {

        return (UIImageRepository.getImageAsStream(name));
    }

    public static Image getImage(InputStream is) {
        try {
            return (ImageIO.read(is));

        } catch (Throwable e) {

            //Debug.printStackTrace( e );

            return (null);
        }
    }

    public static Icon getIcon(String name) {
        Image image = getImage(name);

        return (image == null ? null : new ImageIcon(image));
    }

    public static Icon getIcon(InputStream is) {
        Image image = getImage(is);

        return (image == null ? null : new ImageIcon(image));
    }
}
