/**
 * Graphium Neo4j - Map Matching module of Graphium
 * Copyright © 2017 Salzburg Research Forschungsgesellschaft (graphium@salzburgresearch.at)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package at.srfg.graphium.mapmatching.adapter.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import at.srfg.graphium.geomutils.GeometryUtils;
import at.srfg.graphium.io.adapter.IAdapter;
import at.srfg.graphium.mapmatching.dto.TrackPointDTO;
import at.srfg.graphium.mapmatching.model.ITrackPoint;
import at.srfg.graphium.mapmatching.model.impl.TrackPointImpl;

/**
 * @author mwimmer
 *
 */
public class TrackPointDTO2TrackPointAdapter implements IAdapter<List<ITrackPoint>, List<TrackPointDTO>> {

	private final int SRID = 4326;
	
	@Override
	public List<ITrackPoint> adapt(List<TrackPointDTO> trackPointsToAdapt) {
		if (trackPointsToAdapt == null) {
			return null;
		}
		
		List<ITrackPoint> trackPoints = new ArrayList<>(trackPointsToAdapt.size());
		for (TrackPointDTO tpDto : trackPointsToAdapt) {
			ITrackPoint trackPoint = new TrackPointImpl();
			trackPoint.setId(tpDto.getId());
			trackPoint.setPoint(GeometryUtils.createPoint(tpDto.getX(), tpDto.getY(), tpDto.getZ(), SRID));
			trackPoint.setTimestamp(new Date(tpDto.getTimestamp()));
			trackPoints.add(trackPoint);
		}
		
		return trackPoints;
	}

}
