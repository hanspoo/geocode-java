package geo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import com.google.gson.Gson;

import geo.nomi.Place;

public class GeocoderNominatum implements Geocoder {

	@Override
	public double[] geocode(String address, String country) {

		String url = null;
		try {
			url = String.format(
					"https://nominatim.openstreetmap.org/search?q=%s&polygon=1&format=json&addressdetails=1&country=%s",
					URLEncoder.encode(address, "UTF-8"), URLEncoder.encode(country, "UTF-8"));
		} catch (UnsupportedEncodingException e1) {
			throw new RuntimeException(e1.getMessage());
		}

		HttpURLConnection con = null;
		try {

			URL myurl = new URL(url);
			con = (HttpURLConnection) myurl.openConnection();

			con.setRequestMethod("GET");

			StringBuilder content;

			try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
				String line;
				content = new StringBuilder();

				while ((line = in.readLine()) != null) {
					content.append(line);
					content.append(System.lineSeparator());
				}
			}

			Gson g = new Gson();
			Place[] places = g.fromJson(content.toString(), Place[].class);
			if (places.length == 0)
				throw new RuntimeException("Dirección " + address + " no se pudo geocodificar");
			Place place = places[0];
			double[] coords = { place.lat, place.lon };
			return coords;

		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			if (con != null)
				con.disconnect();
		}

	}

}
