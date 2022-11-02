package curso.java.tienda.util;

import java.util.ArrayList;
import java.util.HashMap;

import curso.java.tienda.index.pojo.OpcionMenu;
import curso.java.tienda.index.pojo.Rol;

public class RoleData {

	private static Rol userRol;
	private static HashMap<String, OpcionMenu> opcionMenuList;

	public static void fillOpcionMenu(Rol rol, ArrayList<OpcionMenu> opcionMenu) {

		if (rol != null && opcionMenu != null) {

			if (!opcionMenu.isEmpty()) {

				for (OpcionMenu opcion : opcionMenu) {
					opcionMenuList.put(opcion.getOpcion().getAlias(), opcion);
				}

			}

			userRol = rol;

		}

	}

	public static boolean isVisible(String opcionAlias) {
		
		OpcionMenu opcion = opcionMenuList.get(opcionAlias);
		
		if (opcion.getRol().getId() == userRol.getId()) {
			return true;
		} else {
			return false;
		}
		
	}
	
}
