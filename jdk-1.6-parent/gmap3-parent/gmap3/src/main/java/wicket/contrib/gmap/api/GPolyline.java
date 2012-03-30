/*
 * 
 * ==============================================================================
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package wicket.contrib.gmap.api;

import org.apache.wicket.ajax.AjaxRequestTarget;

import wicket.contrib.gmap.js.Array;
import wicket.contrib.gmap.js.Constructor;

/**
 * Represents an Google Maps API's <a href= "http://www.google.com/apis/maps/documentation/reference.html#GPolyline"
 * >GPolyline</a>.
 */
public class GPolyline extends GOverlay
{
	private static final long serialVersionUID = 1L;

	private final GLatLng[] _gLatLngs;

	private final String _color;

	private final int _weight;

	private final float _opacity;

	public GPolyline(String color, int weight, float opacity, GLatLng... gLatLngs)
	{
		super();

		_gLatLngs = gLatLngs;
		_color = color;
		_weight = weight;
		_opacity = opacity;
	}

	/**
	 * @see wicket.contrib.gmap.api.GOverlay#getJSconstructor()
	 */
	@Override
	public String getJSconstructor()
	{
		Constructor constructor = new Constructor("GPolyline");

		Array array = new Array();
		for (GLatLng gLatLng : _gLatLngs)
		{
			array.add(gLatLng.getJSconstructor());
		}
		constructor.add(array.toJS());

		constructor.addString(_color);
		constructor.addString(_weight);
		constructor.addString(_opacity);

		return constructor.toJS();
	}

	/**
	 * @see wicket.contrib.gmap.api.GOverlay#updateOnAjaxCall(org.apache.wicket.ajax.AjaxRequestTarget,
	 *      wicket.contrib.gmap.api.GEvent)
	 */
	@Override
	protected void updateOnAjaxCall(AjaxRequestTarget target, GEvent overlayEvent)
	{
		// TODO
	}
}
