package geo;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class TestGeocode {

	String dirMetro = "Av.República 580, Santiago, Santiago, Metropolitana";
	String dirValpo = "Alberto Blest Gana 317, Viña del Mar, Valparaíso";
	double[] metro = { -33.4506902, -70.6678208 };
	double[] valpo = { -33.0273333, -71.5481336 };

	@Test
	public void geoMetro() {
		Geocoder g = new GeocoderNominatum();
		double[] coord = g.geocode(dirMetro, "cl");
		assertThat(coord[0], is(-33.4506902));
		assertThat(coord[1], is(-70.6678208));

	}

	@Test
	public void geoValpo() {

		Geocoder g = new GeocoderNominatum();
		double[] coord = g.geocode(dirValpo, "cl");
		assertThat(coord[0], is(-33.0273333));
		assertThat(coord[1], is(-71.5481336));

	}

	@Test(expected = RuntimeException.class)
	public void direccionInexistenteException() {

		Geocoder g = new GeocoderNominatum();
		double[] coord = g.geocode("dirección que no existe,ninguna ciudad,ninguna region", "cl");

	}

}
