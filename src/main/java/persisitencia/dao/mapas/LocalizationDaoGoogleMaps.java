package persisitencia.dao.mapas;

import persistencia.dao.iface.LocalizationDao;

public class LocalizationDaoGoogleMaps implements LocalizationDao{

	@Override
	public MapPoint getLocationOf(String location) {
		return new MapPoint(-34.521423, -58.700954);
	}

}
