package persistencia.dao.iface;

public interface LocalizationDao {

	public class MapPoint{
		
		private double lat, lon;
		
		public MapPoint(double lat, double lon) {
			this.lat = lat;
			this.lon = lon;
		}

		public double getLat() {
			return lat;
		}

		public double getLon() {
			return lon;
		}
		
	}
	
	MapPoint getLocationOf(String location);
	
	
}
