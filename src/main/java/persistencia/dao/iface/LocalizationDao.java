package persistencia.dao.iface;

public interface LocalizationDao {

	public class MapPoint{
		
		private float lat, lon;
		
		public MapPoint(float lat, float lon) {
			this.lat = lat;
			this.lon = lon;
		}

		public float getLat() {
			return lat;
		}

		public float getLon() {
			return lon;
		}
		
	}
	
	MapPoint getLocationOf(String location);
	
	
}
